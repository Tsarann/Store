package model.builder;

import model.entity.Product;

public interface ProductBuilder {
    ProductBuilder setId(long id);

    ProductBuilder setName(String name);

    ProductBuilder setCategory(String category);

    ProductBuilder setColor(String color);

    ProductBuilder setSize(String size);

    ProductBuilder setPrice(long price);

    ProductBuilder setDetailsId(long detailsId);

    Product build();
}
