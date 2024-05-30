package com.daylong.userlibrary.mrg;


import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import java.util.ArrayList;
import java.util.List;

public class LoginMrg {

    public static LoginMrg instance = null;
    private static List<LoginSucListener> listenerList;

    public static synchronized LoginMrg getInstance() {
        if (instance == null) {
            synchronized (LoginMrg.class) {
                instance = new LoginMrg();
                listenerList = new ArrayList<LoginSucListener>();
            }
        }
        return instance;
    }


    public void post(UserInfoResponse userInfoResponse) {
        if (listenerList != null && listenerList.size() > 0) {
            for (LoginSucListener loginSucListener : listenerList) {
                loginSucListener.onLoginSuc(userInfoResponse);
            }
        }

    }

    public void addLoginListener(LoginSucListener loginSucListener) {
        listenerList.add(loginSucListener);
    }

    public void removerListener(LoginSucListener loginSucListener) {
        listenerList.remove(loginSucListener);
    }

    public interface LoginSucListener {


        void onLoginSuc(UserInfoResponse userInfoResponse);

    }

}
