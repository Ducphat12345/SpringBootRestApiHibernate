package com.poly.service.impl;

import com.poly.entity.Category;
import com.poly.repository.CategoryRepository;
import com.poly.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.getAllCategory();
    }

    @Override
    public Category findByID(int id) {
        return categoryRepository.findByID(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.saveCategory(category);
    }

    @Override
    public Category updateCategory(int id, Category category) {
        return categoryRepository.updateCategory(id, category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteCategory(id);
    }
}
