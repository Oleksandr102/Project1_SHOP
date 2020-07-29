package com.company.service;


public class UserOrder implements OrderFromUser {
    private String activeOrder;
    private Categories categories;

    private ActiveOrders activeOrders;

    public UserOrder(String activeOrder, Categories categories) {
        this.activeOrder = activeOrder;
        this.categories = categories;
    }

    public String getActiveOrder() {
        return activeOrder;
    }

    public void setActiveOrder(String activeOrder) {
        this.activeOrder = activeOrder;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public void addOrder(String activeOrder) {
        activeOrders.getOrdersList().put(categories, activeOrder);
    }

    public void displayProducts() {
        System.out.println(activeOrders.getOrdersList());
    }

    public void searchByCategory(Categories categories) {
        activeOrders.getOrdersList().forEach((Categories, String) -> System.out.println(Categories + " " + String));
    }
}
