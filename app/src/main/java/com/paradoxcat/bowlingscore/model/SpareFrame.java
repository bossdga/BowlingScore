package com.paradoxcat.bowlingscore.model;

import java.util.List;

/**
 * Class that represents a SpareFrame
 */
public class SpareFrame extends Frame {

    public SpareFrame(List<BallThrow> ballThrows, BallThrow firstThrow, BallThrow secondThrow) {
        super(ballThrows);
        this.ballThrows.add(firstThrow);
        this.ballThrows.add(secondThrow);
    }

    @Override
    public int getScore() {
        return 10 + firstExtraBall().getValue();
    }

    @Override
    protected int getFrameSize() {
        return 2;
    }

}
