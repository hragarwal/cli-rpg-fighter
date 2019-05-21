package com.fighter.service.direction;

import com.fighter.model.Player;

import java.io.IOException;

public interface Direction {
    Player move(Player player, Player monster) throws IOException;
}
