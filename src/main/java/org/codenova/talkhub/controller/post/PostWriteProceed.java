package org.codenova.talkhub.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.deo.PostDAO;
import org.codenova.talkhub.model.vo.Post;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/write-proceed")
public class PostWriteProceed extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String writerId = req.getParameter("writer_id");
        String category = req.getParameter("category");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        //=============================================================================================
        PostDAO postDAO = new PostDAO();

        boolean success = postDAO.post(writerId, category, title, content);

        //=========================================================================================
        if (success) {
            req.setAttribute("suceess", true);

        }
        req.getRequestDispatcher("/WEB-INF/views/post/post-write.jsp").forward(req, resp);
    }
}