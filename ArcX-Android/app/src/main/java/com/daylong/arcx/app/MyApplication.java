package com.daylong.arcx.app;

import com.daylong.arcx.Appinfo;
import com.daylong.musiclibrary.mrg.SoundPoolManager;

import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.base.IAppInfo;

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        SoundPoolManager.init(this);
    }


    @Override
    public IAppInfo initAppInfo() {
        return new Appinfo();
    }


}
