package com.fighter.service;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.utils.Console.displayResumeGameOptions;

public class ResumeService {

    public boolean askUserForResume(BufferedReader inputTaker) throws IOException {
        displayResumeGameOptions();
        int choice = getChoice(inputTaker);
        boolean isResumeRequested = false;
        switch (choice) {
            case 1:
                isResumeRequested = true;
                break;
        }
        return isResumeRequested;
    }

    private int getChoice(BufferedReader inputTaker) throws IOException {
        int choice = Integer.parseInt(inputTaker.readLine());
        while (!(choice >= 1 && choice <= 2)) {
            System.out.println("No such option available, please select again");
            choice = Integer.parseInt(inputTaker.readLine());
        }
        return choice;
    }

}
