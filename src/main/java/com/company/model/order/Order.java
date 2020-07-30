package main.java.com.company.model.order;

import main.java.com.company.model.Users;
import main.java.com.company.model.product.Product;

import java.util.Map;

public class Order {
    private Integer idOrder;
    private Users user;
    private Map<Integer, Product> product;

    public Order(Integer idOrder, Users user, Map<Integer, Product> product) {
        this.idOrder = idOrder;
        this.user = user;
        this.product = product;
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

    public Product getProduct() {
        return (Product) product;
    }

    public void setProduct(Product product) {
        this.product = (Map<Integer, Product>) product;
    }

    @Override
    public String toString() {
        return
                "idOrder=" + idOrder +
                " user=" + user +
                " product=" + product ;
    }
}
