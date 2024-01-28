package by.tms.service;

import lombok.Data;

@Data
public class Message {
    private String message;

    public void clearMessage(){
        message = " ";
    }
}
