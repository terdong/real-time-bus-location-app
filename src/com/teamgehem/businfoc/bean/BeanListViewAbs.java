/**
 * @FileName : BeanListViewAbs.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo.bean
 * @Date	 : 2011. 2. 17.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc.bean;

/**
 * @Class	 : BeanListViewAbs
 * @Date	 : 2011. 2. 17.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public abstract class BeanListViewAbs {
    private boolean expanded;
    /**
     * BeanListViewAbs's Constructor
     * @Comment  :
     */
    public BeanListViewAbs() {
        this.expanded=false;
    }
    public boolean isExpanded() {
        return expanded;
    }
    public void setExpanded() {
        this.expanded = !expanded;
    }
}//class
