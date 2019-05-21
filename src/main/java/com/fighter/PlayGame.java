package com.fighter;

import com.fighter.service.ActivityService;
import com.fighter.service.GameService;
import com.fighter.service.ResumeService;
import com.fighter.service.TownService;
import com.fighter.service.file.FileStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayGame {

    public static void main(String[] args) {
        final BufferedReader inputTaker = new BufferedReader(new InputStreamReader(System.in));
        try {
            ActivityService activityService = new ActivityService(new FileStore());
            TownService townService = new TownService(activityService);
            ResumeService resumeService = new ResumeService();
            new GameService(activityService, townService, resumeService).startGame(inputTaker);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
