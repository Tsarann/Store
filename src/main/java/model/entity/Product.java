package model.entity;

import model.builder.ProductBuilder;
import model.builder.UserBuilder;

import java.util.Objects;

public class Product extends Model {
    private String name;
    private String category;
    public long detailsId;


    private Product(ProductBuilderImpl builder) {
        super(builder.id);
        this.name = builder.name;
        this.category = builder.category;
        this.detailsId = builder.detailsId;

    }

    public static class ProductBuilderImpl implements ProductBuilder {

        private long id;
        private String name;
        private String category;
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
                ", detailsId='" + detailsId + '\'' +
                '}';
    }
}
