package DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlHelper {

    // 增,删,改
    public static int executeUpdate(String sql, Object... objects) {
        int len = 0;
        PreparedStatement preparedStatement = DbUtil.createPreparedStatement(sql);
        try {
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            len = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return len;
    }

    // 查询
    public static ResultSet executeQuery(String sql, Object... objects) {
        ResultSet rs = null;
        PreparedStatement preparedStatement = DbUtil.createPreparedStatement(sql);
        try {
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
