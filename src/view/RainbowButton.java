package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RainbowButton extends JButton {
    private final Timer timer;
    private float hue = 0.0f;

    public RainbowButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setOpaque(true);

        timer = new Timer(50, e -> {
            hue += 0.01f;
            if (hue > 1.0f) {
                hue = 0.0f;
            }
            setBackground(Color.getHSBColor(hue, 0.7f, 0.7f));
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                timer.stop();
                setBackground(Color.BLACK);
            }
        });
    }
}