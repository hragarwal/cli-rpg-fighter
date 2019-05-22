package com.fighter.service.action;

import com.fighter.model.Player;
import com.fighter.service.ActivityService;
import com.fighter.service.TownService;
import com.fighter.service.file.FileStore;
import com.fighter.utils.PlayerUtils;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;

public class GuardAttackTest {


    @Test
    public void shouldDecreaseHealthPointOnAttack() throws IOException {
        String character = "Meow";
        final BufferedReader inputTaker = new BufferedReader(new StringReader("key to move"));
        ActivityService activityService = new ActivityService(new FileStore());
        final TownService townService = Mockito.spy(new TownService(activityService));
        GuardAttack guardAttack = new GuardAttack(inputTaker, townService);
        Player player = PlayerUtils.createCharacter(character);
        doNothing().when(townService).moveToTown(any(), any(), any());
        player = guardAttack.perform(player, null);
        Assert.assertEquals(PlayerUtils.HP - 1, player.getHealthPower());
    }
}
