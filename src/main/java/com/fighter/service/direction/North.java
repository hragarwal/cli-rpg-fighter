package com.fighter.service.direction;

import com.fighter.model.Player;
import com.fighter.service.action.CrossRoad;
import com.fighter.utils.Console;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.utils.Console.displayNorthSideOptions;
import static com.fighter.utils.InputUtils.getValidUserChoice;

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
        displayNorthSideOptions(player.getHealthPower());
        getValidUserChoice(inputTaker, 1, 1);
        crossRoad.perform(player, monster);
        return player;
    }
}
