package com.pyk.dao;

import com.pyk.model.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by 彭义凯 on 2019/12/1.
 */
@Component
@Mapper
public interface TypeDao {
    public int saveType(Type type);

    public Type getType(Long id);

    public Type getTypeByName(String name);

    public List<Type> listPage(int pageCode, int pageSize);

    public List<Type> listType();

    public int updateType(Type type);

    public int deleteType(Long id);

    public int findTotalCount();
}
