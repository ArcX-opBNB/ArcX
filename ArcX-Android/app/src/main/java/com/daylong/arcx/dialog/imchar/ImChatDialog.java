//package com.daylong.arcx.dialog.imchar;
//
//import android.view.View;
//import android.widget.FrameLayout;
//import android.widget.ImageButton;
//
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.constraintlayout.widget.Constraints;
//import androidx.fragment.app.FragmentManager;
//
//
//import com.daylong.arcx.R;
//
//import net.daylong.baselibrary.base.dialog.BaseDialog;
//import net.daylong.baselibrary.dialog.BaseFragmentDialog;
//import net.daylong.baselibrary.utils.sys.AppUtil;
//import net.daylong.baselibrary.utils.ui.layout.cl.BottomLayoutC;
//import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
//import net.daylong.baselibrary.utils.ui.layout.cl.LeftLayoutC;
//import net.daylong.baselibrary.utils.ui.layout.cl.RightLayoutC;
//import net.daylong.baselibrary.utils.ui.layout.cl.TopLayoutC;
//
//public class ImChatDialog extends BaseFragmentDialog {
//
//    @Override
//    protected boolean isWinDismiss() {
//        return false;
//    }
//
//    public static void showDialog(FragmentManager fragmentManager) {
//
//        ImChatDialog imChatDialog = new ImChatDialog();
//
//        imChatDialog.show(fragmentManager, "imChatDialog");
//    }
//
//    @Override
//    protected int getAnimStyle() {
//        return AppUtil.isHorizontal() ? net.daylong.daylongbase.R.style.right_dialog_anim : net.daylong.daylongbase.R.style.give_gift_dialog_anim;
//    }
//
//    @Override
//    public void initView(ConstraintLayout rootView, BaseDialog dialog) {
//        boolean horizontal = AppUtil.isHorizontal();
//
//
//        ConstraintLayout.LayoutParams layoutParamsMM0 = new Constraints.LayoutParams(horizontal ? AppUtil.getSize(188) : 0, 0);
//
//        if (!horizontal) {
//            TopLayoutC.margin(layoutParamsMM0, 46);
//            LeftLayoutC.leftTop(layoutParamsMM0);
//        } else {
//            TopLayoutC.top(layoutParamsMM0);
//        }
//
//        RightLayoutC.right(layoutParamsMM0);
//        BottomLayoutC.bottom(layoutParamsMM0);
//        FrameLayout frameLayout = new FrameLayout(getContext());
//        frameLayout.setLayoutParams(layoutParamsMM0);
//        frameLayout.setId(View.generateViewId());
//        rootView.addView(frameLayout);
//
//        frameLayout.setBackgroundResource(R.drawable.ic_im_service_bg);
//        addFragment(new NewImChatFragment(), R.id.im_chat_frt, "NewImChatFragment");
//        createBack();
//    }
//
//    private void createBack() {
//        ImageButton imageButton = new ImageButton(getContext());
//        imageButton.setBackgroundResource(R.drawable.btn_back_x);
//
//        ConstraintLayout.LayoutParams winLayoutParamsLT = ConstraintLayoutUtils.getWinLayoutParams(15, 15);
//        TopLayoutC.top(winLayoutParamsLT, R.id.im_chat_frt);
//        RightLayoutC.right(winLayoutParamsLT, R.id.im_chat_frt);
//        RightLayoutC.margin(winLayoutParamsLT, 8);
//        TopLayoutC.margin(winLayoutParamsLT, 8);
//
//        imageButton.setLayoutParams(winLayoutParamsLT);
//        imageButton.setId(R.id.msg_im_chat_btn_delete);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
//        addView(imageButton);
//
//    }
//
//    @Override
//    public void initData() {
//
//    }
//}
