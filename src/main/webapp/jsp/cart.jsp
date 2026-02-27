<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>


        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Your Cart - Lumina Store</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/cart.css">
        </head>

        <body>

            <header class="site-header">
                <div class="container">
                    <a href="index.html" class="logo">LUMINA</a>
                    <nav class="user-nav">
                        <a href="#">Account</a>
                        <a href="#">Orders</a>
                        <a href="#">Cart (0)</a>
                    </nav>
                </div>
            </header>

            <main class="cart-section">
                <div class="cart-header">
                    <h1>Your Cart</h1>
                </div>

                <div class="cart-grid">

                    <div class="cart-items">

                        <c:forEach var="cartItem" items="${cartItemsList}">
                            <div class="cart-item">
                                <img src="${cartItem.productId.productImage}" alt="Lumina Pro Laptop"
                                    class="item-image">
                                <div class="item-details">
                                    <h3>${cartItem.productId.name}</h3>
                                    <p>${cartItem.productId.productDescription}</p>
                                    <div class="item-actions">

                                        <div class="quantity-wrapper">

                                            <form class="reduce-item-from-cart">
                                                <input type="hidden" name="CartItemId" value="${cartItem.id}">
                                                <button type="submit" class="qty-btn minus">-</button>
                                            </form>
                                            <input type="text" class="qty-input" value="${cartItem.quantity}" readonly>
                                            <form class="increase-item-from-cart">
                                                <input type="hidden" name="CartItemId" value="${cartItem.id}">
                                                <button type="submit" class="qty-btn plus">+</button>
                                            </form>
                                            
                                        </div>
                                        <form class="remove-item-from-cart">
                                            <input type="hidden" name="CartItemId" value="${cartItem.id}">
                                            <button type="submit" class="remove-btn">Remove</button>
                                        </form>
                                    </div>
                                </div>
                                <div class="item-price">$${cartItem.productId.price}</div>
                            </div>
                        </c:forEach>

                    </div>

                    <div class="order-summary">
                        <h2>Order Summary</h2>
                        <div class="summary-row"><span>Subtotal</span><span>$1,548.00</span></div>
                        <div class="summary-row"><span>Shipping</span><span>Free</span></div>
                        <div class="summary-row"><span>Estimated Tax</span><span>$108.36</span></div>
                        <div class="summary-total"><span>Total</span><span>$1,656.36</span></div>

                        <a href="#" class="btn-primary">Proceed to Checkout</a>
                        <a href="${pageContext.request.contextPath}/home" class="continue-shopping">Continue
                            Shopping</a>
                    </div>

                </div>
            </main>

            <script>
                document.querySelectorAll('.remove-item-from-cart').forEach(form => {
                    form.addEventListener('submit', function (e) {
                        e.preventDefault();

                        const formData = new FormData(this);
                        const params = new URLSearchParams(formData).toString();

                        fetch('${pageContext.request.contextPath}/cart/remove', {
                            method: 'POST',
                            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                            body: params
                        })
                            .then(response => response.text())
                            .then(status => {
                                if (status === 'success') {
                                    alert('Product removed from cart!');
                                } else {
                                    alert('Failed to remove from product.');
                                }
                            })
                            .catch(err => console.error(err));
                    });
                });
                document.querySelectorAll('.reduce-item-from-cart').forEach(form => {
                    form.addEventListener('submit', function (e) {
                        e.preventDefault();

                        const formData = new FormData(this);
                        const params = new URLSearchParams(formData).toString();

                        fetch('${pageContext.request.contextPath}/cart/decreasecnt', {
                            method: 'POST',
                            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                            body: params
                        })
                            .then(response => response.text())
                            .then(status => {
                                if (status === 'success') {
                                    console.log('Product quantity reduced successfully!');
                                } else {
                                    console.log('Failed to reduce product quantity product.');
                                }
                            })
                            .catch(err => console.error(err));
                    });
                });
                document.querySelectorAll('.increase-item-from-cart').forEach(form => {
                    form.addEventListener('submit', function (e) {
                        e.preventDefault();

                        const formData = new FormData(this);
                        const params = new URLSearchParams(formData).toString();

                        fetch('${pageContext.request.contextPath}/cart/increasecnt', {
                            method: 'POST',
                            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                            body: params
                        })
                            .then(response => response.text())
                            .then(status => {
                                if (status === 'success') {
                                    console.log('Product quantity reduced successfully!');
                                } else {
                                    console.log('Failed to reduce product quantity product.');
                                }
                            })
                            .catch(err => console.error(err));
                    });
                });
            </script>

        </body>

        </html>