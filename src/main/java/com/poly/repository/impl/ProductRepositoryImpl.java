package com.poly.repository.impl;

import com.poly.dto.ProductDTO;
import com.poly.entity.Product;
import com.poly.repository.BaseRepository;
import com.poly.repository.CategoryRepository;
import com.poly.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl extends BaseRepository implements ProductRepository {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProduct() {
        Session session = getSession();
        try {
            session.getTransaction().begin();
            Query<Product> query = session.createQuery("from Product");
            List<Product> result = query.getResultList();
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
    public Product findByID(int id) {
        Session session = getSession();
        try {
            session.getTransaction().begin();
            Query<Product> query = session.createQuery("select p from Product p where p.id =:p_id");
            query.setParameter("p_id", id);
            Product product = query.getSingleResult();
            session.getTransaction().commit();
            return product;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        Session session = getSession();
        try {
            session.getTransaction().begin();
            Query<Product> query = session.createQuery("select p from Product p where p.name =:p_name");
            query.setParameter("p_name", name);
            Product product = query.getSingleResult();
            session.getTransaction().commit();
            return product;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDto) {
        Session session = getSession();
        Product product = new Product();
        try {
            session.getTransaction().begin();
            product.setId(productDto.getId());
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setCategory(categoryRepository.findByID(productDto.getCategory_Id()));
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return new ProductDTO(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Session session = getSession();
        Product newProduct = null;
        try {
            session.getTransaction().begin();
            if (product != null){
                newProduct = findByID(id);
                newProduct.setId(id);
                newProduct.setName(product.getName());
                newProduct.setPrice(product.getPrice());
                newProduct.setCategory(categoryRepository.findByID(product.getCategory().getId()));
                session.update(newProduct);
            }
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return newProduct;
    }

    @Override
    public void deleteProduct(int id) {
        Session session = getSession();
        try {
            session.getTransaction().begin();
            Product product = findByID(id);
            if (product != null){
                session.delete(product);
            }
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
    }
}
