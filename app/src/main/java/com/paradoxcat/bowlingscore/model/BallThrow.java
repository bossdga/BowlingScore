package com.paradoxcat.bowlingscore.model;

/**
 * Created by diego.alonso 17/07/2018.
 * Copyright © 2018. Fleetmatics Development Limited. All rights reserved.
 */

public class BallThrow {

    private int id;
    private int value;

    public BallThrow(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
