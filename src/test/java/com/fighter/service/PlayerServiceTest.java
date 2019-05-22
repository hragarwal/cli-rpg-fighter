package com.fighter.service;

import com.fighter.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerServiceTest {

    private PlayerService playerService = new PlayerService();

    @Test
    public void shouldCreateACharacter() {
        String name = "TestUser";
        Player player = playerService.createCharacter(name);
        assertNotNull(player);
        assertEquals(name, player.getCharacterName());
        assertEquals(10, player.getHealthPower());
    }

    @Test
    public void shouldCreateMonster() {
        String name = "Monster";
        Player player = playerService.createMonster(name);
        assertNotNull(player);
        assertEquals(name, player.getCharacterName());
        assertEquals(15, player.getHealthPower());
        assertNull(player.getWeapon());
    }
}
