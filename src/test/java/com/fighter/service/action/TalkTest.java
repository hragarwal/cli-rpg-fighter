package com.fighter.service.action;

import com.fighter.model.Player;
import com.fighter.service.ActivityService;
import com.fighter.service.TownService;
import com.fighter.service.file.FileStore;
import com.fighter.utils.PlayerUtils;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;

public class TalkTest {

    @Test
    public void shouldNotChangeHPWhenPlayerChoosesTalkWithGuard() throws IOException {
        String character = "Meow";
        final BufferedReader inputTaker = new BufferedReader(new StringReader("key to move"));
        ActivityService activityService = new ActivityService(new FileStore());
        final TownService townService = Mockito.spy(new TownService(activityService));
        Player player = PlayerUtils.createCharacter(character);
        Talk talk = new Talk(inputTaker, townService);
        doNothing().when(townService).moveToTown(player, inputTaker, null);
        player = talk.perform(player, null);
        assertEquals(10, player.getHealthPower());
    }
}
