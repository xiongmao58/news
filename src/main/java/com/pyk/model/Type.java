package com.pyk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 彭义凯 on 2019/11/30.
 */
public class Type {
    private Long id;
    private String name;//分类的名称
    private List<News> newses =new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type() {

    }
    public Type(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<News> getNewses() {
        return newses;
    }

    public void setNewses(List<News> newses) {
        this.newses = newses;
    }

    @Override
    public java.lang.String toString() {
        return "Type{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }


}
