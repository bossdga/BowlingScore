package com.paradoxcat.bowlingscore.model;

import java.util.List;

/**
 * Created by diego.alonso 18/07/2018.
 * Copyright © 2018. Fleetmatics Development Limited. All rights reserved.
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
