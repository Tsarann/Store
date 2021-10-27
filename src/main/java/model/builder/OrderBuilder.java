package model.builder;

import model.entity.Order;

public interface OrderBuilder {
    OrderBuilder setId(long id);

    OrderBuilder setUserId(long id);

    OrderBuilder setProductId(long id);

    Order build();
}
