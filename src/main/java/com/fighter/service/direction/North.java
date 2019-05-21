package com.fighter.service.direction;

import com.fighter.model.Player;
import com.fighter.service.action.CrossRoad;
import com.fighter.utils.Console;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.utils.Console.displayNorthSideOptions;

public class North implements Direction {
    private BufferedReader inputTaker;
    private CrossRoad crossRoad;

    public North(BufferedReader inputTaker, CrossRoad crossRoad) {
        this.inputTaker = inputTaker;
        this.crossRoad = crossRoad;
    }

    @Override
    public Player move(Player player, Player monster) throws IOException {
        Console.displayRiverInfo();
        player.increaseHealthPoint(1);
        displayNorthSideOptions(player.getHp());

        int choice = Integer.parseInt(inputTaker.readLine());
        while (choice != 1) {
            System.out.println("No such direction, please select again");
            choice = Integer.parseInt(inputTaker.readLine());
        }
        crossRoad.perform(player, monster);
        return player;
    }
}
