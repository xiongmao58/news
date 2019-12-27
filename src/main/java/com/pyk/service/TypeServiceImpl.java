package com.pyk.service;

import com.pyk.dao.TypeDao;
import com.pyk.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 彭义凯 on 2019/12/1.
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Override
    public List<Type> listPage(int pageCode, int pageSize) {
        return typeDao.listPage(pageCode, pageSize);
    }


    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Override
    public int deleteType(Long id) {
        return typeDao.deleteType(id);
    }

    @Override
    public int findTotalCount() {
        return typeDao.findTotalCount();
    }

    @Override
    public List<Type> listType() {
        return typeDao.listType();
    }
}
