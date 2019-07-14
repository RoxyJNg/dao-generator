package com.null01.model;

/**
 * Created by Roxy on 2019/7/13.
 */
public class TableColumn {

    private String colName;
    private String colType;
    private Integer colLength;
    /**
     * 小数点后长度
     */
    private Integer decimalPoint;
    private Boolean nullable;
    /**
     * 是否自增
     */
    private Boolean autoIncrement;
    /**
     * 字段注释
     */
    private String colComment;

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public Integer getColLength() {
        return colLength;
    }

    public void setColLength(Integer colLength) {
        this.colLength = colLength;
    }

    public Integer getDecimalPoint() {
        return decimalPoint;
    }

    public void setDecimalPoint(Integer decimalPoint) {
        this.decimalPoint = decimalPoint;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    public String getColComment() {
        return colComment;
    }

    public void setColComment(String colComment) {
        this.colComment = colComment;
    }

    public Boolean getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(Boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    @Override
    public String toString() {
        return "TableColumn{" +
                "colName='" + colName + '\'' +
                ", colType='" + colType + '\'' +
                ", colLength=" + colLength +
                ", decimalPoint=" + decimalPoint +
                ", nullable=" + nullable +
                ", autoIncrement=" + autoIncrement +
                ", colComment='" + colComment + '\'' +
                '}';
    }
}
