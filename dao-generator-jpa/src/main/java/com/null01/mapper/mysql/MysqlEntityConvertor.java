package com.null01.mapper.mysql;

import com.null01.mapper.EntityConvertor;
import com.null01.model.TableColumn;
import com.null01.model.TableInfo;
import com.null01.util.StringTransformUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 表结构转换为实体信息
 * Created by Roxy on 2019/7/21.
 */
@Component
public class MysqlEntityConvertor implements EntityConvertor{

    @Override
    public List<TableInfo> metadataToEntity(List<TableInfo> tableList){
        tableList.stream().forEach(tableInfo -> {
            //表名
            tableInfo.setTableName(StringTransformUtil.getInstance().underlineToCamelCase(tableInfo.getTableName(),true));
            //表字段
            List<TableColumn> columnList = tableInfo.getColumnList();
            columnList.stream().forEach(column ->{
                column.setAttrName(StringTransformUtil.getInstance().underlineToCamelCase(column.getColName(),false));
                try {
                    column.setAttrType(MysqlMappingUtil.getInstance().columnTypeMapping(column.getColType()));
                }catch (Exception ex){}

                //主键
                tableInfo.getPrimaryKeysName().stream().forEach(pkName ->{
                    if(pkName.equals(column.getColName())){
                        String anno = MysqlMappingUtil.getInstance().colAnnotationMapping(column, true);
                        column.setAnnotation(anno);
                    }else{
                        String anno = MysqlMappingUtil.getInstance().colAnnotationMapping(column,false);
                        column.setAnnotation(anno);
                    }
                });
            });
            //注解
            String tableAnno = MysqlMappingUtil.getInstance().tableAnnotationMapping(tableInfo);
            tableInfo.setAnnotation(tableAnno);

        });
        return tableList;
    }
}
