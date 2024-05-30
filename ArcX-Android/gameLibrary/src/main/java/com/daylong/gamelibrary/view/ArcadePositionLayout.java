package com.daylong.gamelibrary.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.bean.GameInfoBean;
import com.daylong.gamelibrary.cache.UserCache;
import com.daylong.gamelibrary.meuns.GameStatus;
import com.daylong.gamelibrary.view.btn.arcade.ArcadePositionView;
import com.daylong.gamelibrary.view.btn.service.IStartBtn;
import com.daylong.httplibrary.bean.ArcadePositionBean;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

import java.util.List;

/**

 */
public class ArcadePositionLayout extends IStartBtn {
    private LinearLayout layout;

    public ArcadePositionLayout(@NonNull Context context) {
        super(context);
        setLayoutParams(new ConstraintBuilder().mm().height(30).leftBottom().bottomMargin(42).buildPayoutParams());

        layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setLayoutParams(new ConstraintBuilder().mm().buildPayoutParams());
        layout.setGravity(Gravity.CENTER_VERTICAL);
        addView(layout);
    }

    public void addArcadePosition(GameStatus iGameStatus, List<ArcadePositionBean> postions) {


        int visibility = getVisibility();
        if (iGameStatus == GameStatus.GAME) {
            if (visibility != View.GONE) {
                setVisibility(View.GONE);
            }
        } else {
            if (visibility != View.VISIBLE) {
                setVisibility(View.VISIBLE);
            }
        }
        if (layout.getChildCount() <= 0) {
            addView(postions);
        } else {
            int childCount = layout.getChildCount();
            int childCount2 = postions.size();
            MyLogUtil.e("rag==>" + "childCount:" + childCount + "<childCount2>" + childCount2);
            if (layout.getChildCount() != postions.size()) {
                
                removeAllViews();
                addView(postions);
            }
            for (int i = 0; i < postions.size(); i++) {
                ArcadePositionView arcadePositionView = (ArcadePositionView) layout.getChildAt(i);
                arcadePositionView.setData(postions.get(i));
            }
        }
    }


    private void addView(List<ArcadePositionBean> postions) {
        for (int i = 0; i < postions.size(); i++) {
            ArcadePositionBean gamePostion = postions.get(i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            layoutParams.weight = 1;
            ArcadePositionView arcadePositionView = new ArcadePositionView(getContext());
            arcadePositionView.setLayoutParams(layoutParams);
            arcadePositionView.setData(gamePostion);
            layout.addView(arcadePositionView);
        }
    }

    public boolean isMeStartGame(List<ArcadePositionBean> postions) {


        boolean isMe = false;
        try {
            if (postions != null && postions.size() > 0) {
                for (ArcadePositionBean postion : postions) {
                    UserInfoResponse userMsg = postion.getUserInfoResponse();
                    if (userMsg != null) {
                        if (userMsg.getUserId() == UserCache.getUserId()) {
                            isMe = true;
                        }
                        break;
                    }

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return isMe;
    }


    @Override
    public void setData(GameInfoBean gameInfoBean) {
        
        addArcadePosition(gameInfoBean.getGameStatus(UserCache.getUserId()), gameInfoBean.getStreeList());

    }
}
