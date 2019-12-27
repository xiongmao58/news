package com.pyk.dao;

import com.pyk.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 彭义凯 on 2019/12/5.
 */
@Mapper
public interface CommentDao {

    public List<Comment> listCommentByNewsId(Long newses_id);

    public  int saveComment(Comment comment);

    public  Comment findOne(Long parentCommentId);
}
