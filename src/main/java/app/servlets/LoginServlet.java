package app.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();

        loginBean.setUserName(userName);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();

        String userValidate = null;
        try {
            userValidate = loginDao.authenticateUser(loginBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userValidate.equals("SUCCESS"))
        {
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            request.setAttribute("errMessage", userValidate);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
