package com.company.view;

import com.company.model.product.Category;
import com.company.model.product.Product;
import com.company.model.product.ProductManager;
import com.company.service.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

import static com.company.model.product.ProductManager.deleteProduct;
import static com.company.model.product.ProductManager.products;

public class AdminMenu {
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private static final String PAUSE = "Press Enter to continue";
    private static final String MENU_LINE = "-------------------------------";
    private static final String WRONG_INPUT = "Wrong input, try one more time";
    private final String[] adminMenuItems = {
            "\t\t\tADMIN MENU",
            "1. BLOCK/UNBLOCK USER",
            "2. CONFIRM/UNCONFIRM USER ORDER (NOT ACTIVE)",
            "3. PRODUCT MENU",
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
            "4. DELETE PRODUCT",
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
        System.out.println(MENU_LINE);
        System.out.print("Enter a number, please: ");
        Integer choice = null;
        choice = Integer.parseInt(inputReader());
        if (choice == null) {
            System.out.println("Enter only numbers!");
            enterChoice();
        }
        System.out.println(MENU_LINE);
        return choice;
    }

    public static String inputReader() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(input);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bufferedReader != null) {
            try {
                input.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
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
                System.out.println(WRONG_INPUT);
                runAdminMenu();
            }
        }
    }

    public void blockUser() {
        System.out.println("\t\tUSER BLOCKING");
        System.out.print("Enter user ID for blocking: ");   //Better would be if block user was by ID
        int id = Integer.parseInt(inputReader());
        userServiceImpl.userBlock(id);
        System.out.println("User " + id + " was blocked\n" + MENU_LINE);
        pauseConsole();
        runSubMenuUserBlock();
    }

    public void unblockUser() {
        System.out.println("\t\tUSER BLOCKING");
        System.out.print("Enter user ID for blocking: ");   //Better would be if block user was by ID
        int id = Integer.parseInt(inputReader());
        userServiceImpl.userUnblock(id);
        System.out.println("User " + id + " was blocked\n" + MENU_LINE);
        pauseConsole();
        runSubMenuUserBlock();
    }

    public void showProducts() {
        System.out.println("\t\t\tALL PRODUCTS");
        if (products.isEmpty()) {
            System.out.println("\nList of products is empty\n");
        }
        ProductManager.printAllProduct();
        pauseConsole();
        runSubMenuProduct();
    }

    public void showProductsByCategory() {
        boolean iteration = true;
        while (iteration) {
            System.out.println("\t\t\tALL CATEGORIES");
            Arrays.stream(Category.values()).forEach(System.out::println);
            System.out.print("\nEnter a category from the list: ");
            String categoryName = inputReader();
            try {
                Category category = Category.valueOf(categoryName);
                ProductManager.printByCategory(category);
            } catch (Exception e) {
                System.out.println(WRONG_INPUT);
                System.out.println("Press enter to continue");
                continue;
            }
            iteration = false;
            pauseConsole();
            runSubMenuProduct();
        }
    }

    public void addProduct() {
        String inputName = "";
        Long inputCode = 0L;
        boolean nameIteration = true;
        boolean codeIteration = true;

        Nameloop:
        while (nameIteration) {
            System.out.print("Name of product: ");
            inputName = inputReader();
            for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                if (inputName.equals(entry.getValue().getName())) {
                    System.out.println("Product with such name already exist");
                    continue Nameloop;
                }
            }
            nameIteration = false;
        }

        Codeloop:
        while (codeIteration) {
            System.out.print("Code of product: ");
            inputCode = Long.parseLong(inputReader());
            for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                if (inputCode.equals(entry.getValue().getProductСode())) {
                    System.out.println("Product with such name already exist");
                    continue Codeloop;
                }
            }
            codeIteration = false;
        }

        System.out.println("\t\t\tALL CATEGORIES");
        Arrays.stream(Category.values()).forEach(System.out::println);

        System.out.print("\nCategory: ");
        String categoryName = inputReader();
        Category category = Category.valueOf(categoryName);

        System.out.print("Company: ");
        String producer = inputReader();

        System.out.print("Price: ");
        Float price = Float.parseFloat(inputReader());

        ProductManager.addProduct(inputName, inputCode, category, producer, price);
        runSubMenuProduct();
    }

    public void editProduct() {
        System.out.print("Choose the product by ID: ");
        Integer id = Integer.parseInt(inputReader());

        System.out.print("New name: ");
        String name = inputReader();

        System.out.print("New code: ");
        Long productCode = Long.parseLong(inputReader());

        System.out.println("\t\t\tALL CATEGORIES");
        Arrays.stream(Category.values()).forEach(System.out::println);

        System.out.print("\nNew category: ");
        String categoryName = inputReader();
        Category category = Category.valueOf(categoryName);

        System.out.print("New company: ");
        String producer = inputReader();

        System.out.print("New price: ");
        Float price = Float.parseFloat(inputReader());
        ProductManager.editProduct(id, name, productCode, category, producer, price);
        runSubMenuProduct();
    }

    public void deleteProductById() {
        System.out.print("Enter product ID for remove: ");
        int productId = Integer.parseInt(inputReader());
        deleteProduct(productId);
    }

    public void runSubMenuUserBlock() {
        showMenuItems(subMenuUserBlockItems);
        switch (enterChoice()) {
            case 1 -> blockUser();
            case 2 -> unblockUser();
            case 3 -> runAdminMenu();
            case 0 -> System.exit(0);
            default -> {
                System.out.println(WRONG_INPUT);
                runSubMenuUserBlock();
            }
        }
    }

    public void runSubMenuProduct() {
        showMenuItems(subMenuProductItems);
        switch (enterChoice()) {
            case 1 -> showProducts();
            case 2 -> showProductsByCategory();
            case 3 -> addProduct();
            case 4 -> deleteProductById();
            case 5 -> editProduct();
            case 6 -> runAdminMenu();
            case 0 -> System.exit(0);
            default -> {
                System.out.println(WRONG_INPUT);
                runSubMenuProduct();
            }
        }
    }
}
