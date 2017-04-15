package com.polytech.business;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ENABLED")
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "user")
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "user")
    private List<Comment> posts = new ArrayList<Comment>();

    public User() {this.enabled=true;}

    public User(String username, String password){this.username = username; this.password = password; this.enabled = true;}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getEnabled() {return enabled;}

    public List<Comment> getComments() {return comments;}

    public void setUsername(String username) {this.username = username; }

    public void setPassword(String password) {this.password = password; }

    public void setEnabled(boolean enabled) {this.enabled = enabled; }

    public void setComments(List<Comment> comments) {this.comments = comments;}

    public List<Comment> getPosts() {return posts;}

    public void setPosts(List<Comment> posts) {this.posts = posts;}
}