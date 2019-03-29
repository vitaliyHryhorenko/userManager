package com.management.service;

import com.management.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getAll();

    User getById(Integer id);

    void delete(Integer id);
}
