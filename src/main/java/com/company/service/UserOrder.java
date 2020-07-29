package main.java.com.company.service;

import main.java.com.company.model.ActiveOrders;
import main.java.com.company.model.product.Category;
import main.java.com.company.service.interfaces.OrderFromUser;

public class UserOrder implements OrderFromUser {
    private String activeOrder;
    private Category category;

    private ActiveOrders activeOrders;


    public UserOrder(String activeOrder, Category category) {
        this.activeOrder = activeOrder;
        this.category = this.category;
    }

    public String getActiveOrder() {
        return activeOrder;
    }

    public void setActiveOrder(String activeOrder) {
        this.activeOrder = activeOrder;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategories(Category category) {
        this.category = category;
    }

    public void addOrder(String activeOrder) {
        activeOrders.getOrderslist().put(category, activeOrder);
    }

    @Override
    public void searchByCategory(String category) {

    }

    public void displayProducts() {
        System.out.println(activeOrders.getOrderslist());
    }

    public void searchByCategory(Category category) {
        activeOrders.getOrderslist().forEach((Category, String) -> System.out.println(Category + " " + String));
    }
}
