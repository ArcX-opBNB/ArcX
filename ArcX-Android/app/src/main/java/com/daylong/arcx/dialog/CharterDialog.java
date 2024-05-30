//
//package com.daylong.arcx.dialog;
//
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.fragment.app.FragmentManager;
//
//import com.daylong.arcx.R;
//
//import net.daylong.baselibrary.base.dialog.BaseDialog;
//import net.daylong.baselibrary.dialog.BaseFragmentDialog;
//import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
//import net.daylong.baselibrary.view.textview.MyTextView;
//
///**

// */
//public abstract class CharterDialog extends BaseFragmentDialog {
//
//    public static void showDialog(FragmentManager fragmentManager,) {
//
//        CharterDialog reportDialog = new CharterDialog();
//        if (reportDialog.getDialog() == null || !reportDialog.getDialog().isShowing()) {
//            reportDialog.show(fragmentManager, reportDialog.toString());
//        }
//    }
//
//    protected abstract int contentBgReg();
//
//    @Override
//    protected ViewGroup getContentLayout() {
//        ConstraintLayout build = new ConstraintBuilder(166, 121).center().build(getContext());
//        build.setBackgroundResource(com.daylong.arcx.R.drawable.img_mch_alert);
//
//        return build;
//
//    }
//
//    @Override
//    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
//        super.initView(rootView, contentView, dialog);
//
//        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(17));
//        myTextView.setId(View.generateViewId());

//        MyTextView tvDesc = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(17));
//        tvDesc.setId(View.generateViewId());

//
//
//    }
//
//    private void initBtn(ConstraintLayout rootView) {
//
//
//    }
//
//    private void initTitle(ConstraintLayout rootView) {
//
//
//    }
//
//    @Override
//    public void initData() {
//
//    }
//
//}
