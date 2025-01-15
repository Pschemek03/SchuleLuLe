package Aufgaben;

import Aufgaben.extras.*;
import Aufgaben.extras.GUI.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokedexGUI extends JFrame {
    private Pokedex pokedex;
    private JPanel displayPanel;
    private JComboBox<String> nameComboBox;
    private JTextField levelField;
    private JComboBox<String> sexComboBox;
    private JTextField customNameField;
    private JComboBox<String> deleteComboBox;
    private JTextField searchField;
    private JComboBox<String> sortComboBox;
    private JComboBox<String> sortOrderComboBox;
    private JButton sortButton;
    private Point initialClick;

    public PokedexGUI() {
        pokedex = new Pokedex();
        loadPokedexFromFile();

        setUndecorated(true);
        setSize(820, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var outerBorder = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 4));
        getRootPane().setBorder(outerBorder);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        var iconURL = getClass().getClassLoader().getResource("Icon.png");
        if (iconURL != null) {
            setIconImage(new ImageIcon(iconURL).getImage());
        } else {
            System.err.println("Icon not found");
        }

        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));

        var titleImageURL = getClass().getClassLoader().getResource("pokeDex_Written.png");
        JLabel titleLabel = null;
        if (titleImageURL != null) {
            titleLabel = new JLabel(new ImageIcon(titleImageURL));
            titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        } else {
            System.err.println("Title image not found");
        }

        var searchSortPanel = new JPanel();
        searchSortPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        searchSortPanel.setBackground(new Color(0xFFDD0000, true));

        searchField = new JTextField(15);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setToolTipText("Enter the name of the Pokémon to search");
        var searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.addActionListener(new SearchButtonListener(this));

        sortComboBox = new JComboBox<>(new String[]{"Alphabetically", "Level", "Type", "Sex"});
        sortComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        sortComboBox.setToolTipText("Select the criteria to sort the Pokémon");
        sortOrderComboBox = new JComboBox<>(new String[]{"Ascending", "Descending"});
        sortOrderComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        sortOrderComboBox.setToolTipText("Select the order to sort the Pokémon");
        sortButton = new JButton("Sort");
        sortButton.setFont(new Font("Arial", Font.BOLD, 14));
        sortButton.addActionListener(new SortButtonListener());

        searchSortPanel.add(searchField);
        searchSortPanel.add(searchButton);
        searchSortPanel.add(sortComboBox);
        searchSortPanel.add(sortOrderComboBox);
        searchSortPanel.add(sortButton);

        var topPanel = new JPanel(new BorderLayout());
        if (titleLabel != null) {
            topPanel.add(titleLabel, BorderLayout.WEST);
        }
        topPanel.add(searchSortPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        var scrollPane = new JScrollPane(displayPanel);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        add(scrollPane, BorderLayout.CENTER);

        var panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0xFFDD0000, true));
        panel.setPreferredSize(new Dimension(300, getHeight()));
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        var gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        nameComboBox = new JComboBox<>(PokemonList.getPokemonNames());
        var nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel, gbc);
        gbc.gridy++;
        panel.add(nameComboBox, gbc);

        levelField = new JTextField(5);
        var levelLabel = new JLabel("Level:");
        levelLabel.setFont(new Font("Arial", Font.BOLD, 14));
        levelLabel.setForeground(Color.WHITE);
        gbc.gridy++;
        panel.add(levelLabel, gbc);
        gbc.gridy++;
        panel.add(levelField, gbc);

        sexComboBox = new JComboBox<>(new String[]{"♂", "♀"});
        var sexLabel = new JLabel("Sex:");
        sexLabel.setFont(new Font("Arial", Font.BOLD, 14));
        sexLabel.setForeground(Color.WHITE);
        gbc.gridy++;
        panel.add(sexLabel, gbc);
        gbc.gridy++;
        panel.add(sexComboBox, gbc);

        customNameField = new JTextField(1);
        var customNameLabel = new JLabel("Custom Name:");
        customNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        customNameLabel.setForeground(Color.WHITE);
        gbc.gridy++;
        panel.add(customNameLabel, gbc);
        gbc.gridy++;
        panel.add(customNameField, gbc);

        var addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(new Color(0x0000FF));
        addButton.setToolTipText("Add a new Pokémon to the Pokédex");
        addButton.setSize(new Dimension(200, 30));
        addButton.addActionListener(new AddButtonListener());
        gbc.gridy++;
        panel.add(addButton, gbc);

        deleteComboBox = new JComboBox<>();
        updateDeleteComboBox();
        gbc.gridy++;
        panel.add(deleteComboBox, gbc);

        var deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(0xFF9A00));
        deleteButton.setToolTipText("Delete a Pokémon from the Pokédex");
        deleteButton.setPreferredSize(new Dimension(80, 30));
        deleteButton.addActionListener(new DeleteButtonListener());
        gbc.gridy++;
        panel.add(deleteButton, gbc);

        add(panel, BorderLayout.EAST);

        var wavyBorderPanel = new WavyBorderPanel();
        add(wavyBorderPanel, BorderLayout.WEST);

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
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("pokedex.json"), pokedex.getPokemonList());
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

    public void updateDisplayPanel() {
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

    public void updateDisplayPanel(List<Pokemon> filteredList) {
        displayPanel.removeAll();
        for (var pokemon : filteredList) {
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

    public Pokedex getPokedex() {
        return pokedex;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JComboBox<String> getSortComboBox() {
        return sortComboBox;
    }

    public JComboBox<String> getSortOrderComboBox() {
        return sortOrderComboBox;
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

    private class SortButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var sortCriteria = (String) sortComboBox.getSelectedItem();
            var sortOrder = (String) sortOrderComboBox.getSelectedItem();
            var searchText = searchField.getText().trim().toLowerCase();

            List<Pokemon> filteredList;
            if (!searchText.isEmpty()) {
                filteredList = pokedex.getPokemonList().stream()
                        .filter(pokemon -> pokemon.getName().toLowerCase().contains(searchText) ||
                                pokemon.getCustomName().toLowerCase().contains(searchText))
                        .collect(Collectors.toList());
            } else {
                filteredList = pokedex.getPokemonList();
            }

            List<Pokemon> sortedList = filteredList.stream()
                    .sorted(getComparator(sortCriteria, sortOrder))
                    .collect(Collectors.toList());

            updateDisplayPanel(sortedList);
        }

        private Comparator<Pokemon> getComparator(String criteria, String order) {
            Comparator<Pokemon> comparator;
            switch (criteria) {
                case "Level":
                    comparator = Comparator.comparingInt(Pokemon::getLevel);
                    break;
                case "Type":
                    comparator = Comparator.comparing(Pokemon::getType);
                    break;
                case "Sex":
                    comparator = Comparator.comparing(Pokemon::getSex);
                    break;
                default:
                    comparator = Comparator.comparing(Pokemon::getName);
            }
            if ("Descending".equals(order)) {
                comparator = comparator.reversed();
            }
            return comparator;
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