package com.techouts.entities;

import com.techouts.utils.logging.BaseHibernateLogger;
import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem extends BaseHibernateLogger {

    @Id
    @GeneratedValue
    private int id;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;

    private int quantity;

    @Column(name = "purchased_price")
    private float purchasedPrice;

    public OrderItem() {}

    public OrderItem(Product productId, Order orderId, int quantity, float purchasedPrice) {

        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.purchasedPrice = purchasedPrice;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(float purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }
}
