package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;

public class DBConnect {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Properties props = new Properties();

            // Load directly from file system (no classpath issues)
            FileInputStream input = new FileInputStream("src/db/db.properties");
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
