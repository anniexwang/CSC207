package view;

import static org.junit.jupiter.api.Assertions.assertSame;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

class TextAreaPanelDiffblueTest {
    /**
     * Method under test: {@link TextAreaPanel#getTextArea()}
     */
    @Test
    void testGetTextArea() {
        JLabel label = new JLabel("foo");
        JTextArea textArea = new JTextArea("foo");
        assertSame(textArea, (new TextAreaPanel(label, textArea)).getTextArea());
    }
}
