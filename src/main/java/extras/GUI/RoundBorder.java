package extras.GUI;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class RoundBorder extends AbstractBorder {
    private final int radius;
    private Color color;
    private final BasicStroke stroke;

    public RoundBorder(int radius, Color color, int strokeWidth) {
        this.radius = radius;
        this.color = color;
        this.stroke = new BasicStroke(strokeWidth);
    }

    public RoundBorder(int radius, int strokeWidth) {
        this.radius = radius;
        this.stroke = new BasicStroke(strokeWidth);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        var g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.setStroke(stroke);
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius + 2, radius + 2, radius + 2, radius + 2);
    }
}