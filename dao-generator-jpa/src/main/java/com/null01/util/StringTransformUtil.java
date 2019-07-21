package com.null01.util;

/**
 * 字符串转换工具类
 * Created by Roxy on 2019/7/17.
 */
public class StringTransformUtil {
    private static StringTransformUtil instance = new StringTransformUtil();
    private StringTransformUtil(){}

    public static StringTransformUtil getInstance(){
        return instance;
    }

    /**
     * 下划线命名法→骆驼式命名法
     */
    public String underlineToCamelCase(String str,boolean firstLetterUpper){
        StringBuffer result = new StringBuffer();
        String[] strings = str.split("_");
        if(strings.length>1){
            int i=0;
            if(!firstLetterUpper){
                i=1;
                result.append(strings[0]);
            }
            for(;i<strings.length;i++){
                if(strings[i].length()>1){
                    strings[i] = strings[i].substring(0,1).toUpperCase()+strings[i].substring(1);
                }else{
                    strings[i] = strings[i].toUpperCase();
                }
                result.append(strings[i]);
            }
            return result.toString();
        }else{
            if(str.length()>1){
                return firstLetterUpper?str.substring(0,1).toUpperCase()+str.substring(1):str;
            }else{
                return firstLetterUpper?str.toUpperCase():str;
            }
        }
    }

}
