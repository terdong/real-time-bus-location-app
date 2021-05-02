/**
 * @FileName : SearchListAdapter.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo.adapter
 * @Date	 : 2011. 2. 7.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import com.teamgehem.businfoc.R;
import com.teamgehem.businfoc.bean.BeanListViewImplStop;
import com.teamgehem.businfoc.bean.viewholder.BeanViewHolderStop;

/**
 * @Class	 : SearchListAdapter
 * @Date	 : 2011. 2. 7.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class SearchListAdapterImplStop extends StateListAdapter<BeanListViewImplStop> {
    private static final String TAG = "SearchListAdapterImplLine";
    
    /**
     * SearchListAdapterImplLine's Constructor
     * @param context
     * @param textViewResourceId
     * @param arSrc
     * @Comment  :
     */
    public SearchListAdapterImplStop(Context context, int textViewResourceId, ArrayList<BeanListViewImplStop> arSrc) {
        super(context, textViewResourceId, arSrc);
    }
    
    public SearchListAdapterImplStop(Context context, int textViewResourceId) {
        super(context,textViewResourceId, new ArrayList<BeanListViewImplStop>());
    }
/*    public SearchListAdapterExtd(Context context, int textViewResourceId, HashMap <String,BeanListViewManager> tableTitle ) {
        super(context, textViewResourceId, new ArrayList<BeanStateListExtdSearchList>());
        arSrc.add( tableTitle.get("stop"));
        this.tableTitle = tableTitle;
    }*/
    
/*    @Override
    public void clear() {
        super.clear();
        arSrc.add( tableTitle.get("stop"));
    }
    public void clear(String msg) {
        super.clear();
        if(msg==null)
            add( tableTitle.get("stop"));
        else
            add(tableTitle.get(msg));
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        BeanViewHolderStop bvhs;
        if(v==null) {
            LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(layout, parent, false);
            bvhs = new BeanViewHolderStop((TextView)v.findViewById(R.id.table_listview_stop_content)
                                          ,(TableRow)v.findViewById(R.id.table_listview_stop_line_row));
            v.setTag(bvhs);
        }else{
            bvhs = (BeanViewHolderStop) v.getTag();
        }
        BeanListViewImplStop blvis = arSrc.get(position);
        String str = blvis.getStopName();
        Log.d(TAG,"STR="+str);
        bvhs.stopName.setText(str);
//        if(blvm.getBlvis().isExpanded()){
//            bvhs.table_listview_stop_line_row.setVisibility(View.VISIBLE);
//        }else
//            bvhs.table_listview_stop_line_row.setVisibility(View.GONE);
 //       bvhs.table_listview_stop_line_row.setVisibility(blvm.getBlvis().isExpanded()?View.VISIBLE:View.GONE);
        
/*        tv = (TextView)convertView.findViewById(R.id.table_listview_row_current_content);
        tempBean = arSrc.get(position);
        tv.setText(tempBean.getStationList());
        TableRow tr = (TableRow)convertView.findViewById(R.id.table_listview_row_current);
        tr.setVisibility(tempBean.isExpanded()?View.VISIBLE:View.GONE);*/
        return v;
    }

    @Override
    public void add(BeanListViewImplStop object) {
        super.add(object);
    }

    public void toggle(int position) {
        Log.d(TAG,"toggle position="+String.valueOf(position));
//        BeanListViewManager blvm = arSrc.get(position);
//        blvm.getBlvis().setExpanded();
//        notifyDataSetChanged();
    }

}//class








