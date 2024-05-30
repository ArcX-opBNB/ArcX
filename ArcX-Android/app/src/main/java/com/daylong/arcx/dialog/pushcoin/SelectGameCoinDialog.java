package com.daylong.arcx.dialog.pushcoin;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.daylong.arcx.R;
import com.daylong.arcx.view.game.pushcoin.GameCoinItemView;
import com.daylong.basecache.GameCache;
import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.gamelibrary.request.operate.StartGameRequest;
import com.daylong.httplibrary.bean.response.game.GameMultiplier;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.gamesocket.mrg.WebSocketMrg;

public class SelectGameCoinDialog extends BaseFragmentDialog {

    @Override
    protected boolean isWinDismiss() {
        return true;
    }

    public static void showDialog(FragmentManager manager, GameMultiplier coinMultiMsg) {
        SelectGameCoinDialog cardChildInfoDialog = new SelectGameCoinDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("CoinMultiMsg", coinMultiMsg);
        cardChildInfoDialog.setArguments(bundle);
        cardChildInfoDialog.show(manager, cardChildInfoDialog.toString());
        GameCache.setGameMultiplier(0);
    }


    private GameMultiplier coinMultiMsg;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BaseGameActivity activity = (BaseGameActivity) getActivity();
            if (activity != null) {
                activity.showLoadingDialog();
                GameCache.setGameMultiplier(((GameCoinItemView) v).getNum());
                WebSocketMrg.getInstance().sendMsg(new StartGameRequest());
                dismiss();
            }
            
        }
    };


    @Override
    protected ViewGroup getContentLayout() {
        return new ConstraintBuilder(152, 175).center().build(getContext());
    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {

    }


    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);
        coinMultiMsg = (GameMultiplier) getArguments().getSerializable("CoinMultiMsg");
        contentView.setBackgroundResource(R.drawable.img_mch_alert);
        createLayoutBg(contentView);
    }

    private void createLayoutBg(ViewGroup rootView) {

        createContent(rootView);
        createBtnBack(rootView);
    }

    private void createContent(ViewGroup rootView) {



        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.setLayoutParams(new ConstraintBuilder().mm0().center().topMargin(13).bottomMargin(19).buildPayoutParams());
        for (GameMultiplier.MulTblnDTO mulTblnDTO : coinMultiMsg.getMulTbln()) {

            GameCoinItemView gameCoinItemView = GameCoinItemView.create(linearLayout, mulTblnDTO);
            if (!mulTblnDTO.isFlg()) {
                gameCoinItemView.setOnClickListener(onClickListener);
            }

        }

        rootView.addView(linearLayout);

    }

    private void createBtnBack(ViewGroup rootView) {


    }

    @Override
    public void initData() {

    }
}
