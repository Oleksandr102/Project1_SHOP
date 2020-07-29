package main.java.com.company.model.product;

public class Product {
    private String name;
    private Long productСode;
    private Category category;
    private String producer;
    private Double price;
    private Integer quantity;

    public Product(String name, Long productСode, Category category, String producer, Double price, Integer quantity) {
        this.name = name;
        this.productСode = productСode;
        this.category = category;
        this.producer = producer;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductСode() {
        return productСode;
    }

    public void setProductСode(Long productСode) {
        this.productСode = productСode;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return " name=" + name +
                " productСode=" + productСode +
                " category=" + category +
                " producer='" + producer +
                " price=" + price +
                " quantity=" + quantity;

    }
}
