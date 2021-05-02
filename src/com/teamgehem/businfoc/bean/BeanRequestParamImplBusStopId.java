/**
 * @FileName : BeanImplementsRequestParamBusStopId.java
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
 * @Class	 : BeanImplementsRequestParamBusStopId
 * @Date	 : 2011. 2. 10.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanRequestParamImplBusStopId extends BeanRequestParamAbs {
    private static final String BUSSTOPID = "busStopId";
    private String busStopId;
    /**
     * BeanImplementsRequestParamBusStopId's Constructor
     * @param cmd
     * @param action
     * @Comment  :
     */
    public BeanRequestParamImplBusStopId(String cmd, String action, String busStopId) {
        super(cmd, action);
        this.busStopId=busStopId;
    }
    public String getBusStopId() {
        return busStopId;
    }
    public void setBusStopId(String busStopId) {
        this.busStopId = busStopId;
    }
    @Override
    public HashMap<String, String> getAllItem() {
        super.getAllItem();
        hashmap.put(BUSSTOPID, busStopId);
        return hashmap;
    }
}//class





