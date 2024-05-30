package net.daylong.baselibrary.utils.ui.frt;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseModel;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.AdapterNullView;
import net.daylong.baselibrary.view.recycler.BaseRecyclerView;
import net.daylong.baselibrary.view.recycler.CustomRefreshHeader;
import net.daylong.baselibrary.view.recycler.VerticalRecyclerView;

import java.util.List;

public abstract class BaseListFragment<P extends BasePresenter, M extends IBaseModel, T> extends BaseMvpFragment<P, M> implements OnRefreshListener, OnLoadMoreListener {

    public BaseRecyclerView getRecyclerView() {
        VerticalRecyclerView verticalRecyclerView = new VerticalRecyclerView(getContext());
        SmartRefreshLayout.LayoutParams layoutParams = new SmartRefreshLayout.LayoutParams(SmartRefreshLayout.LayoutParams.MATCH_PARENT, SmartRefreshLayout.LayoutParams.MATCH_PARENT);
        verticalRecyclerView.setLayoutParams(layoutParams);
        return verticalRecyclerView;
    }


    protected int page = 1;

    /**

     *
     * @return
     */
    protected boolean isRefresh() {
        return false;
    }

    /**

     *
     * @return
     */
    protected boolean isLoadMore() {
        return false;
    }


    protected BaseQuickAdapter<T, MyViewHolder> baseQuickAdapter;

    public abstract BaseQuickAdapter<T, MyViewHolder> getAdapter();

    private SmartRefreshLayout smartRefreshLayout;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);


        smartRefreshLayout = new SmartRefreshLayout(getContext());
        smartRefreshLayout.setLayoutParams(new ConstraintBuilder().mm().leftTop().buildPayoutParams());
        addView(smartRefreshLayout);


        smartRefreshLayout.setReboundDuration(300);
        smartRefreshLayout.setEnableRefresh(isRefresh());
        smartRefreshLayout.setEnableLoadMore(isLoadMore());


        if (isRefresh()) {
            CustomRefreshHeader customRefreshHeader = new CustomRefreshHeader(getContext());
            smartRefreshLayout.setRefreshHeader(customRefreshHeader);
            smartRefreshLayout.setOnRefreshListener(this);

        }
        if (isLoadMore()) {
            smartRefreshLayout.setOnLoadMoreListener(this);
            ClassicsFooter classicsFooter = new ClassicsFooter(getContext());
            
            classicsFooter.setAccentColor(Color.TRANSPARENT);
            classicsFooter.setPrimaryColor(Color.TRANSPARENT);
            smartRefreshLayout.setRefreshFooter(classicsFooter);
        }


        BaseRecyclerView recyclerView = getRecyclerView();
        baseQuickAdapter = getAdapter();
        if (baseQuickAdapter != null) {

            recyclerView.setAdapter(baseQuickAdapter);


        }
        smartRefreshLayout.setRefreshContent(recyclerView);

    }


    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        baseQuickAdapter.setOnItemChildClickListener(onItemChildClickListener);
    }

    public void setOnItemChildClickListener(OnItemClickListener onItemChildClickListener) {
        baseQuickAdapter.setOnItemClickListener(onItemChildClickListener);
    }


    /**

     */
    public void finishNoMoreData() {
        smartRefreshLayout.finishLoadMore();
        smartRefreshLayout.finishLoadMoreWithNoMoreData();
        smartRefreshLayout.setEnableLoadMore(false);
    }

    public void setData(List<T> list) {


        if (page == 1 && list.size() == 0) {
            if (baseQuickAdapter != null) {
                baseQuickAdapter.setEmptyView(new AdapterNullView(getContext()));
            }
        }


        if (list.size() < 20) {
            finishNoMoreData();
        }

        if (baseQuickAdapter != null) {
            baseQuickAdapter.setList(list);
        }
    }


    @Override
    protected void initData() {
        super.initData();

        getListUrl();
    }

    abstract public void getListUrl();

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

        page++;
        getListUrl();

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        getListUrl();
    }


}
