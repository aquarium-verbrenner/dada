package de.htwsaar.esch.Codeopolis.DomainModel;

import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.*;
import java.text.DecimalFormat;

public class Depot {
    private LinkedList<Silo> silos;

    public int[] getBushelsCategorizedByGrainType() {
        int[] result = new int[Game.GrainType.values().length];
        for (Game.GrainType grainType : Game.GrainType.values()) {
            result[grainType.ordinal()] = getFillLevel(grainType);
        }
        return result;
    }

    public Depot(int numberOfSilos, int capacityPerSilo) {
        this.silos = new LinkedList<>();
        for (int i = 0; i < numberOfSilos; i++) {
            this.silos.add(new Silo(capacityPerSilo));
        }
    }

    // Changement pour un forEach (alignment avec le reste)
    public Depot(LinkedList<Silo> silosList) {
        this.silos = new LinkedList<>();
        if (silosList != null) {
            silosList.forEach(silo -> this.silos.add(new Silo(silo)));
        }
    }

    public Depot(Silo[] silosArray) {
        this.silos = new LinkedList<>();
        if (silosArray != null) {
            for (Silo silo : silosArray) {
                if (silo != null) {
                    this.silos.add(new Silo(silo));
                }
            }
        }
    }

    // En premier nous filtrons et ensuite nous selections
    public int getFillLevel(Game.GrainType grainType) {
        final int[] totalFillLevel = {0};
        // Combinaison de filter() et forEach()
        this.silos.filter(silo -> silo.getGrainType() == grainType)
                .forEach(silo -> totalFillLevel[0] += silo.getFillLevel());
        return totalFillLevel[0];
    }

    // Utilisation forEach renvoie maintenant une LinkedList
    public Silo[] getSilos() {
        Silo[] silosArray = new Silo[this.silos.size()];
        final int[] index = {0};

        this.silos.forEach(silo -> {
            silosArray[index[0]] = new Silo(silo);
            index[0]++;
        });

        return silosArray;
    }

    public int getTotalFillLevel() {
        final int[] totalBushels = {0};
        this.silos.forEach(silo -> totalBushels[0] += silo.getFillLevel());
        return totalBushels[0];
    }

    public int getCapacity(Game.GrainType grainType) {
        final int[] totalCapacity = {0};
        this.silos.filter(silo -> silo.getGrainType() == grainType)
                .forEach(silo -> totalCapacity[0] += silo.getCapacity());
        return totalCapacity[0];
    }

    // Utilisation forEach
    public boolean store(Harvest harvest) {
        final Harvest[] currentHarvest = {harvest};

        this.silos.forEach(silo -> {
            if (currentHarvest[0] != null && (silo.getGrainType() == currentHarvest[0].getGrainType() || silo.getFillLevel() == 0)) {
                currentHarvest[0] = silo.store(currentHarvest[0]);
            }
        });

        if (currentHarvest[0] == null) return true;

        defragment();

        this.silos.forEach(silo -> {
            if (currentHarvest[0] != null && (silo.getGrainType() == currentHarvest[0].getGrainType() || silo.getFillLevel() == 0)) {
                currentHarvest[0] = silo.store(currentHarvest[0]);
            }
        });

        return currentHarvest[0] == null;
    }

    // Utilisatiion forEach
    public int takeOut(int amount, Game.GrainType grainType) {
        final int[] remainingAmount = {amount};
        final int[] takenAmount = {0};

        this.silos.forEach(silo -> {
            if (remainingAmount[0] > 0 && silo.getGrainType() == grainType) {
                int amountTaken = silo.takeOut(remainingAmount[0]);
                remainingAmount[0] -= amountTaken;
                takenAmount[0] += amountTaken;
            }
        });

        return takenAmount[0];
    }

    public int takeOut(int amount) {
        int totalFill = this.getTotalFillLevel();
        if (amount >= totalFill) {
            // ALTERNATIVE : reference
            this.silos.forEach(Silo::emptySilo);
            return totalFill;
        }

        int count = this.silos.size(); // Utilisation de size() au lieu de la boucle de comptage
        int partition = amount / count;
        final int[] remainder = {amount % count};

        this.silos.forEach(silo -> {
            if (silo.getFillLevel() < partition) {
                remainder[0] += partition - silo.getFillLevel();
                silo.emptySilo();
            } else {
                silo.takeOut(partition);
            }
        });

        while (remainder[0] > 0) {
            for (int i = 0; i < silos.size(); i++) {
                Silo silo = silos.get(i);
                if (remainder[0] > 0 && silo.getFillLevel() > 0) {
                    silo.takeOut(1);
                    remainder[0]--;
                }
            }
        }
        return amount;
    }

    public void expand(int numberOfSilos, int capacityPerSilo) {
        for (int i = 0; i < numberOfSilos; i++) {
            this.silos.add(new Silo(capacityPerSilo));
        }
    }

    public void defragment() {
        LinkedList<Harvest> allHarvests = new LinkedList<>();

        this.silos.forEach(silo -> {
            Harvest[] siloHarvests = silo.emptySilo();
            if (siloHarvests != null) {
                for (Harvest h : siloHarvests) {
                    if (h != null) allHarvests.add(h);
                }
            }
        });

        // ALTERNATIVE
        allHarvests.forEach(this::store);
    }

    private int getTotalHarvestCount() {
        final int[] totalCount = {0};
        this.silos.forEach(silo -> totalCount[0] += silo.getHarvestCount());
        return totalCount[0];
    }

    public int decay(int currentYear) {
        final int[] totalDecayedAmount = {0};
        this.silos.forEach(silo -> totalDecayedAmount[0] += silo.decay(currentYear));
        return totalDecayedAmount[0];
    }

    public boolean full() {
        return this.getTotalFillLevel() >= this.totalCapacity();
    }

    public int totalCapacity() {
        final int[] totalCapacity = {0};
        this.silos.forEach(silo -> totalCapacity[0] += silo.getCapacity());
        return totalCapacity[0];
    }

    // Passage à forEach
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        DecimalFormat df = new DecimalFormat("0.00");
        final int[] index = {1};

        this.silos.forEach(silo -> {
            builder.append("Silo ").append(index[0]++).append(": ");
            String grainName = (silo.getGrainType() != null) ? silo.getGrainType().toString() : "EMPTY";
            builder.append(grainName).append("\n");

            int fillLevel = silo.getFillLevel();
            int capacity = silo.getCapacity();
            double fillPercentage = (capacity > 0) ? ((double) fillLevel / capacity * 100) : 0;

            builder.append("Amount of Grain: ").append(fillLevel).append(" units\n");

            int fillBarLength = 20;
            int filledBars = (int) (fillPercentage / 100 * fillBarLength);
            int emptyBars = fillBarLength - filledBars;

            builder.append("|");
            for (int j = 0; j < filledBars; j++) builder.append("=");
            for (int j = 0; j < emptyBars; j++) builder.append("-");
            builder.append("| ").append(df.format(fillPercentage)).append("% filled\n");
            builder.append("Capacity: ").append(capacity).append(" units\n\n");
        });

        return builder.toString();
    }
}