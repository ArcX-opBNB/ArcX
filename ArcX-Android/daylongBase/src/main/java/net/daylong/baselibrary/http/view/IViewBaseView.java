package net.daylong.baselibrary.http.view;


import com.trello.rxlifecycle2.LifecycleTransformer;
;

public interface IViewBaseView {



    /**

     *
     * @param <T>
     * @return
     */
    <T> LifecycleTransformer<T> bindToLife();




}
