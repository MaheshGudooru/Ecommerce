package com.techouts.servlets;

import java.io.IOException;

import com.techouts.dao.UserDAO;
import com.techouts.entities.User;
import com.techouts.utils.HashPasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("register servlet started......");
        req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");

        if (name == null || email == null || !password.equals(confirmPassword)) {

            req.setAttribute("registerMessage", "Re-entered password doesnot match");
            req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);

            return;

        }

        if (UserDAO.checkEmailExistence(email)) {

            req.setAttribute("registerMessage", "Email already exists! try new one");
            req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);

            return;

        }

        if (!HashPasswordUtil.isValidPassword(password)) {

            req.setAttribute("registerMessage", "Try another strong password");
            req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);

            return;
        }

        User user = new User(name, email, HashPasswordUtil.getHashedPassword(password));

        if (!UserDAO.registerUser(user)) {

            req.setAttribute("registerMessage", "Something went wrong! please try again");
            req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);

            return;
        }

        req.getSession().setAttribute("user", user);

        resp.sendRedirect(req.getContextPath() + "/home");

        System.out.println("USER CREATED BY THE REGISTER SERVLET........");

    }

}
