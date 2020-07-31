package main.java.com.company.view;

import main.java.com.company.model.order.ActiveOrders;
import main.java.com.company.model.product.Category;
import main.java.com.company.model.product.ProductManager;
import main.java.com.company.model.user.User;
import main.java.com.company.service.CheckOut;
import main.java.com.company.service.UserOrder;

import java.util.Scanner;

public class UserMenu {
    Scanner scr = new Scanner(System.in);
    String currentUser = User.getUserID();

    private String[] menu = {
            "1. Show available products.",
            "2. Search categories.",
            "3. Add items to order.",
            "4. Show my order.",
            "5. Check-out.",
            "6. Exit."};

    public void dropMenu() {
        while (true) {
            showMenu();
            System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
            System.out.print("Welcome to the shop! What do you need today?: ");
            String choice = scr.next();
            int check = switch (choice) {
                case "1" -> {
                    ProductManager.printAllProduct();
                    yield 1;
                }
                case "2" -> {
                    checkCategories();
                    yield 2;
                }
                case "3" -> {
                    //add to order
                }
                case "4" -> {
                    ActiveOrders.printByUser(currentUser);
                    yield 3;
                }
                case "5" -> {
                    CheckOut.totalOrderPrice(orderID);
                    System.out.println("Do you want to pay with: \n" +
                            "      1.Card\n" +
                            "      2.Cash");
                    int dec = Integer.parseInt(scr.next());
                    if (dec == 1) {
                        System.out.println("Thank you for transaction");
                    } else {
                        System.out.println("Sorry we don't currently accept cash, please use card");
                    }
                    yield 4;
                }
                case "6" -> {
                    exit();
                    yield 5;
                }
                default -> 1;
            };
        }
    }

    protected void checkCategories() {
        System.out.println("Please chose the product category: ");
        System.out.println("1. Mobile\n" +
                "    2. Tablets\n" +
                "    3. Computer peripherals\n" +
                "    4. Audio & Video\n" +
                "    5. Television\n");
        int dec = Integer.parseInt(scr.next());
        if (dec == 1) {
            ProductManager.printByCategory(Category.MOBILE); //print products method where category equals to Mobile
        } else if (dec == 2) {
            ProductManager.printByCategory(Category.TABLETS);//print products method where category equals to Tablets
        } else if (dec == 3) {
            ProductManager.printByCategory(Category.COMPUTER_PERIPHERAL);//print products method where category equals to Laptops
        } else if (dec == 4) {
            ProductManager.printByCategory(Category.AUDIO_VIDEO);//print products method where category equals to Laptops
        } else if (dec == 5) {
            ProductManager.printByCategory(Category.TELEVISION);//print products method where category equals to Laptops
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
