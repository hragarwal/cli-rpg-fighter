package com.fighter.service.direction;

import com.fighter.model.Player;
import com.fighter.service.action.CrossRoad;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.enums.Weapon.SWORD;
import static com.fighter.utils.Console.displayEastSideOptions;
import static com.fighter.utils.Console.displaySwordInfo;
import static com.fighter.utils.InputUtils.getValidUserChoice;

public class East implements Direction {

    private BufferedReader inputTaker;
    private CrossRoad crossRoad;

    public East(BufferedReader inputTaker, CrossRoad crossRoad) {
        this.inputTaker = inputTaker;
        this.crossRoad = crossRoad;
    }

    @Override
    public Player move(Player player, Player monster) throws IOException {
        getSword(player);
        getValidUserChoice(inputTaker, 1, 1);
        crossRoad.perform(player, monster);
        return player;
    }

    private Player getSword(Player player) {
        displaySwordInfo();
        player.setWeapon(SWORD);
        displayEastSideOptions(player.getWeapon());
        return player;
    }
}
