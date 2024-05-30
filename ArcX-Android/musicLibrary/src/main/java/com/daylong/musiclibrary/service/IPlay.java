package com.daylong.musiclibrary.service;

public interface IPlay {

    /**

     *

     */
    void initBgMusic(String[] bgMusic);

    void play();

    void play(String playPath);
    void stop();
    void destroy();
}
