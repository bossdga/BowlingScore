package com.paradoxcat.bowlingscore.model;

import java.util.List;

/**
 * Created by diego.alonso 18/07/2018.
 * Copyright © 2018. Fleetmatics Development Limited. All rights reserved.
 */
public abstract class Frame {

    protected List<BallThrow> ballThrows;
    protected int startingThrow;
    protected int score;
    protected int frameSize;

    public Frame(List<BallThrow> ballThrows) {
        this.ballThrows = ballThrows;
        this.startingThrow = ballThrows.size();
    }

    public abstract int getScore();
    protected abstract int getFrameSize();

    protected BallThrow firstExtraBall() {
        return ballThrows.get(startingThrow + getFrameSize());
    }

    protected BallThrow secondExtraBall() {
        return ballThrows.get(startingThrow + getFrameSize() + 1);
    }

    public List<BallThrow> getBallThrows() {
        return this.ballThrows;
    }

}
