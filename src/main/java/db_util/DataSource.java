package db_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by aleksandrdolmatov on 21.01.17.
 */

    public class DataSource {
        private static String driverName = "com.mysql.jdbc.Driver";
        private static String url = "jdbc:mysql://localhost:3306/LuckySale";
        private static String user = "root";
        private static String password = "root";
    private static DataSource dataSource;
    //Прояснить!
    //Патерн синглтона выучить и понять!
    private DataSource() {
    }
    public static DataSource getInstance() {
        if (dataSource == null) {
            synchronized (DataSource.class) {
                if (dataSource == null) {
                    dataSource = new DataSource();
                }
            }
        }
        return dataSource;
    }

        public static Connection createConnection() {
            Connection conn = null;

            try {
                Class.forName(driverName);
                conn = DriverManager.getConnection(url, user, password);


            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return conn;

        }
    }

