package main.java.com.company;

import main.java.com.company.model.product.Category;
import main.java.com.company.model.product.ProductManager;

public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.printALlProduct();
        productManager.printByCategory(Category.MOBILE);
        productManager.printById(2);
        // write your code here
    }
}
