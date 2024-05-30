package net.daylong.baselibrary.utils;

import android.util.Base64;


import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import net.daylong.baselibrary.app.Constant;
import net.daylong.baselibrary.utils.date.DateUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class MyLogUtil {
    private static boolean sDebug = true;

    /**

     *
     * @param debug
     */
    public static void init(boolean debug) {


        sDebug = debug;
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    /**

     *

     */
    public static void v(String msg) {
        if (sDebug) {
            Logger.v(msg);
        }
    }

    /**

     *

     */
    public static void d(String msg) {
        if (sDebug) {
            Logger.e(msg);
        }
    }


    /**

     *

     */
    public static void i(String msg) {
        if (sDebug) {
            Logger.i(msg);
        }
    }

    /**

     *

     */
    public static void w(String msg) {
        if (sDebug) {
            Logger.w(msg);
        }
    }

    /**

     *

     */
    public static void wtf(String msg) {
        if (sDebug) {
            Logger.wtf(msg);
        }
    }


    /**

     *

     */
    public static void e(String msg) {
        if (sDebug) {
            Logger.e(msg);
        }
    }

    /**

     *

     */
    public static void e(String msg, String text) {
        if (sDebug) {
            Logger.e(msg + text);
        }
    }

    /**

     *

     */
    public static void i(String msg, String text) {
        if (sDebug) {
            Logger.i(msg + text);
        }
    }

    /**

     *
     * @param throwable
     */
    public static void e(Throwable throwable) {
        if (sDebug) {
            Logger.e(throwable, "");
        }
    }


    /**

     *

     * @param throwable
     */
    public static void e(String msg, Throwable throwable) {
        if (sDebug) {
            Logger.e(throwable, msg);
        }
    }

    /**

     *

     */
    public static void json(String msg) {
        if (sDebug) {
            Logger.json(msg);
        }
    }


    /**

     *
     * @param content
     */
    public static void writeLog(String content) {
        if (sDebug) {
            content = DateUtil.currentDatetimeLong() + ":" + content;
//            String baseContent = encodeToString();
            String path = Constant.LOG_PATH;
            FileWriter writer = null;
            try {
                File file = new File(path);
                if (!file.exists()) {  
                    file.mkdirs();
                }
                
                writer = new FileWriter(path + DateUtil.currentDatetimeDay() + ".log", true);
                writer.write(content + "\r\n");
                writer.flush();
                
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    public static void writeLogAndName(String fileName, String content) {
        if (sDebug) {
            content = DateUtil.currentDatetimeLong() + ":" + content;
//            String baseContent = encodeToString();
            String path = Constant.LOG_PATH;
            FileWriter writer = null;
            try {
                File file = new File(path);
                if (!file.exists()) {  
                    file.mkdirs();
                }
                
                writer = new FileWriter(path + DateUtil.currentDatetimeDay() + fileName + ".log", true);
                writer.write(content + "\r\n");
                writer.flush();
                
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeLog(String name, String content) {
        if (sDebug) {
            content = DateUtil.currentDatetimeLong() + ":" + content;
//            String baseContent = encodeToString();
            String path = Constant.LOG_PATH;
            FileWriter writer = null;
            try {
                File file = new File(path);
                if (!file.exists()) {  
                    file.mkdirs();
                }
                
                writer = new FileWriter(path + DateUtil.currentDatetimeDay() + name + ".log", true);
                writer.write(content + "\r\n");
                writer.flush();
                
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String encodeToString(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
