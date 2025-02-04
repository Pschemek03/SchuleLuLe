package Aufgaben.extras.GUI;

import javax.swing.*;
import java.awt.*;

public class WavyBorderPanel extends JPanel {
    private static final int WAVE_HEIGHT = 10;
    private static final int WAVE_LENGTH = 20;

    public WavyBorderPanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0x2C2C2C));

        var width = getWidth();
        var height = getHeight();
        var path = new java.awt.geom.GeneralPath();

        path.moveTo(0, 0);
        for (int x = 0; x < width; x += WAVE_LENGTH) {
            path.quadTo(x + WAVE_LENGTH / 2, WAVE_HEIGHT, x + WAVE_LENGTH, 0);
        }
        path.lineTo(width, height);
        path.lineTo(0, height);
        path.closePath();

        g2.fill(path);
        g2.dispose();
    }
}