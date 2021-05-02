/**
 * @FileName : BeanImplementRequestParamStop.java
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
 * @Class	 : BeanImplementRequestParamStop
 * @Date	 : 2011. 2. 10.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanRequestParamImplBusStopName extends BeanRequestParamAbs {
    private static final String STOP = "stop";
    private static final String TYPE = "type";
    private String stop;
    private String type;
    /**
     * BeanImplementRequestParamStop's Constructor
     * @param cmd
     * @param action
     * @Comment  :
     */
    public BeanRequestParamImplBusStopName(String cmd, String action,String type, String stop) {
        super(cmd, action);this.type=type;this.stop=stop;
    }
    public String getStop() {
        return stop;
    }
    public void setStop(String stop) {
        this.stop = stop;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public HashMap<String, String> getAllItem() {
        super.getAllItem();
        hashmap.put(STOP, stop);
        hashmap.put(TYPE, type);
        return hashmap;
    }
}//class




