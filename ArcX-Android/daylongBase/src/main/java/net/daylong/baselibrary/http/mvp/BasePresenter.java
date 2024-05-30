package net.daylong.baselibrary.http.mvp;
import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.rx.RxManager;


public abstract class BasePresenter<M, V> {
    protected M mIModel;
    protected V mIView;
    protected RxManager mRxManager = new RxManager();

    /**


     */
    public abstract void onStart();

    /**

     * @param mIModel
     * @param mIView
     */
    public void attachMV(@NonNull M mIModel, @NonNull V mIView){
        this.mIModel = mIModel;
        this.mIView = mIView;
        this.onStart();
    }

    /**

     * @return
     */
    public abstract M getModel();

    /**

     */
    public void detachMV(){
        mIModel = null;
        mIView = null;
        mRxManager = null;
    }

}
