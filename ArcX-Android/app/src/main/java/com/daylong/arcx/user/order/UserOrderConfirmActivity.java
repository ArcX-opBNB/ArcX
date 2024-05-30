package com.daylong.arcx.user.order;

import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.request.user.OrderRequest;
import com.daylong.httplibrary.bean.response.user.MyAddressResponse;
import com.daylong.httplibrary.model.contract.user.OrderPostContract;
import com.daylong.httplibrary.model.model.user.OrderPostModel;
import com.daylong.httplibrary.model.presenter.user.OrderPostPresenter;
import com.daylong.arcx.R;
import com.daylong.arcx.user.address.MyAddressActivity;
import com.daylong.arcx.user.order.frt.OrderConfirmFragment;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.textview.MyTextView;

import java.util.List;

public class UserOrderConfirmActivity extends BaseMvpActivity<OrderPostPresenter, OrderPostModel> implements OrderPostContract.OrderPostView {
    static final int REQUEST_CODE = 1;

    @Override
    protected boolean isAddBaseTitle() {
        return true;
    }

    @Override
    protected Integer getTitleName() {
        return R.string.order_confirm;
    }


    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);
        DefaultView defaultView = DefaultView.create(rootView, new ConstraintBuilder(0, 0).topToBottom(baseTitleView).bottomCenterH().left());
        defaultView.setBackgroundColor(getColor(R.color.color_white));
        initAddress();
        initOrder();
        initBtn();
    }

    private MyTextView tvAddress;
    private CardView cardView;

    private void initAddress() {
        cardView = new CardView(this);
        cardView.setRadius(AppUtil.getSize(7));
        cardView.setLayoutParams(new ConstraintBuilder(171, 34).topToBottom(baseTitleView).topMargin(8).centerH().buildPayoutParams());
        cardView.setId(View.generateViewId());
        ConstraintLayout addressContent = new ConstraintBuilder().mm().build(this);

        tvAddress = MyTextView.create(addressContent, new ConstraintBuilder().ww().leftCenterV().leftMargin(9));


        cardView.addView(addressContent);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserOrderConfirmActivity.this, MyAddressActivity.class);
                intent.putExtra("isOrder", true);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        addView(cardView);
    }

    private void initBtn() {


        BaseButton btnNewAddress = BaseButton.create(rootView, new ConstraintBuilder(108, 28).bottomCenterH().bottomMargin(25));

        btnNewAddress.setGravity(Gravity.CENTER);
        btnNewAddress.setBackgroundResource(R.drawable.shape_r_30_bg_c48);
        btnNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (address == null) {


                    return;
                }

                List<Long> orderId = orderConfirmFragment.getOrderId();


                mPresenter.postOrder(new OrderRequest(orderId, address.getAddressId()));
            }
        });

    }

    private OrderConfirmFragment orderConfirmFragment;

    private void initOrder() {


        CardView cardViewFrt = new CardView(this);
        cardViewFrt.setRadius(AppUtil.getSize(7));
        cardViewFrt.setLayoutParams(new ConstraintBuilder(171, 0).wHei().topMargin(8).topToBottom(cardView).centerH().buildPayoutParams());
        cardViewFrt.setId(View.generateViewId());
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(Color.WHITE);
        frameLayout.setLayoutParams(new ConstraintBuilder().mw().buildPayoutParams());
        frameLayout.setId(net.daylong.daylongbase.R.id.base_frt);
        cardViewFrt.addView(frameLayout);
        rootView.addView(cardViewFrt);

        orderConfirmFragment = new OrderConfirmFragment();
        addFragment(orderConfirmFragment, net.daylong.daylongbase.R.id.base_frt);

    }


    private MyAddressResponse address;
    ;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                address = (MyAddressResponse) data.getSerializableExtra("address");
                tvAddress.initText(address.getInfo(), 6, R.color.color_434343);
                
            }
        }
    }

    @NonNull
    @Override
    protected OrderPostPresenter initPresenter() {
        return OrderPostPresenter.newInstance();
    }

    @Override
    public void onOrderPostSuc() {

        finish();
    }
}
