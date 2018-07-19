package com.paradoxcat.bowlingscore.model;

import java.util.List;

/**
 * Created by diego.alonso 18/07/2018.
 * Copyright © 2018. Fleetmatics Development Limited. All rights reserved.
 */
public class StrikeFrame extends Frame {

    public StrikeFrame(List<BallThrow> ballThrows) {
        super(ballThrows);
        ballThrows.add(new BallThrow(10));
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
