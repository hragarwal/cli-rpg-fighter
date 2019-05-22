package com.fighter.model;

import com.fighter.enums.Weapon;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 7187643650912731042L;

    private String characterName;
    private int healthPower;
    private Weapon weapon;
    private boolean silverRingAvailable;

    public Player(String characterName, int healthPower, Weapon weapon, boolean silverRingAvailable) {
        this.characterName = characterName;
        this.healthPower = healthPower;
        this.weapon = weapon;
        this.silverRingAvailable = silverRingAvailable;
    }

    public String getCharacterName() {
        return characterName;
    }

    public int getHealthPower() {
        return healthPower;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isSilverRingAvailable() {
        return silverRingAvailable;
    }

    public void setSilverRingAvailable(boolean silverRingAvailable) {
        this.silverRingAvailable = silverRingAvailable;
    }

    public void setHealthPower(int healthPower) {
        this.healthPower = healthPower;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void decreaseHealthPoint(int healthPower) {
        this.setHealthPower(this.healthPower - healthPower);
    }

    public void increaseHealthPoint(int healthPower) {
        this.setHealthPower(this.healthPower + healthPower);
    }
}
