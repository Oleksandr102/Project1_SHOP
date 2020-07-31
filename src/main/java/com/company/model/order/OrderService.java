package main.java.com.company.model.order;

import main.java.com.company.model.Users;
import main.java.com.company.model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private static List<Order> orders = new ArrayList<Order>();
    private static List<Order> resultList = new ArrayList<Order>();
    private static Map<Integer, Product> resultMap = new HashMap<Integer, Product>();
    private static List<Product> orderResult;
    private static Integer idOrder = 0;
    private static Float price = 0f;
    private static Status status = Status.ACTIVE;

    public static void addOrder(Users users, Product product) {
        if (orders != null && !orders.isEmpty()) {
            orders.forEach(order -> {
                if (order.getUser().equals(users)) {
                    order.getProduct().add(product);
                } else {
                    List<Product> lstOrder = new ArrayList<Product>();
                    lstOrder.add(product);
                    orders.add(new Order(idOrder++, users, lstOrder, status));
                }
            });
        } else {
            List<Product> lstOrder = new ArrayList<Product>();
            lstOrder.add(product);
            orders.add(new Order(idOrder++, users, lstOrder, status));
        }
    }

    public static void deleteOrder(Users users, Integer idOrder) {
        System.out.println("You deleted " + idOrder);
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUser().equals(users)) {
                orderResult = orders.get(i).getProduct();
            }
        }
        for (int i = 0; i < orderResult.size(); i++) {
            resultMap.put(i, orderResult.get(i));
        }
        resultMap.remove(idOrder);
        System.out.println(resultMap);
    }

    public static Map<Integer, Product> confirmOrder(Users users) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUser().equals(users)) {
                orderResult = orders.get(i).getProduct();
            }
        }
        for (int i = 0; i < orderResult.size(); i++) {
            resultMap.put(i, orderResult.get(i));
        }
        return resultMap;
    }

    public static Float countSum(Users users) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUser().equals(users)) {
                price += orders.get(i).getProduct().get(i).getPrice();
                System.out.println(i);
            }
        }

        return price;
    }

    public static void showOrdersByUser(Users user) {
        System.out.println("Your orders: ");
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUser().equals(user)) {
                orderResult = orders.get(i).getProduct();
            }
        }
        for (int i = 0; i < orderResult.size(); i++) {
            System.out.println(i + " " + orderResult.get(i));
        }
    }

    public static void showAllOrders() {
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getUser() + "\n" +
                    orders.get(i).getProduct() + "\n");
        }
    }
}
