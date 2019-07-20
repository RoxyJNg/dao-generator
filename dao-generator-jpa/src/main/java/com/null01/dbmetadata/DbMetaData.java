package com.null01.dbmetadata;

import com.null01.model.DbProperties;
import com.null01.model.TableColumn;
import com.null01.model.TableInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roxy on 2019/7/13.
 */
@Component
public class DbMetaData {
    @Autowired
    private DbProperties properties;
    @Autowired
    private DbConnection connection;

    private static final Logger logger = LoggerFactory.getLogger(DbMetaData.class);

    /**
     * 获取该库所有表的信息
     * @return
     */
    public List<TableInfo> getTableInfoList() throws Exception{
        Connection conn = null;
        try{
            conn = connection.getConn();
            DatabaseMetaData dbMetaData = conn.getMetaData();
            String catalogName = properties.getUrl().split("/")[3];
            catalogName = catalogName.split("\\?")[0];
            //获取表名
            ResultSet rs = dbMetaData.getTables(catalogName, null, null, new String[] { "TABLE" });
            List<TableInfo> tableList = new ArrayList<>();
            while (rs.next()) {
                TableInfo table = new TableInfo();
                table.setTableName(rs.getString("TABLE_NAME"));
                table.setTableDesc(rs.getString("REMARKS"));
                tableList.add(table);
            }
            //通过表名获取字段等信息
            for(int i=0;i<tableList.size();i++){
                TableInfo table = tableList.get(i);
                rs = dbMetaData.getColumns(catalogName,null,table.getTableName(),null);
                List<TableColumn> columnList = new ArrayList<>();
                while (rs.next()){
                    TableColumn column = new TableColumn();
                    column.setColName(rs.getString("COLUMN_NAME"));
                    column.setColType(rs.getString("TYPE_NAME"));
                    column.setColLength(rs.getInt("COLUMN_SIZE"));
                    column.setDecimalPoint(rs.getInt("DECIMAL_DIGITS"));
                    column.setNullable(rs.getInt("NULLABLE")==1);
                    column.setAutoIncrement(rs.getString("IS_AUTOINCREMENT").equals("YES"));
                    column.setColComment(rs.getString("REMARKS"));
                    columnList.add(column);
                }
                table.setColumnList(columnList);
                tableList.set(i,table);
            }
            //获取主键
            for(int i=0;i<tableList.size();i++){
                TableInfo table = tableList.get(i);
                rs = dbMetaData.getPrimaryKeys(catalogName,null,table.getTableName());
                List<String> primaryKeysName = new ArrayList<>();
                while (rs.next()){
                    primaryKeysName.add(rs.getString("COLUMN_NAME"));
                }
                table.setPrimaryKeysName(primaryKeysName);
                tableList.set(i,table);
            }
            return tableList;
        }catch (Exception ex){
            logger.error(ex.getMessage(),ex);
            return new ArrayList<>();
        }
        finally {
            if(conn!=null){
                conn.close();
            }
        }
    }

}
