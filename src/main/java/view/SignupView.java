package view;

import interface_adapter.Audio.AudioController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.Objects;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    // Constants
    public final String viewName = "sign up"; // Name of the view

    // Controllers and view models
    private final SignupController signupController; // Controller for the signup process

    // UI components
    private final JTextField usernameInputField = new JTextField(15); // Input field for username
    private final JPasswordField passwordInputField = new JPasswordField(15); // Input field for password
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15); // Input field for repeating the password
    private final JButton cancel;
    private JButton muteButton;
    private Timer muteButtonUpdateTimer;


    private  AudioController audioController;

    // Constructor
    public SignupView(SignupController controller, SignupViewModel signupViewModel, AudioController audioController) {
        this.signupController = controller;
        this.audioController = audioController;

        // View model for signup
        signupViewModel.addPropertyChangeListener(this);

        // Container panel for all components
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));

        // Set background color of the panel
        containerPanel.setBackground(Color.BLACK);

        // Image setup
        File imageFile = new File("Resources\\AA.jpg"); // Replace with the actual file path
        ImageIcon imageIcon = new ImageIcon(imageFile.getAbsolutePath());

        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Title setup
        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Setup for username, password, and repeat password fields
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);

        // Buttons setup
        JButton signUp = createRainbowButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        cancel = createRainbowButton(SignupViewModel.CANCEL_BUTTON_LABEL);
        cancel.addActionListener(this);
        JButton skipToLogin = createRainbowButton(SignupViewModel.SKIP_BUTTON_LABEL);

        // Panel for buttons
        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(cancel);
        buttons.add(skipToLogin);

        // Add action listeners to buttons
        signUp.addActionListener(e -> signupController.execute(usernameInputField.getText(), new String(passwordInputField.getPassword()), new String(repeatPasswordInputField.getPassword())));
        cancel.addActionListener(e -> signupController.handleCancel());
        skipToLogin.addActionListener(e -> signupController.goToLogin());


        // Add components to the container panel
        muteButton = createMuteButton();
        containerPanel.add(muteButton);
        containerPanel.add(imageLabel);
        containerPanel.add(title);
        containerPanel.add(usernameInfo);
        containerPanel.add(passwordInfo);
        containerPanel.add(repeatPasswordInfo);
        containerPanel.add(buttons);

        // Add container panel to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Set the layout of the main panel and add the JScrollPane
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);

        // Set background and foreground for each component
        setComponentColors(containerPanel);

        // Start playing background music


        // Timer to update the mute button text
        muteButtonUpdateTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check and update the mute button text based on audioManager.isMuted()
                if (audioController != null) {
                    muteButton.setText(audioController.isMuted() ? "Unmute" : "Mute");
                }
            }
        });
        muteButtonUpdateTimer.start();
    }

    // Method to set colors for components in the container
    private void setComponentColors(Container container) {
        for (Component comp : container.getComponents()) {
            comp.setForeground(Color.WHITE); // Set text color to white
            comp.setBackground(Color.BLACK); // Set background to black

            // Set opaque to true for proper background painting
            if (comp instanceof JComponent) {
                ((JComponent) comp).setOpaque(true);
            }

            // Recursive call for container components
            if (comp instanceof Container) {
                setComponentColors((Container) comp);
            }
        }

        // Special handling for top-level container
        container.setBackground(Color.BLACK);
        if (container instanceof JComponent) {
            ((JComponent) container).setOpaque(true);
        }
    }


    private JButton createMuteButton() {
        JButton muteButton = new RainbowButton(audioController.isMuted() ? "Unmute" : "Mute");
        muteButton.setName("MuteButton"); // Set a unique name to identify the button later
        muteButton.addActionListener(e -> {
            // Toggle mute using AudioManager
            audioController.mute();
            // Update the mute button text
            muteButton.setText(audioController.isMuted() ? "Unmute" : "Mute");
        });
        return muteButton;
    }

    // Method to update the mute button's text based on the mute state


    private JButton createRainbowButton(String text) {
        return new RainbowButton(text);
    }

    // Action performed method for handling button clicks
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == cancel) {
            clearFormFields();
            signupController.handleCancel();
        }
    }

    /**
     * Clears all text fields in the form.
     */
    private void clearFormFields() {
        usernameInputField.setText("");
        passwordInputField.setText("");
        repeatPasswordInputField.setText("");
    }

    // Property change listener to respond to changes in the view model
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle state changes, like showing error messages
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
}
