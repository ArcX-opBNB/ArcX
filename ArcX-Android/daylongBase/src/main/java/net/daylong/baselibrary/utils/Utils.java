package net.daylong.baselibrary.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.view.View;

import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.utils.sys.AppUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Utils {

    /**

     *


     */
    public static int dp2px(float value) {

        final float scale = BaseApplication.getInstance().getContext().getResources().getDisplayMetrics().density;
        return (int) (value * scale + 0.5f);
    }

    /**

     *



     */
    public static int px2dp(Context context, int value) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (value / scale + 0.5f);
    }

    /**

     *
     * @param fraction


     * @return
     */
    public static Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int) (startInt + fraction * (endValue - startInt));
    }

    /**

     *
     * @param f
     */
    public static String floatToString2(float f) {
        DecimalFormat fnum = new DecimalFormat("##0.000");
        String format = fnum.format(f);
        return format.substring(0, format.length() - 1);

    }


    /**

     *
     * @param f
     */
    public static String floatToString1(float f) {
        DecimalFormat fnum = new DecimalFormat("##0.0");
        return fnum.format(f);

    }

    public static boolean isMobileNO(String mobileNums) {
        /**




         * @param str

         */
        String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
        if (TextUtils.isEmpty(mobileNums))
            return false;
        else
            return mobileNums.matches(telRegex);
    }


    /**

     *
     * @param price
     * @return
     */
    public static String for2Pro(double price) {

        DecimalFormat df = new DecimalFormat("0.00");
        double newPrice = price / 10000;
        return df.format(newPrice);

    }


    /**

     *
     * @param number
     * @return
     */
    public static String getDistinguishNumber(int number) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(number);
    }
    /**

     *
     * @param number
     * @return
     */
    public static String getDistinguishNumberDot(int number) {
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(number);
    }

    /**

     *
     * @param number
     * @return
     */
    public static String getDistinguishNumber(double number) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(number);
    }

    /**

     *
     * @param number
     * @return
     */
    public static String getDistinguishNumbers(double number) {
        DecimalFormat df = new DecimalFormat("#,##0");
        return df.format(number);
    }

    /**

     *
     * @param number
     * @return
     */
    public static String getDistinguishNumber(String number) {
//        DecimalFormat df = new DecimalFormat("#,###");
        return number;
    }


    /**

     */

    public static String getCurrentProcessName() {
        FileInputStream in = null;

        try {
            String fn = "/proc/self/cmdline";

            in = new FileInputStream(fn);

            byte[] buffer = new byte[256];

            int len = 0;

            int b;

            while ((b = in.read()) > 0 && len < buffer.length) {
                buffer[len++] = (byte) b;

            }

            if (len > 0) {
                String s = new String(buffer, 0, len, "UTF-8");

                return s;

            }

        } catch (Throwable e) {
            e.printStackTrace();

        } finally {
            if (in != null) {
                try {
                    in.close();

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        }

        return null;

    }


    /**

     *
     * @param view
     * @return
     */
    public static float[] setRect(View view) {

        int[] location = new int[2];
        view.getLocationOnScreen(location);
        float left = location[0];
        float right = left + view.getRight();
        float top = location[1];
        float bottom = top + view.getBottom();
        return new float[]{left, top, right, bottom};


    }

    
    public static String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    public static int getDrawable(String drawableName) {
        return AppUtil.getContext().getResources().getIdentifier(drawableName, "drawable", BaseApplication.getAppContext().getPackageName());

    }
    public static boolean copyMsg(String msg) {
        ClipboardManager clipboard = (ClipboardManager) AppUtil.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard == null || msg == null) {
            return false;
        }
        if (TextUtils.isEmpty(msg)) {
            return false;
        }

        ClipData clip = ClipData.newPlainText("message", msg);
        clipboard.setPrimaryClip(clip);

        return true;
    }
}
