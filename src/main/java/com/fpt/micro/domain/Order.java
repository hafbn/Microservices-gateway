package com.fpt.micro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A Order.
 */
@Table("jhi_order")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @NotNull(message = "must not be null")
    @Column("product")
    private String product;

    @NotNull(message = "must not be null")
    @Column("unit_price")
    private String unitPrice;

    @NotNull(message = "must not be null")
    @Min(value = 0)
    @Column("quantity")
    private Integer quantity;

    @NotNull(message = "must not be null")
    @Column("total")
    private String total;

    @Transient
    private Set<Product> order_products = new HashSet<>();

    @Transient
    private Set<Product> product_prices = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Order id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return this.product;
    }

    public Order product(String product) {
        this.setProduct(product);
        return this;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUnitPrice() {
        return this.unitPrice;
    }

    public Order unitPrice(String unitPrice) {
        this.setUnitPrice(unitPrice);
        return this;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Order quantity(Integer quantity) {
        this.setQuantity(quantity);
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTotal() {
        return this.total;
    }

    public Order total(String total) {
        this.setTotal(total);
        return this;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Set<Product> getOrder_products() {
        return this.order_products;
    }

    public void setOrder_products(Set<Product> products) {
        this.order_products = products;
    }

    public Order order_products(Set<Product> products) {
        this.setOrder_products(products);
        return this;
    }

    public Order addOrder_product(Product product) {
        this.order_products.add(product);
        return this;
    }

    public Order removeOrder_product(Product product) {
        this.order_products.remove(product);
        return this;
    }

    public Set<Product> getProduct_prices() {
        return this.product_prices;
    }

    public void setProduct_prices(Set<Product> products) {
        this.product_prices = products;
    }

    public Order product_prices(Set<Product> products) {
        this.setProduct_prices(products);
        return this;
    }

    public Order addProduct_price(Product product) {
        this.product_prices.add(product);
        return this;
    }

    public Order removeProduct_price(Product product) {
        this.product_prices.remove(product);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        return id != null && id.equals(((Order) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Order{" +
            "id=" + getId() +
            ", product='" + getProduct() + "'" +
            ", unitPrice='" + getUnitPrice() + "'" +
            ", quantity=" + getQuantity() +
            ", total='" + getTotal() + "'" +
            "}";
    }
}
