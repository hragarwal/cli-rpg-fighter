package com.fighter.utils;

import com.fighter.enums.Weapon;
import com.fighter.model.Player;

public class Console {

    public static void displayMonsterDamageInfo(int damageToMonster, int monsterHP) {
        System.out.println("You attacked the monster and gave " + damageToMonster + " damage!");
        System.out.println("Monster HP: " + monsterHP);
    }

    public static void displayPlayerDamageInfo(int damageToPlayer, int playerHP) {
        System.out.println("The monster attacked you and gave " + damageToPlayer + " damage!");
        System.out.println("Player HP: " + playerHP);
    }

    public static void displayRingInfo() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You killed the monster!");
        System.out.println("The monster dropped a ring!");
        System.out.println("You picked the silver ring!\n\n");
        System.out.println("1: Go east");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void markPlayerDead() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Dead!!!");
        System.out.println("\n\nGAME OVER");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void displayWestSideOptions() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You encounter a goblin!\n");
        System.out.println("1: Fight");
        System.out.println("2: Run");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void displayNorthSideOptions(int hp) {
        System.out.println("Your HP: " + hp);
        System.out.println("\n\n1: Go back to the crossroad");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void displayRiverInfo() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("There is a river. You drink the water and rest at the riverside.");
        System.out.println("Your HP is recovered.");
    }

    public static void displayEastSideOptions(Weapon weapon) {
        System.out.println("Your Weapon: " + weapon);
        System.out.println("\n\n1: Go back to the crossroad");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void displaySwordInfo() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You walked into a forest and found a Long Sword!");
    }

    public static void displayTalkToGuardOptions(Player player) {
        System.out.println("Guard: Hello there, stranger. So your name is " + player.getCharacterName() + "? \nSorry but we cannot let stranger enter our town.");
        System.out.println("\nPress any key to continue..");
    }

    public static void displayGuardAttackInfo() {
        System.out.println("Guard: Hey don't be stupid.\n\nThe guard has hit you so hard and you gave up.\n(You received 1 damage)\n");
    }

    public static void displayGuardAttackInfo(int hp) {
        System.out.println("Your HP: " + hp);
        System.out.println("\nPress any key to continue..");
    }

    public static void displayTownEntryInfo() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Guard: Oh you killed that goblin!?? Great!");
        System.out.println("Guard: It seems you are a trustworthy guy. Welcome to our town!");
        System.out.println("\n\n           THE END                    ");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void displayCrossRoadChoice() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are at a crossroad. If you go south, you will go back to the town.\n\n");
        System.out.println("1: Go north");
        System.out.println("2: Go east");
        System.out.println("3: Go south");
        System.out.println("4: Go west");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void displayTownGateChoice() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are at the gate of the town.");
        System.out.println("A guard is standing in front of you.");
        System.out.println("");
        System.out.println("What do you want to do?");
        System.out.println("");
        System.out.println("1: Talk to the guard");
        System.out.println("2: Attack the guard");
        System.out.println("3: Go to Cross Road");
        System.out.println("4: Save game");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void displayResumeGameOptions() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Wooohoo, you already have a game saved, select your choice..");
        System.out.println("");
        System.out.println("1: Resume");
        System.out.println("2: Start New");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void displayStateSaveErrorMessage() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Shit, we're not able save your game..");
        System.out.println("Really sorry");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void displayStateSaveMessage() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("We've successfully saved your game, happy to resume back in future");
        System.out.println("\n------------------------------------------------------------------\n");
    }
}
