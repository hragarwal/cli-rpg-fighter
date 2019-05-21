package com.fighter.service.action;

import com.fighter.model.Player;
import com.fighter.service.TownService;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.utils.Console.displayTalkToGuardOptions;
import static com.fighter.utils.InputUtils.waitForUserInputToProceed;

public class Talk implements Action {

    private BufferedReader inputTaker;
    private TownService townService;

    public Talk(BufferedReader inputTaker, TownService townService) {
        this.inputTaker = inputTaker;
        this.townService = townService;
    }

    @Override
    public Player perform(Player player, Player monster) throws IOException {
        talkToGuard(player, inputTaker);
        townService.moveToTown(player, inputTaker, monster);
        return player;
    }

    public void talkToGuard(Player player, BufferedReader inputTaker) throws IOException {
        displayTalkToGuardOptions(player);
        waitForUserInputToProceed(inputTaker);
    }
}
