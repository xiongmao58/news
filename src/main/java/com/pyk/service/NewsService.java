package com.pyk.service;

import com.pyk.model.News;

import java.util.List;

/**
 * Created by 彭义凯 on 2019/12/1.
 */
public interface NewsService {

    public News getNewsById(Long id);

    public List<News> getNews(int pageCode, int pageSize,Long id,String title);

    public List<News> getNewsAll(int pageCode,int pageSize);

    public News getContent(Long id);

    public List<News> getNewsType();

    public List<News> getNewsList(int pageCode,int pageSize );

    public int saveNews(News news);

    public int updateNews(News news);

    public int deleteNews(Long id);

    public int findTotalCount();
}
