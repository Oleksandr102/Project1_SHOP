package com.company.model.product;

public class Product {
    private String name;
    private Long productCode;
    private Category category;
    private String producer;
    private Float price;

    public Product(String name, Long productCode, Category category, String producer, Float price) {
        this.name = name;
        this.productCode = productCode;
        this.category = category;
        this.producer = producer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductСode() {
        return productCode;
    }

    public void setProductСode(Long productСode) {
        this.productCode = productСode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String formName = String.format("Name = %-15s", name);
        String formCode = String.format("Code = %-10s", productCode);
        String formCategory = String.format("Category = %-20s", category);
        String formProducer = String.format("Producer = %-10s", producer);
        String formPrice = String.format("Price = %-5s", price);
        return formName +
                " | " + formCode +
                " | " + formCategory +
                " | " + formProducer +
                " | " + formPrice + "$";
    }
}

