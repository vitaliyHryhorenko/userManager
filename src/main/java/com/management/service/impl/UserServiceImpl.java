package com.management.service.impl;

import com.management.dao.UserDao;
import com.management.model.User;
import com.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    } 

    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        userDao.deleteById(id);
    }


}
