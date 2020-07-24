package vn.thanhlong.common.helper;

import lombok.SneakyThrows;
import vn.thanhlong.common.anno.NotNullOrEmpty;

import java.lang.reflect.Field;
import java.util.Objects;

public class ObjectHelper {

    @SneakyThrows
    public static Boolean isNotNullOrEmptyFiedRequied(Object object) {
        try {

            Objects.requireNonNull(object, "Object is null");

            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);

                System.out.println(field.getName());

                if (field.isAnnotationPresent(NotNullOrEmpty.class)) {
                    if (field.get(object) == null) {
                        throw new NullPointerException("Field '" + field.getName() + "' is null");
                    }

                    if (field.get(object).toString().isEmpty()) {
                        throw new NullPointerException("Field '" + field.getName() + "' is empty");
                    }

                }

            }
            return true;

        } catch (IllegalAccessException e) {
            throw new IllegalAccessException(e.getMessage());
        }
    }

}
