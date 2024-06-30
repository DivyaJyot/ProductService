package com.scaledivya.ProductService.model;


import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Userdto {
    String name;
    String email;

    List<Role> roles;
    boolean isVerified;


}
