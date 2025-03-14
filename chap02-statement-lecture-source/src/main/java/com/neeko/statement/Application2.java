package com.neeko.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.neeko.common.JDBCTemplate.close;
import static com.neeko.common.JDBCTemplate.getConnection;

/* 사번을 Scanner로 입력 받아서 사원의 정보를 출력하는 프로그램
* 사원의 정보 : emp_id, emp_name, salary
* 없는 사번이면 "해당 사원의 조회 결과가 없습니다." 출력
* */
public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        try {
            /* Statement : 쿼리를 운반하고 그 결과를 반환하는 객체 */
            stmt = con.createStatement();
            /* ResultSet : Statement 객체를 통해 조회 처리된 결과를 다루는 객체 */
            rset = stmt.executeQuery("SELECT * FROM employee"); //select emp_id,emp_name, salary from employee where emp_id = "+empId
            Scanner sc = new Scanner(System.in);
            System.out.print("사번을 입력하세요: ");
            int input = sc.nextInt();
            boolean found = false;
            while(rset.next()) {
            if(rset.getInt("emp_id")==input) { // 결과 행의 존재 여부를 확인
                System.out.print(rset.getInt("emp_id")+" ");
                System.out.print(rset.getString("emp_name")+" ");
                System.out.println(rset.getInt("salary"));

                found = true;
                break;
                }
            }
            if (!found) {
                System.out.println("해당 사원의 조회 결과가 없습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }


    }
}
