package com.hyouka.utils;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 根据实体生成对应的ResultMap
 * @author wangxh
 * @date 2017-10-12 09:44:23
 */
public class ResultMapUtil {
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 获取ResultMap
     * @param clazz 实体类的Class
     * @return String
     */
    public static String getResultMap(Class<?> clazz){

        Object obj = null;
        try{
            obj = clazz.newInstance();
        }catch (Exception e){
            return "#Exception.反射生成实体异常#";
        }

        String clazzName = clazz.getSimpleName();
        String resultMapId = Character.toLowerCase(clazzName.charAt(0))+clazzName.substring(1)+"Map";
        String pkgName = clazz.getName();

        StringBuilder resultMap = new StringBuilder();
        resultMap.append("<resultMap id=\"");
        resultMap.append(resultMapId);
        resultMap.append("\" type=\"");
        resultMap.append(pkgName);
        resultMap.append("\">\n");

        Field[] fields = clazz.getDeclaredFields();
        Column presentColumn;
        String columnName;
        for(Field field : fields){
            String property = field.getName();

            if (field.isAnnotationPresent(Column.class)) {
                presentColumn = field.getDeclaredAnnotation(Column.class);
                columnName = presentColumn.name();
            }else {
                columnName=property;
            }
        //    String javaType = field.getType().getName();
            if("serialVersionUID".equals(property)){
                continue;//忽略掉这个属性
            }
            resultMap.append("    <result column=\"");
            resultMap.append(property2Column(columnName));
//            resultMap.append("\" jdbcType=\"");
//            resultMap.append(javaType2jdbcType(javaType.toLowerCase()));
            resultMap.append("\" property=\"");
            resultMap.append(property);
            resultMap.append("\" />\n");
        }
        resultMap.append("</resultMap>");
        return resultMap.toString();
    }

    private static String property2Column(String property){
        Matcher matcher = humpPattern.matcher(property);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    private static String javaType2jdbcType(String javaType){
        if(javaType.contains("string")){
            return "VARCHAR";
        }else if(javaType.contains("boolean")){
            return "BIT";
        }else if(javaType.contains("byte")){
            return "TINYINT";
        }else if(javaType.contains("short")){
            return "SMALLINT";
        }else if(javaType.contains("int")){
            return "INTEGER";
        }else if(javaType.contains("long")){
            return "BIGINT";
        }else if(javaType.contains("double")){
            return "DOUBLE";
        }else if(javaType.contains("float")){
            return "REAL";
        }else if(javaType.contains("date")){
            return "DATE";
        }else if(javaType.contains("timestamp")){
            return "TIMESTAMP";
        }else if(javaType.contains("time")){
            return "TIME";
        }else if(javaType.contains("bigdecimal")){
            return "DECIMAL";
        }else{
            return "未知类型";
        }
    }
}
