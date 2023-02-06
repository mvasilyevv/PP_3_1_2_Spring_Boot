package com.mvasilyevv.service;

import com.mvasilyevv.dao.UserDAO;
import com.mvasilyevv.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(long id) {
        return userDAO.findById(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void update(User updatedUser, long id) {
        userDAO.update(updatedUser, id);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }
}
