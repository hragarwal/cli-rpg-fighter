package com.fighter.service.direction;

import com.fighter.model.Player;
import com.fighter.service.action.Action;
import com.fighter.service.action.CrossRoad;
import com.fighter.service.action.MonsterAttack;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

import static com.fighter.utils.Console.displayWestSideOptions;
import static com.fighter.utils.InputUtils.getValidUserChoice;


public class West implements Direction {
    private final CrossRoad crossRoad;
    private BufferedReader inputTaker;

    public West(BufferedReader inputTaker, CrossRoad crossRoad) {
        this.inputTaker = inputTaker;
        this.crossRoad = crossRoad;
    }

    @Override
    public Player move(Player player, Player monster) throws IOException {
        displayWestSideOptions();
        Action action;
        int choice = getValidUserChoice(inputTaker, 1, 2);
        switch (choice) {
            case 1:
                action = getMonsterAttack(monster);
                break;
            default:
                action = crossRoad;
        }
        action.perform(player, monster);
        return player;
    }

    private MonsterAttack getMonsterAttack(Player monster) {
        return new MonsterAttack(monster, this, crossRoad, inputTaker, new Random());
    }
}
