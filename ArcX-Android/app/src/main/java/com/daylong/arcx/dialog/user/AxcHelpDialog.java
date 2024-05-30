package com.daylong.arcx.dialog.user;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

/**

 */
public class AxcHelpDialog extends BaseFragmentDialog {




    public static void showDialog(BaseActivity userInfoActivity) {
        AxcHelpDialog payConfirmDialog = new AxcHelpDialog();
        Bundle bundle = new Bundle();
        payConfirmDialog.setArguments(bundle);
        payConfirmDialog.show(userInfoActivity.getSupportFragmentManager(), payConfirmDialog.toString());
    }

    @Override
    protected ViewGroup getContentLayout() {
        return new ConstraintBuilder(116).wHei().center().build(getContext());
    }





    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);


        contentView.setBackgroundResource(R.drawable.img_mch_alert);

        MyImageView.create(contentView, new ConstraintBuilder(46,29).topCenterH().topMargin(8), R.drawable.img_dialog_axc_help_icon);


        MyTextView textView = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(42).leftRightMargin(6));
        textView.initText("AXC is an important token in the game. When you have energy, you can get it through the game and use it to upgrade your level and pay for goods.", 6, R.color.color_white);
        textView.setPadding(AppUtil.getSize(7), 0, AppUtil.getSize(7), AppUtil.getSize(7));





        MyBtn.create(rootView, new ConstraintBuilder(15).bottomCenterH().bottomMargin(27), com.daylong.reglinrary.R.drawable.img_dialog_colse, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {

    }

    @Override
    public void dismiss() {
        super.dismiss();

    }

    @Override
    public void initData() {

    }
}
