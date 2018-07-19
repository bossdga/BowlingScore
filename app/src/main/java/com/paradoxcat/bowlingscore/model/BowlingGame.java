package com.paradoxcat.bowlingscore.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.alonso 17/07/2018.
 * Copyright © 2018. Fleetmatics Development Limited. All rights reserved.
 */
public class BowlingGame {

    private List<BallThrow> ballThrows;
    private List<Frame> frames;

    public BowlingGame() {
        this.ballThrows = new ArrayList();
        this.frames = new ArrayList();
    }

    public void openFrame(BallThrow firstThrow, BallThrow secondThrow) {
        this.frames.add(new OpenFrame(this.ballThrows, firstThrow, secondThrow));
    }

    public void spareFrame(BallThrow firstThrow, BallThrow secondThrow) {
        this.frames.add(new SpareFrame(this.ballThrows, firstThrow, secondThrow));
    }

    public void strikeFrame() {
        this.frames.add(new StrikeFrame(this.ballThrows));
    }

    public void extraThrow(int roll){
        this.frames.add(new BonusFrame(this.ballThrows, new BallThrow(roll)));
    }

    public int getScore() {
        int total = 0;
        for (Frame frame:frames) {
            total += frame.getScore();
        }

        return total;
    }

    public List<Frame> getFrames() {
        return this.frames;
    }

}
