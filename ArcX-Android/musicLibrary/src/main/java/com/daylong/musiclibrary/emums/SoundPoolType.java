package com.daylong.musiclibrary.emums;

import com.daylong.musiclibrary.R;
import com.daylong.musiclibrary.mrg.SoundPoolManager;

public enum SoundPoolType {
    PUSH_COIN(R.raw.sound_game_pusher_slot, "push_icon") //
    , EAST_PUSH_COIN(R.raw.sound_east_push_coin, "east_push_coin") //
    , GET_COIN(R.raw.sound_game_pusher_get_coin, "getCoin") //
    , COMBO_GOOD_JOB(R.raw.sound_game_combo_score_1, "ic_goodjob")//
    , COMBO_WELL_DONE(R.raw.sound_game_combo_score_2, "ic_welldone")//
    , COMBO_PERFECT(R.raw.sound_game_combo_score_3, "ic_perfect")//
    , COMBO_AMAZING(R.raw.sound_game_combo_score_4, "ic_amazing")//
    , COMBO_INCREDIBLE(R.raw.sound_game_combo_score_5, "ic_incredible")//











    , BIG_WIN(R.raw.sound_thunder_big_win, "1")//
    , HUGE_WIN(R.raw.sound_thunder_huge_win, "2")//
    , MEGA_WIN(R.raw.sound_thunder_mega_win, "3")//
    , COLLECT(R.raw.sound_bonus_collect, "3")//





    




    





    //
    ;


    public static SoundPoolType getSoundPoolTypeByName(String name) {

        for (SoundPoolType soundPoolType : SoundPoolType.values()) {


            if (soundPoolType.getDesc().equals(name)) {
                return soundPoolType;
            }

        }

        return null;
    }

    private int rawId;
    private String desc;

    SoundPoolType(int rawId, String desc) {
        this.rawId = rawId;
        this.desc = desc;
    }

    public int getRawId() {
        return rawId;
    }

    public void setRawId(int rawId) {
        this.rawId = rawId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public void play() {
        SoundPoolManager.getInstance().play(getRawId());
    }

    public void playNotStop() {
        SoundPoolManager.getInstance().play(getRawId(), false);
    }

    public void stop() {
        SoundPoolManager.getInstance().stop(getRawId());
    }
}
