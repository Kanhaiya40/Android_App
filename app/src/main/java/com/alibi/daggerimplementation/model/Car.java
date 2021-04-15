package com.alibi.daggerimplementation.model;

public class Car {

    private final Engine engine;
    private final Parts parts;

    public Car(Engine engine, Parts parts) {
        this.engine = engine;
        this.parts = parts;
    }
}
