package net.daylong.gamesocket.emuns;

public enum CmdType {

    private int cmd;
    private String desc;

    CmdType(int cmd, String desc) {
        this.cmd = cmd;
        this.desc = desc;
    }

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
