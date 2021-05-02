/**
 * 0. Project		: XXXX
 *
 * 1. FileName	: SearchListAdapterImplCurrentStop.java
 * 2. Package	: com.teamgehem.businfo.adapter
 * 3. Commnet	: 
 * 4. Writer		: Gehem_um
 * 5. Date		: 2011. 3. 14. 오전 2:47:45
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
import com.teamgehem.businfoc.bean.viewholder.BeanViewHolderCurrentStop;

/**
 * <PRE>
 * 1. ClassName	: SearchListAdapterImplCurrentStop
 * 2. FileName		: SearchListAdapterImplCurrentStop.java
 * 3. Package		: com.teamgehem.businfo.adapter
 * 4. Commnet		: 
 * 5. Writer			: Gehem_um
 * 6. Date			: 2011. 3. 14. 오전 2:47:45
 * </PRE>
 */
public class SearchListAdapterImplCurrentStop extends StateListAdapter<String> implements Cloneable
{
    private static final String TAG="SearchListAdapterImplCurrentStop";
    private static int count=0;
    public SearchListAdapterImplCurrentStop(Context context,int textViewResourceId, ArrayList<String> arSrc)
    {
        super(context, textViewResourceId, arSrc);
    }
    public SearchListAdapterImplCurrentStop(Context context,int textViewResourceId)
    {
        super(context, textViewResourceId, new ArrayList<String>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = super.getView(position, convertView, parent);
        BeanViewHolderCurrentStop bvhcs;
        if(v==null) {
            LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(layout, parent, false);
            bvhcs = new BeanViewHolderCurrentStop((TextView)v.findViewById(R.id.table_listview_current_stop_content));
            v.setTag(bvhcs);
        }else{
            bvhcs = (BeanViewHolderCurrentStop) v.getTag();
        }
        String str = arSrc.get(position);
        Log.d(TAG,String.format("arryaString=%s, arrayCount=%d", str,arSrc.size()));
        bvhcs.currentStop.setText(str);
        return v;
    }

    @Override
    public void add(String object)
    {
        super.add(object);
    }
    
    public void setArrayList(ArrayList<String> al){
        this.arSrc=al;
        notifyDataSetChanged();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        SearchListAdapterImplCurrentStop slaics = new SearchListAdapterImplCurrentStop(this.context, this.layout, new ArrayList<String>());
        return slaics;
    }
    
}//class
























