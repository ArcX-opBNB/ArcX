package com.daylong.arcx.view.home.titlenav;

import android.content.Context;
import android.graphics.Color;

import androidx.fragment.app.FragmentManager;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.layout.LinearLayoutView;

public class HomeGroupNavView extends LinearLayoutView {
    public HomeGroupNavView(Context context ,FragmentManager fragmentManager) {
        super(context);

        setBackgroundColor(Color.WHITE);
        setLayoutParams(new ConstraintBuilder().mm().height(33).leftTop().topMargin(110).buildPayoutParams());

        setPadding(getSize(7),getSize(3),getSize(3),getSize(1));


        CheckInItem checkInItem = new CheckInItem(context,fragmentManager);

        TaskItem taskItem = new TaskItem(context,fragmentManager);
        InvitationItem invitationItem = new InvitationItem(context,fragmentManager);
        RechargeItem rechargeItem = new RechargeItem(context,fragmentManager);
        StoreItem storeItem = new StoreItem(context,fragmentManager);

        addView(checkInItem);
        addView(taskItem);
        addView(invitationItem);
        addView(rechargeItem);
        addView(storeItem);
    }
}
