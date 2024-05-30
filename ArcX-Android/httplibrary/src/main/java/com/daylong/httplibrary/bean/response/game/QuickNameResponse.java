package com.daylong.httplibrary.bean.response.game;

public class QuickNameResponse {
    private GameInfoResponse devIfo;

    public QuickNameResponse(GameInfoResponse devIfo) {
        this.devIfo = devIfo;
    }

    public GameInfoResponse getDevIfo() {
        return devIfo;
    }

    public void setDevIfo(GameInfoResponse devIfo) {
        this.devIfo = devIfo;
    }
}
