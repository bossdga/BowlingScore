package com.paradoxcat.bowlingscore.model;

import java.util.List;

/**
 * Class that represents a StrikeFrame
 */
public class StrikeFrame extends Frame {

    public StrikeFrame(List<BallThrow> ballThrows) {
        super(ballThrows);
        this.ballThrows.add(new BallThrow(10));
    }

    @Override
    public int getScore() {
        return 10 + firstExtraBall().getValue() + secondExtraBall().getValue();
    }

    @Override
    protected int getFrameSize() {
        return 1;
    }

}
