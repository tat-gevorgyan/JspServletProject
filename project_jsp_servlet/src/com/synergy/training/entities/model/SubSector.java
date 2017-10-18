package com.synergy.training.entities.model;

/**
 * Created by user on 10/11/2017.
 */
public class SubSector extends Classifier {
    private final Integer sectorId;

    public SubSector(Integer id, String name, Integer sectorId) {
        super(id, name);
        this.sectorId = sectorId;
    }

    public Integer getSectorId() {
        return sectorId;
    }
}
