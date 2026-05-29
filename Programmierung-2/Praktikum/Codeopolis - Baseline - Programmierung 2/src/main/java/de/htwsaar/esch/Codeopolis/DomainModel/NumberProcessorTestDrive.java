package de.htwsaar.esch.Codeopolis.DomainModel;

public class NumberProcessorTestDrive {

    public static void main(String[] args) {
        int [] values = {1, 1};
        NumberProcessor np = new NumberProcessor(values);
        np.printGreaterThan(1);
    }

}
