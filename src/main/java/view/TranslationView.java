package view;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.*;
import interface_adapter.clear.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.Objects;

public class TranslationView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "translate"; // Name of the view

    // Controllers and View Models
    private final TranslationController translationController;


    // UI
    JTextField translationField = new JTextField("Enter Your Text Here");
    JTextField outputField = new JTextField("Translated Text");

    private final JButton backToSignup;
    private final JButton translate;
    private final JButton getHistory;
    private final JButton cancel;

    public TranslationView(TranslationController translationController,
                           TranslationViewModel translationViewModel
                           ){

        // controller & view model
        this.translationController = translationController;
        translationViewModel.addPropertyChangeListener(this);

        // panels
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));

        containerPanel.setBackground(Color.BLACK);

        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //text field
        LabelTextPanel translationInput = new LabelTextPanel(new JLabel(TranslationViewModel.TRANSLATE_BUTTON_LABEL), translatePhrase);

        // buttons
        cancel = createRainbowButton(SignupViewModel.CANCEL_BUTTON_LABEL);
        translate = createRainbowButton(TranslationViewModel.TRANSLATE_BUTTON_LABEL);
        backToSignup = createRainbowButton(TranslationViewModel.BACK_TO_SIGNUP);
        getHistory = createRainbowButton(TranslationViewModel.GET_HISTORY);

        cancel.addActionListener(this);
        translate.addActionListener(this);
        backToSignup.addActionListener(this);
        getHistory.addActionListener(this);

        // Panel for buttons
        JPanel buttons = new JPanel();
        buttons.add(translate);
        buttons.add(backToSignup);
        buttons.add(getHistory);
        buttons.add(cancel);

        // Add action listeners to buttons
        translate.addActionListener(e -> translationController.execute(translationField.getText()));
        backToSignup.addActionListener(e -> translationController.backToSignup());
        // placeholder for history
        getHistory.addActionListener(e -> translationController.backToSignup());
        cancel.addActionListener(e -> translationController.handleCancel());

        // add elements to panel
        containerPanel.add(title);
        containerPanel.add(translationField);
        containerPanel.add(buttons);

        // Add container panel to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Set the layout of the main panel and add the JScrollPane
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
    }
    private JButton createRainbowButton(String text) {
        return new RainbowButton(text);
    }
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

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == cancel) {
            clearFormFields();
            translationController.handleCancel();
        }
    }

    private void clearFormFields() {
        translationField.setText("");
        outputField.setText("");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle state changes, like showing error messages
        TranslationState state = (TranslationState) evt.getNewValue();
        if (state.getTranslatedError() != null) {
            JOptionPane.showMessageDialog(this, state.getTranslatedError());
        }
    }
}

