package net.daylong.baselibrary.view.recycler;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

public class GridRecyclerView extends BaseRecyclerView {
    public GridRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    protected int cunt = 2;

    public GridRecyclerView(@NonNull Context context, int cunt) {
        this(context, null);
        this.cunt = cunt;
    }

    public GridRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    protected int getGridNum() {
        return cunt;
    }

    protected GridLayoutManager gridLayoutManager;

    @Override
    public LayoutManager getMyLayoutManager() {
        if (gridLayoutManager == null) {
            gridLayoutManager = new GridLayoutManager(getContext(), 2);
        }
        return gridLayoutManager;
    }


}
