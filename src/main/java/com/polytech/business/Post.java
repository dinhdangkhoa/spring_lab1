package com.polytech.business;

/**
 * Created by KHOA on 13-Mar-17.
 */
public class Post {

    private String content;


    public Post(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {return content; }
}
