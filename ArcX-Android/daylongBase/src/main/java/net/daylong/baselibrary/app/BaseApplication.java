package net.daylong.baselibrary.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.StrictMode;

import com.alibaba.android.arouter.launcher.ARouter;
import com.daylong.basecache.MMKVManager;
import com.opensource.svgaplayer.SVGAParser;

import net.daylong.baselibrary.BuglMrg;
import net.daylong.baselibrary.base.IAppInfo;
import net.daylong.baselibrary.utils.KeyboardVisibilityObserver;
import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.files.FileUtil;
import net.daylong.baselibrary.utils.sys.CrashHandlerUtil;
import net.daylong.baselibrary.utils.sys.SystemUtil;


public abstract class BaseApplication extends Application {
    private static BaseApplication sAppApplication;
    protected static Context sContext;
    protected static  Handler sHandler;
    protected static int sMainThreadId;
    public static final boolean DEBUG = true;  
    private IAppInfo appInfo;
    public static final int SERVER_SIDE_TYPE = 7;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppApplication = this;
        sContext = getApplicationContext();
        sHandler = new Handler();
        sMainThreadId = android.os.Process.myTid();
        ARouter.init(this);
        MMKVManager.getInstance().init(this, SystemUtil.getVersionName());
        if (isDebug()) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        CrashHandlerUtil.getInstance().init(this);

        MyLogUtil.init(DEBUG);


        appInfo = initAppInfo();
        KeyboardVisibilityObserver.getInstance().init(this);
        FileUtil.createCacheFile();
        BuglMrg.init(this, "82465e2aac");


        String packageName = getPackageName();
        MyLogUtil.e("rag-->"+packageName);
        SVGAParser.Companion.shareParser().init(BaseApplication.getInstance().getContext());

    }

    public boolean isDebug() {
        return DEBUG;
    }

    public abstract IAppInfo initAppInfo();

    public IAppInfo getAppInfo() {
        return appInfo;
    }


    private void init() {

    }


    /**

     *
     * @return
     */
    public static synchronized BaseApplication getInstance() {
        return sAppApplication;
    }

    public static Context getAppContext() {
        return sContext;
    }

    public static void reAppContext() {
    }

    public Context getContext() {
        return sContext;
    }

    /**

     *
     * @return
     */
    public static Handler getHandler() {
        return sHandler;
    }

    /**

     *
     * @return
     */
    public static int getMainThreadId() {
        return sMainThreadId;
    }

    /**

     *
     * @return
     */
    public String getBaseUrl() {
        return appInfo.getBaseUrl();
    }
}
