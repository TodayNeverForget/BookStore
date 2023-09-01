package com.yp.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {

        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader()
                    .getResourceAsStream("jdbc.properties");

            properties.load(resourceAsStream);

            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {


    }

    /*public static Connection getConnection() {

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }*/

    public static Connection getConnection() {

        Connection conn = conns.get();

        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return conn;
    }

    public static void commitAndClose() {
        Connection conn = conns.get();

        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        conns.remove();
    }

    public static void rollBackAndClose() {

        Connection conn = conns.get();

        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        conns.remove();
    }

    /*public static void close(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }*/


}















