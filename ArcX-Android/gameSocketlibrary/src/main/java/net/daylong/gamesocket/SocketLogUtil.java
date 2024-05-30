package net.daylong.gamesocket;

import android.util.Log;


public class SocketLogUtil {
    private static boolean sDebug = true;
    private static final String  TAG = "webSocket->";

    /**

     *

     */
    public static void v(String msg) {
        if (sDebug) {
            Log.v(TAG,msg);
        }
    }

    /**

     *

     */
    public static void d(String msg) {
        if (sDebug) {
            Log.d(TAG,msg);
        }
    }


    /**

     *

     */
    public static void i(String msg) {
        if (sDebug) {
            Log.i(TAG,msg);
        }
    }

    /**

     *

     */
    public static void w(String msg) {
        if (sDebug) {
            Log.w(TAG,msg);
        }
    }



    /**

     *

     */
    public static void e(String msg) {
        if (sDebug) {
            Log.e(TAG,msg);

        }
    }
}
