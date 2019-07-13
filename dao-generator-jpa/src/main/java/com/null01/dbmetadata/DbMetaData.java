package com.null01.dbmetadata;

import com.null01.model.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Roxy on 2019/7/13.
 */
@Component
public class DbMetaData {
    @Autowired
    private DbConnection connection;

    private DatabaseMetaData getMetaData() throws Exception{
        Connection conn = connection.getConn();
        return conn.getMetaData();
    }

    /**
     * 获取该库所有表的信息
     * @return
     */
    public List<TableInfo> getTableInfoList() throws Exception{
        DatabaseMetaData dbMetaData = getMetaData();
        ResultSet rs = dbMetaData.getTables(null, null, null, new String[] { "TABLE" });
        while (rs.next()) {
            System.err.println(rs.getString("TABLE_NAME"));
        }
        return null;
    }

}
