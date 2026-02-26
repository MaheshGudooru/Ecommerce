package com.techouts.utils.logging.servletlogger;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebListener
public class RequestListener implements ServletRequestListener {

    private void printLog(String s) {
        System.out.println("REQUEST LOG ==> "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-uuuu HH:mm:ss")) + ": " + s);
    }

    public void requestInitialized(ServletRequestEvent sre) {

        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();

        String url = req.getRequestURL().toString();

        if (url.contains("/home")) {
            printLog("HOME PAGE REQUEST RECEIVED....");
        } else if (url.contains("/login")) {
            printLog("LOGIN REQUEST RECEIVED....");
        } else if (url.contains("/register")) {
            printLog("REGISTER REQUEST RECEIVED....");
        } else {
            printLog("UNKNOWN REQUEST RECEIVED....");
        }

    }

    public void requestDestroyed(ServletRequestEvent sre) {

        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();

        String url = req.getRequestURL().toString();

        if (url.contains("/home")) {
            printLog("HOME PAGE REQUEST HAS BEEN DESTROYED....");
        } else if (url.contains("/login")) {
            printLog("LOGIN REQUEST DESTROYED....");
        } else if (url.contains("/register")) {
            printLog("REGISTER REQUEST DESTROYED....");
        } else {
            printLog("UNKNOWN REQUEST DESTROYED....");
        }

    }

}
