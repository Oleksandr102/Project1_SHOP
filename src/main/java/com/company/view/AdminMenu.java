package main.java.com.company.view;

import main.java.com.company.model.product.Category;
import main.java.com.company.model.product.ProductManager;
import main.java.com.company.model.user.User;

import java.util.Scanner;

public class AdminMenu {
    private final String[] adminMenuItems = {
            "1. Block/unblock user",
            "2. Confirm/unconfirm user order (NOT ACTIVE)",
            "3. Edit products",
            "4. Logout (NOT ACTIVE)",
            "0. Exit"
    };
    private final String[] subMenuUserBlockItems = {
            "1. Block user",
            "2. Unblock user",
            "3. Back",
            "0. Exit"
    };
    private final String[] subMenuProductItems = {
            "1. Show all products (NOT ACTIVE)",
            "2. Show product characteristics (NOT ACTIVE)",
            "3. Add product",
            "4. Delete product (NOT ACTIVE)",
            "5. Edit product",
            "6. Back",
            "0. Exit"
    };

    public void showMenuItems(String[] menu) {
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }

    public int enterChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("Inpute a number: ");
        return input.nextInt();
    }

    public void runAdminMenuService() {
        runAdminMenu();
    }

    public void runAdminMenu() {
        System.out.println("\t\t\tADMIN MENU");
        showMenuItems(adminMenuItems);
        switch (enterChoice()) {
            case 1 -> runSubMenuUserBlock();
            case 2 -> System.out.println("Confirm/unconfirm user order");
            case 3 -> runSubMenuProduct();
            case 4 -> {
                // TODO: authorization method from Authorization class
            }
            case 0 -> System.exit(0);
            default -> {
                System.out.println("Wrong input, try one more time");
                runAdminMenu();
            }
        }
    }

    public void runSubMenuUserBlock() {
        showMenuItems(subMenuUserBlockItems);
        switch (enterChoice()) {
            case 1 -> {
                System.out.println("Enter user login for block");   //Better would be if block user was by ID
                Scanner input = new Scanner(System.in);
                String login = input.nextLine();
                User user = new User();
                user.blockUser(login);
                System.out.println("User " + login + " was blocked");

                    // TODO: check if user is blocked/unblocked

                runSubMenuUserBlock();
            }
            case 2 -> {
                System.out.println("Enter user login for unblock");
                Scanner input = new Scanner(System.in);
                String login = input.nextLine();
                User user = new User();
                user.unblockUser(login);
                System.out.println("User " + login + " was unblocked");

                // TODO: check if user is unblocked

                runSubMenuUserBlock();
            }
            case 3 -> runAdminMenuService();
            case 0 -> System.exit(0);
            default -> {
                System.out.println("Wrong input, try one more time");
                runSubMenuUserBlock();
            }
        }
    }

    public void runSubMenuProduct() {
        showMenuItems(subMenuProductItems);
        int choice = enterChoice();
        switch (choice) {
            case 1 -> {

                // TODO: show all products
                // TODO: need showAllProducts method from ProductManager class

                runSubMenuProduct();
            }
            case 2 -> {
/*
                 TODO: show product characteristics
                 TODO: need showProductCharacteristics method from ProductManager class
*/
                runSubMenuProduct();
            }
            case 3 -> {
                Scanner input = new Scanner(System.in);
                System.out.print("Name of product: ");
                String name = input.nextLine();
                if (true) {
/*
                     TODO: checking the Name for existence in other products
                     TODO: need searchProductBy method from ProductManager class
*/
                }
                System.out.print("Code: ");
                long productCode = input.nextInt();
                if (true) {
/*
                     TODO: checking the Code for existence in other products
                     TODO: need searchProductBy method from ProductManager class
*/
                }
                System.out.println("\t\t\tALL CATEGORIES");
                for(Category s: Category.values()) {
                    System.out.println(s);
                }
                System.out.print("\nCategory: ");
                Scanner scan = new Scanner(System.in);
                String categoryName = scan.nextLine();

                // TODO: checking for category existence

                Category category = Category.valueOf(categoryName);

                System.out.print("Company: ");
                String producer = scan.nextLine();

                System.out.print("Price: ");
                Double price = scan.nextDouble();

                System.out.print("Quantity: ");
                Integer quantity = scan.nextInt();

                ProductManager.addProduct(name, productCode, category, producer, price, quantity);

                // TODO: Check if the product has been added

                runSubMenuProduct();
            }
            case 4 -> {
/*
                 TODO: Delete product
                 TODO: need delete method from ProductManager class
*/
            }
            case 5 -> {
                Scanner input = new Scanner(System.in);
                System.out.print("Choose the product by ID: ");
                int id = input.nextInt();

                System.out.print("New name: ");
                String name = new Scanner(System.in).nextLine();
                if (true) {
/*
                     TODO: checking the Name for existence in other products
                     TODO: need searchProductBy method from ProductManager class
*/
                }
                System.out.print("New code: ");
                long productCode = input.nextInt();
                if (true) {
/*
                     TODO: checking the Code for existence in other products
                     TODO: need searchProductBy method from ProductManager class
*/
                }
                System.out.println("\t\t\tALL CATEGORIES");
                for(Category s: Category.values()) {
                    System.out.println(s);
                }
                System.out.print("\nNew category: ");
                Scanner scan = new Scanner(System.in);
                String categoryName = scan.nextLine();

                // TODO: checking for category existence

                Category category = Category.valueOf(categoryName);

                System.out.print("New company: ");
                String producer = scan.nextLine();

                System.out.print("New price: ");
                Double price = scan.nextDouble();

                System.out.print("New quantity: ");
                Integer quantity = scan.nextInt();

                ProductManager.editProduct(id, name, productCode, category, producer, price, quantity);

                // TODO: Check if the product has been added

                runSubMenuProduct();
            }
            case 6 -> runAdminMenu();
            case 0 -> System.exit(0);
            default -> {
                System.out.println("Wrong input, try one more time");
                runSubMenuProduct();
            }
        }
    }
}
