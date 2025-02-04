package Aufgaben.extras.GUI;

import Aufgaben.extras.Pokemon;
import javax.swing.*;
import java.awt.*;

public class ComparePanel extends JPanel {
    private final Pokemon pokemon1;
    private final Pokemon pokemon2;

    public ComparePanel(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        setLayout(new GridLayout(2, 1)); // Top and bottom layout
        setBackground(new Color(0x2C2C2C));
        add(createPokemonPanel(pokemon1, pokemon2));
        add(createPokemonPanel(pokemon2, pokemon1));
    }

    private JPanel createPokemonPanel(Pokemon pokemon, Pokemon opponent) {
        JPanel panel = new JPanel(new GridLayout(7, 2)); // 7 stats + labels
        panel.setBackground(new Color(0x2C2C2C));
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        // Add Pokémon image
        var imageLabel = new JLabel(new ImageIcon(pokemon.getImagePath()));
        panel.add(imageLabel);
        panel.add(new JLabel()); // Empty space

        // Add stats with color coding
        addStat(panel, "Name", pokemon.getName(), opponent.getName());
        addStat(panel, "Type", pokemon.getType(), opponent.getType());
        addStat(panel, "Level", String.valueOf(pokemon.getLevel()), String.valueOf(opponent.getLevel()));
        addStat(panel, "HP", String.valueOf(pokemon.getHp()), String.valueOf(opponent.getHp()));
        addStat(panel, "Attack", String.valueOf(pokemon.getAttack()), String.valueOf(opponent.getAttack()));
        addStat(panel, "Defense", String.valueOf(pokemon.getDefense()), String.valueOf(opponent.getDefense()));
        addStat(panel, "Speed", String.valueOf(pokemon.getSpeed()), String.valueOf(opponent.getSpeed()));

        return panel;
    }

    private void addStat(JPanel panel, String statName, String value1, String value2) {
        JLabel nameLabel = new JLabel(statName + ":");
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);

        JLabel valueLabel = new JLabel(value1);
        valueLabel.setForeground(getStatColor(value1, value2));
        panel.add(valueLabel);
    }

    private Color getStatColor(String value1, String value2) {
        int stat1 = Integer.parseInt(value1);
        int stat2 = Integer.parseInt(value2);

        if (stat1 > stat2) {
            return Color.GREEN; // Higher stat
        } else if (stat1 < stat2) {
            return Color.RED; // Lower stat
        } else {
            return Color.WHITE; // Equal stat
        }
    }
}