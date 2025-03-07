package org.codenova.talkhub.model.deo;

import org.codenova.talkhub.model.vo.Post;
import org.codenova.talkhub.model.vo.PostLike;
import org.codenova.talkhub.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostLikeDAO {

    public boolean create(PostLike one) {

        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://database-1.c1c0momec8jp.ap-northeast-2.rds.amazonaws.com:3306/talkhub", "admin", "1q2w3e4r");

            PreparedStatement ps = conn.prepareStatement("insert into posts values( null,?,?,now() )");
            ps.setString(1, one.getUserId());
            ps.setInt(2, one.getPostId());

            int r = ps.executeUpdate();
            result = true;

            conn.close();

        } catch (Exception e) {
            System.out.println("postDAO.post : " + e.toString());

        }
        return result;
    }

    public List<PostLike> findByUserId(String userId) {

        List<PostLike> postlike = new ArrayList<PostLike>();
        try {
            Connection conn = ConnectionFactory.open();

            PreparedStatement ps = conn.prepareStatement("select * from post_likes where user_id = ? order by created_at desc");
            ps.setString(1, userId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostLike one = new PostLike();

                one.setUserId(rs.getString("user_id"));
                one.setPostId(rs.getInt("post_id"));
                one.setCreatedAt(rs.getDate("created_at"));
                one.setId(rs.getInt("id"));

                postlike.add(one);
            }
           
        } catch (Exception e) {
            System.out.println("PostLikeDAO.findByUserId : " + e.toString());
        }
        return postlike;
    }
}
