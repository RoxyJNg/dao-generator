package com.null01.mapper.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mysql映射工具
 * Created by Roxy on 2019/7/20.
 */
public class MysqlMappingUtil {
    private static final Logger logger = LoggerFactory.getLogger(MysqlMappingUtil.class);

    private static MysqlMappingUtil instance = new MysqlMappingUtil();

    private MysqlMappingUtil(){}

    public static MysqlMappingUtil getInstance(){
        return instance;
    }

    /**
     * mysql数据库字段→entity属性
     */
    public String columnTypeMapping(String columnType) throws Exception{
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
