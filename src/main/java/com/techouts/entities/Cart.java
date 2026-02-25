package com.techouts.entities;

import com.techouts.utils.logging.BaseHibernateLogger;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "carts")
public class Cart extends BaseHibernateLogger {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany(mappedBy = "cartId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItemList;

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

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
