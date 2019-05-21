package com.fighter.service.action;

import com.fighter.model.Player;
import com.fighter.service.TownService;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.utils.Console.displayGuardAttackInfo;
import static com.fighter.utils.InputUtils.waitForUserInputToProceed;

public class GuardAttack implements Action {
    private BufferedReader inputTaker;
    private TownService townService;

    public GuardAttack(BufferedReader inputTaker, TownService townService) {
        this.inputTaker = inputTaker;
        this.townService = townService;
    }

    @Override
    public Player perform(Player player, Player monster) throws IOException {
        attackGuard(player, inputTaker);
        townService.moveToTown(player, inputTaker, monster);
        return player;
    }

    private void attackGuard(Player player, BufferedReader inputTaker) throws IOException {
        displayGuardAttackInfo();
        player.decreaseHealthPoint(1);
        displayGuardAttackInfo(player.getHp());
        waitForUserInputToProceed(inputTaker);
    }
}
