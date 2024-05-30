package com.daylong.arcx.dialog.charter;//package com.daylong.gamelibrary.dialog.charter;
//
//import android.os.Bundle;
//import android.view.Gravity;
//import android.view.View;
//
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.fragment.app.FragmentManager;
//
//import com.daylong.Metapusher.game.R;
//import com.daylong.Metapusher.game.act.base.BaseGameActivity;
//
//import net.daylong.baselibrary.base.dialog.BaseDialog;
//import net.daylong.baselibrary.utils.sys.AppUtil;
//import net.daylong.baselibrary.utils.ui.layout.cl.BottomLayoutC;
//import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
//import net.daylong.baselibrary.utils.ui.layout.cl.LeftLayoutC;
//import net.daylong.baselibrary.utils.ui.layout.cl.TopLayoutC;
//import net.daylong.baselibrary.view.btn.BaseButton;
//import net.daylong.baselibrary.view.textview.MyTextView;
//import net.daylong.metapusherbaselibrary.dialog.BaseFragmentDialog;
//
///**

// */
//public class ExitArcadeGameDialog extends BaseFragmentDialog {
//
//
//    public static void showDialog(FragmentManager fragmentManager) {
//        ExitArcadeGameDialog funCardDialog = new ExitArcadeGameDialog();
//        Bundle bundle = new Bundle();
//        funCardDialog.setArguments(bundle);
//        if (funCardDialog.getDialog() == null || !funCardDialog.getDialog().isShowing()) {
//            funCardDialog.show(fragmentManager, funCardDialog.toString());
//        }
//    }
//
//    @Override
//    public void initView(ConstraintLayout rootView, BaseDialog dialog) {
//
//        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(136, 104);
//        ConstraintLayoutUtils.center(winLayoutParams);
//
//        ConstraintLayout constraintLayout = new ConstraintLayout(getContext());
//        constraintLayout.setLayoutParams(winLayoutParams);
//        initTitle(constraintLayout);
//
//        constraintLayout.setPadding(AppUtil.getSize(24), AppUtil.getSize(24), AppUtil.getSize(24), AppUtil.getSize(16));
//        constraintLayout.setBackgroundResource(R.drawable.ic_chart_dialog_bg);
//
//
//        initConfirmBtn(constraintLayout);
//        rootView.addView(constraintLayout);
//    }
//
//    private void initConfirmBtn(ConstraintLayout constraintLayout) {
//
//
//        ConstraintLayout.LayoutParams layoutParams = ConstraintLayoutUtils.getLayoutParams(48, 22);
//        BottomLayoutC.bottom(layoutParams);
//        LeftLayoutC.centerH(layoutParams);
//
//        BaseButton button = BaseButton.create(constraintLayout, layoutParams);

//        button.setTextColor(getContext().getColor(R.color.color_333));
//        button.setGravity(Gravity.CENTER);
//        button.setBackgroundResource(R.drawable.ic_dialog_default_btn_bg);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((BaseGameActivity) getActivity()).exitRoom();
//                ((BaseGameActivity) getActivity()). finish();
//            }
//        });
//
//
//    }
//
//
//    private void initTitle(ConstraintLayout constraintLayout) {
//
//
//        ConstraintLayout.LayoutParams layoutParamsWW = ConstraintLayoutUtils.getLayoutParamsWW();
//        TopLayoutC.top(layoutParamsWW);
//        TopLayoutC.margin(layoutParamsWW, 6);
//        LeftLayoutC.centerH(layoutParamsWW);
//
//        MyTextView textView = MyTextView.create(constraintLayout, layoutParamsWW);

//        textView.setTextSize(8);
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
