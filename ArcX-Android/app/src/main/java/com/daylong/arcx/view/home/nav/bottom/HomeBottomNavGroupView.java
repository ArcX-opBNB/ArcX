package com.daylong.arcx.view.home.nav.bottom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.backpack.BackpackHomeActivity;
import com.daylong.arcx.dialog.store.StoreDialog;
import com.daylong.arcx.user.backpack.BackpackActivity;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.layout.LinearLayoutView;

public class HomeBottomNavGroupView extends LinearLayoutView implements MyBtn.OnImageClickListener {
    private BaseActivity activity;

    public HomeBottomNavGroupView(BaseActivity activity) {
        super(activity);
        this.activity = activity;
        setLayoutParams(new ConstraintBuilder().mm().height(52).leftBottom().buildPayoutParams());
        setOrientation(HORIZONTAL);

        crateBtn(R.drawable.img_b_nav_store, this, net.daylong.daylongbase.R.id.base_view_1);
        crateBtn(R.drawable.img_b_nav_card, this, net.daylong.daylongbase.R.id.base_view_2);


        ConstraintLayout homeLayout = new ConstraintBuilder(38, 52).build(getContext());
        homeLayout.setBackgroundResource(R.drawable.img_b_nav_home_bg);
        MyImageView.create(homeLayout, new ConstraintBuilder(22, 7).bottomCenterH().bottomMargin(10), R.drawable.img_b_nav_home_name);


        MyBtn.create(homeLayout, new ConstraintBuilder(38).topMargin(3), R.drawable.img_b_nav_home, null);

        addView(homeLayout);

        crateBtn(R.drawable.img_b_nav_backpack, this, net.daylong.daylongbase.R.id.base_view_4);
        crateBtn(R.drawable.img_b_nav_vs, this, net.daylong.daylongbase.R.id.base_view_5);
    }


    public void crateBtn(int regId, MyBtn.OnImageClickListener onImageClickListener, int id) {
        crateBtn(regId, onImageClickListener, null, id);
    }


    public void crateBtn(int regId, MyBtn.OnImageClickListener onImageClickListener, ViewGroup.LayoutParams params, int id) {

        MyBtn myBtn = new MyBtn(getContext());
        if (params == null) {
            LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(AppUtil.getSize(38), AppUtil.getSize(38));
            layout.weight = 1;
            layout.topMargin = AppUtil.getSize(3);
            params = layout;
        }

        myBtn.setLayoutParams(params);
        myBtn.setBackgroundResource(regId);
        myBtn.setOnImageClickListener(onImageClickListener);
        myBtn.setId(id);
        addView(myBtn);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (activity == null) {
            return;
        }

        if (id == net.daylong.daylongbase.R.id.base_view_1) {
            StoreDialog.showDialog(activity.getSupportFragmentManager());
        } else if (id == net.daylong.daylongbase.R.id.base_view_4) {
            BackpackActivity.start(activity, BackpackActivity.class);
        }
    }
}

