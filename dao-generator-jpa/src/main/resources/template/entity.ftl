表名：${tableName}
表备注：${tableDesc}
表列：
<#list columnList as col>
    ${col.attrName},${col.attrType},${col.colComment}.
</#list>