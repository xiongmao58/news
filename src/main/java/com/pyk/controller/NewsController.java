package com.pyk.controller;

import com.pyk.model.News;
import com.pyk.model.PageBean;
import com.pyk.model.Type;
import com.pyk.model.User;
import com.pyk.service.NewsService;
import com.pyk.service.TypeService;
import com.pyk.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 彭义凯 on 2019/12/1.
 */
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private TypeService typeService;

    @RequestMapping("/getIndex")
    public String getIndex(Model model ,HttpServletRequest request){
        System.out.println("进入");
        List<News> n1 = newsService.getNewsType();
        int pageCode = Tool.getPageCode(request);
        int pageSize = 10;
        List<News> newses = newsService.getNewsList(pageCode-1,pageSize);
        PageBean<News> pages = new PageBean<>();
        pages.setBeanList(newses);
        pages.setPageCode(pageCode);
        pages.setPageSize(pageSize);
        int pageTotal = newsService.findTotalCount();
        pages.setTotalCount(pageTotal);
        model.addAttribute("page",pages);
        model.addAttribute("pages",n1);
        return "index";
    }



    @RequestMapping("/getBlags")
    public String getBlags(Model model,HttpServletRequest request){
        model.addAttribute("types",typeService.listType());
        int pageCode = Tool.getPageCode(request);
        int pageSize = 4;
        List<News> newses = newsService.getNewsAll(pageCode-1,pageSize);
        PageBean<News> pages = new PageBean<>();
        pages.setBeanList(newses);
        pages.setPageCode(pageCode);
        pages.setPageSize(pageSize);
        int pageTotal = newsService.findTotalCount();
        pages.setTotalCount(pageTotal);
        model.addAttribute("page",pages);
        return "blags";
    }

    @RequestMapping("/blags")
    public String News(News news,HttpServletRequest request, Model model){
        model.addAttribute("types",typeService.listType());
        int pageCode = Tool.getPageCode(request);
        int pageSize = 4;
        System.out.println(news);
        List<News> newses = newsService.getNews(pageCode-1,pageSize,news.getType().getId(),news.getTitle());
        PageBean<News> pages = new PageBean<>();
        pages.setBeanList(newses);
        pages.setPageCode(pageCode);
        pages.setPageSize(pageSize);
        int pageTotal = newsService.findTotalCount();
        pages.setTotalCount(pageTotal);
        model.addAttribute("page",pages);
        return "blags";
    }

    @RequestMapping("/getBlagsInput")
    public String getBlagsInput(Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("news",new News());
        return "blags-input";
    }

    @RequestMapping("/getBlagsInputs/{id}")
    public  String getEditNews(@PathVariable Long id, Model model){
        model.addAttribute("types",typeService.listType());
        News news = newsService.getNewsById(id);
        System.out.println(news);
        List<Type> types = typeService.listType();
        System.out.println(types);
        model.addAttribute("news",news);
        model.addAttribute("types",types);
        return "blags-input2";
    }




    @RequestMapping("/saveNewsInput")
    public String saveNewsInput(News news, Model model, RedirectAttributes attributes, HttpSession session){
        User user = (User) session.getAttribute("user");
        news.setUser_id(user.getId());
        Type type = typeService.getType(Long.valueOf(news.getName()));
        news.setType_id(typeService.getType(Long.valueOf(news.getName())).getId());
        int n = 0 ;
        if(news.getId() == null){
            n = newsService.saveNews(news);
        }else {
            n = newsService.updateNews(news);
        }
        if(n == 0){
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/getBlags";
    }


    @RequestMapping("/delNews/{id}")
    public String delNews(@PathVariable Long id,RedirectAttributes attributes){
        int delCount = newsService.deleteNews(id);
        if(delCount>0){
            attributes.addFlashAttribute("message","删除成功");
        }else {
            attributes.addFlashAttribute("message","删除成功");
        }
        return "redirect:/getBlags";
    }

    @RequestMapping("/getOneNews/{id}")
    public String getOneNews(@PathVariable Long id,Model model){
        model .addAttribute("news",newsService.getContent(id));
        return "blog";
    }

}
