package com.company.view.menu.submenu;

import com.company.model.order.OrderService;
import com.company.model.order.OrderStatus;
import com.company.view.Menu;
import com.company.view.menu.AdminMenu;

import static com.company.config.Scanner.readString;
import static com.company.model.order.OrderService.orders;

public class UserOrderMenu implements Menu {
    private final String[] subMenuUserOrderItems = {
            "\t\tUSER ORDER MENU",
            "1. Show all orders",
            "2. Show order by users",
            "3. Confirm/unconfirm order",
            "4. Back",
            "0. Exit"
    };
    public void showAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("List of orders is empty");
        }
        OrderService.showAllOrders();
        pauseMenu();
        this.dropMenu();
    }

    public void showOrderByUser() {
        System.out.println("Enter user login");
        String userLogin = readString();
        OrderService.showOrdersByUser(userLogin);
        pauseMenu();
        this.dropMenu();
    }

    public void showConfirmOrderMenu() {
        System.out.println("Choose user order");
        System.out.println("Enter user login");
        String userLogin = readString();
        OrderService.showOrdersByUser(userLogin);
        System.out.println("Choose status: ");
        System.out.println("1. Active\n2. Blocked");
        switch (enterChoice()) {
            case 1 -> OrderService.confirmOrder(userLogin, OrderStatus.ACTIVE);
            case 2 -> OrderService.confirmOrder(userLogin, OrderStatus.BLOCKED);
            default -> showWrongInputMassage();
        }
        OrderService.showOrdersByUser(userLogin);
        pauseMenu();
        this.dropMenu();
    }

    @Override
    public void dropMenu() {
        showMenuItems(subMenuUserOrderItems);
        switch (enterChoice()) {
            case 1 -> showAllOrders();
            case 2 -> showOrderByUser();
            case 3 -> showConfirmOrderMenu();
            case 4 -> new AdminMenu().dropMenu();
            case 0 -> exitMenu();
            default -> showWrongInputMassage();
        }
    }
}
