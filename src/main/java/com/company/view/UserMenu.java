package main.java.com.company.view;

import main.java.com.company.model.product.ProductManager;
import main.java.com.company.service.CheckOut;
import main.java.com.company.service.UserOrder;
import main.java.com.company.model;
import main.java.com.company.service;

import java.util.Scanner;

public class UserMenu {
    Scanner scr = new Scanner(System.in);

    private String[] menu = {
            "1. Show available products.",
            "2. Search categories.",
            "3. Show my order.",
            "4. Check-out.",
            "5. Exit."};

    public void dropMenu() {
        while (true) {
            showMenu();
            System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
            System.out.print("Welcome to the shop! What do you need today?: ");
            String choice = scr.next();
            int check = switch (choice) {
                case "1" -> {
                    ProductManager.printALlProduct();
                    yield 1;
                }
                case "2" -> {
                    System.out.println("Please chose the product category: ");
                    System.out.println("1. MOBILE\n" +
                            "    2. TABLETS\n" +
                            "    3. LAPTOPS");
                    int dec = Integer.parseInt(scr.next());
                    if(dec==1){
                        //print products method where category equals to Mobile
                    }else if (dec==2) {
                        //print products method where category equals to Tablets
                    }else if (dec==3){
                        //print products method where category equals to Laptops
                    }

                    //ProductList.printProductsWith(Category);
                    yield 2;
                }
                case "3" -> {
                    ActiveOrders.showOrder(orderID);
                    yield 3;
                }
                case "4" -> {
                    CheckOut.totalOrderPrice(orderID);
                    System.out.println("Do you want to pay with: \n"+
                            "      1.Card\n"+
                            "      2.Cash");
                    int dec = Integer.parseInt(scr.next());
                    if (dec==1){
                        System.out.println("Thank you for transaction");
                    }else {
                        System.out.println("Sorry we don't currently accept cash, please use card");
                    }
                    yield 4;
                }
                case "5" -> {
                    exit();
                    yield 5;
                }
                default -> 1;
            };
        }
    }

    private void showMenu() {
        for (String item : menu) {
            System.out.println(item);
        }
    }

    private void exit() {
        System.exit(0);
    }
}
