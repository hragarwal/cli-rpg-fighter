package com.fighter.service.action;

import com.fighter.model.Player;
import com.fighter.service.ActivityService;
import com.fighter.service.TownService;
import com.fighter.service.direction.Direction;
import com.fighter.service.direction.West;
import com.fighter.service.file.FileStore;
import com.fighter.utils.PlayerUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MonsterAttackTest {

    private Player player;
    private Player monster;
    private CrossRoad crossRoad;
    private Direction west;
    private Random random;
    private MonsterAttack monsterAttack;

    @Before
    public void setup() {
        final BufferedReader inputTaker = new BufferedReader(new StringReader("1"));
        monster = PlayerUtils.createMonster("globin");
        player = PlayerUtils.createCharacter("Meow");
        ActivityService activityService = new ActivityService(new FileStore());
        TownService townService = new TownService(activityService);
        crossRoad = spy(new CrossRoad(inputTaker, townService));
        west = spy(new West(inputTaker, crossRoad));
        random = spy(new Random());
        monsterAttack = new MonsterAttack(monster, west, crossRoad, inputTaker, random);
    }

    @Test
    public void shouldMarkPlayerAsWonIfMonsterHPIsZeroOrLess() throws Exception {
        //when
        when(random.nextInt(5)).thenReturn(16);
        doReturn(null).when(west).move(player, monster);
        doReturn(null).when(crossRoad).perform(player, monster);
        //then
        player = monsterAttack.perform(player, monster);
        assertTrue(monster.getHp() <= 0);
        assertTrue(player.isSilverRingAvailable());
    }

    @Test
    public void shouldMarkPlayerAsLostIfPlayerHPIsZeroOrLess() throws Exception {
        //when
        when(random.nextInt(5)).thenReturn(4);
        when(random.nextInt(4)).thenReturn(10);
        doReturn(null).when(west).move(player, monster);
        doReturn(null).when(crossRoad).perform(player, monster);
        //then
        player = monsterAttack.perform(player, monster);
        assertTrue(player.getHp() <= 0);
        assertFalse(player.isSilverRingAvailable());
    }

    @Test
    public void shouldContinueTheGameIfBothMonsterAndPlayerHaveHP() throws Exception {
        //when
        when(random.nextInt(5)).thenReturn(2);
        when(random.nextInt(4)).thenReturn(4);
        doReturn(null).when(west).move(player, monster);
        doReturn(null).when(crossRoad).perform(player, monster);
        //then
        player = monsterAttack.perform(player, monster);
        assertThat("player hp", 6, is(player.getHp()));
        assertThat("monster hp", 13, is(monster.getHp()));
        verify(west, times(1)).move(player, monster);
    }
}