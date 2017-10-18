package com.synergy.training.entities;

import com.synergy.training.entities.model.*;
import com.synergy.training.entities.model.Currency;

import java.io.Serializable;
import java.util.*;

/**
 * Created by user on 10/11/2017.
 */
public final class Holder implements Serializable {
    private final static Set<Currency> currencies;
    private final static Set<Sector> sectors;
    private final static Set<SubSector> subSectors;

    public static Set<Project> projects = new HashSet<>();
    public static List<User> users = new ArrayList<>();

    private static int projectId = 0;
    public static int userId = 0;

    static {
        Set<Currency> currencySet = new HashSet<>();
        currencySet.add(new Currency(1, "USD"));
        currencySet.add(new Currency(2, "AMD"));
        currencySet.add(new Currency(3, "RUB"));
        currencySet.add(new Currency(4, "EUR"));
        currencies = Collections.unmodifiableSet(currencySet);

        Set<Sector> sectorSet = new HashSet<>();
        sectorSet.add(new Sector(1, "A"));
        sectorSet.add(new Sector(2, "B"));
        sectorSet.add(new Sector(3, "C"));
        sectorSet.add(new Sector(4, "D"));
        sectors = Collections.unmodifiableSet(sectorSet);

        Set<SubSector> subSectorSet = new HashSet<>();
        subSectorSet.add(new SubSector(1, "AA", 1));
        subSectorSet.add(new SubSector(2, "BB", 2));
        subSectorSet.add(new SubSector(3, "CC", 3));
        subSectorSet.add(new SubSector(4, "DD", 4));
        subSectorSet.add(new SubSector(5, "AAA", 1));
        subSectorSet.add(new SubSector(6, "BBB", 2));
        subSectorSet.add(new SubSector(7, "CCC", 3));
        subSectorSet.add(new SubSector(8, "DDD", 4));
        subSectors = Collections.unmodifiableSet(subSectorSet);

        projects.add(new Project(++projectId, "Project 1",
                "aaatdsf", 20000, 2, 4));
        projects.add(new Project(++projectId, "Project 2",
                "aaatdsf", 24100, 4, 1));
        projects.add(new Project(++projectId, "Project 3",
                "aaatdsf", 20800, 1, 3));
        projects.add(new Project(++projectId, "Project 4",
                "aaatdsf", 20000, 3, 2));


        users.add(new User(++userId, "UserAAA", "passwordAAA"));
        users.add(new User(++userId, "UserBBB", "passwordBBB"));
        users.add(new User(++userId, "UserCCC", "passwordCCC"));

    }

    public Holder() {}

    public static Set<Currency> getCurrencies() {
        return currencies;
    }

    public static Set<Sector> getSectors() {
        return sectors;
    }

    public static Set<SubSector> getSubSectors() {
        return subSectors;
    }

    public static Set<Project> getProjects() {
        return projects;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static int getProjectId() {
        return projectId;
    }

    public static boolean deleteProject(int id) {
        return projects.removeIf((project -> project.getId() == id));
    }

    public static boolean addProject(int id, String title, String description, int totalAmount, int currency, int subSector) {
        if(id <= 0) {
            System.out.println("Adding Project " + projectId);
            return projects.add(new Project(++projectId, title, description, totalAmount, currency, subSector));
        } else {
            System.out.println("Editing Project " + id);
            return projects.add(new Project(id, title, description, totalAmount, currency, subSector));
        }
    }

    public static boolean editProject(int id, String title, String description, int totalAmount, int currency, int subSector) {
        boolean result = projects.removeIf((project -> project.getId() == id));
        if(result) {
            result = addProject(id, title, description, totalAmount, currency, subSector);
        }
        return result;
    }
}
