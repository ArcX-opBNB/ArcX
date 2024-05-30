package com.daylong.arcx.user.backpack;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.daylong.arcx.R;
import com.daylong.arcx.act.BaseAxcActivity;
import com.daylong.arcx.home.frt.HomeTitleFragment;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;

public class BackpackActivity extends BaseAxcActivity {
    private RadioGroup radioGroup;


    @Override
    protected Integer getBackBgRegId() {
        return R.drawable.img_back_backpack;
    }

    private int rgId = View.generateViewId();

    @Override
    protected int getFrtToViewId() {
        return rgId;
    }

    private MyImageView ivContent;

    @Override
    protected void initView(ViewGroup rootView) {


        super.initView(rootView);
        ivContent = MyImageView.create(rootView, new ConstraintBuilder(0, 0).topToBottom(frameTitle).topMargin(6).bottomCenterH());
        ivContent.setBackgroundResource(R.drawable.img_backpack_nft);

        crateRadio();
    }

    public void crateRadio() {

        radioGroup = new RadioGroup(this);
        radioGroup.setLayoutParams(new ConstraintBuilder().mm().height(28).topToBottom(frameTitle).left().topMargin(6).buildPayoutParams());
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        radioGroup.setId(rgId);
        createRadioButton("NFT");
        createRadioButton("PROP");
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });
        addView(radioGroup);
    }

    private RadioButton createRadioButton(String name) {
        RadioButton button = new RadioButton(this);
        button.setText(name);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(0, AppUtil.getSize(28));
        layoutParams.leftMargin = AppUtil.getSize(1);
        layoutParams.weight = 1;
        button.setButtonDrawable(null);
        button.setLayoutParams(layoutParams);
        button.setId(View.generateViewId());

        button.setShadowLayer(AppUtil.getSize(3),0,AppUtil.getSize(1),getColor(R.color.color_ffba9620));
        radioGroup.addView(button);



        return button;
    }

}
