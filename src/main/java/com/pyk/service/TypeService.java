package com.pyk.service;

import com.pyk.model.Type;

import java.util.List;
import java.util.Map;

/**
 * Created by 彭义凯 on 2019/12/1.
 */
public interface TypeService {

    public  int saveType(Type type);

    public Type getType(Long id);

    public Type getTypeByName(String name);

    public List<Type> listPage(int pageCode, int pageSize);

    public int updateType(Type type);

    public int deleteType(Long id);

    public int findTotalCount();

    public List<Type> listType();
}
