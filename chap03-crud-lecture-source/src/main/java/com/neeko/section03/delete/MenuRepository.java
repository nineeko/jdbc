package com.neeko.section03.delete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.neeko.common.JDBCTemplate.close;

public class MenuRepository {
    public int deleteMenu(Connection con, Menu menu) {
        PreparedStatement pstmt = null;
        Properties properties = new Properties();
        int result = 0;

        try {
            properties.loadFromXML(new FileInputStream(
                    "src/main/java/com/neeko/mapper/MenuMapper.xml"
            ));
            String sql = properties.getProperty("deleteMenu");
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, menu.getMenuCode());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            close(pstmt);
        }
        return result;
    }
}
