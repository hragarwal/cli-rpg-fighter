package com.fighter.service.direction;

import com.fighter.model.Player;
import com.fighter.service.action.CrossRoad;
import com.fighter.utils.PlayerUtils;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;

public class NorthTest {

    @Test
    public void shouldIncreaseHP() throws IOException {
        String character = "Meow";
        final BufferedReader inputTaker = new BufferedReader(new StringReader("1"));
        CrossRoad crossRoad = Mockito.spy(new CrossRoad(inputTaker, null));
        North north = new North(inputTaker, crossRoad);
        doReturn(null).when(crossRoad).perform(any(), any());
        Player player = north.move(PlayerUtils.createCharacter(character), null);
        Assert.assertEquals(PlayerUtils.PLAYER_DEFAULT_HP + 1, player.getHealthPower());
    }
}
