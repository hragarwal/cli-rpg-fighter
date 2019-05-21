package com.fighter.service.action;

import com.fighter.model.Player;

import java.io.IOException;

public interface Action {

    Player perform(Player player, Player monster) throws IOException;
}
