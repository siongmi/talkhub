package org.codenova.talkhub.model.deo;

import org.codenova.talkhub.model.vo.Post;
import org.codenova.talkhub.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    public static boolean post(String writerId, String category, String title, String content){


        boolean result = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://database-1.c1c0momec8jp.ap-northeast-2.rds.amazonaws.com:3306/talkhub", "admin", "1q2w3e4r");

            PreparedStatement ps = conn.prepareStatement("insert into posts values( null,?, ?, ?, ?,0,0,now(),now() )");

            ps.setString(1, writerId);
            ps.setString(2, category);
            ps.setString(3, title);
            ps.setString(4, content);

            int r = ps.executeUpdate();
            result = true;

            conn.close();
        } catch (Exception e) {
            System.out.println("postDAO.post : " + e.toString());
        }
        return result;
    }
    public Post findById(int postId) {
        Post one = null;
        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from posts where id = ?");
            ps.setInt(1, postId);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                one = new Post();
                one.setId(rs.getInt("id"));
                one.setWriterId(rs.getString("writer_id"));
                one.setCategory(rs.getString("category"));
                one.setTitle(rs.getString("title"));
                one.setContent(rs.getString("content"));
                one.setLikes(rs.getInt("likes"));
                one.setViews(rs.getInt("views"));
                one.setWritedAt(rs.getDate("writed_at"));
                one.setModifiedAt(rs.getDate("modified_at"));
            }
            conn.close();
        }catch(Exception e) {
            System.out.println("UserDAO.post : "+ e.toString() );
        }
        return one;
    }
    public boolean increaseViewsById(int postId) {
        boolean result = false;

        /* try with resources statement */
        try(Connection conn = ConnectionFactory.open()) {
            PreparedStatement ps = conn.prepareStatement("update posts set views = views + 1 where id = ?");
            ps.setInt(1, postId);

            int r = ps.executeUpdate();
            if(r > 0) {
                result = true;
            }
        }catch(Exception e) {
            System.out.println("PostDAO.post : "+ e.toString() );
        }
        return result;
    }
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<Post>();
        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from posts order by id desc");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post one = new Post();

                one.setId(rs.getInt("id"));
                one.setWriterId(rs.getString("writer_id"));
                one.setCategory(rs.getString("category"));
                one.setTitle(rs.getString("title"));
                one.setContent(rs.getString("content"));
                one.setLikes(rs.getInt("likes"));
                one.setViews(rs.getInt("views"));
                one.setWritedAt(rs.getDate("writed_at"));
                one.setModifiedAt(rs.getDate("modified_at"));

                posts.add(one);
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("UserDAO.post : " + e.toString());
        }
        return posts;
    }
    public boolean likesById(int postId){
        boolean result = false;

        try(Connection conn = ConnectionFactory.open()) {
            PreparedStatement ps = conn.prepareStatement("update posts set likes = likes + 1 where id = ?");
            ps.setInt(1, postId);

            int r = ps.executeUpdate();
            if(r > 0) {
                result = true;
            }
        }catch(Exception e) {
            System.out.println("PostDAO.post : "+ e.toString() );
        }
        return result;
    }
}
