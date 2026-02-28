<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Your Orders - Lumina Store</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/order.css">
        </head>

        <body>

            <header class="site-header">
                <div class="container">
                    <a href="${pageContext.request.contextPath}/home" class="logo">LUMINA</a>
                    <nav class="user-nav">
                        <a href="${pageContext.request.contextPath}/user">Account</a>
                        <a href="${pageContext.request.contextPath}/order">Orders</a>
                        <a href="${pageContext.request.contextPath}/cart">Cart</a>
                    </nav>
                </div>
            </header>

            <main class="orders-section">
                <div class="page-header">
                    <h1>Order History</h1>
                </div>

                <div class="order-card">
                    <div class="order-meta">
                        <div class="meta-group">
                            <label>Order Placed</label>
                            <span>February 12, 2026</span>
                        </div>
                        <div class="meta-group">
                            <label>Total</label>
                            <span>$1,348.50</span>
                        </div>
                        <div class="meta-group">
                            <label>Order #</label>
                            <span>LM-88294-01</span>
                        </div>
                        <div class="meta-group">
                            <label>Status</label>
                            <span class="status-badge status-delivered">Delivered</span>
                        </div>
                    </div>

                    <div class="order-items">
                        <div class="order-item">
                            <img src="https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=200&q=80"
                                alt="Laptop" class="item-image">
                            <div class="item-info">
                                <h3>Lumina Pro Laptop</h3>
                                <p>Quantity: 1</p>
                            </div>
                        </div>
                    </div>

                    <div class="order-footer">
                        <button class="btn-secondary">View Details</button>
                    </div>
                </div>

                <c:forEach var="entry" items="${userOrderMap}">
                    <c:set var="order" value="${entry.key}" />
                    <c:set var="orderItems" value="${entry.value}" />

                    <div class="order-card">

                        <div class="order-meta">
                            <div class="meta-group">
                                <label>Order Placed</label>
                                <span>
                                    <fmt:formatDate value="${order.orderedDate}" pattern="MMMM dd, yyyy" />
                                </span>
                            </div>
                            <div class="meta-group">
                                <label>Total</label>
                                <span>
                                    $
                                    <fmt:formatNumber value="${order.totalPrice}" type="number" minFractionDigits="2"
                                        maxFractionDigits="2" />
                                </span>
                            </div>
                            <div class="meta-group">
                                <label>Order #</label>
                                <span>LM-${order.id}</span>
                            </div>
                            <div class="meta-group">
                                <label>Status</label>
                                <c:choose>
                                    <c:when test="${order.deliveryStatus == 'DELIVERED'}">
                                        <span class="status-badge status-delivered">${order.status}</span>
                                    </c:when>
                                    <c:when test="${order.deliveryStatus == 'PROCESSING'}">
                                        <span class="status-badge status-processing">${order.status}</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="status-badge status-pending">${order.status}</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>

                        <div class="order-items">
                            <c:forEach var="item" items="${orderItems}">
                                <div class="order-item">
                                    <img src="${item.productId.productImage}" alt="${item.productId.name}"
                                        class="item-image">
                                    <div class="item-info">
                                        <h3>${item.productId.name}</h3>
                                        <p>Quantity: ${item.quantity} • ${item.productId.productDescription}</p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <div class="order-footer">
                            <a href="${pageContext.request.contextPath}/order/details?orderId=${order.id}"
                                class="btn-secondary">View Details</a>
                        </div>
                    </div>
                </c:forEach>

            </main>

        </body>

        </html>