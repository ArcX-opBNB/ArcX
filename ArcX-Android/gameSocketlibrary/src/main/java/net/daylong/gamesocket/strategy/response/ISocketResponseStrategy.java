package net.daylong.gamesocket.strategy.response;

import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

public abstract class ISocketResponseStrategy {

    private Set<Integer> cmds = new HashSet<>();






    public ISocketResponseStrategy() {
        addCmd();
    }

    /**

     *
     * @param cmd
     * @return
     */
    public boolean isCurrCmd(Integer cmd) {
        return cmds.contains(cmd);
    }

    /**

     */
    public abstract void addCmd();


    public abstract void issue(Integer cmd, JSONObject msg);

    public  void addCmd(Integer cmd){
        cmds.add(cmd);
    }

}
