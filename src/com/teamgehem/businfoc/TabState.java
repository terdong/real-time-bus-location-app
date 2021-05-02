/**
 * @FileName : TabState.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo
 * @Date	 : 2011. 2. 4.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

import com.teamgehem.businfoc.bean.BeanListViewImplLine;
/**
 * @Class	 : TabState
 * @Date	 : 2011. 2. 4.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class TabState extends Activity {
    /**
     * TabState's Constructor
     * @Comment  :
     */
    public TabState() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_state);
        ArrayList<BeanListViewImplLine> al = new ArrayList<BeanListViewImplLine>();
        
       // ListView StateList = (ListView)findViewById(R.id.state_list);
       // StateList.setAdapter(new StateListAdapter<BeanListViewImplLine>(this, R.layout.table_listview,al));
    }
} 








