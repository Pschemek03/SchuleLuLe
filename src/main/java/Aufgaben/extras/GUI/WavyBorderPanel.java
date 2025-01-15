package Aufgaben.extras.GUI;

import javax.swing.*;
import java.awt.*;

public class WavyBorderPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.RED);

        int width = getWidth();
        int height = getHeight();
        int amplitude = 10;
        int wavelength = 20;

        for (int x = 0; x < width; x += wavelength) {
            int y = (int) (amplitude * Math.sin((2 * Math.PI * x) / wavelength));
            g2d.drawLine(x, height / 2 + y, x + wavelength / 2, height / 2 - y);
            g2d.drawLine(x + wavelength / 2, height / 2 - y, x + wavelength, height / 2 + y);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10, 50);
    }
}