package com.poly.dto;

import com.poly.entity.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class ProductDTO {

    int id;
    String name;
    double price;
    int category_Id;

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.category_Id = product.getCategory().getId();
    }
}
