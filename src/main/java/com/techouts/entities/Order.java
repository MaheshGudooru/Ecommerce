package com.techouts.entities;

import com.techouts.utils.logging.BaseHibernateLogger;
import com.techouts.utils.enums.PaymentType;
import jakarta.persistence.*;
import com.techouts.utils.enums.DeliveryStatus;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order extends BaseHibernateLogger {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status")
    private DeliveryStatus deliveryStatus = DeliveryStatus.PROCESSING;

    @Column(name = "total_price")
    private float totalPrice;

    @Column(name = "delivery_date")
    private LocalDate estimatedDeliveryDate;

    @Column(name = "ordered_date")
    private LocalDate orderedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "delivery_address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "orderId")
    private List<OrderItem> orderItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public DeliveryStatus getStatus() {
        return deliveryStatus;
    }

    public void setStatus(DeliveryStatus status) {
        this.deliveryStatus = status;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public LocalDate getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(LocalDate orderedDate) {
        this.orderedDate = orderedDate;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
