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
import java.util.List;

public class PokedexGUI extends JFrame {
    private Pokedex pokedex;
    private JTextArea displayArea;
    private JComboBox<String> nameComboBox;
    private JTextField levelField;
    private JComboBox<String> sexComboBox;

    public PokedexGUI() {
        pokedex = new Pokedex();
        loadPokedexFromFile();

        setTitle("Pokedex");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        nameComboBox = new JComboBox<>(PokemonList.getPokemonNames());
        panel.add(new JLabel("Name:"));
        panel.add(nameComboBox);

        levelField = new JTextField(5);
        panel.add(new JLabel("Level:"));
        panel.add(levelField);

        sexComboBox = new JComboBox<>(new String[]{"♂", "♀"});
        panel.add(new JLabel("Sex:"));
        panel.add(sexComboBox);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new AddButtonListener());
        panel.add(addButton);

        JButton showButton = new JButton("Show All");
        showButton.addActionListener(new ShowButtonListener());
        panel.add(showButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonListener());
        panel.add(deleteButton);

        add(panel, BorderLayout.SOUTH);
    }

    private void loadPokedexFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Pokemon> pokemonList = mapper.readValue(new File("pokedex.json"), mapper.getTypeFactory().constructCollectionType(List.class, Pokemon.class));
            for (Pokemon pokemon : pokemonList) {
                pokedex.addPokemon(pokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savePokedexToFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("pokedex.json"), pokedex.getPokemonList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = (String) nameComboBox.getSelectedItem();
            String type = PokemonList.getPokemonType(name);
            String levelText = levelField.getText();
            String sex = (String) sexComboBox.getSelectedItem();

            if (!name.isEmpty() && !type.isEmpty() && !levelText.isEmpty() && !sex.isEmpty()) {
                try {
                    int level = Integer.parseInt(levelText);
                    Pokemon pokemon = new Pokemon(name, type, level, sex);
                    pokedex.addPokemon(pokemon);
                    savePokedexToFile();
                    levelField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PokedexGUI.this, "Please enter a valid level.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class ShowButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayArea.setText("");
            for (Pokemon pokemon : pokedex.getPokemonList()) {
                displayArea.append(pokemon.toString() + "\n");
            }
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = (String) nameComboBox.getSelectedItem();
            if (!name.isEmpty()) {
                pokedex.removePokemon(name);
                savePokedexToFile();
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