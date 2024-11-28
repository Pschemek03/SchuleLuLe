package Aufgaben.extras;

import java.util.ArrayList;
import java.util.List;

public class PokemonList {

    public static List<Pokemon> getAllPokemon() {
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon("Bulbasaur", "Grass/Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Ivysaur", "Grass/Poison", 16, "♂", ""));
        pokemonList.add(new Pokemon("Venusaur", "Grass/Poison", 32, "♂", ""));
        pokemonList.add(new Pokemon("Charmander", "Fire", 5, "♂", ""));
        pokemonList.add(new Pokemon("Charmeleon", "Fire", 16, "♂", ""));
        pokemonList.add(new Pokemon("Charizard", "Fire/Flying", 36, "♂", ""));
        pokemonList.add(new Pokemon("Squirtle", "Water", 5, "♂", ""));
        pokemonList.add(new Pokemon("Wartortle", "Water", 16, "♂", ""));
        pokemonList.add(new Pokemon("Blastoise", "Water", 36, "♂", ""));
        pokemonList.add(new Pokemon("Caterpie", "Bug", 5, "♂", ""));
        pokemonList.add(new Pokemon("Metapod", "Bug", 7, "♂", ""));
        pokemonList.add(new Pokemon("Butterfree", "Bug/Flying", 10, "♂", ""));
        pokemonList.add(new Pokemon("Weedle", "Bug/Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Kakuna", "Bug/Poison", 7, "♂", ""));
        pokemonList.add(new Pokemon("Beedrill", "Bug/Poison", 10, "♂", ""));
        pokemonList.add(new Pokemon("Pidgey", "Normal/Flying", 5, "♂", ""));
        pokemonList.add(new Pokemon("Pidgeotto", "Normal/Flying", 18, "♂", ""));
        pokemonList.add(new Pokemon("Pidgeot", "Normal/Flying", 36, "♂", ""));
        pokemonList.add(new Pokemon("Rattata", "Normal", 5, "♂", ""));
        pokemonList.add(new Pokemon("Raticate", "Normal", 20, "♂", ""));
        pokemonList.add(new Pokemon("Spearow", "Normal/Flying", 5, "♂", ""));
        pokemonList.add(new Pokemon("Fearow", "Normal/Flying", 20, "♂", ""));
        pokemonList.add(new Pokemon("Ekans", "Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Arbok", "Poison", 22, "♂", ""));
        pokemonList.add(new Pokemon("Pikachu", "Electric", 5, "♂", ""));
        pokemonList.add(new Pokemon("Raichu", "Electric", 22, "♂", ""));
        pokemonList.add(new Pokemon("Sandshrew", "Ground", 5, "♂", ""));
        pokemonList.add(new Pokemon("Sandslash", "Ground", 22, "♂", ""));
        pokemonList.add(new Pokemon("Nidoran♀", "Poison", 5, "♀", ""));
        pokemonList.add(new Pokemon("Nidorina", "Poison", 16, "♀", ""));
        pokemonList.add(new Pokemon("Nidoqueen", "Poison/Ground", 36, "♀", ""));
        pokemonList.add(new Pokemon("Nidoran♂", "Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Nidorino", "Poison", 16, "♂", ""));
        pokemonList.add(new Pokemon("Nidoking", "Poison/Ground", 36, "♂", ""));
        pokemonList.add(new Pokemon("Clefairy", "Fairy", 5, "♀", ""));
        pokemonList.add(new Pokemon("Clefable", "Fairy", 36, "♀", ""));
        pokemonList.add(new Pokemon("Vulpix", "Fire", 5, "♀", ""));
        pokemonList.add(new Pokemon("Ninetales", "Fire", 36, "♀", ""));
        pokemonList.add(new Pokemon("Jigglypuff", "Normal/Fairy", 5, "♀", ""));
        pokemonList.add(new Pokemon("Wigglytuff", "Normal/Fairy", 36, "♀", ""));
        pokemonList.add(new Pokemon("Zubat", "Poison/Flying", 5, "♂", ""));
        pokemonList.add(new Pokemon("Golbat", "Poison/Flying", 22, "♂", ""));
        pokemonList.add(new Pokemon("Oddish", "Grass/Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Gloom", "Grass/Poison", 21, "♂", ""));
        pokemonList.add(new Pokemon("Vileplume", "Grass/Poison", 36, "♂", ""));
        pokemonList.add(new Pokemon("Paras", "Bug/Grass", 5, "♂", ""));
        pokemonList.add(new Pokemon("Parasect", "Bug/Grass", 24, "♂", ""));
        pokemonList.add(new Pokemon("Venonat", "Bug/Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Venomoth", "Bug/Poison", 31, "♂", ""));
        pokemonList.add(new Pokemon("Diglett", "Ground", 5, "♂", ""));
        pokemonList.add(new Pokemon("Dugtrio", "Ground", 26, "♂", ""));
        pokemonList.add(new Pokemon("Meowth", "Normal", 5, "♂", ""));
        pokemonList.add(new Pokemon("Persian", "Normal", 28, "♂", ""));
        pokemonList.add(new Pokemon("Psyduck", "Water", 5, "♂", ""));
        pokemonList.add(new Pokemon("Golduck", "Water", 33, "♂", ""));
        pokemonList.add(new Pokemon("Mankey", "Fighting", 5, "♂", ""));
        pokemonList.add(new Pokemon("Primeape", "Fighting", 28, "♂", ""));
        pokemonList.add(new Pokemon("Growlithe", "Fire", 5, "♂", ""));
        pokemonList.add(new Pokemon("Arcanine", "Fire", 36, "♂", ""));
        pokemonList.add(new Pokemon("Poliwag", "Water", 5, "♂", ""));
        pokemonList.add(new Pokemon("Poliwhirl", "Water", 25, "♂", ""));
        pokemonList.add(new Pokemon("Poliwrath", "Water/Fighting", 36, "♂", ""));
        pokemonList.add(new Pokemon("Abra", "Psychic", 5, "♂", ""));
        pokemonList.add(new Pokemon("Kadabra", "Psychic", 16, "♂", ""));
        pokemonList.add(new Pokemon("Alakazam", "Psychic", 36, "♂", ""));
        pokemonList.add(new Pokemon("Machop", "Fighting", 5, "♂", ""));
        pokemonList.add(new Pokemon("Machoke", "Fighting", 28, "♂", ""));
        pokemonList.add(new Pokemon("Machamp", "Fighting", 36, "♂", ""));
        pokemonList.add(new Pokemon("Bellsprout", "Grass/Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Weepinbell", "Grass/Poison", 21, "♂", ""));
        pokemonList.add(new Pokemon("Victreebel", "Grass/Poison", 36, "♂", ""));
        pokemonList.add(new Pokemon("Tentacool", "Water/Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Tentacruel", "Water/Poison", 30, "♂", ""));
        pokemonList.add(new Pokemon("Geodude", "Rock/Ground", 5, "♂", ""));
        pokemonList.add(new Pokemon("Graveler", "Rock/Ground", 25, "♂", ""));
        pokemonList.add(new Pokemon("Golem", "Rock/Ground", 36, "♂", ""));
        pokemonList.add(new Pokemon("Ponyta", "Fire", 5, "♀", ""));
        pokemonList.add(new Pokemon("Rapidash", "Fire", 40, "♀", ""));
        pokemonList.add(new Pokemon("Slowpoke", "Water/Psychic", 5, "♂", ""));
        pokemonList.add(new Pokemon("Slowbro", "Water/Psychic", 37, "♂", ""));
        pokemonList.add(new Pokemon("Magnemite", "Electric/Steel", 5, "N/A", ""));
        pokemonList.add(new Pokemon("Magneton", "Electric/Steel", 30, "N/A", ""));
        pokemonList.add(new Pokemon("Farfetch'd", "Normal/Flying", 5, "♂", ""));
        pokemonList.add(new Pokemon("Doduo", "Normal/Flying", 5, "♂", ""));
        pokemonList.add(new Pokemon("Dodrio", "Normal/Flying", 31, "♂", ""));
        pokemonList.add(new Pokemon("Seel", "Water", 5, "♂", ""));
        pokemonList.add(new Pokemon("Dewgong", "Water/Ice", 34, "♂", ""));
        pokemonList.add(new Pokemon("Grimer", "Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Muk", "Poison", 38, "♂", ""));
        pokemonList.add(new Pokemon("Shellder", "Water", 5, "♂", ""));
        pokemonList.add(new Pokemon("Cloyster", "Water/Ice", 36, "♂", ""));
        pokemonList.add(new Pokemon("Gastly", "Ghost/Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Haunter", "Ghost/Poison", 25, "♂", ""));
        pokemonList.add(new Pokemon("Gengar", "Ghost/Poison", 36, "♂", ""));
        pokemonList.add(new Pokemon("Onix", "Rock/Ground", 5, "♂", ""));
        pokemonList.add(new Pokemon("Drowzee", "Psychic", 5, "♂", ""));
        pokemonList.add(new Pokemon("Hypno", "Psychic", 26, "♂", ""));
        pokemonList.add(new Pokemon("Krabby", "Water", 5, "♂", ""));
        pokemonList.add(new Pokemon("Kingler", "Water", 28, "♂", ""));
        pokemonList.add(new Pokemon("Voltorb", "Electric", 5, "N/A", ""));
        pokemonList.add(new Pokemon("Electrode", "Electric", 30, "N/A", ""));
        pokemonList.add(new Pokemon("Exeggcute", "Grass/Psychic", 5, "N/A", ""));
        pokemonList.add(new Pokemon("Exeggutor", "Grass/Psychic", 36, "N/A", ""));
        pokemonList.add(new Pokemon("Cubone", "Ground", 5, "♂", ""));
        pokemonList.add(new Pokemon("Marowak", "Ground", 28, "♂", ""));
        pokemonList.add(new Pokemon("Hitmonlee", "Fighting", 5, "♂", ""));
        pokemonList.add(new Pokemon("Hitmonchan", "Fighting", 5, "♂", ""));
        pokemonList.add(new Pokemon("Lickitung", "Normal", 5, "♂", ""));
        pokemonList.add(new Pokemon("Koffing", "Poison", 5, "♂", ""));
        pokemonList.add(new Pokemon("Weezing", "Poison", 35, "♂", ""));
        pokemonList.add(new Pokemon("Rhyhorn", "Ground/Rock", 5, "♂", ""));
        pokemonList.add(new Pokemon("Rhydon", "Ground/Rock", 42, "♂", ""));
        pokemonList.add(new Pokemon("Chansey", "Normal", 5, "♀", ""));
        pokemonList.add(new Pokemon("Tangela", "Grass", 5, "♀", ""));
        pokemonList.add(new Pokemon("Kangaskhan", "Normal", 5, "♀", ""));
        pokemonList.add(new Pokemon("Horsea", "Water", 5, "♂", ""));
        pokemonList.add(new Pokemon("Seadra", "Water", 32, "♂", ""));
        pokemonList.add(new Pokemon("Goldeen", "Water", 5, "♀", ""));
        pokemonList.add(new Pokemon("Seaking", "Water", 33, "♂", ""));
        pokemonList.add(new Pokemon("Staryu", "Water", 5, "N/A", ""));
        pokemonList.add(new Pokemon("Starmie", "Water/Psychic", 36, "N/A", ""));
        pokemonList.add(new Pokemon("Mr. Mime", "Psychic/Fairy", 5, "♂", ""));
        pokemonList.add(new Pokemon("Scyther", "Bug/Flying", 5, "♂", ""));
        pokemonList.add(new Pokemon("Jynx", "Ice/Psychic", 5, "♀", ""));
        pokemonList.add(new Pokemon("Electabuzz", "Electric", 5, "♂", ""));
        pokemonList.add(new Pokemon("Magmar", "Fire", 5, "♂", ""));
        pokemonList.add(new Pokemon("Pinsir", "Bug", 5, "♂", ""));
        pokemonList.add(new Pokemon("Tauros", "Normal", 5, "♂", ""));
        pokemonList.add(new Pokemon("Magikarp", "Water", 5, "♂", ""));
        pokemonList.add(new Pokemon("Gyarados", "Water/Flying", 20, "♂", ""));
        pokemonList.add(new Pokemon("Lapras", "Water/Ice", 5, "♀", ""));
        pokemonList.add(new Pokemon("Ditto", "Normal", 5, "N/A", ""));
        pokemonList.add(new Pokemon("Eevee", "Normal", 5, "♂", ""));
        pokemonList.add(new Pokemon("Vaporeon", "Water", 36, "♂", ""));
        pokemonList.add(new Pokemon("Jolteon", "Electric", 36, "♂", ""));
        pokemonList.add(new Pokemon("Flareon", "Fire", 36, "♂", ""));
        pokemonList.add(new Pokemon("Porygon", "Normal", 5, "N/A", ""));
        pokemonList.add(new Pokemon("Omanyte", "Rock/Water", 5, "♂", ""));
        pokemonList.add(new Pokemon("Omastar", "Rock/Water", 40, "♂", ""));
        pokemonList.add(new Pokemon("Kabuto", "Rock/Water", 5, "♂", ""));
        pokemonList.add(new Pokemon("Kabutops", "Rock/Water", 40, "♂", ""));
        pokemonList.add(new Pokemon("Aerodactyl", "Rock/Flying", 5, "♂", ""));
        pokemonList.add(new Pokemon("Snorlax", "Normal", 5, "♂", ""));
        pokemonList.add(new Pokemon("Articuno", "Ice/Flying", 50, "N/A", ""));
        pokemonList.add(new Pokemon("Zapdos", "Electric/Flying", 50, "N/A", ""));
        pokemonList.add(new Pokemon("Moltres", "Fire/Flying", 50, "N/A", ""));
        pokemonList.add(new Pokemon("Dratini", "Dragon", 5, "♂", ""));
        pokemonList.add(new Pokemon("Dragonair", "Dragon", 30, "♂", ""));
        pokemonList.add(new Pokemon("Dragonite", "Dragon/Flying", 55, "♂", ""));
        pokemonList.add(new Pokemon("Mewtwo", "Psychic", 70, "N/A", ""));
        pokemonList.add(new Pokemon("Mew", "Psychic", 5, "N/A", ""));
        return pokemonList;
    }

    public static String[] getPokemonNames() {
        List<Pokemon> pokemonList = getAllPokemon();
        String[] names = new String[pokemonList.size()];
        for (int i = 0; i < pokemonList.size(); i++) {
            names[i] = pokemonList.get(i).getName();
        }
        return names;
    }

    public static String getPokemonType(String name) {
        for (Pokemon pokemon : getAllPokemon()) {
            if (pokemon.getName().equals(name)) {
                return pokemon.getType();
            }
        }
        return "Unknown";
    }
}