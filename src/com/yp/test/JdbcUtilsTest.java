package com.yp.test;

import com.yp.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {


    @Test
    public void testJdbcUtils() {
        Connection conn = null;
        for (int i = 0; i < 100; i++) {
            System.out.println(conn = JdbcUtils.getConnection());
            JdbcUtils.close(conn);
        }

    }


}
