package com.example.crudApp.dto;

import com.example.crudApp.model.Category;
import com.example.crudApp.model.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CategoryWriteModel {
    @NotBlank
    private String name;

    public Category toCategory() {
        return new Category(name);
    }
}