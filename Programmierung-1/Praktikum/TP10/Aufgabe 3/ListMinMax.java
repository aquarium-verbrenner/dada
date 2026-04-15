import java.util.ArrayList;

public class ListMinMax {
    public static int min(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        int currentMin = Integer.MAX_VALUE;
        for (int value : list) {
            currentMin = Math.min(currentMin, value);
        }
        return currentMin;
    }

    public static int max(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int currentMax = Integer.MIN_VALUE;
        for (int value : list) {
            currentMax = Math.max(currentMax, value);
        }
        return currentMax;
    }
}