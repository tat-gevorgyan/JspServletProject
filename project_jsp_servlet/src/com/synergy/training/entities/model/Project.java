package com.synergy.training.entities.model;

/**
 * Created by user on 10/11/2017.
 */
public class Project extends Entity {
    private final String title;

    private final String description;

    private final int totalAmount;

    private final int currencyId;

    private final int subSectorId;

    public Project(Integer id, String title, String description,
                   int totalAmount, int currencyId, int subSectorId) {
        super(id);
        this.title = title;
        this.description = description;
        this.totalAmount = totalAmount;
        this.currencyId = currencyId;
        this.subSectorId = subSectorId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public int getSubSectorId() {
        return subSectorId;
    }
}
