package com.pyk.controller;

import com.pyk.model.Comment;
import com.pyk.model.User;
import com.pyk.service.CommentService;
import com.pyk.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 彭义凯 on 2019/12/5.
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private NewsService newsService;

    @Value("${comment.avatar}")
    private String avatar;

    @RequestMapping("/comments/{newsId}")
    public String comments(@PathVariable Long newsId, Model model){
        System.out.println("展示的comment"+newsId);
        System.out.println(commentService.listCommentByNewsId(newsId));
        model.addAttribute("comments",commentService.listCommentByNewsId(newsId));
        return "blog :: commentList";
    }

    @RequestMapping("/comments")
    public String post(Comment comment , HttpSession session){
        System.out.println("存储的comment"+ comment);
        Long newsId = comment.getNews().getId();
        comment.setNews(newsService.getNewsById(newsId));
        User user = (User) session.getAttribute("user");
        if(user != null){
            comment.setAvatar(user.getAvatar());
        }else {
            comment.setAvatar(avatar);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/"+newsId;
    }

}
