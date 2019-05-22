package com.fighter.service.action;

import com.fighter.model.Player;
import com.fighter.service.TownService;
import com.fighter.service.direction.*;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.utils.Console.displayCrossRoadChoice;
import static com.fighter.utils.InputUtils.getValidUserChoice;

public class CrossRoad implements Action {
    private BufferedReader inputTaker;
    private TownService townService;

    public CrossRoad(BufferedReader inputTaker, TownService townService) {
        this.inputTaker = inputTaker;
        this.townService = townService;
    }

    @Override
    public Player perform(Player player, Player monster) throws IOException {
        final Direction direction = moveToCrossRoad(inputTaker, monster);
        return direction.move(player, monster);
    }

    public Direction moveToCrossRoad(BufferedReader inputTaker, Player monster) throws IOException {
        displayCrossRoadChoice();
        Direction direction;
        int choice = getValidUserChoice(inputTaker, 1, 4);
        switch (choice) {
            case 1:
                direction = new North(inputTaker, this);
                break;
            case 2:
                direction = new East(inputTaker, this);
                break;
            case 3:
                direction = new South(inputTaker, townService);
                break; //townGate
            default:
                direction = new West(inputTaker, this);
                break;
        }
        return direction;
    }
}
