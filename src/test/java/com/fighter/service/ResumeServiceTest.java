package com.fighter.service;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ResumeServiceTest {

    private ResumeService resumeService;
    private BufferedReader inputTaker;

    @Before
    public void setup() {
        resumeService = new ResumeService();
    }

    @Test
    public void shouldReturnTrueWhenUserRequestsResume() throws IOException {
        inputTaker = new BufferedReader(new StringReader("1"));
        boolean isResumeRequested = resumeService.askUserForResume(inputTaker);
        assertTrue(isResumeRequested);
    }

    @Test
    public void shouldReturnFalseWhenUserRequestsStartNewGame() throws IOException {
        inputTaker = new BufferedReader(new StringReader("2"));
        boolean isResumeRequested = resumeService.askUserForResume(inputTaker);
        assertFalse(isResumeRequested);
    }
}