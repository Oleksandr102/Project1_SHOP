package com.company;

import com.company.model.order.OrderService;
import com.company.model.order.Status;
import com.company.model.product.Product;
import com.company.model.product.ProductManager;
import com.company.model.user.User;
import com.company.model.user.enums.Rights;
import com.company.view.AdminMenu;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
/*
        ProductManager productManager = new ProductManager();
        productManager.printAllProduct();
        //productManager.printByCategory(Category.MOBILE);
        //productManager.printById(2);
        User user = new User("user1", "test", Rights.USER);
        Map<Integer, Product> product = productManager.getById(2);
        Map<Integer, Product> product2 = productManager.getById(4);

        OrderService.addOrder(user, product.get(2));
        OrderService.addOrder(user, product2.get(4));

        OrderService.showOrdersByUser(user);
        OrderService.confirmOrder(user, Status.BLOCKED);

        System.out.println(OrderService.countSum(user));
*/

        AdminMenu adminMenu = new AdminMenu();
        adminMenu.runAdminMenu();
    }
}
