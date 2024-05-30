package com.daylong.arcx;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PackageInstallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e("rag--?onReceive", "onReceive" + action.toString());
        if (action.equals(Intent.ACTION_PACKAGE_ADDED)) {
            String packageName = intent.getData().getSchemeSpecificPart();
            if (packageName.equals("com.daylong.arcx")) {  
                
                Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
                context.startActivity(launchIntent);
            }
        }
    }
}