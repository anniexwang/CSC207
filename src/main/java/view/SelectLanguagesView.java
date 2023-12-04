package view;

import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesController;
import interface_adapter.select_languages.SelectLanguagesState;
import interface_adapter.select_languages.SelectLanguagesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class SelectLanguagesView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Select Languages View";
    private final SelectLanguagesViewModel selectLanguagesViewModel;
    private final HistoryViewModel historyViewModel;

    private List<String> languages = new ArrayList<>();//read languages from csv file

    private final JTextField languagesInputField = new JTextField(15);

    final JButton go;

    public SelectLanguagesView(SelectLanguagesController selectLanguagesController, SelectLanguagesViewModel selectLanguagesViewModel, HistoryViewModel historyViewModel) throws IOException {
        this.selectLanguagesViewModel = selectLanguagesViewModel;
        this.selectLanguagesViewModel.addPropertyChangeListener(this);
        this.historyViewModel = historyViewModel;

        JLabel title = new JLabel(selectLanguagesViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel instruction1 = new JLabel(selectLanguagesViewModel.INSTRUCTION_LABEL1);
        instruction1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel instruction2 = new JLabel(selectLanguagesViewModel.INSTRUCTION_LABEL2);
        instruction2.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel languageInfo = new LabelTextPanel(
                new JLabel(selectLanguagesViewModel.LANGUAGE_LABEL), languagesInputField);

        JPanel buttons = new JPanel();
        go = new JButton(selectLanguagesViewModel.GO_BUTTON_LABEL);
        buttons.add(go);

        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(go)) {
                    selectLanguagesController.execute(languagesInputField.getText().split(","));
                }
            }
        });

        languagesInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                HistoryState historyState = historyViewModel.getState();
                String text = languagesInputField.getText() + e.getKeyChar();
                historyState.setHistoryLanguages(text.split(","));

                SelectLanguagesState currentState = selectLanguagesViewModel.getState();
                currentState.setLanguages(languagesInputField.getText().split(","));
                selectLanguagesViewModel.setState(currentState);
            }
            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(instruction1);
        this.add(instruction2);
        this.add(languageInfo);
        this.add(buttons);
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getSource().equals(go)) {
            historyViewModel.firePropertyChanged();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SelectLanguagesState state = (SelectLanguagesState) evt.getNewValue();
        if (state.getLanguagesError() != null) {
            JOptionPane.showMessageDialog(this, state.getLanguagesError());
        }
    }
}
