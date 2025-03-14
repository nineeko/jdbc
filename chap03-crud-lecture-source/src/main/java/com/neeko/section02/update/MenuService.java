package com.neeko.section02.update;


import java.sql.Connection;

import static com.neeko.common.JDBCTemplate.*;
import static com.neeko.common.JDBCTemplate.close;

public class MenuService {
    public void registMenu(Menu menu) {
        Connection con = getConnection();
        MenuRepository menuRepository = new MenuRepository();
        int result = menuRepository.updateMenu(con, menu);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}
