package view;

import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.number_languages.NumberLanguagesController;
import interface_adapter.number_languages.NumberLanguagesState;
import interface_adapter.number_languages.NumberLanguagesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NumberLanguagesView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Number of Languages View";
    private final NumberLanguagesViewModel numberLanguagesViewModel;
    private final NumberLanguagesController numberLanguagesController;
    private final HistoryViewModel historyViewModel;

    private final JTextField numberLanguagesInputField = new JTextField(15);
    //TODO: add error field
    final JButton go;

    /**
     * A window with a title and a JButton.
     */
    public NumberLanguagesView(NumberLanguagesController numberLanguagesController, NumberLanguagesViewModel numberLanguagesViewModel, HistoryViewModel historyViewModel) {
//    public NumberLanguagesView(NumberLanguagesViewModel numberLanguagesViewModel) {

        this.numberLanguagesViewModel = numberLanguagesViewModel;
        this.numberLanguagesViewModel.addPropertyChangeListener(this);
        this.numberLanguagesController = numberLanguagesController;
        this.historyViewModel = historyViewModel;

        JLabel title = new JLabel(numberLanguagesViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel numberLanguagesInfo = new LabelTextPanel(
                new JLabel(numberLanguagesViewModel.LANGUAGE_LABEL), numberLanguagesInputField);

        JPanel buttons = new JPanel();
        go = new JButton(numberLanguagesViewModel.GO_BUTTON_LABEL);
        buttons.add(go);

        numberLanguagesInputField.addActionListener(this);
        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(go)) {
                    NumberLanguagesState currentState = numberLanguagesViewModel.getState();

                    numberLanguagesController.execute(
                            currentState.getNumberLanguages()
                    );
                }
            }
        });
        numberLanguagesInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                NumberLanguagesState currentState = numberLanguagesViewModel.getState();
                currentState.setNumberLanguages(numberLanguagesInputField.getText());
                numberLanguagesViewModel.setState(currentState);
            }
            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(numberLanguagesInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
//        historyViewModel.getData();
        HistoryState historyState = historyViewModel.getState();
//        System.out.println("NumberLanguagesView: historyViewModel.getData(): " + historyViewModel.getData());

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        NumberLanguagesState state = (NumberLanguagesState) evt.getNewValue();
        if (state.getNumberLanguagesError() != null) {
            JOptionPane.showMessageDialog(this, state.getNumberLanguagesError()); //TODO: edit each error
        }
    }
}
