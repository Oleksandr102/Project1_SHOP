package main.java.com.company.model.order;

import main.java.com.company.model.Users;
import main.java.com.company.model.product.Product;

import java.util.List;
import java.util.Map;

/*Як на мене, потрібно переписати логіку класу Order. Потрібно щоб він взаємодіяв з класом Product.
 В Order класі має бути:
 поле  мапа, яка зберігає Integer ідентифікатор замовлення і List замовлень користувача
 статичне поле ідентифікатор, який інкрементується при створенні замовлення.
 поле статус типу enum Status
   OrderService
 addOrder має добавляти продукти по ідентифікатору продукту в List
 deleteOrder має видаляти по ідентифікатору
 showOrder виводить в консоль все замовлення (мапу з ідентифікатором та списком замвлень)
 confirmOrder для цього методу потрібно створити enum такий, як Status enum, який має два об'єкти
 ACTIVE та BLOCKED . Метод отримує true або false і встановлює відповідний статус замовлення.
  Можливо, було б доречно добавити методи addOrderItem та deleteOrderItem для видалення/додавання окремих продуктів із
   замовлення, щоб при бажанні не робити все замовлення заново, якщо щось не так.*/
public class Order {
    private Integer idOrder;
    private Users user;
    private List<Product> product;
    private Status status;

    public Order(Integer idOrder, Users user, List<Product> product, Status status) {
        this.idOrder = idOrder;
        this.user = user;
        this.product = product;
        this.status = status;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", user=" + user +
                ", product=" + product +
                ", status=" + status +
                '}';
    }
}
