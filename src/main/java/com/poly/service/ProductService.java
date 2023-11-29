package com.poly.service;

import com.poly.dto.ProductDTO;
import com.poly.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    Product findByID(int id);

    Product findByName(String name);

    ProductDTO saveProduct(ProductDTO productDTO);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);
}
