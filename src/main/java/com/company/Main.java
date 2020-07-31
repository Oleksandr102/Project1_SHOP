package main.java.com.company;

import main.java.com.company.model.Users;
import main.java.com.company.model.order.ActiveOrders;
import main.java.com.company.model.product.Category;
import main.java.com.company.model.product.Product;
import main.java.com.company.model.product.ProductManager;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.printAllProduct();
        productManager.printByCategory(Category.MOBILE);
        productManager.printById(2);
        Users user = new Users("user1", "test", "test");
        Map<Integer, Product> product = productManager.getById(2);
        Map<Integer, Product> product2 = productManager.getById(4);
        ActiveOrders.addOrder(user, product);
        ActiveOrders.addOrder(user, product2);
        ActiveOrders.printByUser(user);
        ActiveOrders.printAllOrders();
    }
}
