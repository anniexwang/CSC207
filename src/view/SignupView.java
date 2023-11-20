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
        this.signupController = controller; // Assign the controller
        this.signupViewModel = signupViewModel; // Assign the view model
        this.signupViewModel.addPropertyChangeListener(this); // Add this view as a listener to the view model

        // Set background color of the panel
        this.setBackground(Color.BLACK);

        // Image setup
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/AA.jpg"))); // Load the image
        // Label to display an image
        JLabel imageLabel = new JLabel(imageIcon); // Create a label for the image
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the image label

        // Title setup
        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL); // Create title label
        title.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the title label

        // Setup for username, password, and repeat password fields
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);

        // Buttons setup
        // Button for signing up
        JButton signUp = createRainbowButton(SignupViewModel.SIGNUP_BUTTON_LABEL); // Create a signup button with rainbow effect
        cancel = createRainbowButton(SignupViewModel.CANCEL_BUTTON_LABEL); // Create a cancel button with rainbow effect
        // Button to skip to login screen
        JButton skipToLogin = createRainbowButton("Skip to Login"); // Create a skip-to-login button with rainbow effect

        // Add the mute button to the view
        this.add(createMuteButton());

        // Panel for buttons
        JPanel buttons = new JPanel(); // Create a panel to hold buttons
        buttons.add(signUp); // Add the signup button
        buttons.add(cancel); // Add the cancel button
        buttons.add(skipToLogin); // Add the skip-to-login button

        // Add action listeners to buttons
        signUp.addActionListener(e -> signupController.execute(usernameInputField.getText(), new String(passwordInputField.getPassword()), new String(repeatPasswordInputField.getPassword())));
        cancel.addActionListener(this);
        skipToLogin.addActionListener(e -> signupController.goToLogin());

        // Set the layout of the panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Add components to the panel
        this.add(imageLabel);
        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);

        // Set background and foreground for each component
        setComponentColors(this);

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

    // Method to create a button with a rainbow hover effect
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

    // Inner class for a JButton with a rainbow hover effect
    static class RainbowButton extends JButton {
        private final Timer timer; // Timer for animation
        private float hue = 0.0f; // Hue value for the color

        public RainbowButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setOpaque(true);

            // Setup timer to change color
            timer = new Timer(50, e -> {
                hue += 0.01f; // Increment hue
                if (hue > 1.0f) {
                    hue = 0.0f; // Reset hue if it goes beyond 1
                }
                setBackground(Color.getHSBColor(hue, 0.7f, 0.7f)); // Set background color based on hue
            });

            // Add mouse listener for hover effect
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    timer.start(); // Start the timer on mouse enter
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    timer.stop(); // Stop the timer on mouse exit
                    setBackground(Color.BLACK); // Reset the background color
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Paint the component normally
        }

    }

}