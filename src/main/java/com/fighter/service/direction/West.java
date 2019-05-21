package com.fighter.service.direction;

import com.fighter.model.Player;
import com.fighter.service.action.Action;
import com.fighter.service.action.CrossRoad;
import com.fighter.service.action.MonsterAttack;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

import static com.fighter.utils.Console.displayWestSideOptions;


public class West implements Direction {
    private BufferedReader inputTaker;
    private final CrossRoad crossRoad;

    public West(BufferedReader inputTaker, CrossRoad crossRoad) {
        this.inputTaker = inputTaker;
        this.crossRoad = crossRoad;
    }

    @Override
    public Player move(Player player, Player monster) throws IOException {
        displayWestSideOptions();
        Action action;
        int choice = getChoice();
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

    public MonsterAttack getMonsterAttack(Player monster) {
        return new MonsterAttack(monster, this, crossRoad, inputTaker, new Random());
    }

    private int getChoice() throws IOException {
        int choice = Integer.parseInt(inputTaker.readLine());
        while (!(choice >= 1 && choice <= 2)) {
            System.out.println("No such option available, please select again");
            choice = Integer.parseInt(inputTaker.readLine());
        }
        return choice;
    }
}
