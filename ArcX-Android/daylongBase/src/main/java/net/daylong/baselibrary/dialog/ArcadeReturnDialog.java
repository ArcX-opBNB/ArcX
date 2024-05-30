package net.daylong.baselibrary.dialog;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.OutlinedTextView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class ArcadeReturnDialog extends BaseFragmentDialog {

    @Override
    protected boolean isWinDismiss() {
        return true;
    }

    public static void showDialog(FragmentManager fragmentManager, long coin) {

        ArcadeReturnDialog reportDialog = new ArcadeReturnDialog();

        Bundle bundle = new Bundle();
        bundle.putLong("coin", coin);
        reportDialog.setArguments(bundle);
        if (reportDialog.getDialog() == null || !reportDialog.getDialog().isShowing()) {
            reportDialog.show(fragmentManager, reportDialog.toString());
        }

    }

    //    @Override
    protected ViewGroup getContentLayout() {
        ConstraintLayout build = new ConstraintBuilder(166, 96).center().build(getContext());
        build.setBackgroundResource(DrawableUtils.getDrawableByName("img_mch_alert"));
        return build;

    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {

    }


    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);
        Bundle arguments = getArguments();
        long coin = arguments.getLong("coin");

        MyImageView myImageView = MyImageView.create(contentView, new ConstraintBuilder(50).leftCenterV().leftMargin(25), DrawableUtils.getDrawableByName("img_recharge_product_4"));
        myImageView.setId(View.generateViewId());


        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().top(myImageView).leftToRightById(myImageView).leftTopMargin(31, 6));

        myTextView.setId(View.generateViewId());
        OutlinedTextView.create(contentView, new ConstraintBuilder().ww().height(17).topToBottom(myTextView).topMargin(2).leftToRightById(myImageView).leftTopMargin(12, 6), AppUtil.getSize(12), StringUtils.numFormatDot(coin));

    }

    @Override
    public void initData() {

    }


}
