package com.fighter.service;

import com.fighter.model.Player;
import com.fighter.service.action.*;
import com.fighter.service.file.FileStore;
import com.fighter.utils.PlayerUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.assertTrue;

public class TownServiceTest {

    private Player player;
    private BufferedReader inputTaker;
    private TownService townService;

    @Before
    public void setUp() {
        inputTaker = new BufferedReader(new StringReader("1"));
        ActivityService activityService = new ActivityService(new FileStore());
        townService = new TownService(activityService);
    }

    @Test
    public void shouldReturnEntryActionIfChoiceIsOneAndSilverRingIsAvailable() {
        player = PlayerUtils.createCharacter("Meow");
        player.setSilverRingAvailable(true);
        final Action userAction = townService.getUserAction(player, inputTaker, 1);
        assertTrue(userAction instanceof Entry);
    }

    @Test
    public void shouldReturnTalkActionIfChoiceIsOneAndSilverRingIsNotAvailable() {
        player = PlayerUtils.createCharacter("Meow");
        final Action userAction = townService.getUserAction(player, inputTaker, 1);
        assertTrue(userAction instanceof Talk);
    }

    @Test
    public void shouldReturnGuardAttackActionIfChoiceIsTwo() {
        player = PlayerUtils.createCharacter("Meow");
        final Action userAction = townService.getUserAction(player, inputTaker, 2);
        assertTrue(userAction instanceof GuardAttack);
    }

    @Test
    public void shouldReturnCrossRoadAttackActionIfChoiceIsThree() {
        player = PlayerUtils.createCharacter("Meow");
        final Action userAction = townService.getUserAction(player, inputTaker, 3);
        assertTrue(userAction instanceof CrossRoad);
    }

    @Test
    public void shouldReturnCrossRoadAttackActionIfChoiceIsFour() {
        player = PlayerUtils.createCharacter("Meow");
        final Action userAction = townService.getUserAction(player, inputTaker, 4);
        assertTrue(userAction instanceof Save);
    }
}