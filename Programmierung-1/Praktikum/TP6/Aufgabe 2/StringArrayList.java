import java.util.ArrayList;

public class StringArrayList {
    private ArrayList<String> data;

    public StringArrayList(int capacity) {
        if (capacity < 0) {
            capacity = 0;
        }
        data = new ArrayList<>(capacity);
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < data.size();
    }

    public String get(int index) {
        if (isValidIndex(index)) {
            return data.get(index);
        }
        return null;
    }

    public void set(int index, String value) {
        if (value != null && isValidIndex(index)) {
            data.set(index, value);
        }
    }

    public int size() {
        return data.size();
    }

    public void remove(int index) {
        if (isValidIndex(index)) {
            data.remove(index);
        }
    }

    public int add(String value) {
        if (value == null) {
            return -1;
        }
        data.add(value);
        return data.size() - 1;
    }
}
