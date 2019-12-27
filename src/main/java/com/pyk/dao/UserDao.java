package com.pyk.dao;

import com.pyk.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by 彭义凯 on 2019/11/27.
 */
@Component
@Mapper
public interface UserDao {


    public User login(User user);

    public User getUserById(Long id);

    public User getUserByName(String username);

    public List<User> findUserAll();

    public List<User>  findUserAllByPage(int page,int pageSize);

    public int updatePwdById(Map<String,Object> map);

    public int findTotalCount();

    public int addUser(User user);

    public int editUser(User user);

    public int deleteUser(Long id);
}
