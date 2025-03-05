package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.deo.UserDAO;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/login-proceed")
public class LoginProceedServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        User user = UserDAO.findById(id);

        if(user != null) {
            if (password.equals(user.getPassword())) {
                resp.sendRedirect(req.getContextPath() + "/index");
            }else{

            }
        }else{
            req.getRequestDispatcher("WEB-INF/views/login-fail.jsp").forward(req,resp);
        }
    }
}
