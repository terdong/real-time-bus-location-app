/**
 * @FileName : BeanRequestParam.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo.bean
 * @Date	 : 2011. 2. 10.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc.bean;

import java.util.HashMap;

/**
 * @Class	 : BeanRequestParam
 * @Date	 : 2011. 2. 10.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
abstract public class BeanRequestParamAbs {
    private static final String CMD = "cmd";
    private static final String ACTION = "action";
    private String cmd;
    private String action;
    protected HashMap<String, String> hashmap;
    /**
     * BeanRequestParam's Constructor
     * @Comment  :
     */
    public BeanRequestParamAbs(String cmd, String action) {
        this.cmd=cmd;this.action=action;
        hashmap = new HashMap<String, String>();
    }
    public String getCmd() {
        return cmd;
    }
    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    private Boolean clearMap() {
        try {
            hashmap.clear();
        } catch (Exception e) {return false;}
        return true;
    }
    public HashMap<String, String> getAllItem() {
        if(!clearMap())
            return null;
        hashmap.put(CMD, cmd);
        hashmap.put(ACTION,action);
        return hashmap;
    }
}





