package extras;

import java.util.ArrayList;
import java.util.List;

public class PokemonList {

    public static List<Pokemon> getAllPokemon() {
        List<Pokemon> pokemonList = new ArrayList<>();

        pokemonList.add(new Pokemon("Bulbasaur", "Grass/Poison", 1, 45, 49, 49, 65, 45, 5, "♂", ""));
        pokemonList.add(new Pokemon("Ivysaur", "Grass/Poison", 2, 60, 62, 63, 80, 60, 16, "♂", ""));
        pokemonList.add(new Pokemon("Venusaur", "Grass/Poison", 3, 80, 82, 83, 100, 80, 32, "♂", ""));
        pokemonList.add(new Pokemon("Charmander", "Fire", 4, 39, 52, 43, 60, 65, 5, "♂", ""));
        pokemonList.add(new Pokemon("Charmeleon", "Fire", 5, 58, 64, 58, 80, 80, 16, "♂", ""));
        pokemonList.add(new Pokemon("Charizard", "Fire/Flying", 6, 78, 84, 78, 109, 100, 36, "♂", ""));
        pokemonList.add(new Pokemon("Squirtle", "Water", 7, 44, 48, 65, 50, 43, 5, "♂", ""));
        pokemonList.add(new Pokemon("Wartortle", "Water", 8, 59, 63, 80, 65, 58, 16, "♂", ""));
        pokemonList.add(new Pokemon("Blastoise", "Water", 9, 79, 83, 100, 85, 78, 36, "♂", ""));
        pokemonList.add(new Pokemon("Caterpie", "Bug", 10, 45, 30, 35, 20, 45, 5, "♂", ""));
        pokemonList.add(new Pokemon("Metapod", "Bug", 11, 50, 20, 55, 25, 30, 7, "♂", ""));
        pokemonList.add(new Pokemon("Butterfree", "Bug/Flying", 12, 60, 45, 50, 90, 70, 10, "♂", ""));
        pokemonList.add(new Pokemon("Weedle", "Bug/Poison", 13, 40, 35, 30, 20, 50, 5, "♂", ""));
        pokemonList.add(new Pokemon("Kakuna", "Bug/Poison", 14, 45, 25, 50, 25, 35, 7, "♂", ""));
        pokemonList.add(new Pokemon("Beedrill", "Bug/Poison", 15, 65, 90, 40, 45, 75, 10, "♂", ""));
        pokemonList.add(new Pokemon("Pidgey", "Normal/Flying", 16, 40, 45, 40, 35, 56, 5, "♂", ""));
        pokemonList.add(new Pokemon("Pidgeotto", "Normal/Flying", 17, 63, 60, 55, 50, 71, 18, "♂", ""));
        pokemonList.add(new Pokemon("Pidgeot", "Normal/Flying", 18, 83, 80, 75, 70, 101, 36, "♂", ""));
        pokemonList.add(new Pokemon("Rattata", "Normal", 19, 30, 56, 35, 25, 72, 5, "♂", ""));
        pokemonList.add(new Pokemon("Raticate", "Normal", 20, 55, 81, 60, 50, 97, 20, "♂", ""));
        pokemonList.add(new Pokemon("Spearow", "Normal/Flying", 21, 40, 60, 30, 31, 70, 5, "♂", ""));
        pokemonList.add(new Pokemon("Fearow", "Normal/Flying", 22, 65, 90, 65, 61, 100, 20, "♂", ""));
        pokemonList.add(new Pokemon("Ekans", "Poison", 23, 35, 60, 44, 40, 55, 5, "♂", ""));
        pokemonList.add(new Pokemon("Arbok", "Poison", 24, 60, 95, 69, 65, 80, 22, "♂", ""));
        pokemonList.add(new Pokemon("Pikachu", "Electric", 25, 35, 55, 40, 50, 90, 5, "♂", ""));
        pokemonList.add(new Pokemon("Raichu", "Electric", 26, 60, 90, 55, 90, 110, 22, "♂", ""));
        pokemonList.add(new Pokemon("Sandshrew", "Ground", 27, 50, 75, 85, 30, 40, 5, "♂", ""));
        pokemonList.add(new Pokemon("Sandslash", "Ground", 28, 75, 100, 110, 45, 65, 22, "♂", ""));
        pokemonList.add(new Pokemon("Nidoran♀", "Poison", 29, 55, 47, 52, 40, 41, 5, "♀", ""));
        pokemonList.add(new Pokemon("Nidorina", "Poison", 30, 70, 62, 67, 55, 56, 16, "♀", ""));
        pokemonList.add(new Pokemon("Nidoqueen", "Poison/Ground", 31, 90, 92, 87, 75, 76, 36, "♀", ""));
        pokemonList.add(new Pokemon("Nidoran♂", "Poison", 32, 46, 57, 40, 40, 50, 5, "♂", ""));
        pokemonList.add(new Pokemon("Nidorino", "Poison", 33, 61, 72, 57, 55, 65, 16, "♂", ""));
        pokemonList.add(new Pokemon("Nidoking", "Poison/Ground", 34, 81, 102, 77, 75, 85, 36, "♂", ""));
        pokemonList.add(new Pokemon("Clefairy", "Fairy", 35, 70, 45, 48, 60, 35, 5, "♀", ""));
        pokemonList.add(new Pokemon("Clefable", "Fairy", 36, 95, 70, 73, 95, 60, 36, "♀", ""));
        pokemonList.add(new Pokemon("Vulpix", "Fire", 37, 38, 41, 40, 65, 65, 5, "♀", ""));
        pokemonList.add(new Pokemon("Ninetales", "Fire", 38, 73, 76, 75, 100, 100, 36, "♀", ""));
        pokemonList.add(new Pokemon("Jigglypuff", "Normal/Fairy", 39, 115, 45, 20, 45, 20, 5, "♀", ""));
        pokemonList.add(new Pokemon("Wigglytuff", "Normal/Fairy", 40, 140, 70, 45, 85, 45, 36, "♀", ""));
        pokemonList.add(new Pokemon("Zubat", "Poison/Flying", 41, 40, 45, 35, 40, 55, 5, "♂", ""));
        pokemonList.add(new Pokemon("Golbat", "Poison/Flying", 42, 75, 80, 70, 75, 90, 22, "♂", ""));
        pokemonList.add(new Pokemon("Oddish", "Grass/Poison", 43, 45, 50, 55, 75, 30, 5, "♂", ""));
        pokemonList.add(new Pokemon("Gloom", "Grass/Poison", 44, 60, 65, 70, 85, 40, 21, "♂", ""));
        pokemonList.add(new Pokemon("Vileplume", "Grass/Poison", 45, 75, 80, 85, 110, 50, 36, "♂", ""));
        pokemonList.add(new Pokemon("Paras", "Bug/Grass", 46, 35, 70, 55, 55, 25, 5, "♂", ""));
        pokemonList.add(new Pokemon("Parasect", "Bug/Grass", 47, 60, 95, 80, 80, 30, 24, "♂", ""));
        pokemonList.add(new Pokemon("Venonat", "Bug/Poison", 48, 60, 55, 50, 40, 45, 5, "♂", ""));
        pokemonList.add(new Pokemon("Venomoth", "Bug/Poison", 49, 70, 65, 60, 90, 90, 31, "♂", ""));
        pokemonList.add(new Pokemon("Diglett", "Ground", 50, 10, 55, 25, 45, 95, 5, "♂", ""));
        pokemonList.add(new Pokemon("Dugtrio", "Ground", 51, 35, 100, 50, 70, 120, 26, "♂", ""));
        pokemonList.add(new Pokemon("Meowth", "Normal", 52, 40, 45, 35, 40, 90, 5, "♂", ""));
        pokemonList.add(new Pokemon("Persian", "Normal", 53, 65, 70, 60, 65, 115, 28, "♂", ""));
        pokemonList.add(new Pokemon("Psyduck", "Water", 54, 50, 52, 48, 65, 55, 5, "♂", ""));
        pokemonList.add(new Pokemon("Golduck", "Water", 55, 80, 82, 78, 95, 85, 33, "♂", ""));
        pokemonList.add(new Pokemon("Mankey", "Fighting", 56, 40, 80, 35, 35, 70, 5, "♂", ""));
        pokemonList.add(new Pokemon("Primeape", "Fighting", 57, 65, 105, 60, 60, 95, 28, "♂", ""));
        pokemonList.add(new Pokemon("Growlithe", "Fire", 58, 55, 70, 45, 70, 60, 5, "♂", ""));
        pokemonList.add(new Pokemon("Arcanine", "Fire", 59, 90, 110, 80, 100, 95, 36, "♂", ""));
        pokemonList.add(new Pokemon("Poliwag", "Water", 60, 40, 50, 40, 40, 90, 5, "♂", ""));
        pokemonList.add(new Pokemon("Poliwhirl", "Water", 61, 65, 65, 65, 50, 90, 25, "♂", ""));
        pokemonList.add(new Pokemon("Poliwrath", "Water/Fighting", 62, 90, 95, 95, 70, 70, 36, "♂", ""));
        pokemonList.add(new Pokemon("Abra", "Psychic", 63, 25, 20, 15, 105, 90, 5, "♂", ""));
        pokemonList.add(new Pokemon("Kadabra", "Psychic", 64, 40, 35, 30, 120, 105, 16, "♂", ""));
        pokemonList.add(new Pokemon("Alakazam", "Psychic", 65, 55, 50, 45, 135, 120, 36, "♂", ""));
        pokemonList.add(new Pokemon("Machop", "Fighting", 66, 70, 80, 50, 35, 35, 5, "♂", ""));
        pokemonList.add(new Pokemon("Machoke", "Fighting", 67, 80, 100, 70, 50, 45, 28, "♂", ""));
        pokemonList.add(new Pokemon("Machamp", "Fighting", 68, 90, 130, 80, 65, 55, 36, "♂", ""));
        pokemonList.add(new Pokemon("Bellsprout", "Grass/Poison", 69, 50, 75, 35, 70, 40, 5, "♂", ""));
        pokemonList.add(new Pokemon("Weepinbell", "Grass/Poison", 70, 65, 90, 50, 85, 55, 21, "♂", ""));
        pokemonList.add(new Pokemon("Victreebel", "Grass/Poison", 71, 80, 105, 65, 100, 70, 36, "♂", ""));
        pokemonList.add(new Pokemon("Tentacool", "Water/Poison", 72, 40, 40, 35, 100, 70, 5, "♂", ""));
        pokemonList.add(new Pokemon("Tentacruel", "Water/Poison", 73, 80, 70, 65, 120, 100, 30, "♂", ""));
        pokemonList.add(new Pokemon("Geodude", "Rock/Ground", 74, 40, 80, 100, 30, 20, 5, "♂", ""));
        pokemonList.add(new Pokemon("Graveler", "Rock/Ground", 75, 55, 95, 115, 45, 35, 25, "♂", ""));
        pokemonList.add(new Pokemon("Golem", "Rock/Ground", 76, 80, 120, 130, 55, 45, 36, "♂", ""));
        pokemonList.add(new Pokemon("Ponyta", "Fire", 77, 50, 85, 55, 65, 90, 5, "♀", ""));
        pokemonList.add(new Pokemon("Rapidash", "Fire", 78, 65, 100, 70, 80, 105, 40, "♀", ""));
        pokemonList.add(new Pokemon("Slowpoke", "Water/Psychic", 79, 90, 65, 65, 40, 15, 5, "♂", ""));
        pokemonList.add(new Pokemon("Slowbro", "Water/Psychic", 80, 95, 75, 110, 100, 30, 37, "♂", ""));
        pokemonList.add(new Pokemon("Magnemite", "Electric", 81, 25, 35, 70, 95, 45, 5, "N/A", ""));
        pokemonList.add(new Pokemon("Magneton", "Electric", 82, 50, 60, 95, 120, 70, 30, "N/A", ""));
        pokemonList.add(new Pokemon("Farfetch'd", "Normal/Flying", 83, 52, 90, 55, 58, 60, 5, "♂", ""));
        pokemonList.add(new Pokemon("Doduo", "Normal/Flying", 84, 35, 85, 45, 35, 75, 5, "♂", ""));
        pokemonList.add(new Pokemon("Dodrio", "Normal/Flying", 85, 60, 110, 70, 60, 110, 31, "♂", ""));
        pokemonList.add(new Pokemon("Seel", "Water", 86, 65, 45, 55, 70, 45, 5, "♂", ""));
        pokemonList.add(new Pokemon("Dewgong", "Water/Ice", 87, 90, 70, 80, 95, 70, 34, "♂", ""));
        pokemonList.add(new Pokemon("Grimer", "Poison", 88, 80, 80, 50, 40, 25, 5, "♂", ""));
        pokemonList.add(new Pokemon("Muk", "Poison", 89, 105, 105, 75, 65, 50, 38, "♂", ""));
        pokemonList.add(new Pokemon("Shellder", "Water", 90, 30, 65, 100, 45, 40, 5, "♂", ""));
        pokemonList.add(new Pokemon("Cloyster", "Water/Ice", 91, 50, 95, 180, 85, 70, 36, "♂", ""));
        pokemonList.add(new Pokemon("Gastly", "Ghost/Poison", 92, 30, 35, 30, 100, 80, 5, "♂", ""));
        pokemonList.add(new Pokemon("Haunter", "Ghost/Poison", 93, 45, 50, 45, 115, 95, 25, "♂", ""));
        pokemonList.add(new Pokemon("Gengar", "Ghost/Poison", 94, 60, 65, 60, 130, 110, 36, "♂", ""));
        pokemonList.add(new Pokemon("Onix", "Rock/Ground", 95, 35, 45, 160, 30, 70, 5, "♂", ""));
        pokemonList.add(new Pokemon("Drowzee", "Psychic", 96, 60, 48, 45, 90, 42, 5, "♂", ""));
        pokemonList.add(new Pokemon("Hypno", "Psychic", 97, 85, 73, 70, 115, 67, 26, "♂", ""));
        pokemonList.add(new Pokemon("Krabby", "Water", 98, 30, 105, 90, 25, 50, 5, "♂", ""));
        pokemonList.add(new Pokemon("Kingler", "Water", 99, 55, 130, 115, 50, 75, 28, "♂", ""));
        pokemonList.add(new Pokemon("Voltorb", "Electric", 100, 40, 30, 50, 55, 100, 5, "N/A", ""));
        pokemonList.add(new Pokemon("Electrode", "Electric", 101, 60, 50, 70, 80, 150, 30, "N/A", ""));
        pokemonList.add(new Pokemon("Exeggcute", "Grass/Psychic", 102, 60, 40, 80, 60, 40, 5, "N/A", ""));
        pokemonList.add(new Pokemon("Exeggutor", "Grass/Psychic", 103, 95, 95, 85, 125, 55, 36, "N/A", ""));
        pokemonList.add(new Pokemon("Cubone", "Ground", 104, 50, 50, 95, 40, 35, 5, "♂", ""));
        pokemonList.add(new Pokemon("Marowak", "Ground", 105, 60, 80, 110, 50, 45, 28, "♂", ""));
        pokemonList.add(new Pokemon("Hitmonlee", "Fighting", 106, 50, 120, 53, 35, 87, 5, "♂", ""));
        pokemonList.add(new Pokemon("Hitmonchan", "Fighting", 107, 50, 105, 79, 35, 76, 5, "♂", ""));
        pokemonList.add(new Pokemon("Lickitung", "Normal", 108, 90, 55, 75, 60, 30, 5, "♂", ""));
        pokemonList.add(new Pokemon("Koffing", "Poison", 109, 40, 65, 95, 60, 35, 5, "♂", ""));
        pokemonList.add(new Pokemon("Weezing", "Poison", 110, 65, 90, 120, 85, 60, 35, "♂", ""));
        pokemonList.add(new Pokemon("Rhyhorn", "Ground/Rock", 111, 80, 85, 95, 30, 25, 5, "♂", ""));
        pokemonList.add(new Pokemon("Rhydon", "Ground/Rock", 112, 105, 130, 120, 45, 40, 42, "♂", ""));
        pokemonList.add(new Pokemon("Chansey", "Normal", 113, 250, 5, 5, 105, 50, 5, "♀", ""));
        pokemonList.add(new Pokemon("Tangela", "Grass", 114, 65, 55, 115, 100, 60, 5, "♀", ""));
        pokemonList.add(new Pokemon("Kangaskhan", "Normal", 115, 105, 95, 80, 40, 90, 5, "♀", ""));
        pokemonList.add(new Pokemon("Horsea", "Water", 116, 30, 40, 70, 70, 60, 5, "♂", ""));
        pokemonList.add(new Pokemon("Seadra", "Water", 117, 55, 65, 95, 95, 85, 32, "♂", ""));
        pokemonList.add(new Pokemon("Goldeen", "Water", 118, 45, 67, 60, 35, 63, 5, "♀", ""));
        pokemonList.add(new Pokemon("Seaking", "Water", 119, 80, 92, 65, 65, 68, 33, "♂", ""));
        pokemonList.add(new Pokemon("Staryu", "Water", 120, 30, 45, 55, 70, 85, 5, "N/A", ""));
        pokemonList.add(new Pokemon("Starmie", "Water/Psychic", 121, 60, 75, 85, 100, 115, 36, "N/A", ""));
        pokemonList.add(new Pokemon("Mr. Mime", "Psychic/Fairy", 122, 40, 45, 65, 100, 90, 5, "♂", ""));
        pokemonList.add(new Pokemon("Scyther", "Bug/Flying", 123, 70, 110, 80, 55, 105, 5, "♂", ""));
        pokemonList.add(new Pokemon("Jynx", "Ice/Psychic", 124, 65, 50, 35, 115, 95, 5, "♀", ""));
        pokemonList.add(new Pokemon("Electabuzz", "Electric", 125, 65, 83, 57, 95, 105, 5, "♂", ""));
        pokemonList.add(new Pokemon("Magmar", "Fire", 126, 65, 95, 57, 100, 93, 5, "♂", ""));
        pokemonList.add(new Pokemon("Pinsir", "Bug", 127, 65, 125, 100, 55, 85, 5, "♂", ""));
        pokemonList.add(new Pokemon("Tauros", "Normal", 128, 75, 100, 95, 70, 110, 5, "♂", ""));
        pokemonList.add(new Pokemon("Magikarp", "Water", 129, 20, 10, 55, 20, 80, 5, "♂", ""));
        pokemonList.add(new Pokemon("Gyarados", "Water/Flying", 130, 95, 125, 79, 100, 81, 20, "♂", ""));
        pokemonList.add(new Pokemon("Lapras", "Water/Ice", 131, 130, 85, 80, 95, 60, 5, "♀", ""));
        pokemonList.add(new Pokemon("Ditto", "Normal", 132, 48, 48, 48, 48, 48, 5, "N/A", ""));
        pokemonList.add(new Pokemon("Eevee", "Normal", 133, 55, 55, 50, 65, 55, 5, "♂", ""));
        pokemonList.add(new Pokemon("Vaporeon", "Water", 134, 130, 65, 60, 110, 65, 36, "♂", ""));
        pokemonList.add(new Pokemon("Jolteon", "Electric", 135, 65, 65, 60, 110, 130, 36, "♂", ""));
        pokemonList.add(new Pokemon("Flareon", "Fire", 136, 65, 130, 60, 95, 65, 36, "♂", ""));
        pokemonList.add(new Pokemon("Porygon", "Normal", 137, 65, 60, 70, 85, 40, 5, "N/A", ""));
        pokemonList.add(new Pokemon("Omanyte", "Rock/Water", 138, 35, 40, 100, 90, 35, 5, "♂", ""));
        pokemonList.add(new Pokemon("Omastar", "Rock/Water", 139, 70, 60, 125, 115, 55, 40, "♂", ""));
        pokemonList.add(new Pokemon("Kabuto", "Rock/Water", 140, 30, 80, 90, 55, 55, 5, "♂", ""));
        pokemonList.add(new Pokemon("Kabutops", "Rock/Water", 141, 60, 115, 105, 70, 80, 40, "♂", ""));
        pokemonList.add(new Pokemon("Aerodactyl", "Rock/Flying", 142, 80, 105, 65, 60, 130, 5, "♂", ""));
        pokemonList.add(new Pokemon("Snorlax", "Normal", 143, 160, 110, 65, 65, 30, 5, "♂", ""));
        pokemonList.add(new Pokemon("Articuno", "Ice/Flying", 144, 90, 85, 100, 125, 85, 50, "N/A", ""));
        pokemonList.add(new Pokemon("Zapdos", "Electric/Flying", 145, 90, 90, 85, 125, 100, 50, "N/A", ""));
        pokemonList.add(new Pokemon("Moltres", "Fire/Flying", 146, 90, 100, 90, 125, 90, 50, "N/A", ""));
        pokemonList.add(new Pokemon("Dratini", "Dragon", 147, 41, 64, 45, 50, 50, 5, "♂", ""));
        pokemonList.add(new Pokemon("Dragonair", "Dragon", 148, 61, 84, 65, 70, 70, 30, "♂", ""));
        pokemonList.add(new Pokemon("Dragonite", "Dragon/Flying", 149, 91, 134, 95, 100, 80, 55, "♂", ""));
        pokemonList.add(new Pokemon("Mewtwo", "Psychic", 150, 106, 110, 90, 154, 130, 70, "N/A", ""));
        pokemonList.add(new Pokemon("Mew", "Psychic", 151, 100, 100, 100, 100, 100, 5, "N/A", ""));

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