/**
 * 0. Project		: XXXX
 *
 * 1. FileName	: HomeListAdapterImplNotify.java
 * 2. Package	: com.teamgehem.businfo.adapter
 * 3. Commnet	: 
 * 4. Writer		: Gehem_um
 * 5. Date		: 2011. 4. 4. 오전 12:06:18
 * 6. Edit	: 
 *                    name     : date          : reference    : comment
 *                   ------------------------------------------------------
 *                    Gehem_um  : 2011. 4. 4.  :              : 신규 개발.
 */
package com.teamgehem.businfoc.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamgehem.businfoc.R;
import com.teamgehem.businfoc.bean.BeanListViewImplNotify;
import com.teamgehem.businfoc.bean.viewholder.BeanViewHolderNotify;

/**
 * <PRE>
 * 1. ClassName	: HomeListAdapterImplNotify
 * 2. FileName		: HomeListAdapterImplNotify.java
 * 3. Package		: com.teamgehem.businfo.adapter
 * 4. Commnet		: 
 * 5. Writer			: Gehem_um
 * 6. Date			: 2011. 4. 4. 오전 12:06:18
 * </PRE>
 */
public class HomeListAdapterImplNotify extends StateListAdapter<BeanListViewImplNotify>
{
    private static final String TAG="HomeListAdapterImplNotify";
    public HomeListAdapterImplNotify(Context context, int textViewResourceId,
            ArrayList<BeanListViewImplNotify> arSrc)
    {
        super(context, textViewResourceId, arSrc);
    }

    public HomeListAdapterImplNotify(Context context, int textViewResourceId)
    {
        super(context, textViewResourceId, new ArrayList<BeanListViewImplNotify>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
         View v = super.getView(position, convertView, parent);
         BeanViewHolderNotify bvhn;
         if(v==null){
             LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             v=li.inflate(layout, parent, false);
             bvhn = new BeanViewHolderNotify((TextView)v.findViewById(R.id.table_listview_notify_head_text)
                                           ,(TextView)v.findViewById(R.id.table_listview_notify_date_text)
                                           ,(TextView)v.findViewById(R.id.table_listview_notify_contents_text)
                                           ,(ImageView)v.findViewById(R.id.table_listview_notify_icon)
                                           ,v.getResources().getDrawable(R.drawable.notify_unlock)
                                           ,v.getResources().getDrawable(R.drawable.notify_lock));
             v.setTag(bvhn);
         }else{
             bvhn=(BeanViewHolderNotify) v.getTag();
         }
         BeanListViewImplNotify blvin = arSrc.get(position);
         bvhn.head.setText(blvin.getNotifyHead());
         bvhn.date.setText(blvin.getNotifyDate());
         Boolean bool = blvin.isExpanded();
         if(bool){
                 bvhn.contents.setText(blvin.getNotifyContents());
                 bvhn.contents.setVisibility(View.VISIBLE);
                 bvhn.setIv(bool);
         }else{
             bvhn.contents.setVisibility(View.GONE);
             bvhn.setIv(bool);
         }
         return v;
    }
    
    public void toggle(int position) {
        Log.d(TAG,"toggle");
        BeanListViewImplNotify blvin = arSrc.get(position);
        blvin.setExpanded();
        notifyDataSetChanged();
    }
}//class



















