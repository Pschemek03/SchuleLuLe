package Aufgaben;

import Aufgaben.extras.Pokedex;
import Aufgaben.extras.Pokemon;
import Aufgaben.extras.PokemonList;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
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
    private Point initialClick;

    public PokedexGUI() {
        pokedex = new Pokedex();
        loadPokedexFromFile();

        setTitle("Pokédex");
        setUndecorated(true);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        var iconURL = getClass().getClassLoader().getResource("Icon.png");
        if (iconURL != null) {
            setIconImage(new ImageIcon(iconURL).getImage());
        } else {
            System.err.println("Icon not found");
        }

        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));

        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        var scrollPane = new JScrollPane(displayPanel);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        add(scrollPane, BorderLayout.CENTER);

        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(0xFF0000));
        panel.setPreferredSize(new Dimension(300, getHeight()));

        nameComboBox = new JComboBox<>(PokemonList.getPokemonNames());
        var nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);
        panel.add(nameComboBox);

        levelField = new JTextField(5);
        var levelLabel = new JLabel("Level:");
        levelLabel.setForeground(Color.WHITE);
        panel.add(levelLabel);
        panel.add(levelField);

        sexComboBox = new JComboBox<>(new String[]{"♂", "♀"});
        var sexLabel = new JLabel("Sex:");
        sexLabel.setForeground(Color.WHITE);
        panel.add(sexLabel);
        panel.add(sexComboBox);

        customNameField = new JTextField(1);
        var customNameLabel = new JLabel("Custom Name:");
        customNameLabel.setForeground(Color.WHITE);
        panel.add(customNameLabel);
        panel.add(customNameField);

        var addButton = new JButton("Add");
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(new Color(0x0000FF));
        addButton.setToolTipText("Add a new Pokémon to the Pokédex");
        addButton.setSize(new Dimension(200, 30));
        addButton.addActionListener(new AddButtonListener());
        panel.add(addButton);

        deleteComboBox = new JComboBox<>();
        updateDeleteComboBox();
        panel.add(deleteComboBox);

        var deleteButton = new JButton("Delete");
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(0x0000FF));
        deleteButton.setToolTipText("Delete a Pokémon from the Pokédex");
        deleteButton.setPreferredSize(new Dimension(80, 30));
        deleteButton.addActionListener(new DeleteButtonListener());
        panel.add(deleteButton);

        add(panel, BorderLayout.EAST);
        updateDisplayPanel();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int thisX = getLocation().x;
                int thisY = getLocation().y;
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                setLocation(X, Y);
            }
        });
    }

    private void loadPokedexFromFile() {
        var mapper = new ObjectMapper();
        try {
            var pokemonList = mapper.readValue(new File("pokedex.json"),
                    mapper.getTypeFactory().constructCollectionType(List.class, Pokemon.class));

            // Explicitly specify the type here
            for (var pokemon : (List<Pokemon>) pokemonList) {
                pokedex.addPokemon(pokemon);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading Pokédex file.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }



    private void savePokedexToFile() {
        var mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("pokedex.json"), pokedex.getPokemonList());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving Pokédex file.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void updateDeleteComboBox() {
        deleteComboBox.removeAllItems();
        for (var pokemon : pokedex.getPokemonList()) {
            deleteComboBox.addItem(pokemon.getName() + " (" + pokemon.getCustomName() + ")");
        }
    }

    private void updateDisplayPanel() {
        displayPanel.removeAll();
        for (var pokemon : pokedex.getPokemonList()) {
            var pokemonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            var imagePath = pokemon.getImagePath();
            JLabel iconLabel;
            if (imagePath != null) {
                iconLabel = new JLabel(new ImageIcon(imagePath));
            } else {
                iconLabel = new JLabel("Image not found");
            }
            var textLabel = new JLabel(pokemon.toString());
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
            var name = (String) nameComboBox.getSelectedItem();
            var type = PokemonList.getPokemonType(name);
            var levelText = levelField.getText();
            var sex = (String) sexComboBox.getSelectedItem();
            var customName = customNameField.getText().trim();

            if (!name.isEmpty() && !type.isEmpty() && !levelText.isEmpty() && !sex.isEmpty()) {
                try {
                    var level = Integer.parseInt(levelText);
                    if (level < 1 || level > 100) {
                        throw new NumberFormatException("Level must be between 1 and 100.");
                    }
                    if (customName.isEmpty()) {
                        customName = name;
                    }
                    var pokemon = new Pokemon(name, type, level, sex, customName);
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
            var selectedItem = (String) deleteComboBox.getSelectedItem();
            if (selectedItem != null && !selectedItem.isEmpty()) {
                var name = selectedItem.split(" \\(")[0];
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
            var gui = new PokedexGUI();
            gui.setVisible(true);
        });
    }

    private static class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = new Color(0xFF0000);
            this.trackColor = new Color(0x000000);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            var button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
    }
}
