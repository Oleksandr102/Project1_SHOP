package com.company.model.product;

public class ProductBuilder implements IBuilder {
    private String name;
    private Long productСode;
    private Category category;
    private String producer;
    private Float price;

    @Override
    public IBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IBuilder setProductCode(Long productCode) {
        this.productСode = productCode;
        return this;
    }

    @Override
    public IBuilder setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public IBuilder setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @Override
    public IBuilder setPrice(Float price) {
        this.price = price;
        return this;
    }

    @Override
    public Product build() {
        return new Product(name, productСode, category, producer, price);
    }
}
