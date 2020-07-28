package main.java.com.makkkkkkkks.product;

import java.util.HashMap;
import java.util.Map;

public class ProductManager {

    static Map<Integer, Product> products = new HashMap<Integer, Product>();
    static Integer productId = 0;
    static Product product;
    static Integer quantity = 0;

    public static void addProduct(String name, Long productCode, Category category,
                                  String producer, Double price, Integer quantity) {
        products.put(productId++,
                product = new ProductBuilder()
                        .setName(name)
                        .setProductCode(productCode)
                        .setCategory(category)
                        .setProducer(producer)
                        .setPrice(price)
                        .setQuality(quantity)
                        .build());

    }

    public static void editProduct(Integer productId, String name, Long productCode, Category category,
                                   String producer, Double price, Integer quantity) {
        product = products.get(productId);

        product = new ProductBuilder()
                .setName(name)
                .setProductCode(productCode)
                .setCategory(category)
                .setProducer(producer)
                .setPrice(price)
                .setQuality(quantity)
                .build();
    }

    public static void quantityDown(Integer productId, Integer subtractQuantity) {
        product = products.get(productId);
        quantity = product.getQuantity();
        if ((quantity != 0)
                && (quantity != null)
                && (quantity > 0)
                && (quantity - subtractQuantity > 0)) {
            product.setQuantity(quantity - subtractQuantity);
        }
    }

    public static void printProduct() {
        products.forEach((a, b) -> System.out.println("Id " + a + " " + b));
    }
}

