package com.fighter.utils;

import com.fighter.model.Player;

import static com.fighter.enums.Weapon.KNIFE;

public class PlayerUtils {

    public static final int HP = 10;
    private static final int MONSTER_HP = 15;

    public static Player createCharacter(String name) {
        return Player.builder()
                .characterName(name)
                .silverRingAvailable(false)
                .healthPower(HP)
                .weapon(KNIFE)
                .build();
    }

    public static Player createMonster(String name) {
        return Player.builder()
                .characterName(name)
                .silverRingAvailable(false)
                .healthPower(MONSTER_HP)
                .weapon(null)
                .build();
    }
}
