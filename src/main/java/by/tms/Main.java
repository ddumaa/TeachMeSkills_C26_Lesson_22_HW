package by.tms;

import by.tms.utils.Application;
import by.tms.web.WebApplication;

public class Main {
    public static void main(String[] args) {
        Application application = new WebApplication();
        application.run();
    }
}
