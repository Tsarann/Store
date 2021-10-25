package model.entity;

import model.builder.OrderBuilder;
import model.builder.ProductBuilder;

import java.util.Objects;

public class Order extends Model  {
    private long userId;
    private long productId;


    private Order(OrderBuilderImpl builder) {
        super(builder.id);
        this.userId = builder.userId;
        this.productId = builder.productId;
    }

    public static class OrderBuilderImpl implements OrderBuilder {

        private long id;
        private long userId;
        private long productId;

        @Override
        public OrderBuilder setId(long id) {
            this.id = id;
            return this;
        }

        @Override
        public OrderBuilder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        @Override
        public OrderBuilder setProductId(long productId) {
            this.productId = productId;
            return this;
        }

}

    public Order() {

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(userId, order.userId) && Objects.equals(productId, order.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, productId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
