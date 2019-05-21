package com.fighter.service.action;

import com.fighter.model.Player;
import com.fighter.service.ActivityService;
import com.fighter.service.file.FileStore;
import org.junit.Test;

import static com.fighter.utils.PlayerUtils.createCharacter;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SaveTest {

    @Test
    public void shouldBeAbleToSaveGameStateWithoutAnyException() {
        ActivityService activityService = spy(new ActivityService(new FileStore()));
        Save save = new Save(activityService);
        when(activityService.saveActivity(any())).thenReturn(true);
        Player player = save.perform(createCharacter("ShaktiMan"), null);
        assertNotNull(player);
    }

}