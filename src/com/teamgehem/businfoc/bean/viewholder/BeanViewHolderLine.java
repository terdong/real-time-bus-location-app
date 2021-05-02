/**
 * @FileName : BeanViewHolderLine.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo.bean
 * @Date	 : 2011. 2. 17.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc.bean.viewholder;

import android.widget.TableRow;
import android.widget.TextView;

/**
 * @Class	 : BeanViewHolderLine
 * @Date	 : 2011. 2. 17.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanViewHolderLine {
    public TextView lineName;
    public TextView lineStart;
    public TextView lineEnd;
    public TableRow table_listview_line_current_stop_row;
    public TextView currentListView;
   
    /**
     * BeanViewHolderLine's Constructor
     * @Comment  :
     */
    public BeanViewHolderLine(TextView lineName, TextView lineStart, TextView lineEnd,  TextView lv) {
        this.lineName = lineName;
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
        //this.table_listview_line_current_stop_row = t;
        this.currentListView = lv;
    }
}//class
