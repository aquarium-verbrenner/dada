public class StringArray {
    private String[] data;
    private int logicalSize;

    public StringArray(int capacity) {
        if (capacity < 0) {
            capacity = 0; 
        }
        data = new String[capacity];
        logicalSize = 0;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < data.length;
    }

    public String get(int index) {
        if (isValidIndex(index)) {
            return data[index];
        }
        return null;
    }

    public void set(int index, String value) {
        if (value != null && isValidIndex(index)) {
            if (data[index] == null && value != null) {
                logicalSize++;
            }
            data[index] = value;
        }
    }

    public int size() {
        return logicalSize;
    }

    public void remove(int index) {
        if (isValidIndex(index)) {
            if (data[index] != null) {
                logicalSize--;
            }
            
            data[index] = null;
        }
    }

    private void resize() {
        int newCapacity = data.length + (data.length / 2);
        
        if (data.length == 0) {
            newCapacity = 1;
        }
        
        System.out.println("New capacity of the array : " + newCapacity);
        String[] newData = new String[newCapacity];
        
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public int add(String value) {
        if (value == null) {
            return -1;
        }
        
        int freeIndex = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                freeIndex = i;
                break;
            }
        }
        
        if (freeIndex == -1) {
            resize();
            freeIndex = data.length - 1; 
        }
        data[freeIndex] = value;
        logicalSize++;
        return freeIndex;
    }
}
