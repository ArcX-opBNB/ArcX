package com.daylong.arcx.view.user;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.MyProgressBar;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

import java.util.List;

/**

 */
public class UserAttributeItemView extends ConstraintLayoutView {


    private MyProgressBar myProgressBar;
    private MyImageView ivUpdateLevel;
    private MyImageView ivIcon;
    MyTextView tvLevel;


    public UserAttributeItemView(@NonNull Context context) {
        super(context);
        setLayoutParams(new ConstraintBuilder(73, 82).leftTop().buildPayoutParams());


        int iconId = View.generateViewId();
        MyImageView.create(this, new ConstraintBuilder(73, 67).leftBottom(), R.drawable.img_u_a_i_bg);

        tvLevel = MyTextView.create(this, new ConstraintBuilder().ww().centerH().topToBottom(iconId).topMargin(6));
        tvLevel.initText(8, net.daylong.daylongbase.R.color.color_333, true);


        myProgressBar = MyProgressBar.create(this, new ConstraintBuilder(62, 13).bottomCenterH().bottomMargin(5)
                , null, true, 7f, R.color.color_white);
        myProgressBar.getPDText().setShadowLayer(AppUtil.getSize(3), 0, 0, R.color.color_000000);
        ivUpdateLevel = MyImageView.create(this, new ConstraintBuilder(10, 11).centerV(myProgressBar).right().rightMargin(4), R.drawable.img_u_i_l);
        ivIcon = MyImageView.create(this, new ConstraintBuilder(50, 41).topCenterH());
        ivIcon.setId(iconId);
    }

    public void setData(LoginUserInfoResponse.AtbTblnDTO atbTblnDTO) {
        tvLevel.setText(atbTblnDTO.getLevel());
        ivUpdateLevel.setVisibility(atbTblnDTO.showLevel());
        myProgressBar.setProgressRegId(atbTblnDTO.getPdRegId());
        myProgressBar.setProgress(atbTblnDTO.getPd(), atbTblnDTO.getPdStr());
        ivIcon.setImageReg(atbTblnDTO.getIconRegId());
    }
}
