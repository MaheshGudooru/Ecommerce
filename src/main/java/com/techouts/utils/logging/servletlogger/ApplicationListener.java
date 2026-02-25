package com.techouts.utils.logging.servletlogger;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebListener
public class ApplicationListener implements ServletContextListener {

    private void printLog(String s) {
        System.out.println ("SERVLET LOG ==> " + LocalDateTime.now ().format (DateTimeFormatter.ofPattern ("dd-MMM-uuuu HH:mm:ss")) + ": " + s);
    }

    public void contextInitialized(ServletContextEvent sce) {

        printLog ("SERVLET APPLICATION STARTED....");

    }

    public void contextDestroyed(ServletContextEvent sce) {

        printLog ("SERVLET APPLICATION SHUTDOWN!!!!");

    }
}
