package com.jtzh.szcj.search;

import com.jtzh.szcj.common.page.Page;

import java.io.Serializable;

public class RememberMissionSearch implements Serializable {

    private String title;

    private String pic;

    private String content;

    private String author;

    private String type;

    private Page page;

    public RememberMissionSearch(String title, String pic, String content, String author, String type, Page page) {
        this.title = title;
        this.pic = pic;
        this.content = content;
        this.author = author;
        this.type = type;
        this.page = page;
    }

    public RememberMissionSearch(){}

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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
