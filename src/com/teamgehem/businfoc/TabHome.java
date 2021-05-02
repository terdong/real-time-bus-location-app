/**
 * 0. Project		: XXXX
 *
 * 1. FileName	: TabHome.java
 * 2. Package	: com.teamgehem.businfo
 * 3. Commnet	: 
 * 4. Writer		: Gehem_um
 * 5. Date		: 2011. 4. 3. 오후 4:32:47
 * 6. Edit	: 
 *                    name     : date          : reference    : comment
 *                   ------------------------------------------------------
 *                    Gehem_um  : 2011. 4. 3.  :              : 신규 개발.
 */
package com.teamgehem.businfoc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.teamgehem.businfoc.adapter.HomeListAdapterImplNotify;
import com.teamgehem.businfoc.bean.BeanListViewImplNotify;

/**
 * <PRE>
 * 1. ClassName	: TabHome
 * 2. FileName		: TabHome.java
 * 3. Package		: com.teamgehem.businfo
 * 4. Commnet		: 
 * 5. Writer			: Gehem_um
 * 6. Date			: 2011. 4. 3. 오후 4:32:47
 * </PRE>
 */
public class TabHome extends Activity
{
    private static final String HEAD[]={
        "반갑습니다.",
        "#00 - 버그수정",
        "#01 - 버그수정&기능추가",
        "#02 - 버그수정",
        "#03 - 버그수정: 터치시 색깔 변화 삭제",
        };
    private static final String DATE[]={
      "2011/03/18",
      "2011/03/24",
      "2011/04/01",
      "2011/04/04",
      "2011/04/05"
    };
    private static final String CONTENTS[]={
      "반갑습니다. 천안에는 시내버스 검색 앱이 없어서\n직접 천안 시내버스 검색 앱을 제작해 봤습니다.\n기대에 많이 못 미치더라도 많은 관심 부탁드립니다.",
      "많은 기능을 넣고 싶지만, 기본적인 기능사항부터 버그를 고치도록 하겠습니다.",
      "기존에 정류장부터 검색되던 것을 버스번호만 바로 검색 할 수 있게 수정했습니다.",
      "몇가지 자잘한 버그와 메인화면을 수정해봤습니다.",
      "검색 결과를 터치 했을 경우에 발생되었던 전체 반전에 따른 색 변화를 없앴습니다."
    };
    
    private HomeListAdapterImplNotify hlain;
    
    /**
     * <PRE>
     * 1. MethodName	: TabHome
     * 2. ClassName		: TabHome
     * 3. Commnet			: 
     * 4. Writer			: Gehem_um
     * 5. Date				: 2011. 4. 3. 오후 4:32:47
     * </PRE>
     */
    public TabHome()
    {
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_home);
        hlain = new HomeListAdapterImplNotify(TabHome.this, R.layout.table_listview_notify);
        ListView lv = (ListView) findViewById(R.id.home_listview_notify);
        lv.setAdapter(hlain);
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id)
            {
                hlain.toggle(position);
            }
        });
        for(int i=HEAD.length-1; i>=0; i--){
            hlain.add(new BeanListViewImplNotify(HEAD[i], DATE[i], CONTENTS[i]));
        }
        
    }
}//class



















