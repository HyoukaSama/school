import com.hyouka.entity.User;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ClazzTest {


    public static void main(String[] args) {
       Map map= getEntityFieldsMap(User.class);
        for (Object o : map.keySet()) {
            System.out.println(o+"---"+map.get(o));
        }
    }

    private static Map<String, String> getEntityFieldsMap(Class<?> clazz) {
        Map<String, String> entityFieldsMap = new HashMap<>();
        Field[] videoFields = clazz.getDeclaredFields();
        Column presentColumn;
        String columnName;
        for (Field field : videoFields) {
            if (field.isAnnotationPresent(Column.class)) {
                presentColumn = field.getDeclaredAnnotation(Column.class);
                columnName = presentColumn.name();
                entityFieldsMap.put(columnName, field.getName());
            }
        }
        return entityFieldsMap;
    }

}
