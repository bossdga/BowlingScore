package com.paradoxcat.bowlingscore.model;

import java.util.List;

/**
 * Class that represents an OpenFrame
 */
public class OpenFrame extends Frame {

    public OpenFrame(List<BallThrow> ballThrows, BallThrow firstThrow, BallThrow secondThrow) {
        super(ballThrows);
        this.ballThrows.add(firstThrow);
        this.ballThrows.add(secondThrow);
    }

    @Override
    public int getScore() {
        return this.ballThrows.get(startingThrow).getValue() + ballThrows.get(startingThrow + 1).getValue();
    }

    @Override
    protected int getFrameSize() {
        return 2;
    }

}
