package com.daylong.arcx.view.btn;

import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.basecache.GameCache;
import com.daylong.gamelibrary.request.charter.CharterGameRequest;
import com.daylong.httplibrary.bean.request.PayRequest;
import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;
import com.daylong.httplibrary.bean.response.game.charter.UserCharterInfoResponse;
import com.daylong.arcx.R;
import com.daylong.arcx.dialog.PayDialog;
import com.daylong.arcx.enums.CharterType;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.gamesocket.mrg.WebSocketMrg;

public class CharterPayBtn extends BaseButton implements View.OnClickListener {

    private CharterDescResponse.CommodityListDTO commodityListDTO;
    private UserCharterInfoResponse charterInfoResponse;


    private PayRequest payRequest;

    public void setCommodityListDTO(CharterDescResponse.CommodityListDTO commodityListDTO) {
        this.commodityListDTO = commodityListDTO;
        payRequest = new PayRequest(2, GameCache.getGameRoomId(), commodityListDTO.getCommodityId(), -1, "");
        setText(commodityListDTO.getBtnStr());
    }

    public void setCharterInfoResponse(UserCharterInfoResponse charterInfoResponse) {
        this.charterInfoResponse = charterInfoResponse;
    }

    private CharterType charterType;

    private BaseActivity activity;

    public CharterPayBtn(@NonNull BaseActivity activity, CharterType charterType, int id) {
        super(activity);
        this.charterType = charterType;
        this.activity = activity;

        ConstraintBuilder constraintBuilder = new ConstraintBuilder(64, 27).topToBottom(id);
        if (charterType == CharterType.CHARTER_348) {
            constraintBuilder.left().leftTopMargin(13, 16);
        } else {
            constraintBuilder.right().topRightMargin(16, 13);
        }
        setPadding(0, AppUtil.getSize(4), 0, 0);
        setGravity(Gravity.CENTER_HORIZONTAL);
        setOnClickListener(this);
        setBackgroundResource(R.drawable.img_mch_btn);
        initBtn(10, R.color.color_white, true);
        setLayoutParams(constraintBuilder.buildPayoutParams());

    }

    @Override
    public void onClick(View view) {
        if (charterInfoResponse != null) {

            Boolean startCharter = charterInfoResponse.isStartCharter(charterType.getId());


            
            if (startCharter) {
                WebSocketMrg.getInstance().sendMsg(new CharterGameRequest(commodityListDTO.getCommodityId()));
                if (onCharterPayListener != null) {
                    onCharterPayListener.onPaySuc();
                }
            } else {

                PayDialog.show(activity, payRequest);

            }
        }
    }

    private OnCharterPayListener onCharterPayListener;

    public void setOnCharterPayListener(OnCharterPayListener onCharterPayListener) {
        this.onCharterPayListener = onCharterPayListener;
    }

    public interface OnCharterPayListener {
        void onPaySuc();
    }
}
