<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Products - Lumina Store</title>
    <style>
        /* =========================================
           1. RESET & THEME VARIABLES
           ========================================= */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
        }

        :root {
            --color-bg: #ffffff;
            --color-text: #111111;
            --color-text-light: #666666;
            --color-border: #eaeaec;
            --color-accent: #111111;
            --font-main: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
        }

        body {
            background-color: #fafafa;
            color: var(--color-text);
            line-height: 1.6;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        /* =========================================
           2. HEADER
           ========================================= */
        .site-header {
            border-bottom: 1px solid var(--color-border);
            padding: 20px 0;
            position: sticky;
            top: 0;
            background: var(--color-bg);
            z-index: 100;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.02);
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 1.5rem;
            font-weight: 700;
            letter-spacing: -1px;
            text-decoration: none;
            color: var(--color-text);
            transition: opacity 0.3s ease;
        }

        .logo:hover {
            opacity: 0.7;
        }

        .user-nav {
            display: flex;
            gap: 40px;
        }

        .user-nav a {
            font-size: 0.9rem;
            font-weight: 600;
            text-decoration: none;
            color: var(--color-text);
            transition: opacity 0.3s ease;
        }

        .user-nav a:hover {
            opacity: 0.6;
        }

        /* =========================================
           3. PAGE HEADER & FILTERS
           ========================================= */
        .page-header {
            background-color: var(--color-bg);
            padding: 4rem 5% 2rem;
            text-align: center;
        }

        .page-header h1 {
            font-size: clamp(2rem, 5vw, 3.5rem);
            font-weight: 800;
            letter-spacing: -1.5px;
            text-transform: uppercase;
            margin-bottom: 1rem;
        }

        .page-header p {
            color: var(--color-text-light);
            max-width: 600px;
            margin: 0 auto 2.5rem;
        }

        .category-filters {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 1rem;
            max-width: 800px;
            margin: 0 auto;
        }

        .filter-btn {
            padding: 8px 20px;
            border: 1px solid var(--color-border);
            border-radius: 30px;
            background: transparent;
            font-family: var(--font-main);
            font-size: 0.9rem;
            font-weight: 600;
            color: var(--color-text-light);
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .filter-btn:hover {
            border-color: var(--color-text);
            color: var(--color-text);
        }

        .filter-btn.active {
            background-color: var(--color-text);
            color: var(--color-bg);
            border-color: var(--color-text);
        }

        .toolbar {
            max-width: 1400px;
            margin: 0 auto;
            padding: 1.5rem 5%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 0.9rem;
            color: var(--color-text-light);
            border-bottom: 1px solid var(--color-border);
            background-color: var(--color-bg);
        }

        .sort-dropdown {
            padding: 8px 12px;
            border: 1px solid var(--color-border);
            background-color: transparent;
            font-family: var(--font-main);
            color: var(--color-text);
            border-radius: 4px;
            outline: none;
            cursor: pointer;
        }

        /* =========================================
           4. PRODUCT GRID
           ========================================= */
        .products-container {
            padding: 4rem 5% 5rem;
            flex-grow: 1;
            background-color: #fafafa;
        }

        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 2rem;
            max-width: 1400px;
            margin: 0 auto;
        }

        .product-card {
            background-color: var(--color-bg);
            border-radius: 8px;
            overflow: hidden;
            transition: transform 0.3s, box-shadow 0.3s;
            border: 1px solid #f0f0f0;
            display: flex;
            flex-direction: column;
        }

        .product-card:hover {
            transform: translateY(-8px);
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.08);
        }

        .product-card .image-wrapper {
            position: relative;
            overflow: hidden;
        }

        .product-card img {
            width: 100%;
            height: 300px;
            object-fit: cover;
            transition: transform 0.3s ease;
        }

        .product-card:hover img {
            transform: scale(1.05);
        }

        .product-info {
            padding: 1.5rem;
            display: flex;
            flex-direction: column;
            flex-grow: 1;
        }

        .product-info .category {
            font-size: 0.75rem;
            text-transform: uppercase;
            color: #777777;
            letter-spacing: 1.5px;
            font-weight: 600;
            margin-bottom: 0.5rem;
        }

        .product-info h3 {
            font-size: 1.1rem;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: var(--color-text);
        }

        .product-info .price {
            font-size: 1.25rem;
            font-weight: 700;
            color: var(--color-text);
            margin-bottom: 1.5rem;
        }

        .btn-secondary {
            width: 100%;
            padding: 0.75rem;
            background-color: transparent;
            border: 1px solid #111111;
            color: #111111;
            cursor: pointer;
            font-weight: 600;
            border-radius: 4px;
            transition: all 0.3s;
            margin-top: auto;
            font-family: var(--font-main);
            text-transform: uppercase;
            font-size: 0.85rem;
            letter-spacing: 0.5px;
        }

        .btn-secondary:hover {
            background-color: #111111;
            color: #ffffff;
        }

        /* =========================================
           5. FOOTER
           ========================================= */
        footer {
            background-color: #111111;
            color: #ffffff;
            padding: 3rem 5%;
        }

        .footer-bottom {
            text-align: center;
            color: #999999;
            font-size: 0.9rem;
            border-top: 1px solid #333333;
            padding-top: 2rem;
        }

        /* =========================================
           6. RESPONSIVE DESIGN
           ========================================= */
        @media (max-width: 768px) {
            .toolbar {
                flex-direction: column;
                gap: 1rem;
                align-items: flex-start;
            }

            .product-grid {
                grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                gap: 1.5rem;
            }

            .user-nav {
                display: none;
            }

            .category-filters {
                gap: 0.5rem;
            }

            .filter-btn {
                padding: 6px 12px;
                font-size: 0.8rem;
            }
        }
    </style>
</head>

<body>

    <header class="site-header">
        <div class="container">
            <a href="homepage.html" class="logo">LUMINA</a>
            <nav class="user-nav">
                <a href="login.html">Account</a>
                <a href="products.html">Shop</a>
                <a href="cart.html">Cart (2)</a>
            </nav>
        </div>
    </header>

    <section class="page-header">
        <h1>All Products</h1>
        <p>Discover our complete collection of minimalist essentials, meticulously crafted for your everyday life.</p>

        <div class="category-filters">
            <button class="filter-btn active">All</button>
            <button class="filter-btn">Electronics</button>
            <button class="filter-btn">Footwear</button>
            <button class="filter-btn">Apparel</button>
            <button class="filter-btn">Home</button>
        </div>
    </section>

    <div class="toolbar">
        <span class="item-count">Showing 8 products</span>
        <div class="sort-options">
            <label for="sort">Sort by: </label>
            <select id="sort" class="sort-dropdown">
                <option value="featured">Featured</option>
                <option value="price-low">Price: Low to High</option>
                <option value="price-high">Price: High to Low</option>
                <option value="newest">Newest Arrivals</option>
            </select>
        </div>
    </div>

    <main class="products-container">
        <div class="product-grid">

            <div class="product-card">
                <div class="image-wrapper">
                    <img src="https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=500&q=80"
                        alt="Minimalist Laptop">
                </div>
                <div class="product-info">
                    <span class="category">Electronics</span>
                    <h3>Lumina Pro Laptop</h3>
                    <span class="price">$1,299.00</span>
                    <button class="btn-secondary">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="image-wrapper">
                    <img src="https://images.unsplash.com/photo-1549298916-b41d501d3772?w=500&q=80" alt="Sneakers">
                </div>
                <div class="product-info">
                    <span class="category">Footwear</span>
                    <h3>Classic White Sneakers</h3>
                    <span class="price">$120.00</span>
                    <button class="btn-secondary">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="image-wrapper">
                    <img src="https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=500&q=80"
                        alt="Cotton T-Shirt">
                </div>
                <div class="product-info">
                    <span class="category">Apparel</span>
                    <h3>Heavyweight Cotton Tee</h3>
                    <span class="price">$45.00</span>
                    <button class="btn-secondary">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="image-wrapper">
                    <img src="https://images.unsplash.com/photo-1507473885765-e6ed057f782c?w=500&q=80"
                        alt="Ceramic Mug">
                </div>
                <div class="product-info">
                    <span class="category">Home</span>
                    <h3>Matte Ceramic Mug Set</h3>
                    <span class="price">$38.00</span>
                    <button class="btn-secondary">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="image-wrapper">
                    <img src="https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&q=80"
                        alt="Wireless Headphones">
                </div>
                <div class="product-info">
                    <span class="category">Electronics</span>
                    <h3>Acoustic Wireless Over-Ear</h3>
                    <span class="price">$249.00</span>
                    <button class="btn-secondary">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="image-wrapper">
                    <img src="https://images.unsplash.com/photo-1551028719-00167b16eac5?w=500&q=80"
                        alt="Leather Jacket">
                </div>
                <div class="product-info">
                    <span class="category">Apparel</span>
                    <h3>Vegan Leather Jacket</h3>
                    <span class="price">$195.00</span>
                    <button class="btn-secondary">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="image-wrapper">
                    <img src="https://images.unsplash.com/photo-1505693314120-0d443867891c?w=500&q=80" alt="Desk Lamp">
                </div>
                <div class="product-info">
                    <span class="category">Home</span>
                    <h3>Architect Desk Lamp</h3>
                    <span class="price">$85.00</span>
                    <button class="btn-secondary">Add to Cart</button>
                </div>
            </div>

            <div class="product-card">
                <div class="image-wrapper">
                    <img src="https://images.unsplash.com/photo-1608231387042-66d1773070a5?w=500&q=80"
                        alt="Chelsea Boots">
                </div>
                <div class="product-info">
                    <span class="category">Footwear</span>
                    <h3>Suede Chelsea Boots</h3>
                    <span class="price">$165.00</span>
                    <button class="btn-secondary">Add to Cart</button>
                </div>
            </div>

        </div>
    </main>

    <footer>
        <div class="footer-bottom">
            <p>&copy; 2026 Lumina Store. All rights reserved.</p>
        </div>
    </footer>

</body>

</html>