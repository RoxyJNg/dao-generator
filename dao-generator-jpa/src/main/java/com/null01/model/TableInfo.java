package com.null01.model;

import javafx.scene.control.Tab;

import java.util.List;

/**
 * 表信息实体
 * Created by Roxy on 2019/7/13.
 */
public class TableInfo {
    private String tableName;
    private String tableDesc;
    private List<String> primaryKeysName;
    /**
     * 包含主键
     */
    private List<TableColumn> columnList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public List<String> getPrimaryKeysName() {
        return primaryKeysName;
    }

    public void setPrimaryKeysName(List<String> primaryKeysName) {
        this.primaryKeysName = primaryKeysName;
    }

    public List<TableColumn> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<TableColumn> columnList) {
        this.columnList = columnList;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "tableName='" + tableName + '\'' +
                ", tableDesc='" + tableDesc + '\'' +
                ", primaryKeysName=" + primaryKeysName +
                ", columnList=" + columnList +
                '}';
    }
}
