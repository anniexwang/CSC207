package view;

import interface_adapter.Audio.AudioController;
import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Objects;

/**
 * Represents the login view of the application.
 * This class extends JPanel and implements ActionListener and PropertyChangeListener.
 * It holds the state of the login view and provides methods to handle user actions and property changes.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {
    // Constants and view models
    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;
    private final HistoryViewModel historyViewModel;

    // UI components
    final JTextField usernameInputField = new JTextField(15);
    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel usernameErrorField = new JLabel();
    private final JLabel passwordErrorField = new JLabel();
    private JButton muteButton; // Added the muteButton field
    private final AudioController audioController;

    // Timer for periodically updating mute button text
    private Timer muteButtonUpdateTimer;

    /**
     * Constructs a LoginView instance.
     *
     * @param loginViewModel The view model for login.
     * @param loginController The controller for login.
     * @param audioController The audio manager for handling audio.
     * @param historyViewModel The view model for history.
     */
    public LoginView(LoginViewModel loginViewModel, LoginController loginController, AudioController audioController, HistoryViewModel historyViewModel) {
        this.loginController = loginController;
        this.loginViewModel = loginViewModel;
        this.audioController = audioController;
        this.loginViewModel.addPropertyChangeListener(this);
        this.historyViewModel = historyViewModel;

        // Container panel setup
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setBackground(Color.BLACK);

        // Image setup
        File imageFile = new File("Resources\\AA.jpg"); // Replace with the actual file path
        ImageIcon imageIcon = new ImageIcon(imageFile.getAbsolutePath());

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
        audioController.play();

        usernameInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText());
                // set username in current state, used for checking translation history for each user
                HistoryState historyState = historyViewModel.getState();
                historyState.setCurrentUsername(usernameInputField.getText());
                loginViewModel.setState(currentState);
            }
        });

        passwordInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setPassword(new String(passwordInputField.getPassword()));
                loginViewModel.setState(currentState);
            }
        });

        // Initialize and start the timer to periodically update mute button text
        int delay = 1000; // Delay in milliseconds (1 second)
        muteButtonUpdateTimer = new Timer(delay, e -> updateMuteButtonText());
        muteButtonUpdateTimer.start();
    }

    /**
     * Updates the text of the mute button based on the current mute status.
     */
    private void updateMuteButtonText() {
        if (audioController != null) {
            muteButton.setText(audioController.isMuted() ? "Unmute" : "Mute");
        }
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
        JButton muteButton = new RainbowButton(audioController.isMuted() ? "Unmute" : "Mute");
        muteButton.addActionListener(e -> {
            audioController.mute();
            muteButton.setText(audioController.isMuted() ? "Unmute" : "Mute");
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

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
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