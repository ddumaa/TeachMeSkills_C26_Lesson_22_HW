package by.tms.web;

import by.tms.utils.Application;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebApplication implements Application {

    @Override
    public void run() {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8080), 1);
            httpServer.createContext("/calculate", new OperationHttpHandler()); //localhost:8080/calculate
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

