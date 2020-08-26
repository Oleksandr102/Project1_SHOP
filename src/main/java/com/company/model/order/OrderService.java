package com.company.model.order;

import com.company.model.product.Product;
import com.company.model.product.ProductManager;
import com.company.service.UserServiceImpl;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class OrderService {
    private static volatile ProductManager productManager;
    private static volatile UserServiceImpl userServiceImpl;
    public static volatile List<Order> orders = new ArrayList<>();
    private static volatile List<Product> resultList = new ArrayList<>();
    private static volatile Map<Integer, Product> resultMap = new HashMap<>();
    private static volatile Map<Integer, Product> resultConfirm = new HashMap<>();
    private static volatile List<Product> orderResult;
    private static volatile Integer idOrder = 0;
    private static volatile Float price = 0f;
    private static volatile OrderStatus status = OrderStatus.ACTIVE;
    private static volatile List<Product> lstOrder = new ArrayList<>();

    public static synchronized void addOrder(String userLogin, Integer idProduct) {
        if (orders.isEmpty()) {
            lstOrder.add(ProductManager.getProductById(idProduct));
            orders.add(new Order(idOrder++, userLogin, lstOrder, status));
        }
        if (orders != null && !orders.isEmpty()) {
            orders.forEach(order -> {
                if (order.getUserLogin().equals(userLogin)) {
                    order.getProduct().add(productManager.getProductById(idProduct));
                } else if (order.getUserLogin().equals(userLogin)) {
                    lstOrder.add(ProductManager.getProductById(idProduct));
                    orders.add(new Order(idOrder++, userLogin, lstOrder, status));
                }
            });
        }
    }

    public static synchronized void deleteOrder(String userLogin, Integer idOrder) {
        System.out.println("You deleted " + idOrder);
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUserLogin().equals(userLogin)) {
                orderResult = orders.get(i).getProduct();
            }
        }
        for (int i = 0; i < orderResult.size(); i++) {
            resultMap.put(i, orderResult.get(i));
        }
        resultMap.remove(idOrder);
        System.out.println(resultMap);
    }

    public synchronized static Map<Integer, Product> confirmOrder(String userLogin, OrderStatus status) {
        AtomicReference<Integer> count = new AtomicReference<>(0);
        orders.stream().filter(order -> order.getUserLogin().equals(userLogin))
                .forEach(test -> test.setStatus(status));
        orders.stream().filter(order -> order.getUserLogin().equals(userLogin))
                .forEach(order -> order.getProduct()
                        .forEach(product -> resultConfirm.put(count.getAndSet(count.get() + 1), product)));
        return resultConfirm;

    }

    public synchronized Float countSum(String userLogin) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUserLogin().equals(userLogin)) {
                resultList = orders.get(i).getProduct();
            }
        }
        for (int i = 0; i < resultList.size(); i++) {
            price += resultList.get(i).getPrice();
        }
        return price;
    }

    public static synchronized void showOrdersByUser(String userLogin) { ///add cone case
        System.out.println("You orders: " + userLogin);
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUserLogin().equals(userLogin)) {
                orderResult = orders.get(i).getProduct();
            }
        }
        for (int i = 0; i < orderResult.size(); i++) {
            System.out.println(i + " " + orderResult.get(i));
        }
    }

    public static void showAllOrders() {
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getUserLogin());
            for (int j = 0; j < orders.get(i).getProduct().size(); j++) {
                System.out.println(j + " " + orders.get(i).getProduct().get(j));
            }
        }
    }
}
