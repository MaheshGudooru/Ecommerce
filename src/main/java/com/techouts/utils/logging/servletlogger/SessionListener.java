package com.techouts.utils.logging.servletlogger;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import org.hibernate.SessionEventListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebListener
public class SessionListener implements SessionEventListener {

    private void printLog(String s) {
        System.out.println ("SESSION LOG ==> " + LocalDateTime.now ().format (DateTimeFormatter.ofPattern ("dd-MMM-uuuu HH:mm:ss")) + ": " + s);
    }

    public synchronized void sessionCreated(HttpSessionEvent se)  {

        printLog ("SERVLET SESSION(" + se.getSession ().getId () + ")  HAS BEEN CREATED!!!");

    }

    public synchronized void sessionDestroyed(HttpSessionEvent se)  {

        printLog ("SERVLET SESSION(" + se.getSession ().getId () + ")  HAS BEEN DESTROYED!!!");

    }
}
