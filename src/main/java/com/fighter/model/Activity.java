package com.fighter.model;

import java.io.Serializable;

public class Activity implements Serializable {

    private static final long serialVersionUID = 549520608484707660L;

    private Player player;
    private Player monster;

    public Activity(Player player, Player monster) {
        this.player = player;
        this.monster = monster;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getMonster() {
        return monster;
    }

}
