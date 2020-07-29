package main.java.com.company.model.product;

public interface IBuilder {
    IBuilder setName(String name);

    IBuilder setProductCode(Long productCode);

    IBuilder setCategory(Category category);

    IBuilder setProducer(String producer);

    IBuilder setPrice(Float price);

    <T> T build();
}
