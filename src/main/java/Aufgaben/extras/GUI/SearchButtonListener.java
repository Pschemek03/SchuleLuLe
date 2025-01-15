package Aufgaben.extras.GUI;

import Aufgaben.*;
import Aufgaben.extras.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class SearchButtonListener implements ActionListener {
    private PokedexGUI pokedexGUI;

    public SearchButtonListener(PokedexGUI pokedexGUI) {
        this.pokedexGUI = pokedexGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        pokedexGUI.updateDisplayPanel(filteredList);
    }
}