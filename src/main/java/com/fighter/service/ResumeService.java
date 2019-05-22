package com.fighter.service;

import java.io.BufferedReader;
import java.io.IOException;

import static com.fighter.utils.Console.displayResumeGameOptions;
import static com.fighter.utils.InputUtils.getValidUserChoice;

public class ResumeService {

    public boolean askUserForResume(BufferedReader inputTaker) throws IOException {
        displayResumeGameOptions();
        int choice = getValidUserChoice(inputTaker, 1, 2);
        boolean isResumeRequested = false;
        switch (choice) {
            case 1:
                isResumeRequested = true;
                break;
        }
        return isResumeRequested;
    }
}
