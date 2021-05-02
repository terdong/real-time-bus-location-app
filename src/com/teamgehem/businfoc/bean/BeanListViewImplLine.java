/**
 * @FileName : BeanStateList.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo.bean
 * @Date	 : 2011. 2. 4.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc.bean;

import java.util.ArrayList;

import com.teamgehem.businfoc.adapter.SearchListAdapterImplCurrentStop;

/**
 * @Class	 : BeanStateList
 * @Date	 : 2011. 2. 4.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanListViewImplLine extends BeanListViewAbs {
    private String lineName;
    private String stopStart;
    private String stopEnd;
    private String lineId;
    private String fromProgressDirection;
    private ArrayList<String> al;
    private StringBuffer sb;
    private SearchListAdapterImplCurrentStop adapter;
    /**
     * BeanListViewImplLine's Constructor
     * @param lineName              버스번호
     * @param stopStart             기점
     * @param stopEnd               종점
     * @param lineId                버스번호 ID
     * @param fromProgressDirection 방향
     * @Comment  :
     */
    public BeanListViewImplLine(String lineId, String fromProgressDirection, String lineName, String stopStart, String stopEnd) {
        this.lineName=lineName;
        this.stopStart=stopStart;
        this.stopEnd=stopEnd;
        this.lineId=lineId;
        this.fromProgressDirection=fromProgressDirection;
        al=new ArrayList<String>();
        sb=new StringBuffer();
    }
    public String getLine() {
        return lineName;
    }
    public void setLine(String line) {
        this.lineName = line;
    }
    public String getStopStart() {
        return stopStart;
    }
    public void setStopStart(String stopStart) {
        this.stopStart = stopStart;
    }
    public String getStopEnd() {
        return stopEnd;
    }
    public void setStopEnd(String stopEnd) {
        this.stopEnd = stopEnd;
    }
    public String getLineId() {
        return lineId;
    }
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }
    public String getFromProgressDirection() {
        return fromProgressDirection;
    }
    public void setFromProgressDirection(String fromProgressDirection) {
        this.fromProgressDirection = fromProgressDirection;
    }
    public SearchListAdapterImplCurrentStop getAdapter()
    {
        return adapter;
    }
    public void setAdapter(SearchListAdapterImplCurrentStop adapter)
    {
        this.adapter = adapter;
    }
    public ArrayList<String> getAl()
    {
        return al;
    }
    public void setAl(ArrayList<String> al)
    {
        this.al = al;
        sb.setLength(0);
        for(String str:al){
            sb.append(str);
        }
    }
    
    public String getSb(){
        return sb.toString();
    }
    public void setSb(String str){
        sb.setLength(0);
        sb.append(str);
    }
    
}//class
