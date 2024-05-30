package com.daylong.userlibrary.mrg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.daylong.userlibrary.listener.WxLoginListener;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import net.daylong.baselibrary.app.Constant;
import net.daylong.baselibrary.view.DrawableUtils;

import java.io.ByteArrayOutputStream;

public class WXMrg {

    private static WXMrg mInstance;
    private WxLoginListener listeners;

    /**

     *
     * @return
     */
    public static WXMrg getInstance() {
        if (mInstance == null) {
            synchronized (WXMrg.class) {
                if (mInstance == null) {
                    mInstance = new WXMrg();

                }
            }
        }
        return mInstance;
    }


    public void setListeners(WxLoginListener listeners) {
        this.listeners = listeners;
    }

    public void wxLoginSuc(String code) {
        listeners.loginSuc(code);
    }


    public void loing(Context context) {
        IWXAPI wxapi = WXAPIFactory.createWXAPI(context, Constant.WX_APP_ID, true);
        wxapi.registerApp(Constant.WX_APP_ID);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo"; 
        wxapi.sendReq(req);
    }


    public static void share(Context context, String url, String name, String desc) {
        IWXAPI api = WXAPIFactory.createWXAPI(context, Constant.WX_APP_ID, true);
        api.registerApp(Constant.WX_APP_ID);
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = url;


        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = name;
        msg.description = desc;
        Bitmap thumbBmp = BitmapFactory.decodeResource(context.getResources(), DrawableUtils.getDrawableByName("icon"));
        msg.thumbData = bmpToByteArray(thumbBmp, true);


        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneSession;

        api.sendReq(req);
    }

    private static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }
        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis())
                : type + System.currentTimeMillis();
    }
}
