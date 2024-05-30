package net.daylong.baselibrary.utils.files;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoadJson {

    public static String LoadingAssJson(Context context, String fileName) {
        try {
            InputStream is = context.getResources().getAssets().open("music/"+fileName + "/"+fileName+".json");

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length;
            while ((length = is.read(bytes)) != -1) {
                baos.write(bytes, 0, length);
            }
            return baos.toString("UTF-8");


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
