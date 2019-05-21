package com.fighter.service.direction;

import com.fighter.model.Player;
import com.fighter.service.ActivityService;
import com.fighter.service.TownService;
import com.fighter.service.action.CrossRoad;
import com.fighter.service.file.FileStore;
import com.fighter.utils.PlayerUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class WestTest {

    private Player player;
    private Player monster;
    private TownService townService;

    @Before
    public void setup() {
        monster = PlayerUtils.createMonster("globin");
        player = PlayerUtils.createCharacter("Meow");
        ActivityService activityService = new ActivityService(new FileStore());
        townService = new TownService(activityService);
    }

    @Test
    public void playerWillMoveToCrossRoadOnChoice2() throws Exception {
        //given
        BufferedReader inputTaker = new BufferedReader(new StringReader("2"));
        CrossRoad crossRoad = spy(new CrossRoad(inputTaker, townService));
        West west = new West(inputTaker, crossRoad);
        //when
        Player playerAfterAttack = PlayerUtils.createCharacter("Meow");
        playerAfterAttack.setHp(7);
        doReturn(playerAfterAttack).when(crossRoad).perform(player, monster);
        //then
        west.move(player, monster);
        Assert.assertEquals(7, playerAfterAttack.getHp());
    }

}