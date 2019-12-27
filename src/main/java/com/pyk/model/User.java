package com.pyk.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 彭义凯 on 2019/11/30.
 */
public class User {
    private Long id;
    private String nickname;//昵称
    private String password;//密码
    private String email;//邮箱
    private String avatar;//头像
    private Integer type;//类型
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String username;
    public String phone;
    private String msg;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    private List<News> newses = new ArrayList<>();

    public List<News> getNewses() {
        return newses;
    }

    public void setNewses(List<News> newses) {
        this.newses = newses;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public User() {
    }

    public User(Long id, String nickname, String password, String email, String avatar, Integer type, Date createTime, Date updateTime) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.type = type;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User(Long id, String nickname, String password, String email, String avatar, Integer type, Date createTime, Date updateTime, String username, String msg, List<News> newses) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.type = type;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.username = username;
        this.msg = msg;
        this.newses = newses;
    }

    public User(String nickname, String password, String email, String avatar, Date createTime, String username) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.createTime = createTime;
        this.username = username;
    }

    public User(String nickname, String password, String email, String avatar, Date createTime, Date updateTime, String username, String phone) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.username = username;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname=" + nickname +
                ", password=" + password +
                ", email=" + email +
                ", avatar=" + avatar +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
