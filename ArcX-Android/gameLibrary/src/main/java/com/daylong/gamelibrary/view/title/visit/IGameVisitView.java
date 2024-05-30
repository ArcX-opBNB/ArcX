package com.daylong.gamelibrary.view.title.visit;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.gamelibrary.meuns.GameStatus;
import com.daylong.gamelibrary.view.title.IGameUserView;
import com.daylong.gamelibrary.view.title.IUserGameBalance;
import com.daylong.gamelibrary.view.title.visit.adapter.GameVisitAdapter;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.view.layout.LinearLayoutView;
import net.daylong.baselibrary.view.recycler.BaseRecyclerView;
import net.daylong.baselibrary.view.recycler.HorizontalRecyclerView;

import java.util.List;

public abstract class IGameVisitView extends LinearLayoutView {


    ;

    //    private MyTextView myTextView;
    private GameVisitAdapter gameVisitAdapter;

    public IGameVisitView(@NonNull Context context) {
        super(context);

        setGravity(Gravity.RIGHT);
//        myTextView = MyTextView.create(this, new ConstraintBuilder(15));
//        myTextView.initText(6, net.daylong.daylongbase.R.color.color_main, true);
//        myTextView.setGravity(Gravity.CENTER);
//        myTextView.setBackgroundResource(net.daylong.daylongbase.R.drawable.shape_oval_r_30_c_80000);


        BaseRecyclerView baseRecyclerView = new HorizontalRecyclerView(getContext());
        baseRecyclerView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        gameVisitAdapter = new GameVisitAdapter();
        baseRecyclerView.setAdapter(gameVisitAdapter);
        addView(baseRecyclerView);
    }


    public void setList(GameStatus gameStatus, IGameUserView gameUserView, IUserGameBalance userGameBalance, List<UserInfoResponse> list) {

        gameVisitAdapter.setList(list);
        if (list != null && list.size() > 0) {
            setVisibility(View.VISIBLE);
//            myTextView.setVisibility(list.size() > 0 ? View.VISIBLE : View.GONE);

        } else {
            setVisibility(View.GONE);

            return;
        }

//
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        
        if (gameStatus == GameStatus.OTHER) {
            layoutParams.leftToRight = net.daylong.daylongbase.R.id.base_view_4;

        } else {
            layoutParams.leftToRight = net.daylong.daylongbase.R.id.base_view_2;
        }
        setLayoutParams(layoutParams);
    }

}
