package com.paradoxcat.bowlingscore.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by diego.alonso 18/07/2018.
 * Copyright © 2018. Fleetmatics Development Limited. All rights reserved.
 */
public class BowlingGameTest {

    BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    @Test
    public void openFrame() throws Exception {
        openFrames(10, new BallThrow(1), new BallThrow(2));
        assertEquals( 30, game.getScore());
    }

    @Test
    public void spareFrame() throws Exception {
        game.spareFrame(new BallThrow(4), new BallThrow(6));
        game.openFrame(new BallThrow(3), new BallThrow(5));
        openFrames(8, new BallThrow(1), new BallThrow(0));
        assertEquals( 29, game.getScore());
    }

    @Test
    public void stikeFrame() throws Exception {
        game.strikeFrame();
        game.openFrame(new BallThrow(5), new BallThrow(3));
        openFrames(8, new BallThrow(0), new BallThrow(2));
        assertEquals( 42, game.getScore());
    }

    @Test
    public void stikeLastFrame() throws Exception {
        openFrames(9, new BallThrow(0), new BallThrow(0));
        game.strikeFrame();
        game.extraThrow(5);
        game.extraThrow(3);
        assertEquals( 18, game.getScore());
    }

    @Test
    public void spareLastFrame() throws Exception {
        openFrames(9, new BallThrow(0), new BallThrow(0));
        game.spareFrame(new BallThrow(4), new BallThrow(6));
        game.extraThrow(5);
        assertEquals( 15, game.getScore());
    }

    @Test
    public void score() throws Exception {
    }

    private void openFrames(int numberOfFrames, BallThrow firstThrow, BallThrow secondThrow) {
        for (int i = 0; i < numberOfFrames; i++) {
            game.openFrame(firstThrow, secondThrow);
        }
    }

}