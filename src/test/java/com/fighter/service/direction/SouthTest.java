package com.fighter.service.direction;

import com.fighter.enums.Weapon;
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

public class SouthTest {

    @Test
    public void shouldNotChangeHPAndWeapon() throws IOException {
        String character = "Meow";
        final BufferedReader inputTaker = new BufferedReader(new StringReader("1"));
        ActivityService activityService = new ActivityService(new FileStore());
        TownService townService = Mockito.spy(new TownService(activityService));
        South south = new South(inputTaker, townService);
        Player player = PlayerUtils.createCharacter(character);
        doNothing().when(townService)
                .moveToTown(player, inputTaker, null);
        player = south.move(player, null);
        assertEquals(Weapon.KNIFE, player.getWeapon());
        assertEquals(PlayerUtils.PLAYER_DEFAULT_HP, player.getHealthPower());
    }
}
