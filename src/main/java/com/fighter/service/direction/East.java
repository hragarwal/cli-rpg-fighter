package com.fighter.service.direction;

import com.fighter.model.Player;
import com.fighter.service.action.CrossRoad;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.enums.Weapon.SWORD;
import static com.fighter.utils.Console.displayEastSideOptions;
import static com.fighter.utils.Console.displaySwordInfo;

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
        int choice = Integer.parseInt(inputTaker.readLine());
        while (choice != 1) {
            System.out.println("No such direction, please select again");
            choice = Integer.parseInt(inputTaker.readLine());
        }
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
