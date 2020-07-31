package main.java.com.company;

import main.java.com.company.model.product.Category;
import main.java.com.company.model.product.ProductManager;
import main.java.com.company.view.AdminMenu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ProductManager.printALlProduct();
        ProductManager.printByCategory(Category.MOBILE);
        AdminMenu adminMenuService = new AdminMenu();
        adminMenuService.runAdminMenu();
    }
}
