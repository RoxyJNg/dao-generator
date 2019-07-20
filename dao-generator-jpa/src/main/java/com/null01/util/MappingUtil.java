package com.null01.util;

import com.null01.dbmetadata.DbMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

/**
 * 映射工具
 * Created by Roxy on 2019/7/20.
 */
public class MappingUtil {
    private static final Logger logger = LoggerFactory.getLogger(MappingUtil.class);

    private static MappingUtil instance = new MappingUtil();

    private MappingUtil(){}

    public static MappingUtil getInstance(){
        return instance;
    }

    /**
     * mysql数据库字段→entity属性
     */
    public String mysqlColumnTypeMapping(String columnType) throws Exception{
        switch (columnType){
            case "BIT":{return "Boolean";}

            case "TINYINT":
            case "MEDIUMINT":
            case "SMALLINT":{return "Integer";}

            case "BIGINT":{return "BigInteger"; }

            case "INT":
            case "INTEGER":{return "Long";}

            case "NUMERIC":
            case "DECIMAL":{return "BigDecimal";}

            case "DOUBLE":{return "Double";}
            case "FLOAT":{return "Float";}

            case "CHAR":
            case "TEXT":
            case "TINYTEXT":
            case "MEDIUMTEXT":
            case "LONGTEXT":
            case "VARCHAR":{return "String";}

            case "DATE":
            case "DATETIME":
            case "YEAR":
            case "TIME":
            case "TIMESTAMP":{return "Date";}

            case "TINYBLOB":
            case "MEDIUMBLOB":
            case "LONGBLOB":
            case "BLOB":{return "byte[]";}
            default:{
                logger.error("Type "+ columnType +" is not supported.");
                throw new Exception("Type "+ columnType +" is not supported.");
            }
        }
    }
}
