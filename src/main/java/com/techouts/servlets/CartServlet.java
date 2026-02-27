package com.techouts.servlets;

import java.io.IOException;
import java.util.List;

import com.techouts.dao.CartDAO;
import com.techouts.entities.CartItem;
import com.techouts.entities.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cart/*")
public class CartServlet extends HttpServlet {

    private void addProductToCartItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println(req.getParameter("productId"));
        int productId = Integer.parseInt(req.getParameter("productId"));

        boolean productInsertionStatus = CartDAO.addProductToUser((User) req.getSession(false).getAttribute("user"),
                productId);

        resp.setContentType("text/plain");
        resp.getWriter().write(productInsertionStatus ? "success" : "fail");

    }

    private void removeProductCartItem(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        System.out.println(req.getParameter("CartItemId"));
        int cartItemId = Integer.parseInt(req.getParameter("CartItemId"));

        boolean cartItemDeletionStatus = CartDAO.removeCartItem((User) req.getSession().getAttribute("user"),
                cartItemId);
        resp.setContentType("text/plain");
        resp.getWriter().write(cartItemDeletionStatus ? "success" : "fail");

    }

    private void decreaseProductQuantity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(req.getParameter("CartItemId"));
        int cartItemId = Integer.parseInt(req.getParameter("CartItemId"));

        boolean cartItemQuantityUpdationStatus = CartDAO.decreaseCartItemQuantity((User) req.getSession().getAttribute("user"),
                cartItemId);
        resp.setContentType("text/plain");
        resp.getWriter().write(cartItemQuantityUpdationStatus ? "success" : "fail");
    }

    private void increaseProductQuantity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(req.getParameter("CartItemId"));
        int cartItemId = Integer.parseInt(req.getParameter("CartItemId"));

        boolean cartItemQuantityUpdationStatus = CartDAO.increaseCartItemQuantity((User) req.getSession().getAttribute("user"),
                cartItemId);
        resp.setContentType("text/plain");
        resp.getWriter().write(cartItemQuantityUpdationStatus ? "success" : "fail");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CartItem> userCartItems = CartDAO.getUserCartItems((User) req.getSession().getAttribute("user"));

        req.setAttribute("cartItemsList", userCartItems);

        req.getRequestDispatcher("/jsp/cart.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getPathInfo();
        System.out.println(path);

        switch (path) {
            case "/add" -> addProductToCartItem(req, resp);
            case "/remove" -> removeProductCartItem(req, resp);
            case "/decreasecnt" -> decreaseProductQuantity(req, resp);
            case "/increasecnt" -> increaseProductQuantity(req, resp);
            default -> resp.sendRedirect(req.getContextPath() + "/cart");
        }

    }

}
