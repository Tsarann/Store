package model.entity;

import model.builder.ProductBuilder;
import model.builder.UserBuilder;

import java.util.Objects;

public class Product extends Model {
    private long detailsId;
    private long price;
    private String name;
    private String category;
    private String color;
    private String size;


    private Product(ProductBuilderImpl builder) {
        super(builder.id);
        this.name = builder.name;
        this.category = builder.category;
        this.color = builder.color;
        this.size = builder.size;
        this.price = builder.price;
        this.detailsId = builder.detailsId;

    }

    public static class ProductBuilderImpl implements ProductBuilder {

        private long id;
        private String name;
        private String category;
        private String color;
        private String size;
        private long price;
        private long detailsId;

        @Override
        public ProductBuilder setId(long id) {
            this.id = id;
            return this;
        }

        @Override
        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public ProductBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        @Override
        public ProductBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        @Override
        public ProductBuilder setSize(String size) {
            this.size = size;
            return this;
        }

        @Override
        public ProductBuilder setPrice(long price) {
            this.price = price;
            return this;
        }

        @Override
        public ProductBuilder setDetailsId(long detailsId) {
            this.detailsId = detailsId;
            return this;
        }


        @Override
        public Product build() {
            return new Product(this);
        }
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(long detailsId) {
        this.detailsId = detailsId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category)
                && Objects.equals(color, product.color) && Objects.equals(size, product.size)
                && Objects.equals(price, product.price)
                && Objects.equals(detailsId, product.detailsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, detailsId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", detailsId='" + detailsId + '\'' +
                '}';
    }
}
