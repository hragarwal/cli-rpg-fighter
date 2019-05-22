package com.fighter.service;

import com.fighter.model.Player;
import com.fighter.service.action.*;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.utils.Console.displayTownGateChoice;
import static com.fighter.utils.InputUtils.getValidUserChoice;

public class TownService {

    private ActivityService activityService;

    public TownService(ActivityService activityService) {
        this.activityService = activityService;
    }

    private void executeChoice(Player player, BufferedReader inputTaker,
                               int choice, Player monster) throws IOException {
        Action action = getUserAction(player, inputTaker, choice);
        action.perform(player, monster);
    }

    public Action getUserAction(Player player, BufferedReader inputTaker, int choice) {
        Action action;
        switch (choice) {
            case 1:
                action = player.isSilverRingAvailable() ? new Entry() : new Talk(inputTaker, this);
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
        return action;
    }

    public void moveToTown(Player player, BufferedReader inputTaker, Player monster) throws IOException {
        final int playerChoice = getPlayerChoice(inputTaker);
        executeChoice(player, inputTaker, playerChoice, monster);
    }

    private int getPlayerChoice(BufferedReader inputTaker) throws IOException {
        displayTownGateChoice();
        return getValidUserChoice(inputTaker, 1, 4);
    }
}
