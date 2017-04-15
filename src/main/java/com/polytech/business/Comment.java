package com.polytech.business;



import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by KHOA on 09-Apr-17.
 */
@Entity
@Table(name = "COMMENT")
@NamedQueries({
        @NamedQuery(name = "Comment.findByPostID", query = "select NEW com.polytech.business.commentuser(c.user.username,c.content) " +
                "from Comment c where c.post.id = :post"),
})
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "POST_ID",referencedColumnName = "ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name="USERNAME",referencedColumnName = "USERNAME")
    private User user;

    public Comment() {};

    public Comment(String content,Post post, User user){this.post = post;this.content = content;this.user = user;}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public Post getPost() {return post;}

    public void setPost(Post post) {this.post = post;}

}
