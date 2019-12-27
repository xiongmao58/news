package com.pyk.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 彭义凯 on 2019/11/30.
 */
public class Comment {
    private  Long id;
    private  String nickname;//昵称
    private  String email;//电子邮箱
    private  String content;//评论内容
    private  String avatar;//头像
    private Date createTime;//创建时间
    private News news;
    private Long newses_id;
    private Long parent_comment_id;
    private List<Comment> replyComments = new ArrayList<>();//子评论

    private  boolean adminComment;
    private Comment parentComment;//父评论

    public Long getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Long parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    public Long getNewses_id() {
        return newses_id;
    }

    public void setNewses_id(Long newses_id) {
        this.newses_id = newses_id;
    }

    public boolean isAdminComment() {
        return adminComment;
    }

    public void setAdminComment(boolean adminComment) {
        this.adminComment = adminComment;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", news=" + news +
                ", newses_id=" + newses_id +
                ", parent_comment_id=" + parent_comment_id +
                ", replyComments=" + replyComments +
                ", adminComment=" + adminComment +
                ", parentComment=" + parentComment +
                '}';
    }

    public Comment(Long id, String nickname, String email, String content, String avatar, Date createTime, News news, Long newses_id, Long parent_comment_id, List<Comment> replyComments, boolean adminComment, Comment parentComment) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.content = content;
        this.avatar = avatar;
        this.createTime = createTime;
        this.news = news;
        this.newses_id = newses_id;
        this.parent_comment_id = parent_comment_id;
        this.replyComments = replyComments;
        this.adminComment = adminComment;
        this.parentComment = parentComment;
    }

    public Comment() {

    }

    public Comment(String nickname, String email, String content, String avatar, Date createTime, Long newses_id, Long parent_comment_id) {
        this.nickname = nickname;
        this.email = email;
        this.content = content;
        this.avatar = avatar;
        this.createTime = createTime;
        this.newses_id = newses_id;
        this.parent_comment_id = parent_comment_id;
    }
}
