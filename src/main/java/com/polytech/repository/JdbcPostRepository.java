package com.polytech.repository;

import com.polytech.business.Post;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KHOA on 13-Mar-17.
 */
public class JdbcPostRepository implements PostRepository{

    private final DataSource dataSource;  //constant -> forcer a creer un constructor

    public JdbcPostRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Post post) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST (CONTENT) VALUES (?)");
            preparedStatement.setString(1,post.getContent());
            preparedStatement.execute(); //!!
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Post> findAll() {
        List<Post> posts = new ArrayList<Post>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM POST");
            while(rs.next()){
                posts.add(new Post(rs.getString("CONTENT")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return posts;

    }
}
