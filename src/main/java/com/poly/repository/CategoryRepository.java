package com.poly.repository;

import com.poly.entity.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> getAllCategory();

    Category findByID(int id);

    Category findByName(String name);

    Category saveCategory(Category category);

    Category updateCategory(int id, Category category);

    void deleteCategory(int id);
}
