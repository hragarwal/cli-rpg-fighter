package com.fighter.service.direction;

import com.fighter.model.Player;
import com.fighter.service.TownService;

import java.io.BufferedReader;
import java.io.IOException;

public class South implements Direction {
    private BufferedReader inputTaker;
    private TownService townService;

    public South(BufferedReader inputTaker, TownService townService) {
        this.inputTaker = inputTaker;
        this.townService = townService;
    }

    @Override
    public Player move(Player player, Player monster) throws IOException {
        townService.moveToTown(player, inputTaker, monster);
        return player;
    }
}
