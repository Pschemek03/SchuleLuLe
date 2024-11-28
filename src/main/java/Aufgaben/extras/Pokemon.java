package Aufgaben.extras;

public class Pokemon {
    private String name;
    private String type;
    private int level;
    private String sex;

    // Default constructor
    public Pokemon() {
    }

    public Pokemon(String name, String type, int level, String sex) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", sex='" + sex + '\'' +
                '}';
    }
}