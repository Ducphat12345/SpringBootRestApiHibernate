package com.poly.repository.impl;

import com.poly.entity.Category;
import com.poly.repository.BaseRepository;
import com.poly.repository.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl extends BaseRepository implements CategoryRepository {

    @Override
    public List<Category> getAllCategory() {
        Session session = getSession();
        try {
            session.getTransaction().begin();
            List<Category> result = session.createQuery("from Category").getResultList();
            session.getTransaction().commit();
            return result;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Category findByID(int id) {
        Session session = getSession();
        try {
            session.getTransaction().begin();
            Query<Category> query = session.createQuery("select c from Category c where c.id =:c_id");
            query.setParameter("c_id", id);
            Category category = query.getSingleResult();
            session.getTransaction().commit();
            return category;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Category findByName(String name) {
        Session session = getSession();
        try {
            session.getTransaction().begin();
            Query<Category> query = session.createQuery("select c from Category c where c.name =:c_name");
            query.setParameter("c_name", name);
            Category category = query.getSingleResult();
            session.getTransaction().commit();
            return category;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Category saveCategory(Category category) {
        Session session = getSession();
        try {
            session.getTransaction().begin();
            if (category != null){
                session.save(category);
            }
            session.getTransaction().commit();
            return category;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        Session session = getSession();
        try {
            session.getTransaction().begin();
            Category newCategory = findByID(id);
            if (newCategory != null){
                newCategory.setId(id);
                newCategory.setName(category.getName());
                session.update(newCategory);
            }
            session.getTransaction().commit();
            return newCategory;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void deleteCategory(int id) {
        Session session = getSession();
        try {
            session.getTransaction().begin();
            Category category = findByID(id);
            if (category != null){
                session.delete(category);
            }
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
    }
}