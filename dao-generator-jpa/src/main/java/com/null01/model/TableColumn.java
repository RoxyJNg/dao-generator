package com.null01.model;

import java.util.List;

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

    /**
     * 转换为entity之后的属性类型
     */
    private String attrType;
    /**
     * 转换为entity之后的属性名称；
     */
    private String attrName;
    /**
     * 转换为entity之后的属性注解
     */
    private String annotation;

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

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
                ", attrType='" + attrType + '\'' +
                ", attrName='" + attrName + '\'' +
                ", annotation=" + annotation +
                '}';
    }
}
