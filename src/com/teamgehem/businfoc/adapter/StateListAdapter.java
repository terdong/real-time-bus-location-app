/**
 * @FileName : StateList.java
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * @param <T>
 * @Class	 : StateList
 * @Date	 : 2011. 2. 7.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class StateListAdapter<T> extends ArrayAdapter<T>{
    protected static String TITLE=null;
    protected Context context;
    protected ArrayList<T> arSrc;
    protected int layout;
    public StateListAdapter(Context context, int textViewResourceId, ArrayList<T> arSrc) {
        super(context, textViewResourceId, arSrc);
        this.context=context;
        this.arSrc=arSrc;
        this.layout=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        return v;
    }
/*    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        if(convertView==null) {
            LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(layout, parent, false);
        }
        tv = (TextView)convertView.findViewById(R.id.table_listview_row_line_content_first);
        BeanListViewImplLine bsl = (BeanListViewImplLine)arSrc.get(pos);
        tv.setText(bsl.getBusNumber());
        tv = (TextView)convertView.findViewById(R.id.table_listview_row_line_content_second);
        tv.setText(bsl.getRemainTime());
        tv = (TextView)convertView.findViewById(R.id.table_listview_row_line_content_third);
        tv.setText(bsl.getState());
        return convertView;
    }*/
}//class
