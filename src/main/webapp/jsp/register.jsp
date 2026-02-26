<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account - Lumina Store</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/register.css" >
</head>

<body>

    <header class="site-header">
        <div class="container">
            <a href="index.html" class="logo">LUMINA</a>
            <a href="index.html" class="back-link">Back to Store</a>
        </div>
    </header>

    <main class="auth-wrapper">
        <div class="auth-card">
            <h1>Create Account</h1>
            <p>${empty requestScope.registerMessage ? 'Join Lumina to unlock exclusive premium benefits.' : registerMessage}</p>

            <form action="${pageContext.request.contextPath}/register" method="POST">
                
                <div class="form-group">
                    <label for="fullname">Full Name</label>
                    <input type="text" id="fullname" name="fullname" placeholder="Jane Doe" required>
                </div>

                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" id="email" name="email" placeholder="you@example.com" required>
                </div>
                
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Create a strong password" required>
                </div>

                <div class="form-group">
                    <label for="confirm-password">Confirm Password</label>
                    <input type="password" id="confirm-password" name="confirm-password" placeholder="Repeat your password" required>
                </div>

                <div class="checkbox-group">
                    <input type="checkbox" id="terms" name="terms" required>
                    <label for="terms">I agree to the <a href="#">Terms of Service</a> and <a href="#">Privacy Policy</a>.</label>
                </div>

                <button href="${pageContext.request.contextPath}/login" class="btn-primary">Create Account</button>
            </form>

            <a href="${pageContext.request.contextPath}/login" class="switch-auth-link">Already have an account? <span>Sign in</span></a>
        </div>
    </main>

</body>

</html>