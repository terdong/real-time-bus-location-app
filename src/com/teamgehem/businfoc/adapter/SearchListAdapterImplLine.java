/**
 * 0. Project		: BusInfo
 *
 * 1. FileName	: SearchListAdapterImplLine.java
 * 2. Package	: com.teamgehem.businfo.adapter
 * 3. Commnet	: 
 * 4. Writer		: Gehem_um
 * 5. Date		: 2011. 3. 14. 오전 12:13:58
 * 6. Edit	: 
 *                    name     : date          : reference    : comment
 *                   ------------------------------------------------------
 *                    Gehem_um  : 2011. 3. 14.  :              : 신규 개발.
 */
package com.teamgehem.businfoc.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamgehem.businfoc.R;
import com.teamgehem.businfoc.bean.BeanListViewImplLine;
import com.teamgehem.businfoc.bean.viewholder.BeanViewHolderLine;

/**
 * <PRE>
 * 1. ClassName	: SearchListAdapterImplLine
 * 2. FileName		: SearchListAdapterImplLine.java
 * 3. Package		: com.teamgehem.businfo.adapter
 * 4. Commnet		: 
 * 5. Writer			: Gehem_um
 * 6. Date			: 2011. 3. 14. 오전 12:13:58
 * </PRE>
 */
public class SearchListAdapterImplLine extends StateListAdapter<BeanListViewImplLine>
{
    private static final String TAG="SearchListAdapterImplLine";
    private static int count=0;
    private SearchListAdapterImplCurrentStop slaics;
    public SearchListAdapterImplLine(Context context, int textViewResourceId, ArrayList<BeanListViewImplLine> arSrc)
    {
        super(context, textViewResourceId, arSrc);
    }
    public SearchListAdapterImplLine(Context context, int textViewResourceId)
    {
        super(context, textViewResourceId, new ArrayList<BeanListViewImplLine>());
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = super.getView(position, convertView, parent);
        BeanViewHolderLine bvhl;
        if(v==null){
            LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(layout, parent, false);
            bvhl = new BeanViewHolderLine((TextView)v.findViewById(R.id.table_listview_line_content_first)
                                          ,(TextView)v.findViewById(R.id.table_listview_line_content_second)
                                          ,(TextView)v.findViewById(R.id.table_listview_line_content_third)
                                         // ,(TableRow)v.findViewById(R.id.table_listview_line_current_stop_row)
                                          //,(ListView)v.findViewById(R.id.table_listview_line_current_stop_list));
                                          ,(TextView)v.findViewById(R.id.table_listview_line_current_stop_text));
            v.setTag(bvhl);
        }else{
            bvhl=(BeanViewHolderLine) v.getTag();
        }
        BeanListViewImplLine blvil = arSrc.get(position);
        bvhl.lineName.setText(blvil.getLine());
        bvhl.lineStart.setText(blvil.getStopStart());
        bvhl.lineEnd.setText(blvil.getStopEnd());
        if(blvil.isExpanded()){
            if(blvil.getAl()!=null){
            SearchListAdapterImplCurrentStop slaics = blvil.getAdapter();
          //      bvhl.table_listview_line_current_stop_row.addView(tv);
         //       Log.d(TAG,String.format("slaics!=null, count=%d",count>2?count=0:count++));
                //bvhl.currentListView.setAdapter(slaics);
                bvhl.currentListView.setText(blvil.getSb());
                bvhl.currentListView.setFocusable(false);
                bvhl.currentListView.setVisibility(View.VISIBLE);
            }
        }else
            bvhl.currentListView.setVisibility(View.GONE);
        return v;
    }
    
    @Override
    public void add(BeanListViewImplLine object){
        try
        {
            object.setAdapter((SearchListAdapterImplCurrentStop)slaics.clone());
        }
        catch (CloneNotSupportedException e)
        {
            Log.d(TAG,e.getMessage());
            
        }
        super.add(object);
    }
    
    public void subAdd(int position, ArrayList<String> al){
        if(!al.isEmpty() && al.size()>0){
            arSrc.get(position).setAl(al);
        }
    }
    public void subAdd(int position, String str){
        if(str!=null){
            arSrc.get(position).setSb(str);
        }
    }
    
    public void setSlaics(SearchListAdapterImplCurrentStop slaics)
    {
        this.slaics = slaics;
    }
    
    public boolean toggle(int position) {
        Log.d(TAG,"toggle position="+String.valueOf(position));
        BeanListViewImplLine blvil = arSrc.get(position);
        blvil.setExpanded();
        notifyDataSetChanged();
        return blvil.isExpanded();
    }
    
}//class






























