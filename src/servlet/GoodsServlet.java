package servlet;

import DBUtil.Db;
import bean.Goods;

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

public class GoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("gbk");
        List<Goods> lists = new ArrayList<>();
        String price = req.getParameter("price");
        try {
            if (price == null) {
                String sql = "select * from goods";
                Statement statement = Db.createStatement();
                ResultSet resultSet;
                if (statement != null) {
                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                        Goods goods = new Goods();
                        goods.setId(resultSet.getInt("id"));
                        goods.setName(resultSet.getString("name"));
                        goods.setPrice(Integer.valueOf(resultSet.getString("price")));
                        lists.add(goods);
                    }
                }
            } else {
                String sql = "select * from goods where price > '" + price + "'";
                ResultSet resultSet;
                Statement statement = Db.createStatement();
                if (statement != null) {
                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                        Goods goods = new Goods();
                        goods.setId(resultSet.getInt("id"));
                        goods.setName(resultSet.getString("name"));
                        goods.setPrice(Integer.valueOf(resultSet.getString("price")));
                        lists.add(goods);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        session.setAttribute("goods", lists);
        resp.sendRedirect("/goods.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
