/**
 * ${tableDesc}
 */
${annotation}
public class ${tableName} {
<#list columnList as col>
    /**
     * ${col.colComment}
     */
    ${col.annotation}
    private ${col.attrType} ${col.attrName};

</#list>
<#list columnList as col>
    public void set${col.attrNameWithFirstLetterUpper}(${col.attrType} ${col.attrName}){
        this.${col.attrName} = ${col.attrName};
    }
</#list>

<#list columnList as col>
    public ${col.attrType} get${col.attrNameWithFirstLetterUpper}(){
        return this.${col.attrName};
    }
</#list>
}