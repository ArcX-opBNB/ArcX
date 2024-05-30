package net.daylong.baselibrary.listener;

public interface DownloadFileListener {
     void onStart();
     void onProgress(int pd);
     void onSuc(String path);
     void onFail(int code,String msg);

}
