package com.paradoxcat.bowlingscore.model;

import java.util.List;

/**
 * Class that represents a BonusFrame
 */
public class BonusFrame extends Frame {

    public BonusFrame(List<BallThrow> ballThrows, BallThrow firstThrow) {
        super(ballThrows);
        this.ballThrows.add(firstThrow);
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    protected int getFrameSize() {
        return 0;
    }

}
