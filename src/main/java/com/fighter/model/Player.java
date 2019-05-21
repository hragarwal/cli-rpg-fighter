package com.fighter.model;

import com.fighter.enums.Weapon;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Builder
@Setter
public class Player implements Serializable {
    private static final long serialVersionUID = 7187643650912731042L;

    private String characterName;
    private int hp;
    private Weapon weapon;
    private boolean silverRingAvailable;

    public void decreaseHealthPoint(int hp) {
        this.setHp(this.hp - hp);
    }

    public void increaseHealthPoint(int hp) {
        this.setHp(this.hp + hp);
    }
}
