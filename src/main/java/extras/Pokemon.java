package extras;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private String name;
    private String type;
    private int dexId;
    private int hp;
    private int attack;
    private int defense;
    private int special;
    private int speed;
    private int level;
    private String sex;
    private String customName;

    public Pokemon() {} // Required for Jackson

    public Pokemon(String name, String type, int dexId, int hp, int attack, int defense, int special, int speed, int level, String sex, String customName) {
        this.name = name;
        this.type = type;
        this.dexId = dexId;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.special = special;
        this.speed = speed;
        this.level = level;
        this.sex = sex;
        this.customName = customName;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public int getDexId() { return dexId; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpecial() { return special; }
    public int getSpeed() { return speed; }
    public int getLevel() { return level; }
    public String getSex() { return sex; }
    public String getCustomName() { return customName; }


    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setDexId(int dexId) { this.dexId = dexId; }
    public void setHp(int hp) { this.hp = hp; }
    public void setAttack(int attack) { this.attack = attack; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setSpecial(int special) { this.special = special; }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setLevel(int level) { this.level = level; }
    public void setSex(String sex) { this.sex = sex; }
    public void setCustomName(String customName) { this.customName = customName; }

    public URL getImagePath() {
        return getClass().getClassLoader().getResource("extras/pokemons/" + name.toLowerCase() + ".jpg");
    }

    @Override
    public String toString() {
        return String.format("%03d: %s (%s) | %s | Lv.%d | HP:%d ATK:%d DEF:%d SPD:%d | %s", dexId, name, customName, type, level, hp, attack, defense, speed, sex);
    }
}