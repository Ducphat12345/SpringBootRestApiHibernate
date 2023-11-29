package com.poly.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseRepository {

    @Autowired
    SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
