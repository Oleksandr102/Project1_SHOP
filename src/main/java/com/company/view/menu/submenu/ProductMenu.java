package com.company.view.menu.submenu;

import com.company.model.product.Category;
import com.company.model.product.Product;
import com.company.model.product.ProductManager;
import com.company.view.menu.AdminMenu;
import com.company.view.Menu;

import java.util.Arrays;
import java.util.Map;

import static com.company.config.Scanner.readString;
import static com.company.model.product.ProductManager.products;

public class ProductMenu implements Menu {
    private final String[] subMenuProductItems = {
            "\t\t\tPRODUCT MENU",
            "1. Show all products",
            "2. Show products by categories",
            "3. Add product",
            "4. Delete product",
            "5. Edit product",
            "6. Back",
            "0. Exit"
    };

    public void showProducts() {
        System.out.println("\t\t\tALL PRODUCTS");
        if (products.isEmpty()) {
            System.out.println("\nList of products is empty\n");
        }
        ProductManager.printAllProduct();
        pauseMenu();
        this.dropMenu();
    }

    public void showProductsByCategory() {
        System.out.println("\t\t\tALL CATEGORIES");
        Arrays.stream(Category.values()).forEach(System.out::println);
        System.out.print("\nEnter a category from the list: ");
        String categoryName = readString();
        try {
            Category category = Category.valueOf(categoryName);
            ProductManager.printByCategory(category);
        } catch (Exception e) {
            System.out.println("Wrong input!");
            showProductsByCategory();
        }
        pauseMenu();
        this.dropMenu();
    }

    public void addProduct() {
        String inputName = "";
        Long inputCode = 0L;
        boolean nameIteration = true;
        boolean codeIteration = true;

        Nameloop:
        while (nameIteration) {
            System.out.print("Name of product: ");
            inputName = readString();
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
            inputCode = Long.parseLong(readString());
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
        String categoryName = readString();
        Category category = Category.valueOf(categoryName);

        System.out.print("Company: ");
        String producer = readString();

        System.out.print("Price: ");
        Float price = Float.parseFloat(readString());

        ProductManager.addProduct(inputName, inputCode, category, producer, price);
        this.dropMenu();
    }

    public void editProduct() {
        System.out.print("Choose the product by ID: ");
        Integer id = Integer.parseInt(readString());

        System.out.print("New name: ");
        String name = readString();

        System.out.print("New code: ");
        Long productCode = Long.parseLong(readString());

        System.out.println("\t\t\tALL CATEGORIES");
        Arrays.stream(Category.values()).forEach(System.out::println);

        System.out.print("\nNew category: ");
        String categoryName = readString();
        Category category = Category.valueOf(categoryName);

        System.out.print("New company: ");
        String producer = readString();

        System.out.print("New price: ");
        Float price = Float.parseFloat(readString());
        ProductManager.editProduct(id, name, productCode, category, producer, price);
        this.dropMenu();
    }

    public void deleteProductById() {
        System.out.print("Enter product ID for remove: ");
        int productId = Integer.parseInt(readString());
        ProductManager.deleteProduct(productId);
    }

    @Override
    public void dropMenu() {
        showMenuItems(subMenuProductItems);
        switch (enterChoice()) {
            case 1 -> showProducts();
            case 2 -> showProductsByCategory();
            case 3 -> addProduct();
            case 4 -> deleteProductById();
            case 5 -> editProduct();
            case 6 -> new AdminMenu().dropMenu();
            case 0 -> exitMenu();
            default -> showWrongInputMassage();
        }
    }
}
