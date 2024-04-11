package com.scaledivya.ProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Category extends BaseModel{

//private String id;
private String title;

}
