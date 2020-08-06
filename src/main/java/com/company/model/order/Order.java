package com.company.model.order;

import com.company.model.Users;
import com.company.model.product.Product;

import java.util.List;

public class Order {
    private Integer idOrder;
    private Users user;
    private List<Product> product;
    private Status status;

    public Order(Integer idOrder, Users user, List<Product> product, Status status) {
        this.idOrder = idOrder;
        this.user = user;
        this.product = product;
        this.status = status;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", user=" + user +
                ", product=" + product +
                ", status=" + status +
                '}';
    }
}
