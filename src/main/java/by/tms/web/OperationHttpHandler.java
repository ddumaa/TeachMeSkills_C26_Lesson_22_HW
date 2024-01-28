package by.tms.web;

import by.tms.service.DataChecking;
import by.tms.service.Message;
import by.tms.service.SeparationEnteredDataAndSaving;
import by.tms.storage.StorageData;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.PrintWriter;

public class OperationHttpHandler implements HttpHandler {

    private final StorageData storageData = new StorageData();
    private final SeparationEnteredDataAndSaving separationEnteredDataAndSaving = new SeparationEnteredDataAndSaving();
    private final Message message = new Message();
    private final DataChecking dataChecking = new DataChecking();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery(); //localhost:8080/calculate?num1=2&type=+&num2=2
		String[] parameters = query.split("&");

        separationEnteredDataAndSaving.separationEnteredDataAndSaving(parameters, storageData);

        String s = dataChecking.check(storageData, message);

        exchange.sendResponseHeaders(200, s.length());

        PrintWriter printWriter = new PrintWriter(exchange.getResponseBody());
        printWriter.print(s);
        printWriter.flush();

        message.clearMessage();
        storageData.clearOperations();
        storageData.clearValue();
    }
}
