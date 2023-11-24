package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

/**
 * Represents the login view of the application.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {
    // Constants and view models
    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;
    private final AudioManager audioManager;

    // UI components
    final JTextField usernameInputField = new JTextField(15);
    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel usernameErrorField = new JLabel();
    private final JLabel passwordErrorField = new JLabel();
    private JButton muteButton; // Added the muteButton field

    // Timer for periodically updating mute button text
    private Timer muteButtonUpdateTimer;

    /**
     * Constructs a LoginView instance.
     *
     * @param loginViewModel The view model for login.
     * @param loginController The controller for login.
     * @param audioManager The audio manager for handling audio.
     */
    public LoginView(LoginViewModel loginViewModel, LoginController loginController, AudioManager audioManager) {
        this.loginController = loginController;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);
        this.audioManager = audioManager;

        // Container panel setup
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setBackground(Color.BLACK);

        // Image setup
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/AA.jpg")));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Title and form setup
        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Username"), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Password"), passwordInputField);

        // Button setup using RainbowButton

        JButton logIn = createRainbowButton(loginViewModel.LOGIN_BUTTON_LABEL);
        JButton cancel = createRainbowButton(loginViewModel.CANCEL_BUTTON_LABEL);
        logIn.addActionListener(e -> handleLogin());
        cancel.addActionListener(e -> loginController.goToSignUp());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Add the buttons to the button panel
        buttonPanel.add(logIn);
        buttonPanel.add(cancel);

        // Add mute button
        muteButton = createMuteButton();
        containerPanel.add(muteButton);

        containerPanel.add(imageLabel);
        containerPanel.add(title);
        containerPanel.add(usernameInfo);
        containerPanel.add(passwordInfo);
        containerPanel.add(buttonPanel);

        // Add container panel to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Set the layout of the main panel and add the JScrollPane
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);

        // Set colors for each component
        setComponentColors(containerPanel);
        // Start playing background music
        audioManager.startBackgroundMusic();

        // Initialize and start the timer to periodically update mute button text
        muteButtonUpdateTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check and update the mute button text based on audioManager.isMuted()
                if (audioManager != null) {
                    muteButton.setText(audioManager.isMuted() ? "Unmute" : "Mute");
                }
            }
        });
        muteButtonUpdateTimer.start();
    }

    /**
     * Handles the login action.
     */
    private void handleLogin() {
        LoginState currentState = loginViewModel.getState();
        loginController.execute(
                currentState.getUsername(),
                currentState.getPassword()
        );
    }

    /**
     * Creates a RainbowButton with the specified text.
     *
     * @param text The text for the button.
     * @return The created RainbowButton.
     */
    private JButton createRainbowButton(String text) {
        // Method similar to SignupView for creating rainbow buttons
        return new RainbowButton(text);
    }

    /**
     * Creates a mute button for audio control.
     *
     * @return The created mute button.
     */
    private JButton createMuteButton() {
        JButton muteButton = new RainbowButton(audioManager.isMuted() ? "Unmute" : "Mute");
        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (audioManager != null) {
                    audioManager.toggleMute(); // Toggle mute state using AudioManager
                    muteButton.setText(audioManager.isMuted() ? "Unmute" : "Mute"); // Update button text
                }
            }
        });
        return muteButton;
    }

    /**
     * Sets colors for components within the given container.
     *
     * @param container The container containing components to set colors for.
     */
    private void setComponentColors(Container container) {
        for (Component comp : container.getComponents()) {
            comp.setForeground(Color.WHITE);
            comp.setBackground(Color.BLACK);
            if (comp instanceof JComponent) {
                ((JComponent) comp).setOpaque(true);
            }
            if (comp instanceof Container) {
                setComponentColors((Container) comp);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // Logic for handling action events
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Logic for handling property change events
        if ("state".equals(evt.getPropertyName())) {
            LoginState state = loginViewModel.getState();
            if (state.getUsernameError() != null && !state.getUsernameError().isEmpty()) {
                JOptionPane.showMessageDialog(this, state.getUsernameError());
                state.setUsernameError(null);
                state.setUsername("");
                state.setPassword("");
                loginViewModel.setState(state);
                usernameInputField.setText("");
                passwordInputField.setText("");
            }
        }
    }
}