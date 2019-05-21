package com.fighter.service.action;

import com.fighter.model.Player;

import static com.fighter.utils.Console.displayTownEntryInfo;

public class Entry implements Action {

    @Override
    public Player perform(Player player, Player monster) {
        displayTownEntryInfo();
        return player;
    }
}
