package com.daylong.arcx.view.home.titlenav;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.daylong.arcx.R;
import com.daylong.arcx.user.task.TaskActivity;

public class TaskItem extends TitleNavItem {
    public TaskItem(@NonNull Context context, FragmentManager fragmentManager) {
        super(context, fragmentManager);
    }

    @Override
    public int imgRegId() {
        return R.drawable.img_main_mission;
    }

    @Override
    public void onClick(View view) {
        TaskActivity.start(getContext(), TaskActivity.class);
    }
}
