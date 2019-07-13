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
    private String primaryKeyName;
    /**
     * 包含主键
     */
    private List<TableColumn> columnList;
    private String engine;
    private String charset;
    /**
     * 需要生成但不是表字段的属性
     */
    private List<TableColumn> transientList;

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

    public String getPrimaryKeyName() {
        return primaryKeyName;
    }

    public void setPrimaryKeyName(String primaryKeyName) {
        this.primaryKeyName = primaryKeyName;
    }

    public List<TableColumn> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<TableColumn> columnList) {
        this.columnList = columnList;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public List<TableColumn> getTransientList() {
        return transientList;
    }

    public void setTransientList(List<TableColumn> transientList) {
        this.transientList = transientList;
    }
}
