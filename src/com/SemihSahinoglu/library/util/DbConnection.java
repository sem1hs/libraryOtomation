package com.SemihSahinoglu.library.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbConnection {
    private static final String CONFIG_FILE = "config.properties";
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            props.load(input);
            url = props.getProperty("DB_URL");
            username = props.getProperty("DB_USERNAME");
            password = props.getProperty("DB_PASSWORD");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
