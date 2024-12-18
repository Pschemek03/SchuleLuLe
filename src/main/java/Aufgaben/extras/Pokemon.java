package Aufgaben.extras;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private String name;
    private String type;
    private int level;
    private String sex;
    private String customName;

    // Default constructor
    public Pokemon() {
    }

    public URL getImagePath() {
        return getClass().getClassLoader().getResource("Aufgaben/extras/pokemons/" + name.toLowerCase() + ".jpg");
    }

    public Pokemon(String name, String type, int level, String sex, String customName) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.sex = sex;
        this.customName = customName;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCustomName() {
        return customName;
    }

    public int getLevel() {
        return level;
    }

    public String getSex() {
        return sex;
    }


    @Override
    public String toString() {
        return "Pokemon: " + name + " (" + customName + ") | " + type + " | lvl. " + level + " | " + sex;
    }
}