package view;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LabelTextPanelDiffblueTest {
    /**
     * Method under test: {@link LabelTextPanel#LabelTextPanel(JLabel, JComboBox)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        JLabel label = null;
        JComboBox dropDown = null;

        // Act
        LabelTextPanel actualLabelTextPanel = new LabelTextPanel(label, dropDown);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link LabelTextPanel#LabelTextPanel(JLabel, JTextField)}
     */
    @Test
    void testConstructor2() {
        JLabel label = new JLabel("foo");
        JTextField textField = new JTextField(1);
        Component[] components = (new LabelTextPanel(label, textField)).getComponents();
        assertSame(components[0], label);
        assertSame(components[1], textField);
    }
}
