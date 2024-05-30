package com.daylong.arcx.act;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import net.daylong.baselibrary.utils.ui.act.BaseActivity;

import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import io.reactivex.functions.Consumer;


public class ScanAddressActivity extends BaseActivity implements QRCodeView.Delegate {
    private ZXingView cp;


    public static void start(Activity context) {

        Intent intent = new Intent(context, ScanAddressActivity.class);
        context.startActivityForResult(intent, 1024);
    }



    @Override
    protected Integer getLayoutId() {
        return R.layout.scan_address_layout;
    }

    @Override
    protected void initView() {
        super.initView();
        cp = (ZXingView) findViewById(R.id.zxingview);
        cp.setDelegate(this);
    }

    @Override
    protected void initData() {
        super.initData();
        BGAQRCodeUtil.setDebug(true);
        new RxPermissions(ScanAddressActivity.this)
                .request(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            cp.startCamera(); 

                            cp.startSpotAndShowRect(); 

                        }

                    }
                });
    }






    @Override
    protected void onDestroy() {
        super.onDestroy();
        cp.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cp.stopCamera();
    }


    @Override
    public void onScanQRCodeSuccess(String result) {


        Intent intent = new Intent();
        intent.putExtra("address", result);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {

    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }
}