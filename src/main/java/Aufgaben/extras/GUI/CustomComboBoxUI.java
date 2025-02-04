package Aufgaben.extras.GUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;

public class CustomComboBoxUI extends BasicComboBoxUI {
    @Override
    protected ComboPopup createPopup() {
        ComboPopup popup = super.createPopup();
        JScrollPane scrollPane = (JScrollPane) ((JPopupMenu) popup).getComponent(0);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
        return popup;
    }

    @Override
    protected JButton createArrowButton() {
        JButton button = super.createArrowButton();
        button.setBackground(new Color(0x606060));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return button;
    }
}