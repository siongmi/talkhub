/*package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie")
public class LoginCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie(String, Object);
        resp.addCookie(Cookie);
        Cookie[] cookies = req.getCookies();

        for(; ; ){
            Cookie one = cookies[];
            String cookieName = one.getName();
            if(cookieName.equals("ticket")){

            }
        }


    }
}

 */
