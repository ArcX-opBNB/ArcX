package net.daylong.baselibrary.utils;


import android.Manifest;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import net.daylong.baselibrary.utils.ui.act.BaseActivity;


public class PermissionsUtils {

    private static PermissionsUtils instance = null;

    //    private
    public static synchronized PermissionsUtils getInstance() {
        if (instance == null) {
            synchronized (PermissionsUtils.class) {
                instance = new PermissionsUtils();

            }
        }
        return instance;
    }



    public void requestPermissions(BaseActivity activity) {
        
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(activity,
                        new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.CAMERA,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, 10001);
            } else {
                ActivityCompat.requestPermissions(activity,
                        new String[]{
                                Manifest.permission.CAMERA,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        }, 10001);
            }
        } else {

        }

    }

}
