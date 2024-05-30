package net.daylong.gamesocket.utls;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class SocketJsonUtil {
    private static Gson sGson = new Gson();

    /**

     * @param Object
     * @return
     */
    public static <T> String toJson(T Object){
        return sGson.toJson(Object);
    }
    /**

     * @param Object
     * @return
     */
    public static <T> String toJson(T Object, String key){
        Map map = new HashMap();
        map.put(key,Object);
        return sGson.toJson(map);
    }

    /**

     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T fromJsonToObject(String json, Class<T> cls){
        return sGson.fromJson(json,cls);
    }

    /**

     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJsonToObject(String json, Type type){
        return sGson.fromJson(json,type);
    }

}
