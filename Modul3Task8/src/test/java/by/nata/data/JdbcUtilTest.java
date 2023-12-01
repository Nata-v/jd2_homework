package by.nata.data;

import by.nata.data.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtilTest extends JdbcUtil {
    private static JdbcUtilTest jdbcUtil;


    protected JdbcUtilTest() throws ClassNotFoundException {
        super();

    }

    @Override
    protected Connection getJdbcConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/People_test",
                "user",
                "user");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (jdbcUtil == null) {
            jdbcUtil = new JdbcUtilTest();
        }
        return jdbcUtil.getJdbcConnection();
    }

}
