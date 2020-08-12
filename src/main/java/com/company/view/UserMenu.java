package com.company.view;


import com.company.authorization.view.AuthorizationMenu;
import com.company.authorization.view.impl.AuthorizationMenuImpl;
import com.company.model.order.OrderService;
import com.company.model.product.Category;
import com.company.model.product.Product;
import com.company.model.product.ProductManager;
import com.company.model.user.User;
import com.company.service.UserServiceImpl;

import java.util.Scanner;

import static com.company.view.AdminMenu.inputReader;

public class UserMenu {
    Scanner scr = new Scanner(System.in);
    User currentUser = new AuthorizationMenuImpl().login();
    private static final String PAUSE = "Press Enter to continue";

    private final String[] menu = {
            "1. Show available products.",
            "2. Search categories.",
            "3. Add items to order.",
            "4. Show my order.",
            "5. Check-out.",
            "6. Exit."};

    public void dropMenu() {
        System.out.println(currentUser);
        System.out.println("userMenu");
//        while (true) {
//            showMenu();
//            System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
//            System.out.print("Welcome to the shop! What do you need today?: ");
//            String choice = scr.next();
//            int check = switch (choice) {
//                case "1" -> {
////                    System.out.println(currentUser);
//                    ProductManager.printAllProduct();
//                    pauseConsole();
//                    yield 1;
//                }
//                case "2" -> {
//                    checkCategories();
//                    pauseConsole();
//                    yield 2;
//                }
//                case "3" -> {
//                    ProductManager.printAllProduct();
//                    System.out.println("Please enter product ID to add it to the order: "); //add to order
//                    Integer pIdValue = Integer.valueOf(scr.next());
////                    OrderService.addOrder(currentUser, pIdValue);
//                    pauseConsole();
//                    yield 3;
//                }
//                case "4" -> {
//                    OrderService.showOrdersByUser(currentUser);
//                    pauseConsole();
//                    yield 4;
//                }
//                case "5" -> {
//                    OrderService.countSum(currentUser);
//                    System.out.println("Do you want to pay with: \n" +
//                            "      1.Card\n" +
//                            "      2.Cash");
//                    int dec = Integer.parseInt(scr.next());
//                    if (dec == 1) {
//                        System.out.println("Thank you for transaction");
//                    } else {
//                        System.out.println("Sorry we don't currently accept cash, please use card");
//                    }
//                    pauseConsole();
//                    yield 5;
//                }
//                case "6" -> {
//                    exit();
//                    yield 6;
//                }
//                default -> 1;
//            };
//        }
//    }
//
//    protected void checkCategories() {
//        System.out.println("Please chose the product category: ");
//        System.out.println("1. Mobile\n" +
//                "    2. Tablets\n" +
//                "    3. Computer peripherals\n" +
//                "    4. Audio & Video\n" +
//                "    5. Television\n");
//        int dec = Integer.parseInt(scr.next());
//        if (dec == 1) {
//            ProductManager.printByCategory(Category.MOBILE); //print products method where category equals to Mobile
//        } else if (dec == 2) {
//            ProductManager.printByCategory(Category.TABLETS);//print products method where category equals to Tablets
//        } else if (dec == 3) {
//            ProductManager.printByCategory(Category.COMPUTER_PERIPHERAL);//print products method where category equals to Laptops
//        } else if (dec == 4) {
//            ProductManager.printByCategory(Category.AUDIO_VIDEO);//print products method where category equals to Laptops
//        } else if (dec == 5) {
//            ProductManager.printByCategory(Category.TELEVISION);//print products method where category equals to Laptops
//        }
//    }
//
//    private void showMenu() {
//        for (String item : menu) {
//            System.out.println(item);
//        }
//    }
//    public void pauseConsole() {
//        System.out.println(PAUSE);
//        inputReader();
    }

//    private void exit() {
//        System.exit(0);
//    }
}
