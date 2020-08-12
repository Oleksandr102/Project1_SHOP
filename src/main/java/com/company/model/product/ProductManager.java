package com.company.model.product;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductManager {

    public static Map<Integer, Product> products = new HashMap<Integer, com.company.model.product.Product>();
    static Integer productId = 0;
    static Product product;

    static {
        ProductManager.addProduct("VHS", 123456L, Category.AUDIO_VIDEO, "Sony", 120.0f);
        ProductManager.addProduct("Ipnone", 53264L, Category.MOBILE, "Apple", 499.99f);
        ProductManager.addProduct("TV", 325655L, Category.TELEVISION, "Samsung", 800.00f);
        ProductManager.addProduct("PS4", 6454351L, Category.COMPUTER_PERIPHERAL, "Sony", 450.0f);
        ProductManager.addProduct("XBOX", 542155313L, Category.COMPUTER_PERIPHERAL, "Microsoft", 500.0f);
        ProductManager.addProduct("S9+", 54864L, Category.MOBILE, "Samsung", 800.0f);
        ProductManager.addProduct("Mate Pad Pro", 3215668L, Category.TABLETS, "Huawei", 320.0f);
        ProductManager.addProduct("JBL Charje 4", 351545L, Category.AUDIO_VIDEO, "JBL", 50.0f);
        ProductManager.addProduct("Mi Smart Band 5 ", 165651L, Category.COMPUTER_PERIPHERAL, "Xiaomi", 30.0f);
    }

    public static void addProduct(String name, Long productCode, Category category,
                                  String producer, Float price) {
        products.put(productId++,
                product = new ProductBuilder()
                        .setName(name)
                        .setProductCode(productCode)
                        .setCategory(category)
                        .setProducer(producer)
                        .setPrice(price)
                        .build());

    }

    public static void editProduct(Integer productId, String name, Long productCode, Category category,
                                   String producer, Float price) {
        product = products.get(productId);
        product = new ProductBuilder()
                .setName(name)
                .setProductCode(productCode)
                .setCategory(category)
                .setProducer(producer)
                .setPrice(price)
                .build();

        products.put(productId, product);
    }

    public static Map<Integer, Product> getById(Integer idProduct) {
        Map<Integer, Product> result = products
                .entrySet().stream()
                .filter(map -> map.getKey().equals(idProduct))
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        return result;

    }

    public static Product getProductById(Integer idProduct) {
        return products.get(idProduct);
    }

    public static void printAllProduct() {
        products.forEach((a, b) -> System.out.println("Id " + a + " " + b));
    }

    public static void printByCategory(Category inputCategory) {
        Map<Integer, Product> result = products
                .entrySet().stream()
                .filter(map -> map.getValue().getCategory().equals(inputCategory))
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        result.forEach((a, b) -> System.out.println("Id " + a + " " + b));
    }

    public static void printById(Integer id) {
        Map<Integer, Product> result = products
                .entrySet().stream()
                .filter(map -> map.getKey().equals(id))
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        result.forEach((a, b) -> System.out.println("Id " + a + " " + b));
    }

    public static void deleteProduct(Integer productId) {
        products.remove(productId);
    }
}

