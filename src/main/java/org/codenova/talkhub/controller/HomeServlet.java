package org.codenova.talkhub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/index")
public class  HomeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String sid = session.getId();
        boolean f = session.isNew();
        long ct = session.getCreationTime();

        System.out.println("session info ==============");
        System.out.println("sessionId" + sid);
        System.out.println("isNew" + f);
        System.out.println("createTime" + ct);

        if(Math.random()>0.5){
            req.setAttribute("authentication", true);
        }else{
            req.setAttribute("authentication", false);
        }
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}
