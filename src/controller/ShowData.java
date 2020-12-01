package controller;

import DBUtil.MysqlHelper;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("gbk");
        ArrayList<Student> lists = new ArrayList<>();

        String condition = req.getParameter("condition");
        System.out.println(condition);
        try {
            if (condition==null) {
                String sql = "select * from student";
                ResultSet resultSet = MysqlHelper.executeQuery(sql);
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setStudentNo(Integer.valueOf(resultSet.getString("student_no")));
                    student.setScope(Integer.valueOf(resultSet.getString("scope")));
                    lists.add(student);
                    System.out.println("**************"+lists);
                }
            } else {
                String sql = "select * from student where scope>?";
                ResultSet resultSet = MysqlHelper.executeQuery(sql, condition);
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setStudentNo(Integer.valueOf(resultSet.getString("student_no")));
                    student.setScope(Integer.valueOf(resultSet.getString("scope")));
                    lists.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        session.setAttribute("students", lists);
        resp.sendRedirect("/student.jsp");
//
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
