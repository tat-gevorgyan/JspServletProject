package com.synergy.training.entities.model;

/**
 * Created by user on 10/11/2017.
 */
public abstract class Classifier extends Entity{
    private final String name;
    public String getName() {
        return name;
    }

    public Classifier(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
