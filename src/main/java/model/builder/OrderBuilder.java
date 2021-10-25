package model.builder;

public interface OrderBuilder {
    OrderBuilder setId(long id);

    OrderBuilder setUserId(long id);

    OrderBuilder setProductId(long id);
}
