package com.paradoxcat.bowlingscore.model;

import java.util.List;

/**
 * Created by diego.alonso 18/07/2018.
 * Copyright © 2018. Fleetmatics Development Limited. All rights reserved.
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
