package com.daylong.gamelibrary.bean;

import com.daylong.gamelibrary.meuns.GameStatus;
import com.daylong.httplibrary.bean.ArcadePositionBean;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import java.util.ArrayList;
import java.util.List;

public class GameInfoBean extends BaseGameReturnBean {

    private UserInfoResponse gmPly; 
    private List<UserInfoResponse> vsUsrTbln; 
    private List<ArcadePositionBean> streeList;

    public UserInfoResponse getGamingUserMsg() {
        return gmPly;
    }

    public void setGamingUserMsg(UserInfoResponse gamingUserMsg) {
        this.gmPly = gamingUserMsg;
    }

    public List<UserInfoResponse> getVisitList() {
        return vsUsrTbln;
    }

    public  List<String> getUserImg() {


        List<String> list = new ArrayList<>();
        if(vsUsrTbln!=null&&vsUsrTbln.size()>0){
            for (UserInfoResponse userInfoResponse : vsUsrTbln) {
                list.add(userInfoResponse.getUserImgUrl());
            }
        }
        return list;
    }

    public void setVisitList(List<UserInfoResponse> visitList) {
        this.vsUsrTbln = visitList;
    }

    public List<ArcadePositionBean> getStreeList() {
        return streeList;
    }

    public void setStreeList(List<ArcadePositionBean> streeList) {
        this.streeList = streeList;
    }


    public GameStatus getGameStatus(long userId) {
        if (gmPly == null) {
            return GameStatus.FREE;
        } else {
            Long gameUserId = gmPly.getUserId();
            
            if (gameUserId == userId) {
                return GameStatus.GAME;
            }
            return GameStatus.OTHER;
        }
    }
}
