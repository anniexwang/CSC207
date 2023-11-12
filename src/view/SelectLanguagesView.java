package view;

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

public class SelectLanguagesView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Select Languages";
    private final SelectLanguagesViewModel selectLanguagesViewModel;

    private final SelectLanguagesController selectLanguagesController;
    private String[] languages = {"Select"}; //read languages from csv file
    final JComboBox languageDropDown = new JComboBox();

    //TODO: add error field
    final JButton go;

    /**
     * A window with a title and a JButton.
     */

    //TODO: add for loop for language drop downs
    public SelectLanguagesView(SelectLanguagesController selectLanguagesController, SelectLanguagesViewModel selectLanguagesViewModel) {
//    public SelectLanguagesView(SelectLanguagesViewModel selectLanguagesViewModel) {

        this.selectLanguagesViewModel = selectLanguagesViewModel;
        this.selectLanguagesViewModel.addPropertyChangeListener(this);
        this.selectLanguagesController = selectLanguagesController;

        JLabel title = new JLabel(selectLanguagesViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int i = 0; i < languages.length; i++) {
            languageDropDown.addItem(languages[i]);
        }

        LabelTextPanel languageInfo = new LabelTextPanel(
                new JLabel(selectLanguagesViewModel.LANGUAGE_LABEL), languageDropDown);

        JPanel buttons = new JPanel();
        go = new JButton(selectLanguagesViewModel.GO_BUTTON_LABEL);
        buttons.add(go);

        languageDropDown.addActionListener(this);
        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(go)) {
                    SelectLanguagesState currentState = selectLanguagesViewModel.getState();

                    selectLanguagesController.execute(
                            currentState.getLanguages()
                    );
                }
            }
        });

        languageDropDown.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                String[] strArray = new String[] {languageDropDown.getName()};
                SelectLanguagesState currentState = selectLanguagesViewModel.getState();
                currentState.setLanguages(strArray); //TODO: fix
                selectLanguagesViewModel.setState(currentState);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(languageInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SelectLanguagesState state = (SelectLanguagesState) evt.getNewValue();
        if (state.getLanguagesError() != null) {
            JOptionPane.showMessageDialog(this, state.getLanguagesError()); //TODO: edit each error
//        setFields(state);
        }

//    private void setFields(TableState state) {
//        usernameInputField.setText(state.getUsername());
//        passwordInputField.setText(state.getPassword());
//    }
    }
}
