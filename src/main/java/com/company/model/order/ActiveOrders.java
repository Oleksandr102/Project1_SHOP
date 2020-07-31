package main.java.com.company.model.order;

import main.java.com.company.model.Users;
import main.java.com.company.model.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActiveOrders {
    private static List<Order> orders = new ArrayList<Order>();
    private static Integer idOrder = 0;

    public static void addOrder(Users users, Map<Integer, Product> product) {
        orders.add(new Order(idOrder++, users, product));
    }

    public static void printByUser(Users user) {
        orders.stream()
                .filter(usr -> usr.equals(user))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println(user);
    }
    public static void printAllOrders(){
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i));

        }
    }
}
