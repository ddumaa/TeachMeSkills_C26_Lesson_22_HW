package by.tms.service;

import by.tms.model.Operation;
import by.tms.storage.StorageData;

public class DataChecking {
    private final OperationService operationService = new OperationService();
    public String check (StorageData storageData, Message message){
        boolean messageYep = false;
        String result = null;
        String output;
        if (storageData.getValues().isEmpty()) {
            message.setMessage("Incorrect data was entered instead of a number");
            messageYep = true;
        } else if (storageData.getOperations().isEmpty()){
            message.setMessage("an incorrect mathematical sign was entered");
            messageYep = true;
        } else if (storageData.getValues().size() %2 !=0) {
            message.setMessage("Incorrect data was entered instead of a number");
            messageYep = true;
        } else {
            int zero = storageData.getValues().get("num2");
            String op = storageData.getOperations().get("type");
            if (zero == 0 && op.equals("/")) {
                message.setMessage("You can't divide by zero");
                messageYep = true;
            }  else {
                Operation operation = new Operation(storageData.getValues().get("num1"),
                        storageData.getValues().get("num2"),
                        storageData.getOperations().get("type"));
                operationService.calculate(operation);
                result = String.valueOf(operation.getResult());
            }
        }
        if(!messageYep){
            output = "Result: " + result;
        } else {
            output = message.getMessage();
        }
        return output;
    }
}
