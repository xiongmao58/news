package com.pyk.service;

import com.pyk.model.User;

import java.util.List;

/**
 * Created by 彭义凯 on 2019/11/27.
 */
public interface UserService {

    public User login(User user);

    public List<User> findUserAll();

    public List<User>  findUserAllByPage(int page,int pageSize);

    public int updatePwdById(String passward,Long id);

    public int findTotalCount();

    public int addUser(User user);

    public int editUser(User user);

    public int deleteUser(Long id);

    public User getUserById(Long id);

    public User getUserByName(String username);
}
