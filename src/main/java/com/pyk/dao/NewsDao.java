package com.pyk.dao;

import com.pyk.model.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by 彭义凯 on 2019/12/1.
 */
@Component
@Mapper
public interface NewsDao {

    public News getNewsById(Long id);

    public List<News> getNewsList(int pageCode,int pageSize );

    public List<News> getNewsType();


    public News getContent(Long id);

    public List<News> getNewsAll(int pageCode,int pageSize);

    public List<News> getNews(Map<String,Object> map);

    public int saveNews(News news);

    public int updateNews(News news);

    public int updateViews(Long id);

    public int deleteNews(Long id);

    public int findTotalCount();
}
