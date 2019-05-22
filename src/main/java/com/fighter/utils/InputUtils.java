package com.fighter.utils;

import java.io.BufferedReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class InputUtils {

    public static String waitForUserInputToProceed(BufferedReader inputTaker) throws IOException {
        return inputTaker.readLine();
    }

    public static int getValidUserChoice(BufferedReader inputTaker, int lb, int ub) throws IOException {
        int choice = getChoice(inputTaker);
        while (!(choice >= lb && choice <= ub)) {
            System.out.println("No such action, please select again");
            choice = getChoice(inputTaker);
        }
        return choice;
    }

    public static int getChoice(BufferedReader inputTaker) throws IOException {
        int choice = 0;
        try {
            choice = parseInt(inputTaker.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Oops, invalid choice");
        }
        return choice;
    }
}
