package net.daylong.baselibrary.app;

import android.content.Context;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.date.DateUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static CrashHandler sCrashHandler;
    /**

     */
    private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler;
    /**
     * context
     */
    private Context mContext;
    /**

     */
    private Map<String, String> exceptionMap = new HashMap<>();

    /**

     */
    private CrashHandler(){

    }

    /**

     * @return
     */
    public static synchronized CrashHandler getInstance(){
        if(sCrashHandler == null){
            synchronized (CrashHandler.class){
                if(sCrashHandler == null){
                    sCrashHandler = new CrashHandler();
                }
            }
        }
        return sCrashHandler;
    }

    /**

     * @param context
     */
    public void init(Context context){
        this.mContext = context;
        mUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if(!handlerException(e) && mUncaughtExceptionHandler != null){
            
            mUncaughtExceptionHandler.uncaughtException(t, e);
        }else{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                MyLogUtil.e(e1.toString());
            }
          AppManager.getInstance().exitApp(mContext,true);
        }
    }

    /**

     * @param throwable

     */
    public boolean handlerException(Throwable throwable){
        if(throwable == null){
            return false;
        }
        collectDeviceInfo(mContext);
        saveCrashInfoToFile(throwable);
        AppManager.getInstance().exitApp(mContext,true);
        return true;
    }

    /**

     * @param context
     */
    private void collectDeviceInfo(Context context) {
        int versionCode = AppUtil.getVersionCode(context);
        String appVersionName = AppUtil.getAppVersionName(context);
        exceptionMap.put("versionCode", String.valueOf(versionCode));
        exceptionMap.put("versionName",appVersionName);
        

    }

    /**

     * @param throwable
     */
    private void saveCrashInfoToFile(Throwable throwable) {
        if (AppUtil.isHasSDCard()) {
            try{
                String path = AppUtil.getSDCardPath() + "/crash/";
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                String currentTime = DateUtil.currentDatetime();
                String fileName = "crash-" + currentTime + ".log";
                File file = new File(path + "/" + fileName);
                if(!file.exists()){
                    file.createNewFile();
                }
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
                printWriter.print(currentTime);
                printWriter.println();
                for(Map.Entry<String, String> entry : exceptionMap.entrySet()){
                    String key = entry.getKey();
                    String value = entry.getValue();
                    printWriter.print(key + "=" + value + "\n");
                }
                printWriter.println();
                
                throwable.printStackTrace(printWriter);
                MyLogUtil.e("throwable************:"+throwable.toString());
                printWriter.close();
            }catch (Exception e){
                MyLogUtil.d("saveCrashInfoToFile fail...");
            }
        }else{

        }
    }

}
