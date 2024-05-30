package net.daylong.baselibrary.view.recycler;

import android.content.Context;
import android.view.ViewGroup;

/**

 */
public class BaseVerticalRefreshRecycler extends BaseRefreshRecycler {



    public BaseVerticalRefreshRecycler(Context context) {
        super(context);
    }

    public static BaseVerticalRefreshRecycler create(ViewGroup view, ViewGroup.LayoutParams params) {

        BaseVerticalRefreshRecycler baseRefreshRecycler = new BaseVerticalRefreshRecycler(view.getContext());
        baseRefreshRecycler.setLayoutParams(params);
        view.addView(baseRefreshRecycler);
        return baseRefreshRecycler;

    }



}
