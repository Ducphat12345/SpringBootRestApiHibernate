package com.poly.controller;

import com.poly.dto.ResponseObject;
import com.poly.entity.Category;
import com.poly.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategory() {
        if (!categoryService.getAllCategory().isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(HttpStatus.OK,"Success!", categoryService.getAllCategory()));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject(HttpStatus.NO_CONTENT, "Fail!", null));
    }

    @GetMapping("/search-by-id/{id}")
    public ResponseEntity<Category> findByID(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(categoryService.findByID(id), HttpStatus.OK);
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<Category> findByName(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(categoryService.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/create-category")
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.OK);
    }

    @PutMapping("/update-category/{id}")
    public ResponseEntity<Category> update(@PathVariable(name = "id") int id, @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.updateCategory(id, category), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        categoryService.deleteCategory(id);
    }
}
