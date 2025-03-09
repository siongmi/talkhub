package org.codenova.talkhub.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.deo.PostDAO;
import org.codenova.talkhub.model.vo.Post;

import java.io.IOException;

@WebServlet("/post/view")
public class PostView extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        PostDAO dao = new PostDAO();

        boolean r = dao.increaseViewsById(id);
        Post one = dao.findById(id);



        if(one == null) {
            resp.sendRedirect(req.getContextPath()+"/post/list");
        }else {
            req.setAttribute("post", one);
            req.getRequestDispatcher("/WEB-INF/views/post/view.jsp").forward(req, resp);
        }


    }
}
