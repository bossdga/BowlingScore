package com.paradoxcat.bowlingscore.model;

import java.util.List;

/**
 * Created by diego.alonso 17/07/2018.
 * Copyright © 2018. Fleetmatics Development Limited. All rights reserved.
 */
public class OpenFrame extends Frame {

    public OpenFrame(List<BallThrow> ballThrows, BallThrow firstThrow, BallThrow secondThrow) {
        super(ballThrows);
        ballThrows.add(firstThrow);
        ballThrows.add(secondThrow);
    }

    @Override
    public int getScore() {
        return ballThrows.get(startingThrow).getValue() + ballThrows.get(startingThrow + 1).getValue();
    }

    @Override
    protected int getFrameSize() {
        return 2;
    }

}
