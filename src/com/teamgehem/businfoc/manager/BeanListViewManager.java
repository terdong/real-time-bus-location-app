/**
 * @FileName : BeanListViewManager.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo.manager
 * @Date	 : 2011. 2. 17.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc.manager;

import java.util.ArrayList;

import com.teamgehem.businfoc.bean.BeanListViewImplLine;
import com.teamgehem.businfoc.bean.BeanListViewImplStop;

/**
 * @Class	 : BeanListViewManager
 * @Date	 : 2011. 2. 17.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanListViewManager {
    private BeanListViewImplStop blvis;
    private ArrayList<BeanListViewImplLine> alBlvil;
    private ArrayList<String> alCurrentStop;
    /**
     * BeanListViewManager's Constructor
     * @Comment  :
     */
    public BeanListViewManager(BeanListViewImplStop blvis) {
        this.blvis = blvis;
    }
    public BeanListViewManager(String stopName, String stopId) {
        this.blvis = new BeanListViewImplStop(stopName, stopId);
    }
    public BeanListViewManager() {
        this.blvis = null;
    }
    
    public void concreteCollectionBeanListViewImplLine() {
        alBlvil = new ArrayList<BeanListViewImplLine>();
    }
    public void concreteCollectionCurrentStop() {
        alCurrentStop = new ArrayList<String>();
    }
    public BeanListViewImplStop getBlvis() {
        return blvis;
    }
    public void setBlvis(BeanListViewImplStop blvis) {
        this.blvis = blvis;
    }
    public ArrayList<BeanListViewImplLine> getAlBlvil() {
        return alBlvil;
    }
    public void setAlBlvil(ArrayList<BeanListViewImplLine> alBlvil) {
        this.alBlvil = alBlvil;
    }
    public ArrayList<String> getAlCurrentStop() {
        return alCurrentStop;
    }
    public void setAlCurrentStop(ArrayList<String> alCurrentStop) {
        this.alCurrentStop = alCurrentStop;
    }
    public void addAlBlvil(BeanListViewImplLine blvil) {
        if(alBlvil==null) return;
        alBlvil.add(blvil);
    }
    public void addCurrentStop(String currentStop) {
        if(alCurrentStop==null) return;
        alCurrentStop.add(currentStop);
    }

}//class













