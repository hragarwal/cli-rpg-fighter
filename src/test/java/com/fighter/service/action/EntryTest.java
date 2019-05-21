package com.fighter.service.action;

import com.fighter.model.Player;
import com.fighter.utils.PlayerUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EntryTest {

    @Test
    public void shouldNotChangePlayerHPIfPlayerEntersTheTown() {
        Player player = PlayerUtils.createCharacter("name");
        Entry entry = new Entry();
        Player playerAfterEntry = entry.perform(player, null);
        assertThat(player, is(playerAfterEntry));
    }

}