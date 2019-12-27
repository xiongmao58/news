package com.pyk.service;

import com.pyk.model.Comment;

import java.util.List;

/**
 * Created by 彭义凯 on 2019/12/5.
 */
public interface CommentService {
    public  List<Comment> listCommentByNewsId(Long newses_id);

    public  int saveComment(Comment comment);
}
