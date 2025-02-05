package Aufgaben.extras;

import java.util.HashMap;
import java.util.Map;

public class TypeEffectiveness {
    public static final Map<String, Map<String, Double>> effectivenessMap = new HashMap<>();

    static {
        initializeEffectiveness();
    }

    private static void initializeEffectiveness() {
        Map<String, Double> normal = new HashMap<>();
        normal.put("Rock", 0.5);
        normal.put("Ghost", 0.0);
        effectivenessMap.put("Normal", normal);

        Map<String, Double> fire = new HashMap<>();
        fire.put("Fire", 0.5);
        fire.put("Water", 0.5);
        fire.put("Grass", 2.0);
        fire.put("Ice", 2.0);
        fire.put("Bug", 2.0);
        fire.put("Rock", 0.5);
        fire.put("Dragon", 0.5);
        effectivenessMap.put("Fire", fire);

        Map<String, Double> water = new HashMap<>();
        water.put("Fire", 2.0);
        water.put("Water", 0.5);
        water.put("Grass", 0.5);
        water.put("Ground", 2.0);
        water.put("Rock", 2.0);
        water.put("Dragon", 0.5);
        effectivenessMap.put("Water", water);

        Map<String, Double> grass = new HashMap<>();
        grass.put("Fire", 0.5);
        grass.put("Water", 2.0);
        grass.put("Grass", 0.5);
        grass.put("Poison", 0.5);
        grass.put("Ground", 2.0);
        grass.put("Flying", 0.5);
        grass.put("Bug", 0.5);
        grass.put("Rock", 2.0);
        grass.put("Dragon", 0.5);
        effectivenessMap.put("Grass", grass);

        Map<String, Double> electric = new HashMap<>();
        electric.put("Water", 2.0);
        electric.put("Electric", 0.5);
        electric.put("Grass", 0.5);
        electric.put("Ground", 0.0);
        electric.put("Flying", 2.0);
        electric.put("Dragon", 0.5);
        effectivenessMap.put("Electric", electric);

        Map<String, Double> ice = new HashMap<>();
        ice.put("Fire", 0.5);
        ice.put("Water", 0.5);
        ice.put("Grass", 2.0);
        ice.put("Ice", 0.5);
        ice.put("Ground", 2.0);
        ice.put("Flying", 2.0);
        ice.put("Dragon", 2.0);
        effectivenessMap.put("Ice", ice);

        Map<String, Double> fighting = new HashMap<>();
        fighting.put("Normal", 2.0);
        fighting.put("Ice", 2.0);
        fighting.put("Poison", 0.5);
        fighting.put("Flying", 0.5);
        fighting.put("Psychic", 0.5);
        fighting.put("Bug", 0.5);
        fighting.put("Rock", 2.0);
        fighting.put("Ghost", 0.0);
        effectivenessMap.put("Fighting", fighting);

        Map<String, Double> poison = new HashMap<>();
        poison.put("Grass", 2.0);
        poison.put("Poison", 0.5);
        poison.put("Ground", 0.5);
        poison.put("Rock", 0.5);
        poison.put("Ghost", 0.5);
        poison.put("Bug", 2.0);
        effectivenessMap.put("Poison", poison);

        Map<String, Double> ground = new HashMap<>();
        ground.put("Fire", 2.0);
        ground.put("Electric", 2.0);
        ground.put("Grass", 0.5);
        ground.put("Poison", 2.0);
        ground.put("Flying", 0.0);
        ground.put("Bug", 0.5);
        ground.put("Rock", 2.0);
        effectivenessMap.put("Ground", ground);

        Map<String, Double> flying = new HashMap<>();
        flying.put("Electric", 0.5);
        flying.put("Grass", 2.0);
        flying.put("Fighting", 2.0);
        flying.put("Bug", 2.0);
        flying.put("Rock", 0.5);
        effectivenessMap.put("Flying", flying);

        Map<String, Double> psychic = new HashMap<>();
        psychic.put("Fighting", 2.0);
        psychic.put("Poison", 2.0);
        psychic.put("Psychic", 0.5);
        psychic.put("Bug", 0.5);
        effectivenessMap.put("Psychic", psychic);

        Map<String, Double> bug = new HashMap<>();
        bug.put("Fire", 0.5);
        bug.put("Grass", 2.0);
        bug.put("Fighting", 0.5);
        bug.put("Flying", 0.5);
        bug.put("Poison", 2.0);
        bug.put("Psychic", 2.0);
        bug.put("Ghost", 0.5);
        bug.put("Rock", 0.5);
        effectivenessMap.put("Bug", bug);

        Map<String, Double> rock = new HashMap<>();
        rock.put("Fire", 2.0);
        rock.put("Water", 0.5);
        rock.put("Grass", 0.5);
        rock.put("Fighting", 0.5);
        rock.put("Ground", 0.5);
        rock.put("Flying", 2.0);
        rock.put("Bug", 2.0);
        rock.put("Ice", 2.0);
        effectivenessMap.put("Rock", rock);

        Map<String, Double> ghost = new HashMap<>();
        ghost.put("Normal", 0.0);
        ghost.put("Psychic", 2.0);
        ghost.put("Ghost", 2.0);
        effectivenessMap.put("Ghost", ghost);

        Map<String, Double> dragon = new HashMap<>();
        dragon.put("Dragon", 2.0);
        effectivenessMap.put("Dragon", dragon);
    }

    public static double getEffectiveness(String attackerType, String defenderType) {
        return effectivenessMap.getOrDefault(attackerType, new HashMap<>()).getOrDefault(defenderType, 1.0);
    }
}