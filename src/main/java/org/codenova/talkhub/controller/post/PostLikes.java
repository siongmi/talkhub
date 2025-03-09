package org.codenova.talkhub.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.deo.PostDAO;
import org.codenova.talkhub.model.deo.PostLikeDAO;
import org.codenova.talkhub.model.vo.Post;
import org.codenova.talkhub.model.vo.PostLike;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/likes")
public class PostLikes extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        PostLikeDAO postlikedao = new PostLikeDAO();

        User requester = (User)req.getSession().getAttribute("user");
        List<PostLike> likes = postlikedao.findByUserId(requester.getId());

        boolean alreadyLiked = false;
        for(PostLike like : likes){
            if(like.getPostId() == id){
                alreadyLiked = true;
            }
        }

        if(!alreadyLiked){
            PostDAO dao = new PostDAO();
            dao.likesById(id);

            PostLike log = PostLike.builder().postId(id).userId(requester.getId()).build();
            postlikedao.create(log);
        }
        PostDAO dao = new PostDAO();
        Post one = dao.findById(id);

        req.setAttribute("post", one);

       req.getRequestDispatcher("/WEB-INF/views/post/view.jsp").forward(req, resp);

        }
    }

