package main.java.com.company.model.order;

<<<<<<< HEAD
import main.java.com.company.model.product.Product;

public class Order {
    private String productName;
    private float productPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = Product.getName();
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = Product.getPrice();
=======
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
>>>>>>> origin/Rachipa
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Order{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
=======
        return
                "idOrder=" + idOrder +
                " user=" + user +
                " product=" + product ;
>>>>>>> origin/Rachipa
    }
}
