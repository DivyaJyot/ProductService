package com.scaledivya.ProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel {

//private long id;
    @ManyToOne
    private Category category;
    private String title;
    private  double price;
    private String description;
    private String image;
   // private int quantity;

}
