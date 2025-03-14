package com.neeko.section01.insert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/* Repository 계층
 * DBMS를 통해 수행 되는 CRUD 작업 단위의 메소드를 정의 */
public class MenuRepository {
    public int insertMenu(Connection con, Menu menu) {
        PreparedStatement pstmt = null;
        Properties properties = new Properties();
        int result = 0;

        try {
            properties.loadFromXML(new FileInputStream(
                    "src/main/java/com/neeko/mapper/MenuMapper.xml"
            ));
            String sql = properties.getProperty("insertMenu");
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, menu.getMenuName());
            pstmt.setInt(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
