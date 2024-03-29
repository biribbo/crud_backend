package com.example.crudApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.Set;

@Entity
@Table
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    Set<Product> products;
    private boolean isDeleted;

    void setId(int id) {
        this.id = id;
    }
    void setName(String name) {
        this.name = name;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        int id = product.getId();
        for (Product productFromSet : products) {
            if (productFromSet.getId() == id) {
                products.remove(productFromSet);
                product.removeCategory(this.id);
                break;
            }
        }
    }

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @PrePersist
    void PrePersist() {
        isDeleted = false;
    }

    public void delete() {
        this.isDeleted = true;
    }
    public void Update(Category source) {
        this.name = source.getName();
    }
}