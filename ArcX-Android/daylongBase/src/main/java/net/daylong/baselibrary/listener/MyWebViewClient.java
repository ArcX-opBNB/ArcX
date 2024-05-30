package net.daylong.baselibrary.listener;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.net.http.SslError;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;


public class MyWebViewClient extends WebViewClient {
//    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        view.loadUrl(url);
//        return true;
//    }

    private AlertDialog dialog;

    @Override
    public void onPageFinished(WebView view, String url) {
        try {
            if (dialog != null) {
                dialog.dismiss();
            }
            injectJavaScript(view);
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
        super.onPageFinished(view, url);
    }

    private void injectJavaScript(WebView webView) {
        
        String js = "javascript: (function() {" +
                "   document.querySelector('#yes_btn').addEventListener('click', function() {" +
                "       window.onButtonClicked('Button was clicked');" +
                "   });" +
                "})();";

        
        webView.evaluateJavascript(js, null);
    }

    @Override
    public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(AppUtil.getContext());
        String message = "SSL Certificate error.";
        switch (error.getPrimaryError()) {
            case SslError.SSL_UNTRUSTED:
                message = "The certificate authority is not trusted.";
                break;
            case SslError.SSL_EXPIRED:
                message = "The certificate has expired.";
                break;
            case SslError.SSL_IDMISMATCH:
                message = "The certificate Hostname mismatch.";
                break;
            case SslError.SSL_NOTYETVALID:
                message = "The certificate is not yet valid.";
                break;
        }
        message += " Do you want to continue anyway?";

        builder.setTitle("SSL Certificate Error");
        builder.setMessage(message);
        builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                handler.proceed();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                handler.cancel();
            }
        });
        dialog = builder.create();
        dialog.show();
    }


    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
