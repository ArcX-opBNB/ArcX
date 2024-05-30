package com.daylong.arcx.user.wallet;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.daylong.arcx.R;
import com.daylong.arcx.act.BaseAxcActivity;
import com.daylong.arcx.user.wallet.frt.WalletSpendingFragment;
import com.daylong.arcx.user.wallet.frt.WalletWalletFragment;
import com.daylong.arcx.view.user.wallet.WalletRadioBtn;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.frt.BaseFragment;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class WalletActivity extends BaseActivity {

    @Override
    protected Integer getBackBgRegId() {
        return R.drawable.img_back_wallet;

    }

    private FrameLayout contentFrame;

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);

        contentFrame = new FrameLayout(this);
        contentFrame.setId(View.generateViewId());
        contentFrame.setLayoutParams(new ConstraintBuilder().mm().leftTop().buildPayoutParams());
        addView(contentFrame);
        crateRadio();
    }

    private RadioGroup radioGroup;
    private RadioButton btnSpending, btnWallet;

    public void crateRadio() {

        radioGroup = new RadioGroup(this);
        radioGroup.setLayoutParams(new ConstraintBuilder(173, 29).topCenterH().topMargin(30).buildPayoutParams());
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        radioGroup.setId(net.daylong.daylongbase.R.id.base_rg);
        radioGroup.setBackgroundResource(R.drawable.img_wallet_rg_bg);
        btnSpending = WalletRadioBtn.create(radioGroup, "Spending",R.drawable.img_wallet_rb_bg);
        btnSpending.setChecked(true);
        btnWallet = WalletRadioBtn.create(radioGroup, "Wallet",R.drawable.img_wallet_rb2_bg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                getFragment(i);
            }
        });
        addView(radioGroup);
        getFragment(btnSpending.getId());

    }


    private BaseFragment fragment;
    private int tabCurrent;

    public void getFragment(int checkedId) {
        
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragment = (BaseFragment) fragmentManager.findFragmentByTag(checkedId + "");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment == null) {
            
            if (checkedId == btnSpending.getId()) {
                fragment = new WalletSpendingFragment();
            } else {
                fragment = new WalletWalletFragment();

            }

            fragmentTransaction.add(contentFrame.getId(), fragment, checkedId + "");
        } else {
            fragmentTransaction.show(fragment);
            fragment.onFragmentEnter();
        }
        
        BaseFragment CurrentFragment = (BaseFragment) fragmentManager.findFragmentByTag(tabCurrent + "");
        if (tabCurrent != 0 && CurrentFragment != null && tabCurrent != checkedId) {
            fragmentTransaction.hide(CurrentFragment);
            CurrentFragment.onFragmentExit();
        }
        fragmentTransaction.commitAllowingStateLoss();

        tabCurrent = checkedId;
    }
}
