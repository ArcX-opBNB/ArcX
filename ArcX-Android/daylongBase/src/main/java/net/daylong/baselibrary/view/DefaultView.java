package net.daylong.baselibrary.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class DefaultView extends View {

    public static DefaultView create(ViewGroup viewGroup, ConstraintBuilder builder) {


        DefaultView defaultView = new DefaultView(viewGroup.getContext());
        defaultView.setLayoutParams(builder.buildPayoutParams());
        viewGroup.addView(defaultView);
        return defaultView;

    }

    public DefaultView(Context context) {
        super(context);
        setId(View.generateViewId());
    }
}
