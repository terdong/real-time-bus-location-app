/**
 * @FileName : BeanRequestParamImplBusLineId.java
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
 * @Class	 : BeanRequestParamImplBusLineId
 * @Date	 : 2011. 2. 10.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanRequestParamImplBusLineId extends BeanRequestParamAbs {
    private static final String BUSLINEID = "busLineId";
    private static final String FROMPROGRESSDIRECTION = "fromProgressDirection";
    private String busLineId;
    private String fromProgressDirection;
    /**
     * BeanRequestParamImplBusLineId's Constructor
     * @param cmd
     * @param action
     * @param busLineId
     * @param fromProgressDirection
     * @Comment  :
     */
    public BeanRequestParamImplBusLineId(String cmd, String action, String busLineId, String fromProgressDirection) {
        super(cmd, action);
        this.busLineId=busLineId;
        this.fromProgressDirection=fromProgressDirection;
    }
    public String getBusLineId() {
        return busLineId;
    }
    public void setBusLineId(String busLineId) {
        this.busLineId = busLineId;
    }
    public String getFromProgressDirection() {
        return fromProgressDirection;
    }
    public void setFromProgressDirection(String fromProgressDirection) {
        this.fromProgressDirection = fromProgressDirection;
    }
    @Override
    public HashMap<String, String> getAllItem() {
        super.getAllItem();
        hashmap.put(BUSLINEID, busLineId);
        hashmap.put(FROMPROGRESSDIRECTION, fromProgressDirection);
        return hashmap;
    }
}//class






