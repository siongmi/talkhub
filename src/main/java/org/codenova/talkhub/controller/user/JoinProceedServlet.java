package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.model.deo.UserDAO;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/join-proceed")
public class JoinProceedServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean hasError = false;
        String id = req.getParameter("id");
        if(id.length()<=4){
            hasError = true;
            req.setAttribute("idError", "아이디는 4글자 이상입니다");
        }
        String password = req.getParameter("password");
        if(password.length()<6){
            hasError = true;
            req.setAttribute("passwordError", "비밀번호는 4글자 이상입니다");
        }
        String nickname = req.getParameter("nickname");
        if(nickname == null || nickname.isEmpty()){
            hasError = true;
            req.setAttribute("nicknameError", "닉네임을 입력해주세요");
        }
        String gender = req.getParameter("gender");
        if(gender == null || gender.isEmpty()){
            hasError = true;
            req.setAttribute("genderError", "성별을 선택해주세요");
        }
        int birth = Integer.parseInt(req.getParameter("birth"));


        UserDAO userDao = new UserDAO();
        UserDAO userDAO = new UserDAO();
        User found = userDAO.findById(id);
        if(found != null){
            hasError = true;
            req.setAttribute("idError", "해당 아이디는 사용 중입니다.");
        }

        User ff = userDAO.findById(nickname);
        if(ff != null){
            hasError = true;
            req.setAttribute("nicknameError", "해당 닉네임은 사용 중입니다.");
        }
        if(hasError){
            req.getRequestDispatcher("WEB-INF/views/user/join-fail.jsp").forward(req, resp);
        }else {

            boolean result = UserDAO.create(
                    id, password, nickname, gender, birth);
            if (result) {
                resp.sendRedirect(req.getContextPath() + "/index");
            } else {
                req.getRequestDispatcher("WEB-INF/views/user/join-fail.jsp").forward(req, resp);
            }
        }
    }
}
