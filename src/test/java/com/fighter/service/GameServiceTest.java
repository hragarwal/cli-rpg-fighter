package com.fighter.service;

import com.fighter.model.Activity;
import com.fighter.model.Player;
import com.fighter.service.file.FileStore;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static com.fighter.utils.PlayerUtils.createCharacter;
import static com.fighter.utils.PlayerUtils.createMonster;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GameServiceTest {

    private GameService gameService;
    private ActivityService activityService;
    private TownService townService;
    private ResumeService resumeService;
    private Activity activity;
    private Player player;
    private Player monster;

    @Before
    public void setup() {
        activityService = spy(new ActivityService(new FileStore()));
        townService = spy(new TownService(activityService));
        resumeService = spy(new ResumeService());
        gameService = new GameService(activityService, townService, resumeService);
        activity = null;
        player = createCharacter("Batman");
        monster = createMonster("Globin");
    }

    @Test
    public void shouldGetPlayerNameFromConsole() throws IOException {
        String character = "Meow";
        final BufferedReader inputTaker = new BufferedReader(new StringReader(character));
        String playerName = gameService.askCharacterName(inputTaker);
        assertEquals(character, playerName);
    }

    @Test
    public void shouldResumeGameIfUserRequestsAndGameWasSaved() throws IOException {
        final BufferedReader inputTaker = new BufferedReader(new StringReader(""));
        activity = new Activity(player, monster);
        doReturn(activity).when(activityService).getActivity();
        doReturn(true).when(resumeService).askUserForResume(inputTaker);
        doNothing().when(townService).moveToTown(player, inputTaker, monster);
        gameService.startGame(inputTaker);
        verify(resumeService, times(1)).askUserForResume(inputTaker);
        verify(townService, times(1)).moveToTown(player, inputTaker, monster);
    }

    @Test
    public void shouldNotAskToResumeGameIfGameWasNotSaved() throws IOException {
        final BufferedReader inputTaker = new BufferedReader(new StringReader(""));
        doReturn(activity).when(activityService).getActivity();
        doNothing().when(townService).moveToTown(any(), any(), any());
        gameService.startGame(inputTaker);
        verify(resumeService, times(0)).askUserForResume(inputTaker);
        verify(townService, times(1)).moveToTown(any(), any(), any());
    }
}
