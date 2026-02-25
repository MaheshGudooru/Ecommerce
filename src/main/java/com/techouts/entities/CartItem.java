package com.techouts.entities;

import com.techouts.utils.logging.BaseHibernateLogger;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "cart_items")
public class CartItem extends BaseHibernateLogger {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cartId;

    @CreationTimestamp
    @Column(name = "added_date")
    private LocalDateTime addedToCartDate;

    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public LocalDateTime getAddedToCartDate() {
        return addedToCartDate;
    }

    public void setAddedToCartDate(LocalDateTime addedToCartDate) {
        this.addedToCartDate = addedToCartDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
}
