package com.poly.service;

import com.poly.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    Category findByID(int id);

    Category findByName(String name);

    Category saveCategory(Category category);

    Category updateCategory(int id, Category category);

    void deleteCategory(int id);
}
