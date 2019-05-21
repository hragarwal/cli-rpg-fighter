package com.fighter.service;

import com.fighter.model.Player;
import com.fighter.service.action.*;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.utils.Console.displayTownGateChoice;

public class TownService {

    private ActivityService activityService;

    public TownService(ActivityService activityService) {
        this.activityService = activityService;
    }

    private void executeChoice(Player player, BufferedReader inputTaker,
                               int choice, Player monster) throws IOException {
        Action action;
        while (!(choice >= 1 && choice <= 4)) {
            System.out.println("No such action available, please select again");
            choice = getChoice(inputTaker);
        }
        switch (choice) {
            case 1:
                if (player.isSilverRingAvailable()) {
                    action = new Entry();
                } else {
                    action = new Talk(inputTaker, this);
                }
                break;
            case 2:
                action = new GuardAttack(inputTaker, this);
                break;
            case 3:
                action = new CrossRoad(inputTaker, this);
                break;
            default:
                action = new Save(activityService);
        }
        action.perform(player, monster);
    }

    public void moveToTown(Player player, BufferedReader inputTaker, Player monster) throws IOException {
        final int playerChoice = getPlayerChoice(inputTaker);
        executeChoice(player, inputTaker, playerChoice, monster);
    }

    private int getPlayerChoice(BufferedReader inputTaker) throws IOException {
        displayTownGateChoice();
        return getChoice(inputTaker);
    }

    private int getChoice(BufferedReader inputTaker) throws IOException {
        return Integer.parseInt(inputTaker.readLine());
    }
}
