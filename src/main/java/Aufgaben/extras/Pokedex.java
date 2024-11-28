package Aufgaben.extras;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {
    private List<Pokemon> pokemonList;

    public Pokedex() {
        this.pokemonList = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public void removePokemon(String name) {
        pokemonList.removeIf(pokemon -> pokemon.getName().equalsIgnoreCase(name));
    }

    public void displayAllPokemon() {
        if (pokemonList.isEmpty()) {
            System.out.println("No Pokemon in the Pokedex.");
        } else {
            for (Pokemon pokemon : pokemonList) {
                System.out.println(pokemon);
            }
        }
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }
}