package com.daylong.arcx.view.user.order.group;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.daylong.arcx.user.order.frt.MyPendingItemsFragment;
import com.daylong.arcx.user.order.frt.SendGoodsFragment;

import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.frt.BaseFragment;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;


public class OrderGroupView extends RadioGroup implements RadioGroup.OnCheckedChangeListener {

    private TaskRadioBtn taskWeek;
    private TaskRadioBtn taskDay;

    public static OrderGroupView create(ViewGroup viewGroup, BaseActivity activity) {

        OrderGroupView taskGroup = new OrderGroupView(viewGroup.getContext());
        taskGroup.init(activity);

        taskGroup.setLayoutParams(new ConstraintBuilder(90, 30).top().centerHorizontally().buildPayoutParams());
        viewGroup.addView(taskGroup);

        return taskGroup;

    }


    public OrderGroupView(Context context) {
        super(context);
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
        setId(View.generateViewId());

        taskDay.setId(net.daylong.daylongbase.R.id.base_view_1);


        taskWeek.setId(net.daylong.daylongbase.R.id.base_view_2);
        taskDay.setChecked(true);
        setOnCheckedChangeListener(this);


    }


    private BaseActivity activity;

    public void init(BaseActivity activity) {

        this.activity = activity;

        getFragment(net.daylong.daylongbase.R.id.base_view_1);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        getFragment(checkedId);
    }


    private BaseFragment fragment;
    private int tabCurrent;

    public void getFragment(int checkedId) {
        

        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        fragment = (BaseFragment) fragmentManager.findFragmentByTag(checkedId + "");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment == null) {
            
            if (checkedId == net.daylong.daylongbase.R.id.base_view_1) {
                fragment = new MyPendingItemsFragment();

            } else {
                fragment = new SendGoodsFragment();
            }
            fragmentTransaction.add(net.daylong.daylongbase.R.id.base_frt, fragment, checkedId + "");
        } else {
            fragmentTransaction.show(fragment);
            fragment.onFragmentEnter();
        }
        
        BaseFragment CurrentFragment = (BaseFragment) fragmentManager.findFragmentByTag(tabCurrent + "");
        if (tabCurrent != 0 && CurrentFragment != null && tabCurrent != checkedId) {
            fragmentTransaction.hide(CurrentFragment);
            if (CurrentFragment != null) {
                CurrentFragment.onFragmentExit();
            }
        }
        fragmentTransaction.commitAllowingStateLoss();

        tabCurrent = checkedId;
    }
}
