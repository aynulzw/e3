package com.lzw.community.model;

import org.apache.ibatis.annotations.Insert;

import java.io.Serializable;

/**
 * @author lzw
 * @create 2019/10/15/19:01
 */
public class User implements Serializable {

    private Insert id;
    private String name;
    private String token;
    private String accountId;
    private Long gmtCreate;
    private Long gmtModify;

    public Insert getId() {
        return id;
    }

    public void setId(Insert id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Long gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", accountId='" + accountId + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                '}';
    }
}
