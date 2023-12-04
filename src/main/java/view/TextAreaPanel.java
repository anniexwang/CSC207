package view;
import javax.swing.*;
import java.awt.*;

public class TextAreaPanel extends JPanel {
    private JLabel titleLabel;
    private JTextArea textArea;

    public TextAreaPanel(JLabel label, JTextArea textArea) {
        this.titleLabel = label;
        this.textArea = textArea;
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JTextArea getTextArea() {
        return textArea;
    }}

