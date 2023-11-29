package com.poly.service.impl;

import com.poly.dto.ProductDTO;
import com.poly.entity.Product;
import com.poly.repository.ProductRepository;
import com.poly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }


    @Override
    public Product findByID(int id) {
        return productRepository.findByID(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        return productRepository.saveProduct(productDTO);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return productRepository.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }
}
