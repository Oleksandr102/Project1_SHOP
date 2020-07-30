package main.java.com.company.view;

import main.java.com.company.model.product.Category;
import main.java.com.company.model.product.Product;
import main.java.com.company.model.product.ProductManager;
import main.java.com.company.model.user.User;

import static main.java.com.company.model.product.ProductManager.products;

import java.util.*;

public class AdminMenu {
    private static final String MENU_LINE = "-------------------------------";
    private final String[] adminMenuItems = {
            "1. BLOCK/UNBLOCK USER",
            "2. CONFIRM/UNCONFIRM USER ORDER (NOT ACTIVE)",
            "3. EDIT PRODUCTS",
            "4. LOGOUT (NOT ACTIVE)",
            "0. EXIT"
    };
    private final String[] subMenuUserBlockItems = {
            "1. BLOCK USER",
            "2. UNBLOCK USER",
            "3. BACK",
            "0. EXIT"
    };
    private final String[] subMenuProductItems = {
            "1. SHOW ALL PRODUCTS",
            "2. SHOW PRODUCTS BY CATEGORIES",
            "3. ADD PRODUCT",
            "4. DELETE PRODUCT (NOT ACTIVE)",
            "5. EDIT PRODUCT",
            "6. BACK",
            "0. EXIT"
    };

    public void showMenuItems(String[] menu) {
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
    }

    public int enterChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println(MENU_LINE);
        System.out.print("Enter a number, please: ");
        int choice = input.nextInt();
        System.out.println(MENU_LINE);
        return choice;
    }

    public void runAdminMenu() {
        System.out.println(MENU_LINE);
        System.out.println("\t\t\tADMIN MENU");
        System.out.println(MENU_LINE);
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
                System.out.println("\t\tUSER BLOCKING");
                System.out.print("Enter user login for blocking: ");   //Better would be if block user was by ID
                Scanner input = new Scanner(System.in);
                String login = input.nextLine();
                User user = new User();
                user.blockUser(login);
                System.out.println("User " + login + " was blocked\n" + MENU_LINE);

                // TODO: check if user is blocked/unblocked

                runSubMenuUserBlock();
            }
            case 2 -> {
                System.out.println("\t\tUSER UNBLOCKING");
                System.out.print("Enter user login for unblocking: ");
                Scanner input = new Scanner(System.in);
                String login = input.nextLine();
                User user = new User();
                user.unblockUser(login);
                System.out.println("User " + login + " was unblocked\n" + MENU_LINE);

                // TODO: check if user is unblocked

                runSubMenuUserBlock();
            }
            case 3 -> runAdminMenu();
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
                System.out.println("\t\t\tALL PRODUCTS");
                ProductManager.initProducts();
                if(products.isEmpty()) {
                    System.out.println("\nList of products is empty\n");
                }
                ProductManager.printALlProduct(); // method printAllProduct must return boolean
                Scanner pause = new Scanner(System.in);
                System.out.print("Press enter to continue");
                pause.nextLine();
                System.out.println(MENU_LINE);
                runSubMenuProduct();
            }
            case 2 -> {
                Scanner input = new Scanner(System.in);
                boolean iteration = true;
                while(iteration) {
                    System.out.println("\t\t\tALL CATEGORIES");
                    Arrays.stream(Category.values()).forEach(s -> System.out.println(s));
                    System.out.print("\nEnter a category from the list: ");
                    String categoryName = input.nextLine();
                    try {
                        Category category = Category.valueOf(categoryName);
                        ProductManager.printByCategory(category);
                    } catch (Exception e){
                        System.out.println("!!! Wrong category input, try one more time !!!");
                        System.out.println("Press enter to continue");
                        input.nextLine();
                        System.out.println(MENU_LINE);
                        continue;
                    }
                    iteration = false;
                    System.out.println("Press enter to continue" + MENU_LINE);
                    input.nextLine();
                    runSubMenuProduct();
                }
            }
            case 3 -> {
                Scanner input = new Scanner(System.in);
                String inputName = "";
                boolean nameIteration = true;
                boolean codeIteration = true;

                Nameloop:
                while(nameIteration) {
                    System.out.print("Name of product: ");
                    inputName = input.nextLine();
                    for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                        if(inputName.equals(entry.getValue().getName())){
                            System.out.println("Product with such name already exist");
                            continue Nameloop;
                        }
                    }
                    nameIteration = false;
                }

                Long inputCode = 0L;

                Codeloop:
                while(codeIteration) {
                    System.out.print("Code of product: ");
                    inputCode = input.nextLong();
                    for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                        if(inputCode.equals(entry.getValue().getProductСode())){
                            System.out.println("Product with such name already exist");
                            continue Codeloop;
                        }
                    }
                    codeIteration = false;
                }

                System.out.println("\t\t\tALL CATEGORIES");
                for(Category s: Category.values()) {
                    System.out.println(s);
                }
                System.out.print("\nCategory: ");
                Scanner scan = new Scanner(System.in);
                String categoryName = scan.nextLine();
                Category category = Category.valueOf(categoryName);

                System.out.print("Company: ");
                String producer = scan.nextLine();

                System.out.print("Price: ");
                Float price = (float)scan.nextDouble();

                ProductManager.addProduct(inputName, inputCode, category, producer, price);

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

                Category category = Category.valueOf(categoryName);

                System.out.print("New company: ");
                String producer = scan.nextLine();

                System.out.print("New price: ");
                Float price = (float)scan.nextDouble();

                ProductManager.editProduct(id, name, productCode, category, producer, price);
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
