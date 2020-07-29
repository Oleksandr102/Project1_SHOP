package main.java.com.company.model.product;

public interface IBuilder {
    IBuilder setName(String name);

    IBuilder setProductCode(Long productCode);

    IBuilder setCategory(Category category);

    IBuilder setProducer(String producer);

    IBuilder setPrice(Double price);

    IBuilder setQuality(Integer quantity);

    <T> T build();
}
