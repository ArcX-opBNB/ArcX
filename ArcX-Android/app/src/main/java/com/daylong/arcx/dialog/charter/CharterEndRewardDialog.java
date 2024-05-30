package com.daylong.arcx.dialog.charter;//package com.daylong.gamelibrary.dialog.charter;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.Gravity;
//import android.view.View;
//
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.fragment.app.FragmentManager;
//
//import com.daylong.Metapusher.game.R;
//
//import net.daylong.baselibrary.base.dialog.BaseDialog;
//import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
//import net.daylong.baselibrary.utils.ui.layout.cl.LeftLayoutC;
//import net.daylong.baselibrary.utils.ui.layout.cl.TopLayoutC;
//import net.daylong.baselibrary.view.DrawableUtils;
//import net.daylong.baselibrary.view.btn.BaseButton;
//import net.daylong.baselibrary.view.textview.MyTextView;
//import net.daylong.beanlibrany.game.charter.CharterMsg;
//import net.daylong.metapusherbaselibrary.dialog.BaseFragmentDialog;
//
///**

// */
//public class CharterEndRewardDialog extends BaseFragmentDialog {
//
//    @Override
//    protected boolean isWinDismiss() {
//        return false;
//    }
//
//    public static void showDialog(FragmentManager fragmentManager, CharterMsg charterMsg, OnDismissListener onDismissListener) {
//        CharterEndRewardDialog funCardDialog = new CharterEndRewardDialog();
//        if (onDismissListener != null) {
//            funCardDialog.setOnDismissListener(onDismissListener);
//
//        }
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("charterMsg", charterMsg);
//        funCardDialog.setArguments(bundle);
//        if (funCardDialog.getDialog() == null || !funCardDialog.getDialog().isShowing()) {
//            funCardDialog.show(fragmentManager, funCardDialog.toString());
//        }
//    }
//
//    public static void showDialog(FragmentManager fragmentManager, CharterMsg charterMsg) {
//
//        showDialog(fragmentManager, charterMsg, null);
//    }
//
//    @Override
//    public void initView(ConstraintLayout rootView, BaseDialog dialog) {
//
//        CharterMsg charterMsg = (CharterMsg) getArguments().getSerializable("charterMsg");
//        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(156, 102);
//        ConstraintLayoutUtils.center(winLayoutParams);
//
//        ConstraintLayout constraintLayout = new ConstraintLayout(getContext());
//        constraintLayout.setLayoutParams(winLayoutParams);
//        initTitle(constraintLayout);
//
//        constraintLayout.setBackgroundResource(R.drawable.img_bg_dialog_l);
//        initCharterBalance(constraintLayout, charterMsg);
//        initCharterReturn(constraintLayout, charterMsg);
//        initCharterCount(constraintLayout, charterMsg);
//        initConfirmBtn(constraintLayout);
//        rootView.addView(constraintLayout);
//    }
//
//    private void initConfirmBtn(ConstraintLayout constraintLayout) {
//
//        ConstraintLayout.LayoutParams layoutParams = ConstraintLayoutUtils.getLayoutParams(48, 22);
//
//
//        TopLayoutC.topByBottom(layoutParams, R.id.charter_end_dialog_count_key);
//        TopLayoutC.margin(layoutParams, 3);
//        LeftLayoutC.centerH(layoutParams);
//        BaseButton button = BaseButton.create(constraintLayout, layoutParams);

//        button.setTextColor(Color.BLACK);
//        button.setGravity(Gravity.CENTER);
//        button.setBackgroundResource(R.drawable.ic_dialog_default_btn_bg);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (OnDismissListener != null) {
//                    OnDismissListener.onDismiss();
//                }
//                dismiss();
//            }
//        });
//
//    }
//
//    private void initCharterBalance(ConstraintLayout constraintLayout, CharterMsg charterMsg) {
//
//
//        ConstraintLayout.LayoutParams keyParams = ConstraintLayoutUtils.getLayoutParamsWW();
//        TopLayoutC.top(keyParams);
//        TopLayoutC.margin(keyParams, 31);
//        LeftLayoutC.left(keyParams);
//        LeftLayoutC.margin(keyParams, 36);
//        MyTextView tvKeyBalance = MyTextView.create(constraintLayout, keyParams);
//        tvKeyBalance.setId(R.id.charter_end_dialog_balance_key);

//        tvKeyBalance.setTextSize(8);
//        tvKeyBalance.getPaint().setFakeBoldText(true);
//
//
//        ConstraintLayout.LayoutParams valParams = ConstraintLayoutUtils.getLayoutParamsWW();
//        TopLayoutC.top(valParams, R.id.charter_end_dialog_balance_key);
//        LeftLayoutC.leftToRight(valParams, R.id.charter_end_dialog_balance_key);
//
//        MyTextView tvValBalance = MyTextView.create(constraintLayout, valParams);
//        tvValBalance.setId(R.id.charter_end_dialog_balance_val);
//        tvValBalance.setTextSize(8);
//        tvValBalance.getPaint().setFakeBoldText(true);
//        tvValBalance.setText(charterMsg.getBalance());
//        tvValBalance.setGravity(Gravity.CENTER_VERTICAL);
//        DrawableUtils.setLeftDrawable(tvValBalance, 9, R.drawable.coin);
//    }
//
//

//    private void initCharterReturn(ConstraintLayout constraintLayout, CharterMsg charterMsg) {
//
//
//        ConstraintLayout.LayoutParams keyParams = ConstraintLayoutUtils.getLayoutParamsWW();
//        TopLayoutC.topToBottom(keyParams, R.id.charter_end_dialog_balance_key);
//        TopLayoutC.margin(keyParams, 2);
//        LeftLayoutC.leftToLeft(keyParams, R.id.charter_end_dialog_balance_key);
//
//        MyTextView tvKeyBalance = MyTextView.create(constraintLayout, keyParams);
//        tvKeyBalance.setId(R.id.charter_end_dialog_return_key);

//        tvKeyBalance.setTextSize(8);
//        tvKeyBalance.getPaint().setFakeBoldText(true);
//
//        ConstraintLayout.LayoutParams valParams = ConstraintLayoutUtils.getLayoutParamsWW();
//        TopLayoutC.top(valParams, R.id.charter_end_dialog_return_key);
//        LeftLayoutC.leftToRight(valParams, R.id.charter_end_dialog_return_key);
//        MyTextView tvValBalance = MyTextView.create(constraintLayout, valParams);
//        tvValBalance.setId(R.id.charter_end_dialog_return_val);
//        tvValBalance.setTextSize(8);
//        tvValBalance.getPaint().setFakeBoldText(true);
//        tvValBalance.setText(charterMsg.getBackNum());
//        tvValBalance.setGravity(Gravity.CENTER_VERTICAL);
//        DrawableUtils.setLeftDrawable(tvValBalance, 9, R.drawable.coin);
//    }
//
//    private void initCharterCount(ConstraintLayout constraintLayout, CharterMsg charterMsg) {
//
//
//        ConstraintLayout.LayoutParams keyParams = ConstraintLayoutUtils.getLayoutParamsWW();
//        TopLayoutC.topToBottom(keyParams, R.id.charter_end_dialog_return_key);
//        LeftLayoutC.left(keyParams, R.id.charter_end_dialog_balance_key);
//        TopLayoutC.margin(keyParams, 2);
//
//        MyTextView tvKeyBalance = MyTextView.create(constraintLayout, keyParams);
//        tvKeyBalance.setId(R.id.charter_end_dialog_count_key);

//        tvKeyBalance.setTextSize(10);
//        tvKeyBalance.getPaint().setFakeBoldText(true);
//        tvKeyBalance.setTextColor(getContext().getColor(R.color.color_ffdb00));
//
//        ConstraintLayout.LayoutParams valParams = ConstraintLayoutUtils.getLayoutParamsWW();
//        TopLayoutC.top(valParams, R.id.charter_end_dialog_count_key);
//        LeftLayoutC.leftToRight(valParams, R.id.charter_end_dialog_count_key);
//        MyTextView tvValBalance = MyTextView.create(constraintLayout, valParams);
//
//        tvValBalance.setId(R.id.charter_end_dialog_count_val);
//        tvValBalance.setTextSize(10);
//        tvValBalance.getPaint().setFakeBoldText(true);
//        tvValBalance.setText(charterMsg.getSumNum());
//        tvValBalance.setGravity(Gravity.CENTER_VERTICAL);
//        tvValBalance.setTextColor(getContext().getColor(R.color.color_ffdb00));
//
//        DrawableUtils.setLeftDrawable(tvValBalance, 9, R.drawable.coin);
//
//    }
//
//
//    private void initTitle(ConstraintLayout constraintLayout) {
//
//
//        ConstraintLayout.LayoutParams layoutParamsWW = ConstraintLayoutUtils.getLayoutParamsWW();
//        TopLayoutC.top(layoutParamsWW);
//        TopLayoutC.margin(layoutParamsWW, 14);
//        LeftLayoutC.centerH(layoutParamsWW);
//
//        MyTextView textView = MyTextView.create(constraintLayout, layoutParamsWW);

//        textView.setTextSize(11);
//        textView.getPaint().setFakeBoldText(true);
//
//
//    }
//
//    @Override
//    public void initData() {
//
//    }
//}
