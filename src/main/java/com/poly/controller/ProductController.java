package com.poly.controller;

import com.poly.dto.ProductDTO;
import com.poly.entity.Product;
import com.poly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/search-by-id/{id}")
    public ResponseEntity<Product> findByID(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(productService.findByID(id), HttpStatus.OK);
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<Product> findByName(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(productService.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/create-product")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.saveProduct(productDTO), HttpStatus.OK);
    }

    @PutMapping("/update-product/{id}")
    public ResponseEntity<Product> update(@PathVariable(name = "id") int id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        productService.deleteProduct(id);
    }
}
