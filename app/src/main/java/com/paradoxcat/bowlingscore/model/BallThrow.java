package com.paradoxcat.bowlingscore.model;

/**
 * Class that represents a Ball Throw
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
