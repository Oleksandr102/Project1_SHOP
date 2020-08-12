package com.company.model.order;

import com.company.model.product.Product;

import java.util.List;

public class Order {
    private Integer idOrder;
    private String userLogin;
    private List<Product> product;
    private OrderStatus status;

    public Order(Integer idOrder, String userLogin, List<Product> product, OrderStatus status) {
        this.idOrder = idOrder;
        this.userLogin = userLogin;
        this.product = product;
        this.status = status;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "idOrder=" + idOrder +
                " userLogin='" + userLogin + '\'' +
                " product=" + product +
                ", status=" + status;
    }
}
