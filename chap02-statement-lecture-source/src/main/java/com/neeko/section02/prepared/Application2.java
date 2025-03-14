package com.neeko.section02.prepared;

import java.sql.*;
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
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하고 싶은 사번 : ");
        int empId = sc.nextInt();

        try {
            /* PreparedStatement는 placeholder(?)를 활용한 하나의 문자열 형태로 쿼리를 작성한다. */
            pstmt = con.prepareStatement(
                    "select emp_id, emp_name, salary " +
                            "from employee" +
                            " where emp_id=? and ent_yn=?"
            );
            /* 쿼리 실행 전 placeholder의 내용을 인덱스 번호를 통해 설정한다. */
            pstmt.setInt(1, empId);
            pstmt.setString(2, "N");


           rset = pstmt.executeQuery();
            if (rset.next()) {
                String empName = rset.getString("emp_name");
                int salary = rset.getInt("salary");
                System.out.println(empId + " " + empName + " " + salary);
            } else {
                System.out.println("해당 사원의 조회 결과가 없습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }


    }
}



