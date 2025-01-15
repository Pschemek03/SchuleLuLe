package Aufgaben.extras.GUI;

import Aufgaben.PokedexGUI;
import Aufgaben.extras.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortButtonListener implements ActionListener {
    private PokedexGUI pokedexGUI;

    public SortButtonListener(PokedexGUI pokedexGUI) {
        this.pokedexGUI = pokedexGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var sortCriteria = (String) pokedexGUI.getSortComboBox().getSelectedItem();
        var sortOrder = (String) pokedexGUI.getSortOrderComboBox().getSelectedItem();
        var searchText = pokedexGUI.getSearchField().getText().trim().toLowerCase();

        List<Pokemon> filteredList;
        if (!searchText.isEmpty()) {
            filteredList = pokedexGUI.getPokedex().getPokemonList().stream()
                    .filter(pokemon -> pokemon.getName().toLowerCase().contains(searchText) ||
                            pokemon.getCustomName().toLowerCase().contains(searchText))
                    .collect(Collectors.toList());
        } else {
            filteredList = pokedexGUI.getPokedex().getPokemonList();
        }

        List<Pokemon> sortedList = filteredList.stream()
                .sorted(getComparator(sortCriteria, sortOrder))
                .collect(Collectors.toList());

        pokedexGUI.updateDisplayPanel(sortedList);
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