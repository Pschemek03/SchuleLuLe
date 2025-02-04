package Aufgaben;

import Aufgaben.extras.*;
import Aufgaben.extras.GUI.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokedexGUI extends JFrame {
    private final Pokedex pokedex;
    private final JPanel displayPanel;
    private JComboBox<String> nameComboBox;
    private JTextField levelField;
    private JComboBox<String> sexComboBox;
    private JTextField customNameField;
    private JComboBox<String> deleteComboBox;
    private final JTextField searchField;
    private final JComboBox<String> sortComboBox;
    private final JComboBox<String> sortOrderComboBox;
    private final JButton sortButton;
    private Point initialClick;
    private JComboBox<String> deleteComboBox2;

    public PokedexGUI() {
        pokedex = new Pokedex();
        loadPokedexFromFile();
        setTitle("Pokédex");

        setUndecorated(true);
        setSize(1000, 950);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getRootPane().setBorder(new LineBorder(new Color(0x2C2C2C), 4));
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 18, 18));

        var iconURL = getClass().getClassLoader().getResource("Icon.png");
        setIconImage(new ImageIcon(Objects.requireNonNull(iconURL)).getImage());

        var titleImageURL = getClass().getClassLoader().getResource("pokeDex_Written.png");
        var titleLabel = new JLabel(titleImageURL != null ? new ImageIcon(titleImageURL) : null);
        titleLabel.setBackground(new Color(0x2C2C2C));
        titleLabel.setOpaque(true);

        var searchSortPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        searchSortPanel.setBackground(new Color(0x2C2C2C));
        searchSortPanel.setOpaque(true);

        searchField = createStyledTextField(15);
        var searchButton = createStyledButton("Search", 0x007ACC, 0x0099FF);
        searchButton.setBorder (new CompoundBorder(new RoundBorder(6, new Color(0x007ACC), 2), new EmptyBorder(8, 20, 8, 20)));
        searchButton.addActionListener(new SearchButtonListener(this));

        sortComboBox = createStyledComboBox(new String[]{"Alphabetically", "Level", "Type", "Sex"});
        sortComboBox.setBorder(new RoundBorder(2, new Color(0x606060), 5));

        sortOrderComboBox = createStyledComboBox(new String[]{"Ascending", "Descending"});
        sortOrderComboBox.setBorder(new RoundBorder(2, new Color(0x606060), 5));

        sortButton = createStyledButton("Sort", 0xCC0000, 0xFF3333);
        sortButton.setBorder(new CompoundBorder (new RoundBorder(6, new Color(0xCC0000), 2), new EmptyBorder(8, 20, 8, 20)));
        sortButton.addActionListener(new SortButtonListener());

        searchSortPanel.add(searchField);
        searchSortPanel.add(searchButton);
        searchSortPanel.add(sortComboBox);
        searchSortPanel.add(sortOrderComboBox);
        searchSortPanel.add(sortButton);

        var topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(searchSortPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        displayPanel.setBackground(new Color(0x2C2C2C));

        var scrollPane = new JScrollPane(displayPanel);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        add(scrollPane, BorderLayout.CENTER);

        var sidePanel = createSidePanel();
        add(sidePanel, BorderLayout.EAST);

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

    private JPanel createSidePanel() {

        var panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0x2C2C2C));

        var gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = gbc.gridy = 0;

        var compareButton = createStyledButton("Compare", 0x007ACC, 0x0099FF);
        compareButton.addActionListener(new CompareButtonListener());
        compareButton.setBorder(new CompoundBorder(new RoundBorder(10, new Color(0x00AA00), 1), new EmptyBorder(8, 20, 8, 20)));
        compareButton.addActionListener(new AddButtonListener());
        gbc.gridy++;
        panel.add(compareButton, gbc);

        nameComboBox = createStyledComboBox(PokemonList.getPokemonNames());
        nameComboBox.setBorder(new RoundBorder(2, new Color(0x606060), 5));
        panel.add(createStyledLabel("Name:"), gbc);
        gbc.gridy++;
        panel.add(nameComboBox, gbc);

        levelField = createStyledTextField(5);
        gbc.gridy++;
        panel.add(createStyledLabel("Level:"), gbc);
        gbc.gridy++;
        panel.add(levelField, gbc);

        sexComboBox = createStyledComboBox(new String[]{"♂", "♀"});
        sexComboBox.setBorder(new RoundBorder(2, new Color(0x606060), 5));
        gbc.gridy++;
        panel.add(createStyledLabel("Sex:"), gbc);
        gbc.gridy++;
        panel.add(sexComboBox, gbc);

        customNameField = createStyledTextField(15);
        gbc.gridy++;
        panel.add(createStyledLabel("Custom Name:"), gbc);
        gbc.gridy++;
        panel.add(customNameField, gbc);

        var addButton = createStyledButton("Add", 0x00AA00, 0x00CC00);
        addButton.setBorder(new CompoundBorder(new RoundBorder(10, new Color(0x00AA00), 1), new EmptyBorder(8, 20, 8, 20)));
        addButton.addActionListener(new AddButtonListener());
        gbc.gridy++;
        panel.add(addButton, gbc);

        deleteComboBox = createStyledComboBox(new String[0]);
        updateDeleteComboBox();
        deleteComboBox.setBorder(new RoundBorder(2, new Color(0x606060), 5));
        updateDeleteComboBox();
        gbc.gridy++;
        panel.add(deleteComboBox, gbc);

        deleteComboBox2 = createStyledComboBox(new String[0]);
        updateDeleteComboBox2();
        deleteComboBox2.setBorder(new RoundBorder(2, new Color(0x606060), 5));
        updateDeleteComboBox2();
        gbc.gridy++;
        panel.add(deleteComboBox2, gbc);

        var deleteButton = createStyledButton("Delete", 0xCC0000, 0xFF3333);
        deleteButton.setBorder(new CompoundBorder(new RoundBorder(10, new Color(0xCC0000), 2), new EmptyBorder(8, 20, 8, 20)));
        deleteButton.addActionListener(new DeleteButtonListener());
        gbc.gridy++;
        panel.add(deleteButton, gbc);

        return panel;
    }

    private JLabel createStyledLabel(String text) {
        var label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(0xE0E0E0));
        return label;
    }


    private JTextField createStyledTextField(int columns) {
        var field = new JTextField(columns);
        field.setFont(new Font("Arial", Font.BOLD, 14));
        field.setForeground(Color.WHITE);
        field.setBackground(new Color(0x404040));
        field.setCaretColor(Color.WHITE);
        field.setBorder(new CompoundBorder(new RoundBorder(8, new Color(0x606060), 1), new EmptyBorder(5, 10, 5, 10)));
        return field;
    }

    private JButton createStyledButton(String text, int baseColor, int hoverColor) {
        var button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(baseColor));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(hoverColor));
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(baseColor));
            }
        });
        return button;
    }

    private JComboBox<String> createStyledComboBox(String[] items) {
        var combo = new JComboBox<>(items);
        combo.setFont(new Font("Arial", Font.BOLD, 14));
        combo.setBackground(new Color(0x404040));
        combo.setForeground(new Color(0x404040));
        combo.setRenderer(new CustomComboBoxRenderer());
        combo.setUI(new BasicComboBoxUI() {
            protected JButton createArrowButton() {
                var button = super.createArrowButton();
                button.setBackground(new Color(0x606060));
                button.setBorder(new EmptyBorder(5, 10, 5, 10));
                return button;
            }
        });
        return combo;
    }

    private void loadPokedexFromFile() {
        var mapper = new ObjectMapper();
        try {
            var pokemonList = mapper.readValue(new File("pokedex.json"), mapper.getTypeFactory().constructCollectionType(List.class, Pokemon.class));

            for (var pokemon : (List<Pokemon>) pokemonList) {
                pokedex.addPokemon(pokemon);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading Pokédex file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void savePokedexToFile() {
        var mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("pokedex.json"), pokedex.getPokemonList());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving Pokédex file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDeleteComboBox() {
        deleteComboBox.removeAllItems();
        for (var pokemon : pokedex.getPokemonList()) {
            deleteComboBox.addItem(pokemon.getName() + " (" + pokemon.getCustomName() + ")");
        }
    }

    public void updateDisplayPanel() {
        displayPanel.removeAll();
        for (var pokemon : pokedex.getPokemonList()) {
            var pokemonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pokemonPanel.setBackground(new Color(0x2C2C2C));

            var imagePath = pokemon.getImagePath();
            JLabel iconLabel;
            if (imagePath != null) {
                iconLabel = new JLabel(new ImageIcon(imagePath));
            } else {
                iconLabel = new JLabel("Image not found");
            }

            var textLabel = new JLabel(pokemon.toString());
            textLabel.setForeground(Color.WHITE);

            pokemonPanel.add(iconLabel);
            pokemonPanel.add(textLabel);
            displayPanel.add(pokemonPanel);
        }
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    public void updateDisplayPanel(List<Pokemon> filteredList) {
        displayPanel.removeAll();
        for (var pokemon : filteredList) {
            var pokemonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pokemonPanel.setBackground(new Color(0x2C2C2C));

            var imagePath = pokemon.getImagePath();
            JLabel iconLabel;
            if (imagePath != null) {
                iconLabel = new JLabel(new ImageIcon(imagePath));
            } else {
                iconLabel = new JLabel("Image not found");
            }

            var textLabel = new JLabel(pokemon.toString());
            textLabel.setForeground(Color.WHITE);

            pokemonPanel.add(iconLabel);
            pokemonPanel.add(textLabel);
            displayPanel.add(pokemonPanel);
        }
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var name = (String) nameComboBox.getSelectedItem();
            var type = PokemonList.getPokemonType(name);
            var levelText = levelField.getText();
            var sex = (String) sexComboBox.getSelectedItem();
            var customName = customNameField.getText().trim();

            if (!Objects.requireNonNull(name).isEmpty() && !type.isEmpty() && !levelText.isEmpty() && !Objects.requireNonNull(sex).isEmpty()) {
                try {
                    var level = Integer.parseInt(levelText);
                    if (level < 1 || level > 100) {
                        throw new NumberFormatException("Level must be between 1 and 100.");
                    }
                    if (customName.isEmpty()) {
                        customName = name;
                    }

                    var basePokemon = PokemonList.getAllPokemon().stream().filter(p -> p.getName().equals(name)).findFirst().orElseThrow(() -> new IllegalArgumentException("Pokémon not found in list."));
                    var pokemon = new Pokemon(name, type, basePokemon.getDexId(), basePokemon.getHp(), basePokemon.getAttack(), basePokemon.getDefense(), basePokemon.getSpecial(), basePokemon.getSpeed(), level, sex, customName);

                    pokedex.addPokemon(pokemon);
                    savePokedexToFile();
                    levelField.setText("");
                    customNameField.setText("");
                    updateDeleteComboBox();
                    updateDisplayPanel();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PokedexGUI.this, "Please enter a valid level (1-100).", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(PokedexGUI.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private class SortButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var sortCriteria = (String) sortComboBox.getSelectedItem();
            var sortOrder = (String) sortOrderComboBox.getSelectedItem();
            var searchText = searchField.getText().trim().toLowerCase();

            List<Pokemon> filteredList;
            if (!searchText.isEmpty()) {
                filteredList = pokedex.getPokemonList().stream().filter(pokemon -> pokemon.getName().toLowerCase().contains(searchText) || pokemon.getCustomName().toLowerCase().contains(searchText)).collect(Collectors.toList());
            } else {
                filteredList = pokedex.getPokemonList();
            }

            List<Pokemon> sortedList = filteredList.stream().sorted(getComparator(Objects.requireNonNull(sortCriteria), sortOrder)).collect(Collectors.toList());

            updateDisplayPanel(sortedList);
        }

        private Comparator<Pokemon> getComparator(String criteria, String order) {
            Comparator<Pokemon> comparator;
            switch (criteria) {
                case "Level" -> comparator = Comparator.comparingInt(Pokemon::getLevel);
                case "Type" -> comparator = Comparator.comparing(Pokemon::getType);
                case "Sex" -> comparator = Comparator.comparing(Pokemon::getSex);
                case "ID" -> comparator = Comparator.comparingInt(Pokemon::getDexId);
                case "HealthPoints" -> comparator = Comparator.comparingInt(Pokemon::getHp);
                case "Attack" -> comparator = Comparator.comparingInt(Pokemon::getAttack);
                case "Defense" -> comparator = Comparator.comparingInt(Pokemon::getDefense);
                case "Special" -> comparator = Comparator.comparingInt(Pokemon::getSpecial);
                case "Speed" -> comparator = Comparator.comparingInt(Pokemon::getSpeed);
                default -> comparator = Comparator.comparing(Pokemon::getName);
            }
            if ("Descending".equals(order)) {
                comparator = comparator.reversed();
            }
            return comparator;
        }
    }

    private class CompareButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selected1 = (String) deleteComboBox.getSelectedItem();
            String selected2 = (String) deleteComboBox2.getSelectedItem(); //opp

            if (selected1 != null && selected2 != null) {
                var pokemon1 = pokedex.getPokemonList().stream()
                        .filter(p -> (p.getName() + " (" + p.getCustomName() + ")").equals(selected1))
                        .findFirst()
                        .orElse(null);

                var pokemon2 = pokedex.getPokemonList().stream()
                        .filter(p -> (p.getName() + " (" + p.getCustomName() + ")").equals(selected2))
                        .findFirst()
                        .orElse(null);

                if (pokemon1 != null && pokemon2 != null) {
                    // Open the comparison panel
                    var comparePanel = new ComparePanel(pokemon1, pokemon2);
                    var frame = new JFrame("Pokémon Comparison");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.add(comparePanel);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(PokedexGUI.this, "Please select two Pokémon to compare.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void updateDeleteComboBox2() {
        deleteComboBox2.removeAllItems();
        for (var pokemon : pokedex.getPokemonList()) {
            deleteComboBox2.addItem(pokemon.getName() + " (" + pokemon.getCustomName() + ")");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var gui = new PokedexGUI();
            gui.setVisible(true);
        });
    }

}