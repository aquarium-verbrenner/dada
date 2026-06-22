package de.htwsaar.esch.Codeopolis.DomainModel;

import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.*;
import java.io.Serializable;

public class Silo implements Serializable {
    private LinkedList<Harvest> stock;
    private final int capacity;
    private int fillLevel;


    public static class Status {
        private final int capacity;
        private final int fillLevel;

        private Status(int capacity, int fillLevel) {
            this.capacity = capacity;
            this.fillLevel = fillLevel;
        }

        public int getCapacity() { return capacity; }
        public int getFillLevel() { return fillLevel; }
    }

    public Status getStatus() {
        return new Status(this.capacity, this.fillLevel);
    }

    public Silo(int capacity) {
        this.capacity = capacity;
        this.stock = new LinkedList<>();
        this.fillLevel = 0;
    }

    // Directement géré par LinkedList
    public Silo(Silo other) {
        this.capacity = other.capacity;
        this.fillLevel = other.fillLevel;
        this.stock = new LinkedList<>();
        // Utilisation de forEach avec une expression lambda
        other.stock.forEach(harvest -> this.stock.add(harvest.copy()));
    }

    public Harvest store(Harvest harvest) {
        if (fillLevel > 0 && getGrainType() != harvest.getGrainType()) {
            throw new IllegalArgumentException("The grain type of the given Harvest does not match the grain type of the silo");
        }

        if (fillLevel >= capacity) {
            return harvest;
        }

        int remainingCapacity = this.capacity - this.fillLevel;
        if (harvest.getAmount() <= remainingCapacity) {
            this.stock.add(harvest);
            this.fillLevel += harvest.getAmount();
            return null;
        } else {
            Harvest remainingHarvest = harvest.split(remainingCapacity);
            this.stock.add(remainingHarvest);
            this.fillLevel += remainingHarvest.getAmount();
            return harvest;
        }
    }

    private Harvest[] copyStock(){

        Harvest[] copy = new Harvest[stockIndex + 1];

        for (int i = 0; i <= stockIndex; i++) {
            copy[i] = stock[i].copy();
        }
        return copy;
    }

    public Harvest[] getStockCopy() {
        return copyStock();
    }

    // Directement géré par linkedList
    public Harvest[] emptySilo() {
        if (fillLevel == 0) {
            return null;
        }

        Harvest[] removedHarvests = new Harvest[getHarvestCount()];
        final int[] i = {0};
        // Utilisation de forEach
        this.stock.forEach(harvest -> {
            removedHarvests[i[0]] = harvest;
            i[0]++;
        });

        this.stock = new LinkedList<>();
        this.fillLevel = 0;
        return removedHarvests;
    }

    public int takeOut(int amount) {
        int takenAmount = 0;
        LinkedList<Harvest> updatedStock = new LinkedList<>();

        // Une boucle classique est conservée ici car on doit pouvoir break/modifier l'état
        for (Harvest currentHarvest : stock) {
            if (amount > 0) {
                int taken = currentHarvest.remove(amount);
                amount -= taken;
                takenAmount += taken;
            }
            if (currentHarvest.getAmount() > 0) {
                updatedStock.add(currentHarvest);
            }
        }

        this.stock = updatedStock;
        this.fillLevel -= takenAmount;
        return takenAmount;
    }

    public int getFillLevel() {
        return this.fillLevel;
    }

    public int getCapacity() {
        return capacity;
    }

    public Game.GrainType getGrainType() {
        if (fillLevel > 0 && !stock.isEmpty()) {
            // Récupère le type du premier élément via l'itérateur implicite
            return stock.get(0).getGrainType();
        }
        return null;
    }

    // Amélioration de code en passant d'une boucle for a cette fonction size
    public int getHarvestCount() {
        // Utilisation de la méthode size() (plus rapide)
        return this.stock.size();
    }

    // Changement et utilisation de forEach à la place d'une boucle classique
    public int decay(int currentYear) {
        final int[] totalDecayedAmount = {0};

        // Utilisation de forEach
        this.stock.forEach(harvest -> totalDecayedAmount[0] += harvest.decay(currentYear));

        this.fillLevel -= totalDecayedAmount[0];
        return totalDecayedAmount[0];
    }
}