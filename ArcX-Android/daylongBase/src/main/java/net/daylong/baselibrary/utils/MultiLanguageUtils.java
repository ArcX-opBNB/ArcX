package net.daylong.baselibrary.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;

import java.util.Locale;

public class MultiLanguageUtils {

    /**

     *


     */
    public static void changeLanguage(Context context, String language, String area) {

        
        Locale newLocale = new Locale(language, area);
        setAppLanguage(context, newLocale);
    }


    /**

     *
     * @param context
     * @param locale
     */
    private static void setAppLanguage(Context context, Locale locale) {
        Resources resources = context.getResources();
        if (resources != null) {
            DisplayMetrics metrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            
            configuration.setLocale(locale);
            configuration.setLocales(new LocaleList(locale));
            context.createConfigurationContext(configuration);
            
            
            resources.updateConfiguration(configuration, metrics);



        }
    }


    /**

     */
    public static Locale getAppLocale(Context context) {
        Locale local;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            local = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            local = context.getResources().getConfiguration().locale;
        }
        return local;
    }


    /**

     */
    public static LocaleListCompat getSystemLanguage() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        LocaleListCompat locales = ConfigurationCompat.getLocales(configuration);
        return locales;
    }

    /**

     * <p>



     *
     * @param context application context
     */
    public static void setConfiguration(Context context) {
        if (context == null) {
            return;
        }
        /*



         */
        Context appContext = context.getApplicationContext();
        Locale preferredLocale = getSysPreferredLocale();
        Configuration configuration = appContext.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(preferredLocale);
        } else {
            configuration.locale = preferredLocale;
        }
        
        Resources resources = appContext.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        resources.updateConfiguration(configuration, dm);
    }

    /**

     * <p>

     *
     * @return
     */
    public static Locale getSysPreferredLocale() {
        Locale locale;
        
        if (Build.VERSION.SDK_INT < 24) {
            
            locale = Locale.getDefault();
            
        } else {
            /*

             * 1.context.getResources().getConfiguration().getLocales()
             * 2.LocaleList.getAdjustedDefault()
             */
            
            locale = LocaleList.getDefault().get(0);
        }
        return locale;
    }



}

