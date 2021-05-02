/**
 * 0. Project		: XXXX
 *
 * 1. FileName	: TabSearchGroup.java
 * 2. Package	: com.teamgehem.businfo
 * 3. Commnet	: 
 * 4. Writer		: Gehem_um
 * 5. Date		: 2011. 3. 23. 오전 1:49:14
 * 6. Edit	: 
 *                    name     : date          : reference    : comment
 *                   ------------------------------------------------------
 *                    Gehem_um  : 2011. 3. 23.  :              : 신규 개발.
 */
package com.teamgehem.businfoc;

import java.util.ArrayList;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * <PRE>
 * 1. ClassName	: TabSearchGroup
 * 2. FileName		: TabSearchGroup.java
 * 3. Package		: com.teamgehem.businfo
 * 4. Commnet		: 
 * 5. Writer			: Gehem_um
 * 6. Date			: 2011. 3. 23. 오전 1:49:14
 * </PRE>
 */
public class TabSearchGroup extends ActivityGroup
{
    public static TabSearchGroup group;
    private ArrayList<View> history;
    
    /**
     * <PRE>
     * 1. MethodName	: TabSearchGroup
     * 2. ClassName		: TabSearchGroup
     * 3. Commnet			: 
     * 4. Writer			: Gehem_um
     * 5. Date				: 2011. 3. 23. 오전 1:49:14
     * </PRE>
     */
    public TabSearchGroup()
    {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.history = new ArrayList<View>();
        group = this;
        
        View view = getLocalActivityManager().startActivity("Search", new Intent(this,TabSearchSearch.class)
                                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                                .getDecorView();
        replaceView(view);
    }
    
    public void replaceView(View v){
        history.add(v);
        setContentView(v);
    }
    
    private void back(){
        if(history.size() > 0) {
            history.remove(history.size()-1);
            setContentView(history.get(history.size()-1));
        }else {
            finish();
        }
    }

    @Override
    public void onBackPressed()
    {
        this.group.back();
        return;
    }
    
}//class















