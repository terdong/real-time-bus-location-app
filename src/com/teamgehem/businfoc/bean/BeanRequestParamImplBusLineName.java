/**
 * @FileName : BeanImplementsRequestParamLineName.java
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
 * @Class	 : BeanImplementsRequestParamLineName
 * @Date	 : 2011. 2. 10.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanRequestParamImplBusLineName extends BeanRequestParamAbs {
    private static final String BUSLINENAME = "busLineName";
    private String busLineName;
    /**
     * BeanImplementsRequestParamLineName's Constructor
     * @param cmd
     * @param action
     * @Comment  :
     */
    public BeanRequestParamImplBusLineName(String cmd, String action, String busLineName) {
        super(cmd, action);
        this.busLineName=busLineName;
    }
    public String getBusLineName() {
        return busLineName;
    }
    public void setBusLineName(String busLineName) {
        this.busLineName = busLineName;
    }
    @Override
    public HashMap<String, String> getAllItem() {
        super.getAllItem();
        hashmap.put(BUSLINENAME, busLineName);
        return hashmap;
    }
}//class









