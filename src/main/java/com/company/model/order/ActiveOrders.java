package main.java.com.company.model.order;

import main.java.com.company.model.product.Product;

import java.util.HashMap;
import java.util.Map;

public class ActiveOrders {
    public Map<Integer, Order> orderList = new HashMap<Integer, Order>();
    int orderID=1;
//    private String productName = Product.getName();
//    private String productPrice = Product.getPrice();

    public void displayOrders(){
        orderList.toString();
    }

    public void showOrder(Integer orderID){
        orderList.toString(orderID);
    }
    public void createOrder(String productName, double productPrice){
        Order order = new Order();
        orderList.put(orderID++, order);
        order.setProductName(productName);
        order.setProductPrice(productPrice);

    }
}
