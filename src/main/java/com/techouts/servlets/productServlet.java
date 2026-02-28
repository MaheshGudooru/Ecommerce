package com.techouts.servlets;

import java.io.IOException;

import com.techouts.dao.ProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class productServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int productId = Integer.parseInt(req.getParameter("id"));

        req.setAttribute("productDetail", ProductDAO.getProductById(productId));

        req.getRequestDispatcher("/jsp/product.jsp").forward(req, resp);

    }

}
