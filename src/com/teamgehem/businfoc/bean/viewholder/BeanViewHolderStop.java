/**
 * @FileName : BeanViewHolder.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo.bean
 * @Date	 : 2011. 2. 17.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc.bean.viewholder;

import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * @Class	 : BeanViewHolder
 * @Date	 : 2011. 2. 17.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanViewHolderStop {
    public TableRow table_listview_stop_content_row;
    public TableRow table_listview_stop_line_row;
    public TextView stopName;
    public ListView lineList;
    /**
     * BeanViewHolder's Constructor
     * @Comment  :
     */
    public BeanViewHolderStop(TextView stopName, TableRow table_listview_stop_line_row, ListView lineList) {
        this.table_listview_stop_line_row = table_listview_stop_line_row;
        this.stopName = stopName;
        this.lineList = lineList;
    }
    /**
     * BeanViewHolder's Constructor
     * @Comment  :
     */
    public BeanViewHolderStop(TextView stopName, TableRow table_listview_stop_line_row) {
        this.table_listview_stop_line_row = table_listview_stop_line_row;
        this.stopName = stopName;
    }

}//class








