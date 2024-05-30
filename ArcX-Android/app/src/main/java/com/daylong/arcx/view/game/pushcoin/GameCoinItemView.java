package com.daylong.arcx.view.game.pushcoin;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.httplibrary.bean.response.game.GameMultiplier;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
import net.daylong.baselibrary.view.textview.NumTextView;


/**
 * u
 */
public class GameCoinItemView extends ConstraintLayout {
    public static GameCoinItemView create(ViewGroup viewGroup, GameMultiplier.MulTblnDTO vipLimitMsg) {

        GameCoinItemView gameCoinItemView = new GameCoinItemView(viewGroup.getContext(), vipLimitMsg);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(AppUtil.getSize(120), AppUtil.getSize(30));
        layoutParams.topMargin = AppUtil.getSize(6);
        gameCoinItemView.setLayoutParams(layoutParams);

        viewGroup.addView(gameCoinItemView);

        return gameCoinItemView;
    }

    private MyTextView multipleNumber;

    private GameMultiplier.MulTblnDTO vipLimitMsg;

    public GameCoinItemView(Context context, GameMultiplier.MulTblnDTO vipLimitMsg) {
        super(context);
        this.vipLimitMsg = vipLimitMsg;
        MyImageView bg = MyImageView.create(this, new ConstraintBuilder(120, 30).leftCenterV());
        bg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        bg.setImageResource(com.daylong.reglinrary.R.drawable.img_mch_game_push__select_coin_btn);

        multipleNumber = new MyTextView(getContext());
        multipleNumber.setId(View.generateViewId());
        multipleNumber.setGravity(Gravity.CENTER);
        multipleNumber.initText(10,net.daylong.daylongbase.R.color.color_333,true);
        multipleNumber.setLayoutParams(new ConstraintBuilder().ww().leftTop().leftTopMargin(63,7).buildPayoutParams());
        multipleNumber.setNum(vipLimitMsg.getMulAmt());
        addView(multipleNumber);


        if (vipLimitMsg.isFlg()) {

            

        }


    }

//    /**

//     *
//     * @param view
//     * @param level
//     */
//    public void show(View view, int level) {
//
//        PopupWindow popupWindow = new PopupWindow(getContext());
//
//
//        AssetsImageView contentView = new AssetsImageView(BaseApplication.getInstance().getContext());
//        contentView.setLayoutParams(new ViewGroup.LayoutParams(AppUtil.getSize(37), AppUtil.getSize(26)));
//
//        contentView.setBackgroundResource(R.drawable.ic_coin_vip_bg);
//        contentView.setPadding(AppUtil.getSize(7), AppUtil.getSize(4), AppUtil.getSize(5), AppUtil.getSize(5));
//
//        contentView.setImageReg(LevelImageCreateUtils.getVipLevelImgBg(level));
//
//
//        popupWindow.setContentView(contentView);
//
//        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//        popupWindow.setTouchable(true);
//        popupWindow.setOutsideTouchable(false);
//        popupWindow.setFocusable(true);

//        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//

//        int[] location = new int[2];
//        view.getLocationOnScreen(location);
//
//        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, location[0] + AppUtil.getSize(18), location[1] + AppUtil.getSize(7));
//    }


    public int getNum() {
        return vipLimitMsg != null ? vipLimitMsg.getMulAmt() : 0;
    }
}
