package com.neeko.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {
    public static void main(String[] args) {
        Connection con= null;
        try {
            /* DB 연결 정보가 잘못 작성된 경우 Connection 객체 생성이 불가능하므로
            * SQLException이 발생할 수 있다. */
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306", "practice","practice"
            );
            System.out.println("con = "+con);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
