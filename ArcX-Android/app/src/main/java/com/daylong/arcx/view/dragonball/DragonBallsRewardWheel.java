package com.daylong.arcx.view.dragonball;

import android.content.Context;
import android.util.AttributeSet;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.game.dragon.DragonBallRewardBean;
import com.daylong.musiclibrary.emums.MediaPlayerType;

import net.daylong.baselibrary.utils.sys.AppUtil;


import java.util.ArrayList;
import java.util.List;

public class DragonBallsRewardWheel extends ConstraintLayout {

    private List<DragonBallsRewardItemView> dragonBallsRewardItemViews = new ArrayList<DragonBallsRewardItemView>();

    public DragonBallsRewardWheel(Context context) {
        this(context, null);
    }

    public DragonBallsRewardWheel(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragonBallsRewardWheel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }


    
    private List<DragonBallRewardBean.DragonTrainAwardMsgDTO.IconAwardListDTO> iconAwardList;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            startRun();
        }
    };

    private void init(List<String> listCoin) {

        for (int i = 0; i < listCoin.size(); i++) {

            DragonBallsRewardItemView title = createTitle(i);
            if (title != null) {
                title.setPath(listCoin.get(i));
            }

            DragonBallsRewardItemView right = createRight(i);

            if (right != null) {
                right.setPath(listCoin.get(i));
            }

            DragonBallsRewardItemView bottom = createBottom(i);
            if (bottom != null) {
                bottom.setPath(listCoin.get(i));
            }

            DragonBallsRewardItemView left = createLeft(i);

            if (left != null) {
                left.setPath(listCoin.get(i));
            }
        }


        postDelayed(runnable, 2500);

    }

    private DragonBallsRewardItemView createTitle(int position) {


        if (position < 5) {
            DragonBallsRewardItemView item = createItem(position);
            LayoutParams layoutParams = (LayoutParams) item.getLayoutParams();
            layoutParams.leftToLeft = LayoutParams.PARENT_ID;
            layoutParams.topToTop = LayoutParams.PARENT_ID;

            if (position != 0) {
                int left = position * (DragonBallsRewardItemView.SELECT_IMG_SIZE + 3);
                layoutParams.leftMargin = AppUtil.getSize(left);
                item.setLayoutParams(layoutParams);
            }

            addView(item);

            return item;
        }
        return null;
    }

    private DragonBallsRewardItemView createRight(int position) {
        if (position > 4 && position < 9) {
            DragonBallsRewardItemView item = createItem(position);
            LayoutParams layoutParams = (LayoutParams) item.getLayoutParams();
            layoutParams.leftToLeft = 4;
            layoutParams.topToTop = LayoutParams.PARENT_ID;

            layoutParams.topMargin = AppUtil.getSize((position - 4) * (DragonBallsRewardItemView.SELECT_IMG_SIZE + 3));
            item.setLayoutParams(layoutParams);


            addView(item);

            return item;
        }
        return null;

    }

    private DragonBallsRewardItemView createBottom(int position) {
        if (position > 8 && position < 13) {
            DragonBallsRewardItemView item = createItem(position);
            LayoutParams layoutParams = (LayoutParams) item.getLayoutParams();
            layoutParams.rightToRight = 8;
            layoutParams.bottomToBottom = 8;

            layoutParams.rightMargin = AppUtil.getSize((position - 8) * (DragonBallsRewardItemView.SELECT_IMG_SIZE + 3));
            item.setLayoutParams(layoutParams);


            addView(item);

            return item;
        }


        return null;
    }

    private DragonBallsRewardItemView createLeft(int position) {

        if (position > 12 && position < 16) {
            DragonBallsRewardItemView item = createItem(position);
            LayoutParams layoutParams = (LayoutParams) item.getLayoutParams();
            layoutParams.leftToLeft = LayoutParams.PARENT_ID;
            layoutParams.bottomToBottom = 8;

            layoutParams.bottomMargin = AppUtil.getSize((position - 12) * (DragonBallsRewardItemView.SELECT_IMG_SIZE + 3));
            item.setLayoutParams(layoutParams);

            addView(item);

            return item;
        }

        return null;
    }


    private DragonBallsRewardItemView createItem(int position) {


        LayoutParams params = new LayoutParams(AppUtil.getSize(30), AppUtil.getSize(30));
        DragonBallsRewardItemView dragonBallsRewardItemView = new DragonBallsRewardItemView(getContext());
        dragonBallsRewardItemView.setLayoutParams(params);
        dragonBallsRewardItemView.setId(position);
        dragonBallsRewardItemViews.add(dragonBallsRewardItemView);

        return dragonBallsRewardItemView;

    }

    private ArrayList<AwardBean> awardMsg;

    public void initData(DragonBallRewardBean reward) {


        DragonBallRewardBean.DragonTrainAwardMsgDTO dragonTrainAwardMsg = reward.getDragonTrainAwardMsg();

        if (dragonTrainAwardMsg == null) {
            return;
        }


        awardMsg = dragonTrainAwardMsg.getEarnArr();
        
        List<String> iconList = dragonTrainAwardMsg.getIconList();

        
        iconAwardList = dragonTrainAwardMsg.getIconAwardList();

        if (iconList != null && iconList.size() > 0) {
            init(iconList);
        }
    }


    private int runNum = 0;
    private Integer endPosition = null;
    private Integer currentPosition = 0;

    private boolean isPlay = true;

    public void startRun() {

        int i = currentPosition % dragonBallsRewardItemViews.size();
        if (isPlay) {
            isPlay = false;
            MediaPlayerType.SHOW_BALL_MALI_RUN.play();

        }
        
        if (endPosition == null) {
            
            DragonBallRewardBean.DragonTrainAwardMsgDTO.IconAwardListDTO iconAwardListDTO = iconAwardList.get(runNum);
            Integer awardIndex = iconAwardListDTO.getAwardIndex();

            endPosition = (16 * 3) - i + awardIndex;

        }

        if (endPosition >= 0) {
            if (endPosition == 0) {
                removeCallbacks(runnable);
                dragonBallsRewardItemViews.get(i).selected(false);
                endPosition = null;
                runNum++;
                if (runNum < iconAwardList.size()) {
                    endPosition = null;
                    isPlay = true;
                    MediaPlayerType.SHOW_BALL_MALI_RUN.stop();
                    postDelayed(runnable, 2000);

                } else {
                    if (awardMsg != null) {
                        if (onEndListener != null) {
                            onEndListener.end(awardMsg);
                        }
                    }
                }

            } else {

                dragonBallsRewardItemViews.get(currentPosition % dragonBallsRewardItemViews.size()).selected(true);
                postDelayed(runnable, 20);
                currentPosition++;
                endPosition--;
            }


        }

    }

    private OnEndListener onEndListener;

    public void setOnEndListener(OnEndListener onEndListener) {
        this.onEndListener = onEndListener;
    }

    public interface OnEndListener {

        void end(ArrayList<AwardBean> awardMsg);
    }

}
