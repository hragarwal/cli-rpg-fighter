package com.fighter.service.action;

import com.fighter.service.direction.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertTrue;

public class CrossRoadTest {

    @Test
    public void shouldMoveNorthWhenChoiceIs1() throws IOException {
        final BufferedReader input = new BufferedReader(new StringReader("1"));
        final CrossRoad crossRoad = new CrossRoad(input, null);
        final Direction direction = crossRoad.moveToCrossRoad(input, null);
        assertTrue(direction instanceof North);
    }

    @Test
    public void shouldMoveEastWhenChoiceIs2() throws IOException {
        final BufferedReader input = new BufferedReader(new StringReader("2"));
        final CrossRoad crossRoad = new CrossRoad(input, null);
        final Direction direction = crossRoad.moveToCrossRoad(input, null);
        assertTrue(direction instanceof East);
    }

    @Test
    public void shouldMoveSouthWhenChoiceIs3() throws IOException {
        final BufferedReader input = new BufferedReader(new StringReader("3"));
        final CrossRoad crossRoad = new CrossRoad(input, null);
        final Direction direction = crossRoad.moveToCrossRoad(input, null);
        assertTrue(direction instanceof South);
    }

    @Test
    public void shouldMoveWestWhenChoiceIs4() throws IOException {
        final BufferedReader input = new BufferedReader(new StringReader("4"));
        final CrossRoad crossRoad = new CrossRoad(input, null);
        final Direction direction = crossRoad.moveToCrossRoad(input, null);
        assertTrue(direction instanceof West);
    }
}
