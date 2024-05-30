package com.daylong.httplibrary.model.presenter.game;


import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;
import com.daylong.httplibrary.bean.response.game.charter.UserCharterInfoResponse;
import com.daylong.httplibrary.model.contract.game.CharterContract;
import com.daylong.httplibrary.model.model.game.CharterModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class CharterPresenter extends CharterContract.CharterPresenter {
    public static CharterPresenter newInstance() {
        return new CharterPresenter();
    }

    @Override
    public void onStart() {

    }

    @Override
    public CharterModel getModel() {
        return CharterModel.newInstance();
    }



    @Override
    public void getGameCharterDesc(int productId) {
          if (mIModel != null) {

                      mIModel.getGameCharterDesc(productId)
                              .compose(RxScheduler.<BaseResponse<CharterDescResponse>>rxSchedulerTransform())
                              .compose(mIView.<BaseResponse<CharterDescResponse>>bindToLife())
                              .subscribe(new BaseObserver<CharterDescResponse>() {


                                  @Override
                                  protected void onStart() {


                                  }

                                  @Override
                                  protected void onSuccess(CharterDescResponse data) throws Exception {
                                      if (mIView != null) {
                                          mIView.onGameCharterDesc(data);
                                      }
                                  }

                                  @Override
                                  protected void onFinish() {

                                  }
                              });
                  }
    }

    @Override
    public void getUserCharterInfo() {
        if (mIModel != null) {
            mIModel.getUserCharterInfo()
                    .compose(RxScheduler.<BaseResponse<UserCharterInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<UserCharterInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<UserCharterInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(UserCharterInfoResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onUserCharterInfo(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

