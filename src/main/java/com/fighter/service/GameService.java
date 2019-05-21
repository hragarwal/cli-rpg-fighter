package com.fighter.service;

import com.fighter.model.Activity;
import com.fighter.model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import static com.fighter.utils.InputUtils.waitForUserInputToProceed;

public class GameService {

    private ActivityService activityService;
    private TownService townService;
    private ResumeService resumeService;

    public GameService(ActivityService activityService, TownService townService, ResumeService resumeService) {
        this.activityService = activityService;
        this.townService = townService;
        this.resumeService = resumeService;
    }

    public String askCharacterName(BufferedReader inputTaker) throws IOException {
        System.out.println("Welcome to my Castle!!");
        System.out.println("Please enter your name:");
        return waitForUserInputToProceed(inputTaker);
    }

    public void startGame(BufferedReader inputTaker) throws IOException {
        final Activity activity = checkIfGameWasSaved();
        boolean gameResumeRequested = Objects.nonNull(activity) ? askUserForResumingGame(inputTaker) : false;
        if (gameResumeRequested) {
            resumeGame(inputTaker, activity);
        } else {
            startNewGame(inputTaker);
        }
    }

    private void resumeGame(BufferedReader inputTaker, Activity activity) throws IOException {
        moveToTown(inputTaker, activity.getPlayer(), activity.getMonster());
    }

    private void startNewGame(BufferedReader inputTaker) throws IOException {
        PlayerService playerService = new PlayerService();
        String name = askCharacterName(inputTaker);
        Player player = playerService.createCharacter(name);
        Player monster = playerService.createMonster("globin");
        moveToTown(inputTaker, player, monster);
    }

    private boolean askUserForResumingGame(BufferedReader inputTaker) throws IOException {
        return resumeService.askUserForResume(inputTaker);
    }

    private Activity checkIfGameWasSaved() {
        return activityService.getActivity();
    }

    private void moveToTown(BufferedReader inputTaker, Player player, Player monster) throws IOException {
        townService.moveToTown(player, inputTaker, monster);
    }
}
