package com.fighter.service.action;

import com.fighter.enums.Weapon;
import com.fighter.model.Player;
import com.fighter.service.direction.Direction;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

import static com.fighter.utils.Console.*;
import static com.fighter.utils.InputUtils.getValidUserChoice;

public class MonsterAttack implements Action {

    private final CrossRoad crossRoad;
    private final BufferedReader inputTaker;
    private Player monster;
    private Direction direction;
    private Random random;

    public MonsterAttack(Player monster, Direction direction, CrossRoad crossRoad,
                         BufferedReader inputTaker, Random random) {
        this.monster = monster;
        this.direction = direction;
        this.crossRoad = crossRoad;
        this.inputTaker = inputTaker;
        this.random = random;
    }

    @Override
    public Player perform(Player player, Player monster) throws IOException {
        int lossOfMonsterHP = getLossOfHPToMonster(player);
        this.monster.decreaseHealthPoint(lossOfMonsterHP);
        displayMonsterDamageInfo(lossOfMonsterHP, this.monster.getHealthPower());

        if (this.monster.getHealthPower() <= 0) {
            return playerWonMoveToCrossRoad(player);
        }

        int lossOfPlayerHP = getLossOfHPToPlayer();
        player.decreaseHealthPoint(lossOfPlayerHP);
        displayPlayerDamageInfo(lossOfPlayerHP, player.getHealthPower());

        if (player.getHealthPower() <= 0) {
            markPlayerDead();
        } else {
            direction.move(player, monster);
        }
        return player;
    }

    private int getLossOfHPToPlayer() {
        return random.nextInt(4);
    }

    private Player playerWonMoveToCrossRoad(Player player) throws IOException {
        displayRingInfo();
        player.setSilverRingAvailable(true);
        int choice = getValidUserChoice(inputTaker, 1, 1);
        if (choice == 1) {
            crossRoad.perform(player, monster);
        }
        return player;
    }

    private int getLossOfHPToMonster(Player player) {
        return Weapon.KNIFE.equals(player.getWeapon())
                ? random.nextInt(5)
                : random.nextInt(8);
    }
}
