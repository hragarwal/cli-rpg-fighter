package com.fighter.service;

import com.fighter.model.Player;

import static com.fighter.enums.Weapon.KNIFE;

public class PlayerService {

    public static final int PLAYER_DEFAULT_HP = 10;
    public static final int MONSTER_DEFAULT_HP = 15;

    public Player createCharacter(String name) {
        return new Player(name, PLAYER_DEFAULT_HP, KNIFE, false);
    }

    public Player createMonster(String name) {
        return new Player(name, MONSTER_DEFAULT_HP, null, false);
    }
}
