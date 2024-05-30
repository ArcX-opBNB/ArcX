package net.daylong.baselibrary.utils.sys;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.util.Log;

import com.orhanobut.logger.Logger;

import net.daylong.baselibrary.utils.MyLogUtil;

import org.json.JSONObject;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CrashHandlerUtil implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "CrashHandlerUtil";

    
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    
    private static CrashHandlerUtil INSTANCE = new CrashHandlerUtil();
    
    private Context mContext;
    
    private Map<String, String> infos = new HashMap<>();

    
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA);


    public String getCrashTip() {
        return crashTip;
    }

    public void setCrashTip(String crashTip) {
        this.crashTip = crashTip;
    }


    private CrashHandlerUtil() {
    }


    public static CrashHandlerUtil getInstance() {
        return INSTANCE;
    }


    public void init(Context context) {
        mContext = context;
        
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**

     *


     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            
            mDefaultHandler.uncaughtException(thread, ex);
        } else {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Logger.e("error : ", e);
                e.printStackTrace();
            }
            
            
            System.exit(0);
            
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    /**

     *


     */
    private boolean handleException(final Throwable throwable) {
        if (throwable == null) {
            return false;
        }

        isEnd = false;
        
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                throwable.printStackTrace();

                Looper.loop();
            }
        }.start();


        
        collectDeviceInfo(mContext);
        
        saveCrashInfo2FileJson(throwable);


        while (!isEnd) {
        }

        return true;
    }

    public static boolean isEnd = false;

    /**

     *

     */
    public void collectDeviceInfo(Context ctx) {
        try {
            PackageManager pm = ctx.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (pi != null) {
                String versionName = pi.versionName == null ? "null" : pi.versionName;
                String versionCode = pi.versionCode + "";
                infos.put("versionName", versionName);
                infos.put("versionCode", versionCode);
            }


        } catch (PackageManager.NameNotFoundException e) {
            Logger.e("an error occured when collect package info", e);

        }
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                infos.put(field.getName(), field.get(null).toString());
//                Logger.e(field.getName() + " : " + field.get(null));
            } catch (Exception e) {
                Logger.e("an error occured when collect crash info", e);
            }
        }
    }

    /**

     *


     */
    private void saveCrashInfo2File(Throwable ex) {


        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : infos.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key + "=" + value + "\n");
        }

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        sb.append(result);

        MyLogUtil.writeLog("crash", sb.toString());
        Logger.e(sb.toString());

        /*

         */
        String crashInfo = sb.toString();
        Log.d("tag", "------crashInfo----->" + crashInfo);
        


//        return null;
    }

    /**

     *


     */
    private void saveCrashInfo2FileJson(Throwable ex) {


        JSONObject jsonObject = new JSONObject();
        try {

            for (Map.Entry<String, String> entry : infos.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                jsonObject.put(key.toLowerCase(), value);

            }
            Writer writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            ex.printStackTrace(printWriter);
            Throwable cause = ex.getCause();
            while (cause != null) {
                cause.printStackTrace(printWriter);
                cause = cause.getCause();
            }
            printWriter.close();
            String result = writer.toString();
            jsonObject.put("result", result);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        AppManager.getInstance().exitApp();
//        CrashHandlerUtil.post(jsonObject.toString());

//        return null;
    }

    public static String stringToUnicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            
            char c = string.charAt(i);
            
            
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    public static void post(String crashInfo) {


        if (isLogin()) {
            //FileUploadServiceImpl.upload(crashInfo);
        }
    }


    private static boolean isLogin() {
        return false;
    }


}
