package com.pyk.service;

import com.pyk.dao.NewsDao;
import com.pyk.model.News;
import com.pyk.util.MarkdownUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 彭义凯 on 2019/12/1.
 */
@Service
public class NewsServiceImpl implements  NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public News getNewsById(Long id) {
        return newsDao.getNewsById(id);
    }

    @Override
    public List<News> getNews(int pageCode, int pageSize, Long id, String title) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pageCode",pageCode);
        map.put("pageSize",pageSize);
        map.put("id",id);
        map.put("title",title);
        return newsDao.getNews(map);
    }

    @Override
    public List<News> getNewsAll(int pageCode, int pageSize) {
        return newsDao.getNewsAll(pageCode,pageSize);
    }

    @Override
    public News getContent(Long id) {
        News news = newsDao.getContent(id);
        if( news == null){
            System.out.println("新闻不存在");
        }
        News n = new News();
        BeanUtils.copyProperties(news,n);
        String content = n.getContent();
        n.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        newsDao.updateViews(id);
        return newsDao.getContent(id);
    }

    @Override
    public List<News> getNewsType() {
        return newsDao.getNewsType();
    }

    @Override
    public List<News> getNewsList(int pageCode, int pageSize) {
        return newsDao.getNewsList(pageCode,pageSize);
    }


    @Override
    public int saveNews(News news) {
        if(news.getId() == null){
            news.setCreateTime(new Date());
            news.setUpdateTime(new Date());
            news.setContent(MarkdownUtils.markdownToHtmlExtensions(news.getContent()));
            news.setViews(0);
        }else {
            news.setUpdateTime(new Date());
        }

        return newsDao.saveNews(news);
    }

    @Override
    public int updateNews(News news) {
        news.setUpdateTime(new Date());
        return newsDao.updateNews(news);
    }

    @Override
    public int deleteNews(Long id) {
        return newsDao.deleteNews(id);
    }

    @Override
    public int findTotalCount() {
        return newsDao.findTotalCount();
    }
}
