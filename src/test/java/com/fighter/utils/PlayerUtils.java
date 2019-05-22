package com.fighter.utils;

import com.fighter.model.Player;

import static com.fighter.enums.Weapon.KNIFE;

public class PlayerUtils {

    public static final int PLAYER_DEFAULT_HP = 10;
    private static final int MONSTER_DEFAULT_HP = 15;

    public static Player createCharacter(String name) {
        return new Player(name, PLAYER_DEFAULT_HP, KNIFE, false);
    }

    public static Player createMonster(String name) {
        return new Player(name, MONSTER_DEFAULT_HP, null, false);
    }
}
