package Aufgaben;

import Aufgaben.extras.Pokedex;
import Aufgaben.extras.Pokemon;
import Aufgaben.extras.PokemonList;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class PokedexGUI extends JFrame {
    private Pokedex pokedex;
    private JPanel displayPanel;
    private JComboBox<String> nameComboBox;
    private JTextField levelField;
    private JComboBox<String> sexComboBox;
    private JTextField customNameField;
    private JComboBox<String> deleteComboBox;

    public PokedexGUI() {
        pokedex = new Pokedex();
        loadPokedexFromFile();

        setTitle("Pokédex");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set custom icon
        URL iconURL = getClass().getClassLoader().getResource("Icon.png");
        if (iconURL != null) {
            setIconImage(new ImageIcon(iconURL).getImage());
        } else {
            System.err.println("Icon not found");
        }

        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.RED); // Set background color to red

        nameComboBox = new JComboBox<>(PokemonList.getPokemonNames());
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE); // Set text color to white
        panel.add(nameLabel);
        panel.add(nameComboBox);

        levelField = new JTextField(5);
        JLabel levelLabel = new JLabel("Level:");
        levelLabel.setForeground(Color.WHITE); // Set text color to white
        panel.add(levelLabel);
        panel.add(levelField);

        sexComboBox = new JComboBox<>(new String[]{"♂", "♀"});
        JLabel sexLabel = new JLabel("Sex:");
        sexLabel.setForeground(Color.WHITE); // Set text color to white
        panel.add(sexLabel);
        panel.add(sexComboBox);

        customNameField = new JTextField(10);
        JLabel customNameLabel = new JLabel("Custom Name:");
        customNameLabel.setForeground(Color.WHITE); // Set text color to white
        panel.add(customNameLabel);
        panel.add(customNameField);

        JButton addButton = new JButton("Add");
        addButton.setForeground(Color.WHITE); // Set text color to white
        addButton.setBackground(Color.BLUE); // Set button color to blue
        addButton.setToolTipText("Add a new Pokémon to the Pokédex");
        addButton.addActionListener(new AddButtonListener());
        panel.add(addButton);

        deleteComboBox = new JComboBox<>();
        updateDeleteComboBox();
        JLabel deleteLabel = new JLabel("Delete:");
        deleteLabel.setForeground(Color.WHITE); // Set text color to white
        panel.add(deleteLabel);
        panel.add(deleteComboBox);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setForeground(Color.WHITE); // Set text color to white
        deleteButton.setBackground(Color.BLUE); // Set button color to blue
        deleteButton.setToolTipText("Delete a Pokémon from the Pokédex");
        deleteButton.addActionListener(new DeleteButtonListener());
        panel.add(deleteButton);

        add(panel, BorderLayout.SOUTH);
        updateDisplayPanel();
    }

    private void loadPokedexFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Pokemon> pokemonList = mapper.readValue(new File("pokedex.json"), mapper.getTypeFactory().constructCollectionType(List.class, Pokemon.class));
            for (Pokemon pokemon : pokemonList) {
                pokedex.addPokemon(pokemon);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading Pokédex file.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void savePokedexToFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("pokedex.json"), pokedex.getPokemonList());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving Pokédex file.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void updateDeleteComboBox() {
        deleteComboBox.removeAllItems();
        for (Pokemon pokemon : pokedex.getPokemonList()) {
            deleteComboBox.addItem(pokemon.getName() + " (" + pokemon.getCustomName() + ")");
        }
    }

    private void updateDisplayPanel() {
        displayPanel.removeAll();
        for (Pokemon pokemon : pokedex.getPokemonList()) {
            JPanel pokemonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            URL imagePath = pokemon.getImagePath();
            JLabel iconLabel;
            if (imagePath != null) {
                iconLabel = new JLabel(new ImageIcon(imagePath));
            } else {
                iconLabel = new JLabel("Image not found");
            }
            JLabel textLabel = new JLabel(pokemon.toString());
            pokemonPanel.add(iconLabel);
            pokemonPanel.add(textLabel);
            displayPanel.add(pokemonPanel);
        }
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = (String) nameComboBox.getSelectedItem();
            String type = PokemonList.getPokemonType(name);
            String levelText = levelField.getText();
            String sex = (String) sexComboBox.getSelectedItem();
            String customName = customNameField.getText();

            if (!name.isEmpty() && !type.isEmpty() && !levelText.isEmpty() && !sex.isEmpty() && !customName.isEmpty()) {
                try {
                    int level = Integer.parseInt(levelText);
                    if (level < 1 || level > 100) {
                        throw new NumberFormatException("Level must be between 1 and 100.");
                    }
                    Pokemon pokemon = new Pokemon(name, type, level, sex, customName);
                    pokedex.addPokemon(pokemon);
                    savePokedexToFile();
                    levelField.setText("");
                    customNameField.setText("");
                    updateDeleteComboBox();
                    updateDisplayPanel();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PokedexGUI.this, "Please enter a valid level (1-100).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(PokedexGUI.this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedItem = (String) deleteComboBox.getSelectedItem();
            if (selectedItem != null && !selectedItem.isEmpty()) {
                String name = selectedItem.split(" \\(")[0];
                pokedex.removePokemon(name);
                savePokedexToFile();
                updateDeleteComboBox();
                updateDisplayPanel();
            } else {
                JOptionPane.showMessageDialog(PokedexGUI.this, "Please select a Pokémon to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PokedexGUI gui = new PokedexGUI();
            gui.setVisible(true);
        });
    }
}