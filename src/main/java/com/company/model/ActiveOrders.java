package main.java.com.company.model;

import java.util.TreeMap;

public class ActiveOrders {
    private Map<Categories, String> ordersList = new TreeMap<>();
    private float price;

    public Map<Categories, String> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(Map<Categories, String> ordersList) {
        this.ordersList = ordersList;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void removeFromOrder(String activeOrder) {
        ordersList.remove(activeOrder);
    }

    public void addOrder(Categories categories, String activeOrder) {
        ordersList.put(categories, activeOrder);
    }
}
