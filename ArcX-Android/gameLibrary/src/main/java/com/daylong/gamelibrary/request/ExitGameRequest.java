package com.daylong.gamelibrary.request;

import com.daylong.gamelibrary.meuns.GameCmdType;

/**

 */
public class ExitGameRequest extends BaseGameRequest {
    public ExitGameRequest() {
        super(GameCmdType.C2S_EXIT_PRODUCT.getCdm());
    }
}
