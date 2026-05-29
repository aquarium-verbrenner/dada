package de.htwsaar.esch.Codeopolis.DomainModel;

public class NumberProcessor {
    private int[] values;
    public NumberProcessor(int[] values) {
        this.values = values.clone();
    }

    public void printGreaterThan(int threshold) {
        class ValueFilter {
            void filterAndPrint() {
                for (int value : values) {
                    if (value > threshold) {
                        System.out.println(value);
                    }
                }
            }
        }
        
        ValueFilter filter = new ValueFilter();
        filter.filterAndPrint();
    }
}