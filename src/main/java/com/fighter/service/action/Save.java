package com.fighter.service.action;

import com.fighter.model.Activity;
import com.fighter.model.Player;
import com.fighter.service.ActivityService;

import static com.fighter.utils.Console.displayStateSaveErrorMessage;
import static com.fighter.utils.Console.displayStateSaveMessage;

public class Save implements Action {

    private ActivityService activityService;

    public Save(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Override
    public Player perform(Player player, Player monster) {
        Activity activity = new Activity(player, monster);
        boolean isSaved = activityService.saveActivity(activity);
        if (isSaved) {
            displayStateSaveMessage();
        } else {
            displayStateSaveErrorMessage();
        }
        return player;
    }
}
