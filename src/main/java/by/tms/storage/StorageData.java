package by.tms.storage;

import java.util.HashMap;
import java.util.Map;

public class StorageData {
    private Map<String, Integer> values = new HashMap<>();
    private Map<String, String> operations = new HashMap<>();

    public Map<String, Integer> getValues() {
        return values;
    }

    public void setValue(String key, int value) {
        values.put(key, value);
    }

    public Map<String, String> getOperations() {
        return operations;
    }

    public void setOperations(String key, String value) {
        operations.put(key, value);
    }

    public void clearValue(){
        values.clear();
    }
    public void clearOperations(){
        operations.clear();
    }
}
