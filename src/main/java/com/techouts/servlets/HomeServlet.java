package com.techouts.servlets;

import java.io.IOException;
import java.util.List;

import com.techouts.dao.ProductDAO;
import com.techouts.entities.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> productsList = ProductDAO.getProductsList();

        req.setAttribute("productsList", productsList);
        
        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        doGet(req, resp);

    }

}
