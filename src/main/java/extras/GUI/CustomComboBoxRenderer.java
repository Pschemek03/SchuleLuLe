package extras.GUI;

import javax.swing.*;
import java.awt.*;

public class CustomComboBoxRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        setFont(new Font("Arial", Font.BOLD, 14));
        setBackground(isSelected ? new Color(0xCC0000) : new Color(0x404040));
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return this;
    }
}