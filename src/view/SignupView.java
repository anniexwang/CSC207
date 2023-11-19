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
import java.io.File;
import java.io.IOException;
public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    // Constants
    public final String viewName = "sign up";

    // Controllers and view models
    private final SignupController signupController;
    private final SignupViewModel signupViewModel;

    // UI components
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final JButton signUp;
    private final JButton cancel;
    private final JButton skipToLogin;
    private final JLabel imageLabel;
    private Clip audioClip; // Clip for playing audio
    private boolean isMuted = false; // Mute state

    // Constructor
    public SignupView(SignupController controller, SignupViewModel signupViewModel) {
        this.signupController = controller; // Assign the controller
        this.signupViewModel = signupViewModel; // Assign the view model
        this.signupViewModel.addPropertyChangeListener(this); // Add this view as a listener to the view model
        this.add(createMuteButton());
        // Image setup
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/AA.jpg")); // Load the image
        imageLabel = new JLabel(imageIcon); // Create a label for the image
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the image label





        // Title setup
        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL); // Create title label
        title.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the title label

        // Setup for username, password, and repeat password fields
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel(signupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(new JLabel(signupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);

        // Buttons setup
        signUp = createRainbowButton(signupViewModel.SIGNUP_BUTTON_LABEL); // Create a signup button with rainbow effect
        cancel = createRainbowButton(signupViewModel.CANCEL_BUTTON_LABEL); // Create a cancel button with rainbow effect
        skipToLogin = createRainbowButton("Skip to Login"); // Create a skip-to-login button with rainbow effect

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

        // Start playing background music
        playBackgroundMusic("src/view/power.wav");
    }

    private void playBackgroundMusic(String filePath) {
        try {
            // Open an audio input stream
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip(); // Assign to the member variable
            audioClip.open(audioInputStream);

            // Start playing the music
            audioClip.start();
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(); // Handle exceptions
        }
    }
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
        RainbowButton button = new RainbowButton(text);
        return button;
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
                    setBackground(UIManager.getColor("Button.background")); // Reset the background color
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Paint the component normally
        }
    }
}
