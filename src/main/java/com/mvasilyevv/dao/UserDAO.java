package com.mvasilyevv.dao;

import com.mvasilyevv.models.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(long id);
    void save(User user);
    void update(User updatedUser, long id);
    void delete(long id);
}
