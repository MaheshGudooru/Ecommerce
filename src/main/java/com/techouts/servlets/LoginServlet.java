package com.techouts.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Servlet started............");
        // req.getRequestDispatcher ("/jsp/login.jsp").forward (req, resp);
        resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST REQUEST RECEIVED............");
        System.out.println("email: " + req.getParameter("email"));
        System.out.println("Password: " + req.getParameter("password"));
    }
}   
        