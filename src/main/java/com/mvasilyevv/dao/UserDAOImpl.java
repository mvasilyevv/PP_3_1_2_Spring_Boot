package com.mvasilyevv.dao;

import com.mvasilyevv.models.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final Session session;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
         session = entityManager.unwrap(Session.class);
    }

    @Override
    public List<User> findAll() {
        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User findById(long id) {
        return session.get(User.class, id);
    }

    @Override
    public void save(User user) {
        session.persist(user);
    }

    @Override
    public void update(User updatedUser, long id) {
        User newUser = session.get(User.class, id);
        newUser.setId(updatedUser.getId());
        newUser.setName(updatedUser.getName());
        newUser.setEmail(updatedUser.getEmail());
        newUser.setYearOfBirth(updatedUser.getYearOfBirth());
    }

    @Override
    public void delete(long id) {
        session.remove(session.get(User.class, id));
    }
}
