package com.daylong.httplibrary.bean.menus;
/**

 */
public enum GameChillType {
    KINGKONG(1, "kingKong")
    , EGYPT(2, "egypt")
    , EAST(3, "east")
    , POWER_THUNDER(4, "thunder")
    , CLOWN_CIRCUS(5, "clown")
    , PIRATE(6, "pirate")
    , PILE_TOWER(7, "pile_tower")
    , DOLL(8, "doll")
    , ARCADE_MACHINE(9, "PRESENT")


    ;
    private int id;
    private String desc;

    GameChillType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static GameChillType getGameChillType(int id) {

        for (GameChillType gameChillType : GameChillType.values()) {


            if (gameChillType.getId() == id) {
                return gameChillType;
            }


        }
        return null;
    }
}
