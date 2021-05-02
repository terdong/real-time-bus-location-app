/**
 * 0. Project		: XXXX
 *
 * 1. FileName	: BeanViewHolderNotify.java
 * 2. Package	: com.teamgehem.businfo.bean.viewholder
 * 3. Commnet	: 
 * 4. Writer		: Gehem_um
 * 5. Date		: 2011. 4. 4. 오전 12:07:37
 * 6. Edit	: 
 *                    name     : date          : reference    : comment
 *                   ------------------------------------------------------
 *                    Gehem_um  : 2011. 4. 4.  :              : 신규 개발.
 */
package com.teamgehem.businfoc.bean.viewholder;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * <PRE>
 * 1. ClassName	: BeanViewHolderNotify
 * 2. FileName		: BeanViewHolderNotify.java
 * 3. Package		: com.teamgehem.businfo.bean.viewholder
 * 4. Commnet		: 
 * 5. Writer			: Gehem_um
 * 6. Date			: 2011. 4. 4. 오전 12:07:37
 * </PRE>
 */
public class BeanViewHolderNotify
{
    public TextView head;
    public TextView date;
    public TextView contents;  
    private ImageView iv;
    static private Drawable [] icon=null;
    
    /**
     * <PRE>
     * 1. MethodName	: BeanViewHolderNotify
     * 2. ClassName		: BeanViewHolderNotify
     * 3. Commnet			: 
     * 4. Writer			: Gehem_um
     * 5. Date				: 2011. 4. 4. 오전 12:07:37
     * </PRE>
     */
    public BeanViewHolderNotify(TextView head, TextView date, TextView contents, ImageView iv, Drawable on, Drawable off)
    {
        this.head=head;
        this.date=date;
        this.contents=contents;
        this.iv=iv;
        if(icon==null)
        {       
            icon=new Drawable[2];
            icon[1]=on;icon[0]=off;
        }
    }
    public void setIv(Boolean bool){
        iv.setImageDrawable(bool?icon[1]:icon[0]);
    }
    
}//class












