package by.tms.service;

import by.tms.storage.StorageData;

import java.util.regex.Pattern;

public class SeparationEnteredDataAndSaving {

    public void separationEnteredDataAndSaving (String[] parameters, StorageData storageData){
        for (String parameter : parameters) {
            String[] split = parameter.split("=");
            if (split.length == 2 && !split[0].equals("type")) {
                String key = split[0];
                int value = Integer.parseInt(split[1]);
                storageData.setValue(key, value);
            } else if (split.length == 2){
                if (Pattern.matches(".*[\\+\\-\\*\\/\\=].*", split[1])){
                    String key = split[0];
                    String value = split[1];
                    storageData.setOperations(key, value);
                }
            }
        }
    }
}
