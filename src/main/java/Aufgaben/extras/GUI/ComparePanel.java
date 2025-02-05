package Aufgaben.extras.GUI;

import Aufgaben.extras.*;
import javax.swing.*;
import java.awt.*;

public class ComparePanel extends JPanel {
    private final Pokemon pokemon1;
    private final Pokemon pokemon2;

    public ComparePanel(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        setLayout(new GridLayout(1, 2));
        setBackground(new Color(0x2C2C2C));
        add(createPokemonPanel(pokemon1, pokemon2, "Left"));
        add(createPokemonPanel(pokemon2, pokemon1, "Right"));
    }

    private JPanel createPokemonPanel(Pokemon pokemon, Pokemon opponent, String position) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(0x2C2C2C));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        var imageLabel = new JLabel(new ImageIcon(pokemon.getImagePath()));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imageLabel, BorderLayout.NORTH);

        var namePanel = new JPanel(new GridLayout(2, 1));
        namePanel.setBackground(new Color(0x2C2C2C));
        namePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        var nameLabel = new JLabel(pokemon.getName(), SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setForeground(Color.WHITE);
        namePanel.add(nameLabel);

        if (!pokemon.getCustomName().isEmpty()) {
            var customNameLabel = new JLabel("(" + pokemon.getCustomName() + ")", SwingConstants.CENTER);
            customNameLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            customNameLabel.setForeground(Color.WHITE);
            namePanel.add(customNameLabel);
        }

        var typeLabel = new JLabel("Type: " + pokemon.getType(), SwingConstants.CENTER);
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        typeLabel.setForeground(Color.WHITE);
        //typeLabel.setToolTipText(getTypeEffectivenessTooltip(pokemon.getType()));
        namePanel.add(typeLabel);

        panel.add(namePanel, BorderLayout.CENTER);

        var statsPanel = new JPanel(new GridLayout(5, 2, 5, 5)); // 5 stats, 2 columns
        statsPanel.setBackground(new Color(0x2C2C2C));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        addStat(statsPanel, "HP", String.valueOf(pokemon.getHp()), String.valueOf(opponent.getHp()));
        addStat(statsPanel, "Attack", String.valueOf(pokemon.getAttack()), String.valueOf(opponent.getAttack()));
        addStat(statsPanel, "Defense", String.valueOf(pokemon.getDefense()), String.valueOf(opponent.getDefense()));
        addStat(statsPanel, "Special", String.valueOf(pokemon.getSpecial()), String.valueOf(opponent.getSpecial()));
        addStat(statsPanel, "Speed", String.valueOf(pokemon.getSpeed()), String.valueOf(opponent.getSpeed()));

        panel.add(statsPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void addStat(JPanel panel, String statName, String value1, String value2) {
        JLabel nameLabel = new JLabel(statName + ":");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);

        JLabel valueLabel = new JLabel(value1);
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        valueLabel.setForeground(getStatColor(value1, value2));
        panel.add(valueLabel);
    }

    private Color getStatColor(String value1, String value2) {
        try {
            int stat1 = Integer.parseInt(value1);
            int stat2 = Integer.parseInt(value2);

            if (stat1 > stat2) {
                return Color.GREEN; // Higher stat
            } else if (stat1 < stat2) {
                return Color.RED; // Lower stat
            } else {
                return Color.WHITE; // Equal stat
            }
        } catch (NumberFormatException e) {
            return Color.WHITE;
        }
    }

}