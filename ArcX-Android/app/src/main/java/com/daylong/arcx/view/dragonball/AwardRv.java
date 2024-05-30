package com.daylong.arcx.view.dragonball;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.arcx.adapter.AwardAdapter;
import com.daylong.httplibrary.bean.AwardBean;

import net.daylong.baselibrary.view.recycler.HorizontalRecyclerView;

import java.util.List;

public class AwardRv extends HorizontalRecyclerView {
    private AwardAdapter awardAdapter;

    public AwardRv(@NonNull Context context) {
        super(context);


        awardAdapter = new AwardAdapter();

        setAdapter(awardAdapter);
    }

    public void setData(List<AwardBean> awardBeans) {
        awardAdapter.setList(awardBeans);
    }
}
