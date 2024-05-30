package com.daylong.arcx.dialog.charter;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.arcx.R;
import com.daylong.arcx.view.btn.DefaultCancelDialogBtn;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class ArcadeExitDialog extends BaseFragmentDialog {


    public static void showDialog(FragmentManager fragmentManager) {

        ArcadeExitDialog reportDialog = new ArcadeExitDialog();
        if (reportDialog.getDialog() == null || !reportDialog.getDialog().isShowing()) {
            reportDialog.show(fragmentManager, reportDialog.toString());
        }

    }

    //    @Override
    protected ViewGroup getContentLayout() {
        ConstraintLayout build = new ConstraintBuilder(166, 121).center().build(getContext());
        build.setBackgroundResource(R.drawable.img_mch_alert);
        return build;

    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {

    }


    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);

        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(17));
        myTextView.setId(View.generateViewId());


        MyTextView tvDesc = MyTextView.create(contentView, new ConstraintBuilder().ww().topToBottom(myTextView).topMargin(6));
        tvDesc.setPadding(AppUtil.getSize(10), 0, AppUtil.getSize(10), 0);
        tvDesc.setId(View.generateViewId());

        tvDesc.setGravity(Gravity.CENTER_HORIZONTAL);
        tvDesc.setId(View.generateViewId());


        MyImageView myImageView = MyImageView.create(rootView, new ConstraintBuilder(23).bottom(contentView.getId()).bottomMargin(105).left(contentView.getId()).leftMargin(150), R.drawable.img_mch_close);

        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        DefaultCancelDialogBtn defaultCancelDialogBtn = new DefaultCancelDialogBtn(getContext(), new ConstraintBuilder(64, 27).bottomCenterH().bottomMargin(18));


        defaultCancelDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) {
                    ((BaseGameActivity) getActivity()).exitRoom();
                }
                dismiss();
            }
        });

        contentView.addView(defaultCancelDialogBtn);
    }

    @Override
    public void initData() {

    }


}
