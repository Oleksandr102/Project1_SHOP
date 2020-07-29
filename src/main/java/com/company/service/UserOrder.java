package main.java.com.company.service.interfaces;

enum Categories {
    PHONE, TV, LAPTOP
}

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
        return categories; //should be able toString
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public void addOrder(String activeOrder) {
        activeOrders.getOrderslist().put(categories, activeOrder);
    }

    @Override
    public void searchByCategory(String category) {

    }

    public void displayProducts() {
        System.out.println(activeOrders.getOrderslist());
    }

    public void searchByCategory(Categories categories) {
        activeOrders.getOrderslist().forEach((Categories, String) -> System.out.println(Categories + " " + String));
    }
}
