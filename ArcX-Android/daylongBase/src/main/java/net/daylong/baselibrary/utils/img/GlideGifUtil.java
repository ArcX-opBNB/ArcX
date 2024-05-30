package net.daylong.baselibrary.utils.img;

import android.text.TextUtils;

import java.lang.reflect.Field;

public class GlideGifUtil {
    /**

     *



     * @throws Exception
     */
    public static Object getValue(Object object, String fieldName) throws Exception {
        if (object == null) {
            return null;
        }
        if (TextUtils.isEmpty(fieldName)) {
            return null;
        }
        Field field = null;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(object);
            } catch (Exception e) {
                
                
            }
        }
        return null;
    }
}