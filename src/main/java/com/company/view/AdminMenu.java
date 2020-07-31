package main.java.com.company.view;

import main.java.com.company.model.product.Category;
import main.java.com.company.model.product.Product;
import main.java.com.company.model.product.ProductManager;
import main.java.com.company.model.user.User;

import static main.java.com.company.model.product.ProductManager.products;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AdminMenu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private User user = new User();
    private static final String PAUSE = "Press Enter to continue";
    private static final String MENU_LINE = "-------------------------------";
    private final String[] adminMenuItems = {
            "\t\t\tADMIN MENU",
            "1. BLOCK/UNBLOCK USER",
            "2. CONFIRM/UNCONFIRM USER ORDER (NOT ACTIVE)",
            "3. EDIT PRODUCTS",
            "4. LOGOUT (NOT ACTIVE)",
            "0. EXIT"
    };
    private final String[] subMenuUserBlockItems = {
            "\t\tBLOCK USER MENU",
            "1. BLOCK USER",
            "2. UNBLOCK USER",
            "3. BACK",
            "0. EXIT"
    };
    private final String[] subMenuProductItems = {
            "\t\t\tPRODUCT MENU",
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
//        Scanner input = new Scanner(System.in);
        System.out.println(MENU_LINE);
        System.out.print("Enter a number, please: ");
//        int choice = input.nextInt();
        int choice = Integer.parseInt(inputReader());
        System.out.println(MENU_LINE);
        return choice;
    }

    public String inputReader() {
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    public void pauseConsole() {
        System.out.println(PAUSE);
        inputReader();
    }

    public void runAdminMenu() {
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
//                Scanner input = new Scanner(System.in);
//                String login = input.nextLine();
                String login = inputReader();
                user.blockUser(login);
                System.out.println("User " + login + " was blocked\n" + MENU_LINE);
                pauseConsole();
                runSubMenuUserBlock();
            }
            case 2 -> {
                System.out.println("\t\tUSER UNBLOCKING");
                System.out.print("Enter user login for unblocking: ");
//                Scanner input = new Scanner(System.in);
//                String login = input.nextLine();
                String login = inputReader();
                user.unblockUser(login);
                System.out.println("User " + login + " was unblocked\n" + MENU_LINE);
                pauseConsole();
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
        switch (enterChoice()) {
            case 1 -> {
                System.out.println("\t\t\tALL PRODUCTS");
                if(products.isEmpty()) {
                    System.out.println("\nList of products is empty\n");
                }
                ProductManager.printALlProduct();
                System.out.print("Press enter to continue");
                pauseConsole();
                runSubMenuProduct();
            }
            case 2 -> {
//                Scanner input = new Scanner(System.in);
                boolean iteration = true;
                while(iteration) {
                    System.out.println("\t\t\tALL CATEGORIES");
                    Arrays.stream(Category.values()).forEach(System.out::println);
                    System.out.print("\nEnter a category from the list: ");
                    String categoryName = inputReader();
                    try {
                        Category category = Category.valueOf(categoryName);
                        ProductManager.printByCategory(category);
                    } catch (Exception e){
                        System.out.println("!!! Wrong category input, try one more time !!!");
                        System.out.println("Press enter to continue");
                        continue;
                    }
                    iteration = false;
                    pauseConsole();
                    runSubMenuProduct();
                }
            }
            case 3 -> {
//                Scanner input = new Scanner(System.in);
                String inputName = "";
                Long inputCode = 0L;
                boolean nameIteration = true;
                boolean codeIteration = true;

                Nameloop:
                while(nameIteration) {
                    System.out.print("Name of product: ");
                    inputName = inputReader();
                    for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                        if(inputName.equals(entry.getValue().getName())){
                            System.out.println("Product with such name already exist");
                            continue Nameloop;
                        }
                    }
                    nameIteration = false;
                }

                Codeloop:
                while(codeIteration) {
                    System.out.print("Code of product: ");
                    inputCode = Long.parseLong(inputReader());
                    for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                        if(inputCode.equals(entry.getValue().getProductСode())){
                            System.out.println("Product with such name already exist");
                            continue Codeloop;
                        }
                    }
                    codeIteration = false;
                }

                System.out.println("\t\t\tALL CATEGORIES");
                Arrays.stream(Category.values()).forEach(System.out::println);

                System.out.print("\nCategory: ");
//                Scanner scan = new Scanner(System.in);
//                String categoryName = scan.nextLine();
                String categoryName = inputReader();
                Category category = Category.valueOf(categoryName);

                System.out.print("Company: ");
//                String producer = scan.nextLine();
                String producer = inputReader();

                System.out.print("Price: ");
//                Float price = (float)scan.nextDouble();
                Float price = Float.parseFloat(inputReader());

                ProductManager.addProduct(inputName, inputCode, category, producer, price);
                runSubMenuProduct();
            }
            case 4 -> {
/*
                 TODO: Delete product
                 TODO: need delete method from ProductManager class
*/
            }
            case 5 -> {
//                Scanner input = new Scanner(System.in);
                System.out.print("Choose the product by ID: ");
//                int id = input.nextInt();
                int id = Integer.parseInt(inputReader());

                System.out.print("New name: ");
                String name = inputReader();

                System.out.print("New code: ");
//                long productCode = input.nextInt();
                long productCode = Long.parseLong(inputReader());

                System.out.println("\t\t\tALL CATEGORIES");
                Arrays.stream(Category.values()).forEach(System.out::println);
                System.out.print("\nNew category: ");
//                Scanner scan = new Scanner(System.in);
//                String categoryName = scan.nextLine();
                String categoryName = inputReader();
                Category category = Category.valueOf(categoryName);

                System.out.print("New company: ");
//                String producer = scan.nextLine();
                String producer = inputReader();

                System.out.print("New price: ");
//                Float price = (float)scan.nextDouble();
                Float price = Float.parseFloat(inputReader());
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
