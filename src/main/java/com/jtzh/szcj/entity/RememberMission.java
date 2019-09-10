package com.jtzh.szcj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/*
    不忘初心牢记使命 内容实体类
    author：asher
    2019.9.9
 */
public class RememberMission implements Serializable {

    private int id;

    private String delflag;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createTime = new Date();

    private String title;

    private String pic;

    private String content;

    private String author;

    private String type;

    public RememberMission(int id, String delflag, Date createTime, String title, String pic, String content, String author, String type) {
        this.id = id;
        this.delflag = delflag;
        this.createTime = createTime;
        this.title = title;
        this.pic = pic;
        this.content = content;
        this.author = author;
        this.type = type;
    }

    private RememberMission() {};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
