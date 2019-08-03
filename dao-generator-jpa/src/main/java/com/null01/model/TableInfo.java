package com.null01.model;

import java.util.List;

/**
 * 表信息实体
 * Created by Roxy on 2019/7/13.
 */
public class TableInfo {
    /**
     * 注解
     */
    private String annotation;
    private String tableName;
    private String tableDesc;
    private List<String> primaryKeysName;
    /**
     * 包含主键
     */
    private List<TableColumn> columnList;

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

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
                "annotation=" + annotation +
                ", tableName='" + tableName + '\'' +
                ", tableDesc='" + tableDesc + '\'' +
                ", primaryKeysName=" + primaryKeysName +
                ", columnList=" + columnList +
                '}';
    }
}
