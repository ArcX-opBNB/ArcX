package com.daylong.arcx.dialog.wallet;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.uitls.DialogDefaultOpenAnimator;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;

import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.sys.SystemUtil;
import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

public class ScanAddressDialog extends BottomPopupView {
    private MyImageView ivScan;
    private MyTextView tvWalletAddress;

    private String scanAddress;

    public static void show(BaseActivity activity, String scanAddress) {


        new XPopup.Builder(activity)
                .customAnimator(new DialogDefaultOpenAnimator())
                .animationDuration(500)
                .asCustom(new ScanAddressDialog(activity, scanAddress)).show();

    }

    public ScanAddressDialog(@NonNull Context context, String scanAddress) {
        super(context);
        this.scanAddress = scanAddress;
    }

    @Override
    protected void addInnerContent() {

        ConstraintLayout contentView = new ConstraintBuilder().mm().height(224).build(getContext());
        contentView.setBackgroundResource(com.daylong.reglinrary.R.drawable.img_user_info_bg);


        ivScan = MyImageView.create(contentView, new ConstraintBuilder(93).topCenterH().topMargin(30));


        MyTextView tvTab = MyTextView.create(contentView, new ConstraintBuilder().ww().topToBottom(ivScan).centerH().topMargin(8));
        tvTab.initText("Scan address", 8, net.daylong.daylongbase.R.color.color_333);


        tvWalletAddress = MyTextView.create(contentView, new ConstraintBuilder().ww().topToBottom(tvTab).centerH().topMargin(4));
        tvWalletAddress.initText(scanAddress, 6, net.daylong.daylongbase.R.color.color_aca7b7, false);
        tvWalletAddress.setBackgroundResource(R.drawable.shape_bg_r14_8000);
        tvWalletAddress.setPadding(AppUtil.getSize(6), AppUtil.getSize(2), AppUtil.getSize(6), AppUtil.getSize(3));


        MyBtn btnConfirm = MyBtn.create(contentView, new ConstraintBuilder(80, 30).bottomCenterH().bottomMargin(25), com.daylong.reglinrary.R.drawable.img_btn_user_update, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                StringUtils.copy(scanAddress);
                ToastUtil.show(SystemUtil.getString(R.string.str_success));
                dismiss();
            }
        });
        btnConfirm.setGravity(Gravity.CENTER);
        btnConfirm.initBtn("COPY", 10, R.color.color_white, true);
        btnConfirm.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), getContext().getColor(R.color.color_fff6bfea));


        bottomPopupContainer.addView(contentView);


    }

    @Override
    protected void onCreate() {
        super.onCreate();

        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {
                return QRCodeEncoder.syncEncodeQRCode(scanAddress, BGAQRCodeUtil.dp2px(getContext(), AppUtil.getSize(150)));
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    ivScan.setImageBitmap(bitmap);
                } else {
                }
            }
        }.execute();

    }
}
