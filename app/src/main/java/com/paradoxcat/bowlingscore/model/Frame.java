package com.paradoxcat.bowlingscore.model;

import java.util.List;

/**
 * Class that represents a Frame
 */
public abstract class Frame {

    protected List<BallThrow> ballThrows;
    protected int startingThrow;

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

}
