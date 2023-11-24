package view;

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
    private final SignupViewModel signupViewModel; // View model for signup

    // UI components
    private final JTextField usernameInputField = new JTextField(15); // Input field for username
    private final JPasswordField passwordInputField = new JPasswordField(15); // Input field for password
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15); // Input field for repeating the password
    private final JButton cancel; // Button to cancel the signup
    private Clip audioClip; // Clip for playing audio
    private boolean isMuted = false; // Mute state

    // Constructor
    public SignupView(SignupController controller, SignupViewModel signupViewModel) {
        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.signupViewModel.addPropertyChangeListener(this);

        // Container panel for all components
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));

        // Set background color of the panel
        containerPanel.setBackground(Color.BLACK);

        // Image setup
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/AA.jpg")));
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
        JButton skipToLogin = createRainbowButton("Skip to Login");

        // Add the mute button
        containerPanel.add(createMuteButton());

        // Panel for buttons
        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(cancel);
        buttons.add(skipToLogin);

        // Add action listeners to buttons
        signUp.addActionListener(e -> signupController.execute(usernameInputField.getText(), new String(passwordInputField.getPassword()), new String(repeatPasswordInputField.getPassword())));
        cancel.addActionListener(this);
        skipToLogin.addActionListener(e -> signupController.goToLogin());

        // Add components to the container panel
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
        playBackgroundMusic();
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

    // Method to play background music
    private void playBackgroundMusic() {
        try {
            InputStream audioStream = getClass().getResourceAsStream("/power.wav");
            if (audioStream != null) {
                // Convert InputStream to byte array
                byte[] audioBytes = toByteArray(audioStream);
                // Create an InputStream from the byte array
                InputStream byteArrayInputStream = new ByteArrayInputStream(audioBytes);
                // Create an AudioInputStream from the InputStream
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(byteArrayInputStream);

                audioClip = AudioSystem.getClip();
                audioClip.open(audioInputStream);
                audioClip.start();
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.err.println("Audio file not found: " + "/power.wav");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert InputStream to byte array
    private byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        return out.toByteArray();
    }

    // Method to create a mute button
    private JButton createMuteButton() {
        JButton muteButton = new RainbowButton("Mute");
        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (audioClip != null) {
                    isMuted = !isMuted; // Toggle mute state
                    FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(isMuted ? gainControl.getMinimum() : gainControl.getMaximum()); // Mute or unmute
                    muteButton.setText(isMuted ? "Unmute" : "Mute"); // Update button text
                }
            }
        });
        return muteButton;
    }
    private JButton createRainbowButton(String text) {
        return new RainbowButton(text);
    }


    // Action performed method for handling button clicks
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == cancel) {
            // Clear all text fields when cancel is clicked
            usernameInputField.setText("");
            passwordInputField.setText("");
            repeatPasswordInputField.setText("");
            // Reset any error state in the view model
            SignupState currentState = signupViewModel.getState();
            currentState.setUsernameError(null);
            signupViewModel.setState(currentState);
        }
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