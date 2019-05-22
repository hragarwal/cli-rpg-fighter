package com.fighter.service;

import com.fighter.model.Player;

import static com.fighter.enums.Weapon.KNIFE;

public class PlayerService {

    public static final int DEFAULT_HP = 10;
    public static final int MONSTER_HP = 15;

    public Player createCharacter(String name) {
        return Player.builder()
                .characterName(name)
                .silverRingAvailable(false)
                .healthPower(DEFAULT_HP)
                .weapon(KNIFE)
                .build();
    }

    public Player createMonster(String name) {
        return Player.builder()
                .characterName(name)
                .silverRingAvailable(false)
                .healthPower(MONSTER_HP)
                .weapon(null)
                .build();
    }
}
