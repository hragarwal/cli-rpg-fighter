package com.fighter.model;


import org.junit.Test;

import static com.fighter.utils.PlayerUtils.createCharacter;
import static com.fighter.utils.PlayerUtils.createMonster;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ActivityTest {

    @Test
    public void shouldCreateActivity() {
        final Player player = createCharacter("Meow");
        final Player monster = createMonster("Bhoot");
        Activity activity = new Activity(player, monster);
        assertThat(player, is(activity.getPlayer()));
        assertThat(monster, is(activity.getMonster()));
    }

}