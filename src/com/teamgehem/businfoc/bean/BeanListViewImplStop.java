package com.teamgehem.businfoc.bean;

public class BeanListViewImplStop extends BeanListViewAbs {
    private String stopId;
    private String stopName;
    
    /**
     * BeanListViewImplStop's Constructor
     * @param stopName  정류장 이름
     * @param stopId    정류장 ID
     * @Comment  :
     */
    public BeanListViewImplStop(String stopId,String stopName) {
        this.stopId = stopId;
        this.stopName = stopName;
    }
    public String getStopName() {
        return stopName;
    }
    public void setStopName(String stopName) {
        this.stopName = stopName;
    }
    public String getStopId() {
        return stopId;
    }
    public void setStopId(String stopId) {
        this.stopId = stopId;
    }
}//class
