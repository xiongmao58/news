package com.pyk.service;

import com.pyk.dao.UserDao;
import com.pyk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 彭义凯 on 2019/11/27.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> findUserAll() {
        return userDao.findUserAll();
    }

    @Override
    public List<User> findUserAllByPage(int page, int pageSize) {
        return userDao.findUserAllByPage(page,pageSize);
    }

    @Override
    public int updatePwdById(String passward,Long id) {
        Map<String,Object> map = new HashMap<>();
        map.put("password",passward);
        map.put("id",id);
        return userDao.updatePwdById(map);
    }

    @Override
    public int findTotalCount() {
        return userDao.findTotalCount();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int editUser(User user) {
        return userDao.editUser(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
