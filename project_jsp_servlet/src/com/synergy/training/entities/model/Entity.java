package com.synergy.training.entities.model;

/**
 * Created by user on 10/11/2017.
 */
public abstract class Entity {

    private final int id;

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() &&
                getId() == ((Entity)obj).getId();
    }

    @Override
    public final int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return String.format("{%s, %d}", getClass().getName(), getId());
    }
}
