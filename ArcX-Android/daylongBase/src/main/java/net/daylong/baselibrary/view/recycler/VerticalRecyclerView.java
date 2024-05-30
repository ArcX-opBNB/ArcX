package net.daylong.baselibrary.view.recycler;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

public class VerticalRecyclerView extends BaseRecyclerView {
    public VerticalRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public VerticalRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerticalRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }
    public LinearLayoutManager linearLayoutManager;

    @Override
    public LayoutManager getMyLayoutManager() {
        if (linearLayoutManager==null) {
            linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(VERTICAL);
        }
        return linearLayoutManager;
    }


}
