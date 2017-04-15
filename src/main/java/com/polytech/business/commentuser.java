package com.polytech.business;

/**
 * Created by KHOA on 13-Apr-17.
 */
public class commentuser {
    private String username;
    private String content;

    public commentuser() {}

    public commentuser(String username,String content){
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
