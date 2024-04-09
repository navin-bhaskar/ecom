package com.ecom.models;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Category extends BaseModel {
    public Category(String cat) {
        title = cat;
    }
    public Category() {
        title = "Unknown Category";
    }
    private String title;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.REMOVE)
    List<Product> products;
}
