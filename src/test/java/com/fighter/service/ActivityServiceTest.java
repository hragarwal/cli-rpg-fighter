package com.fighter.service;

import com.fighter.model.Activity;
import com.fighter.service.file.FileStore;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static com.fighter.utils.PlayerUtils.createCharacter;
import static com.fighter.utils.PlayerUtils.createMonster;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ActivityServiceTest {

    private ActivityService activityService;
    private FileStore fileStore;
    private Activity activity;

    @Before
    public void setup() {
        fileStore = spy(new FileStore());
        activityService = new ActivityService(fileStore);
        activity = new Activity(createCharacter("Mee"), createMonster("Meow"));
    }

    @Test
    public void shouldGetActivity() {
        when(fileStore.deserialize()).thenReturn(activity);
        Activity savedActivity = activityService.getActivity();
        assertThat(activity, CoreMatchers.is(savedActivity));
    }

    @Test
    public void shouldReturnTrueWhenStateIsSaved() {
        when(fileStore.serialize(activity)).thenReturn(true);
        boolean stateSaved = activityService.saveActivity(activity);
        assertTrue(stateSaved);
    }

    @Test
    public void shouldReturnFalseWhenStateIsNotSaved() {
        when(fileStore.serialize(activity)).thenReturn(false);
        boolean stateSaved = activityService.saveActivity(activity);
        assertFalse(stateSaved);
    }
}