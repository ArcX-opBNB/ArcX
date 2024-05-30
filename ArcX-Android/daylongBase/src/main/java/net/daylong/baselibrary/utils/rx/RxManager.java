package net.daylong.baselibrary.utils.rx;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxManager {

    /**


     */
    private CompositeDisposable mCompositeDisposable;

    /**

     *
     * @param disposable
     */
    public void subscribe(Disposable disposable) {
        
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    /**

     */
    public void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

}
