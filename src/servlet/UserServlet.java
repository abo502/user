package servlet;

import DBUtil.Db;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("gbk");
        List<User> lists = new ArrayList<>();
        String age = req.getParameter("age");
        try {
            if (age == null) {
                String sql = "select * from user";
                Statement statement = Db.createStatement();
                ResultSet resultSet;
                if (statement != null) {
                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                        User user = new User();
                        user.setId(resultSet.getInt("id"));
                        user.setName(resultSet.getString("name"));
                        user.setSex(resultSet.getString("sex"));
                        user.setAge(Integer.valueOf(resultSet.getString("age")));
                        lists.add(user);
                    }
                }
            } else {
                String sql = "select * from user where age > '" + age + "'";
                ResultSet resultSet;
                Statement statement = Db.createStatement();
                if (statement != null) {
                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                        User user = new User();
                        user.setId(resultSet.getInt("id"));
                        user.setName(resultSet.getString("name"));
                        user.setSex(resultSet.getString("sex"));
                        user.setAge(Integer.valueOf(resultSet.getString("age")));
                        lists.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        session.setAttribute("users", lists);
        resp.sendRedirect("/user.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
