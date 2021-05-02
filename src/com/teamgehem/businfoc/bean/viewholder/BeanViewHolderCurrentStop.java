/**
 * 0. Project		: XXXX
 *
 * 1. FileName	: BeanViewHolderCurrentStop.java
 * 2. Package	: com.teamgehem.businfo.bean.viewholder
 * 3. Commnet	: 
 * 4. Writer		: Gehem_um
 * 5. Date		: 2011. 3. 14. 오전 2:50:13
 * 6. Edit	: 
 *                    name     : date          : reference    : comment
 *                   ------------------------------------------------------
 *                    Gehem_um  : 2011. 3. 14.  :              : 신규 개발.
 */
package com.teamgehem.businfoc.bean.viewholder;

import android.widget.TextView;

/**
 * <PRE>
 * 1. ClassName	: BeanViewHolderCurrentStop
 * 2. FileName		: BeanViewHolderCurrentStop.java
 * 3. Package		: com.teamgehem.businfo.bean.viewholder
 * 4. Commnet		: 
 * 5. Writer			: Gehem_um
 * 6. Date			: 2011. 3. 14. 오전 2:50:13
 * </PRE>
 */
public class BeanViewHolderCurrentStop
{
    public TextView currentStop;
    /**
     * <PRE>
     * 1. MethodName	: BeanViewHolderCurrentStop
     * 2. ClassName		: BeanViewHolderCurrentStop
     * 3. Commnet			: 
     * 4. Writer			: Gehem_um
     * 5. Date				: 2011. 3. 14. 오전 2:50:13
     * </PRE>
     */
    public BeanViewHolderCurrentStop(TextView table_listview_current_stop_content)
    {
        this.currentStop = table_listview_current_stop_content;
    }
    
}//class
