//package com.daylong.arcx.dialog.imchar;
//
//import android.graphics.Color;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.fragment.app.FragmentManager;
//
//
//import com.daylong.arcx.R;
//
//import net.daylong.baselibrary.base.dialog.BaseDialog;
//import net.daylong.baselibrary.dialog.BaseFragmentDialog;
//import net.daylong.baselibrary.utils.sys.AppUtil;
//import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
//import net.daylong.baselibrary.view.textview.MyTextView;
//
//public class ServiceChatDialog extends BaseFragmentDialog {
//
//    @Override
//    protected boolean isWinDismiss() {
//        return false;
//    }
//
//    public static void showDialog(FragmentManager fragmentManager) {
//
//        ServiceChatDialog imChatDialog = new ServiceChatDialog();
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
//    protected ViewGroup getContentLayout() {
//        ConstraintBuilder constraintBuilder = new ConstraintBuilder(188, AppUtil.isHorizontal() ? 188 : 336);
//        if (AppUtil.isHorizontal()) {
//
//            constraintBuilder.rightBottom();
//        } else {
//            constraintBuilder.leftBottom();
//
//        }
//        return constraintBuilder.build(getContext());
//    }
//
//    @Override
//    public void initView(ConstraintLayout rootView, BaseDialog dialog) {
//
//
//        FrameLayout frameLayout = new FrameLayout(getContext());
//        frameLayout.setLayoutParams(new ConstraintBuilder().mm0().buildPayoutParams());
//        frameLayout.setId(View.generateViewId());
//        contentView.addView(frameLayout);
//
//        frameLayout.setBackgroundResource(R.drawable.ic_im_service_bg);
//        addFragment(new ServiceImCharFragment(), R.id.im_chat_frt, "ServiceImCharFragment");
//        createBack();
//
//        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().height(9).topMargin(9).topCenterH());

//
//    }
//
//    private void createBack() {
//
//
//
//        ConstraintBuilder constraintBuilder = new ConstraintBuilder(22);
//
//        if (AppUtil.isHorizontal()) {
//            constraintBuilder.top(contentView.getId()).right(contentView);
//
//        } else {
//            View view = new View(getContext());
//
//            view.setLayoutParams(new ConstraintBuilder(10, 10).top(R.id.base_content_id).right(R.id.base_content_id).
//                    topMargin(11).rightMargin(3).buildPayoutParams());
//            view.setId(View.generateViewId());
//            view.setBackgroundColor(Color.TRANSPARENT);
//            addView(view);
//            constraintBuilder.bottomToTop(view.getId()).right(view);
//        }
//
//        DialogBackBtn.create(rootView, constraintBuilder, this);
//
//    }
//
//    @Override
//    public void initData() {
//
//    }
//}
