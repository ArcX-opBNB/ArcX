package com.daylong.arcx.user.address;

import android.content.Intent;
import android.graphics.Color;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.response.user.MyAddressResponse;
import com.daylong.httplibrary.model.contract.user.MyAddressEditContract;
import com.daylong.httplibrary.model.model.user.MyAddressEditModel;
import com.daylong.httplibrary.model.presenter.user.MyAddressEditPresenter;
import com.daylong.arcx.R;
import com.daylong.arcx.view.check.DefaultCheckBox;
import com.github.gzuliyujiang.wheelpicker.AddressPicker;
import com.github.gzuliyujiang.wheelpicker.annotation.AddressMode;
import com.github.gzuliyujiang.wheelpicker.contract.OnAddressPickedListener;
import com.github.gzuliyujiang.wheelpicker.entity.CityEntity;
import com.github.gzuliyujiang.wheelpicker.entity.CountyEntity;
import com.github.gzuliyujiang.wheelpicker.entity.ProvinceEntity;

import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.textview.MyTextView;

public class NewAddressActivity extends BaseMvpActivity<MyAddressEditPresenter, MyAddressEditModel> implements MyAddressEditContract.MyAddressEditView {

    @Override
    protected boolean isAddBaseTitle() {
        return true;
    }

    @Override
    protected Integer getTitleName() {
        return R.string.address_title;
    }

    private AddressPicker picker;

    private MyAddressResponse address;
    private EditText etName, etPhone, etAddressInfo;
    private BaseButton btnAddress;

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);


        Intent intent = getIntent();
        address = (MyAddressResponse) intent.getSerializableExtra("address");

        if (address != null) {

            address.setDealOperateType(2);
        } else {
            address = new MyAddressResponse();
            address.setDealOperateType(1);
        }


        ConstraintLayout contentView = new ConstraintBuilder(0, 0).topToBottom(baseTitleView).bottomCenterH().build(this);
        contentView.setBackgroundColor(getColor(net.daylong.daylongbase.R.color.color_f6f6f6));

        rootView.addView(contentView);
        MyTextView tvName = MyTextView.create(contentView, new ConstraintBuilder().ww().height(30).leftTop().leftTopMargin(12, 0));
        tvName.setId(View.generateViewId());
        tvName.setGravity(Gravity.CENTER_VERTICAL);






        MyTextView tvPhone = MyTextView.create(contentView, new ConstraintBuilder().ww().height(30).left(tvName).topToBottom(tvName));
        tvPhone.setGravity(Gravity.CENTER_VERTICAL);
        tvPhone.setId(View.generateViewId());





        MyTextView tvAddress = MyTextView.create(contentView, new ConstraintBuilder().ww().height(30).left(tvName).topToBottom(tvPhone));
        tvAddress.setId(View.generateViewId());
        tvAddress.setGravity(Gravity.CENTER_VERTICAL);




        btnAddress = BaseButton.create(contentView, new ConstraintBuilder().ww().centerV(tvAddress).right().rightMargin(10));

        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (picker == null) {


                    picker = new AddressPicker(NewAddressActivity.this);
                    picker.setAddressMode(AddressMode.PROVINCE_CITY_COUNTY);
                    picker.setOnAddressPickedListener(new OnAddressPickedListener() {
                        @Override
                        public void onAddressPicked(ProvinceEntity province, CityEntity city, CountyEntity county) {
                            btnAddress.setText(province.getName() + "-" + city.getName() + "-" + county.getName());
                            address.setProvince(province.getName());
                            address.setCity(city.getName());
                            address.setCounty(county.getName());
                        }
                    });
                }
                String string = btnAddress.getText().toString();
                String[] split = string.split("-");
                if (split.length == 3) {
                    picker.setDefaultValue(split[0], split[1], split[2]);
                }

                picker.show();
            }
        });


        MyTextView tvAddressInfo = MyTextView.create(contentView, new ConstraintBuilder().ww().height(30).left(tvName).topToBottom(tvAddress));
        tvAddressInfo.setId(View.generateViewId());
        tvAddressInfo.setGravity(Gravity.CENTER_VERTICAL);





        MyTextView tvDef = MyTextView.create(contentView, new ConstraintBuilder().ww().height(30).left(tvName).topToBottom(tvAddressInfo));
        tvDef.setId(View.generateViewId());
        tvDef.setGravity(Gravity.CENTER_VERTICAL);



        DefaultCheckBox defaultCheckBox = new DefaultCheckBox(this, new ConstraintBuilder().ww().right().centerV(tvDef).rightMargin(10), R.drawable.setting_switch_selector);
        defaultCheckBox.setChecked(address.isDefault());
        defaultCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                address.setDefaultFlag(b ? 1 : 0);
            }
        });
        contentView.addView(defaultCheckBox);

        BaseButton btnNewAddress = BaseButton.create(contentView, new ConstraintBuilder(163, 28).bottomCenterH().bottomMargin(27));

        btnNewAddress.setGravity(Gravity.CENTER);
        btnNewAddress.setBackgroundResource(R.drawable.shape_r_30_bg_c48);
        btnNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                

                String name = getText(etName);
                String phone = getText(etPhone);
                String addressInfo = getText(etAddressInfo);
                String addressStr = btnAddress.getText().toString().trim();
                String[] split = addressStr.split("-");

                if (split.length != 3) {

                    return;
                } else {
                    if (isOrNull(name, phone, addressInfo)) {

                        return;
                    }
                }

                address.setName(name);
                address.setPhone(phone);
                address.setArea(addressInfo);
                mPresenter.getMyAddressEditList(address);
            }
        });

    }


    public EditText create(ViewGroup viewGroup, View centerV, Integer inputType, String hintStr, String text) {

        EditText EditText = new EditText(this);
        EditText.setGravity(Gravity.RIGHT);
        EditText.setLayoutParams(new ConstraintBuilder().ww().centerV(centerV).right().rightMargin(10).buildPayoutParams());
        EditText.setBackgroundColor(Color.TRANSPARENT);
        EditText.setMaxLines(1);
        if (inputType != null) {
            EditText.setInputType(inputType);
        }
        EditText.setHint(hintStr);
        EditText.setTextColor(getColor(R.color.color_434343));
        EditText.setHintTextColor(getColor(R.color.color_434343));
        EditText.setId(View.generateViewId());
        if (!TextUtils.isEmpty(text)) {
            EditText.setText(text);
        }

        viewGroup.addView(EditText);
        return EditText;
    }

    @NonNull
    @Override
    protected MyAddressEditPresenter initPresenter() {
        return MyAddressEditPresenter.newInstance();
    }

    @Override
    public void onMyAddressEditSuc() {

        finish();
    }
}
