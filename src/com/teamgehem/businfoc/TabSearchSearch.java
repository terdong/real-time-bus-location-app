/**
 * @FileName : TabSearch.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo
 * @Date	 : 2011. 2. 4.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import net.htmlparser.jericho.HTMLElementName;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.AsyncTask.Status;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView.OnEditorActionListener;

import com.teamgehem.businfoc.adapter.SearchListAdapterImplCurrentStop;
import com.teamgehem.businfoc.adapter.SearchListAdapterImplLine;
import com.teamgehem.businfoc.adapter.SearchListAdapterImplStop;
import com.teamgehem.businfoc.bean.BeanListViewImplLine;
import com.teamgehem.businfoc.bean.BeanListViewImplStop;
import com.teamgehem.businfoc.bean.BeanParserInfo;
import com.teamgehem.businfoc.bean.BeanParserParamMsg;
import com.teamgehem.businfoc.bean.BeanRequestParamImplBusLineId;
import com.teamgehem.businfoc.bean.BeanRequestParamImplBusLineName;
import com.teamgehem.businfoc.bean.BeanRequestParamImplBusStopId;
import com.teamgehem.businfoc.bean.BeanRequestParamImplBusStopName;
import com.teamgehem.businfoc.manager.BusInfoManager;

/**
 * @Class	 : TabSearch
 * @Date	 : 2011. 2. 4.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class TabSearchSearch extends Activity {
    private static final String TAG="TabSearch";
    private SearchListAdapterImplStop slais;
    private SearchListAdapterImplLine slail;
    private SearchListAdapterImplCurrentStop slaics;
    private BeanParserInfo bpi;
    private BusInfoManager bim;
    private BeanRequestParamImplBusLineName brpbLineName;
    private BeanRequestParamImplBusLineId brpbLineId;
    private BeanRequestParamImplBusStopName brpbStopName;
    private BeanRequestParamImplBusStopId brpbStopId;
    private RadioGroup rg;
    private EditText etInput;
    private ViewFlipper vf;
    private Animation in_left,out_left, in_right,out_right;
    private int currentPosition=-1;
    private StringBuffer sb = new StringBuffer();
    private static String current_stop_title;
    /**
     * TabSearch's Constructor
     * @Comment  :
     */
    public TabSearchSearch() {}
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_search);
        
        if(current_stop_title==null)
            current_stop_title = getString(R.string.table_listview_current_stop_content_title);
        
        final String [] args_Line = {getString(R.string.request_filter_line_00)
                            ,getString(R.string.request_filter_line_01)
                            ,getString(R.string.request_filter_line_02)};
        final String [] args_Stop = {getString(R.string.request_filter_stop_00)
                            ,getString(R.string.request_filter_stop_01)};
        
        final String [] args_Current = {getString(R.string.request_filter_current_00)
                            ,getString(R.string.request_filter_current_01)};
        
        final BeanParserParamMsg paramLine = new BeanParserParamMsg(args_Line
                                                , getString(R.string.request_filter_line_msg)
                                                , getString(R.string.request_param_pattern_msg));
        final BeanParserParamMsg paramStop = new BeanParserParamMsg(args_Stop
                                                , getString(R.string.request_filter_stop_msg)
                                                , getString(R.string.request_param_pattern_msg));
        final BeanParserParamMsg paramCurrent = new BeanParserParamMsg(args_Current
                                                   , getString(R.string.request_filter_current_msg)
                                                   , getString(R.string.request_param_pattern_msg));
        
        brpbStopName = new BeanRequestParamImplBusStopName(
                getString(R.string.request_param_cmd_stopname),
                getString(R.string.request_param_action_all),
                getString(R.string.request_param_type_stopname), null);
        brpbStopId = new BeanRequestParamImplBusStopId(
                getString(R.string.request_param_cmd_stopid),
                getString(R.string.request_param_action_all), null);
        brpbLineName = new BeanRequestParamImplBusLineName(
                getString(R.string.request_param_cmd_linename),
                getString(R.string.request_param_action_all), null);
        brpbLineId = new BeanRequestParamImplBusLineId(
                getString(R.string.request_param_cmd_lineid),
                getString(R.string.request_param_action_all), null, null);
        bpi = new BeanParserInfo(getString(R.string.request_param_address),
                getString(R.string.request_param_character_type),
                HTMLElementName.DIV, null);

        in_left = AnimationUtils.loadAnimation(this,R.anim.push_left_in);
        out_left = AnimationUtils.loadAnimation(this,R.anim.push_left_out);
        in_right = AnimationUtils.loadAnimation(this,R.anim.push_right_in);
        out_right = AnimationUtils.loadAnimation(this,R.anim.push_right_out);
        
        vf = (ViewFlipper)findViewById(R.id.search_view_flipper);

        slais = new SearchListAdapterImplStop(TabSearchSearch.this, R.layout.table_listview_stop);
        slail = new SearchListAdapterImplLine(TabSearchSearch.this, R.layout.table_listview_line);
        slaics = new SearchListAdapterImplCurrentStop(TabSearchSearch.this, R.layout.table_listview_current_stop);
        slail.setSlaics(slaics);
        
        ListView searchListStop = (ListView)findViewById(R.id.search_list_stop);
        ListView searchListLine = (ListView)findViewById(R.id.search_list_line);
        searchListStop.setAdapter(slais);
        searchListLine.setAdapter(slail);
        searchListStop.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                String stopId = slais.getItem(position).getStopId();
                Log.d(TAG,"stopID="+stopId);
                
                brpbStopId.setBusStopId(stopId);
                bpi.setParamMsg(paramLine);
                bpi.addNameValuePair(brpbStopId.getAllItem());
                bim = BusInfoManager.runProcess(TabSearchSearch.this, mAfterDown, bpi);
                vf.setInAnimation(in_left);
                vf.setOutAnimation(out_left);
                vf.setDisplayedChild(1);
                //slais.toggle(position);
//                Intent i = new Intent(TabSearchSearch.this,TabSearchResult.class);
//                View view = TabSearchGroup.group.getLocalActivityManager()
//                                    .startActivity((String) getText(R.string.tab_title_state), i
//                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//                                    .getDecorView();
//                TabSearchGroup.group.replaceView(view);
            }
        });
        
        searchListLine.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                currentPosition = position;
                if(slail.toggle(currentPosition)){
                    BeanListViewImplLine blvil = slail.getItem(currentPosition);
                    
                    String lineId = blvil.getLineId();
                    String direction = blvil.getFromProgressDirection();
                    
                    brpbLineId.setBusLineId(lineId);
                    brpbLineId.setFromProgressDirection(direction);
                    
                    bpi.setParamMsg(paramCurrent);
                    bpi.addNameValuePair(brpbLineId.getAllItem());
                    bim = BusInfoManager.runProcess(TabSearchSearch.this, mAfterDown, bpi);
                }
            }
        });
        
        // 검색어 입력란
        etInput= (EditText)findViewById(R.id.search_edit);
        etInput.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String input = new String(etInput.getText().toString());
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.search_radiobutton_stop:
                        if(vf.getDisplayedChild()!=0){
                            vf.setInAnimation(in_right);
                            vf.setOutAnimation(out_right);
                            vf.showNext();
                        }
                        brpbStopName.setStop(input);
                        bpi.setParamMsg(paramStop);
                        bpi.addNameValuePair(brpbStopName.getAllItem());
                        break;
                    case R.id.search_radiobutton_line:
                        brpbLineName.setBusLineName(input);
                        bpi.setParamMsg(paramLine);
                        bpi.addNameValuePair(brpbLineName.getAllItem());
                        break;
                    default:
                        break;
                }
                bim = BusInfoManager.runProcess(TabSearchSearch.this, mAfterDown, bpi);
                return false;
            }

    
        });
        // 라디오박스 - 정류장 or 버스노선
        rg = (RadioGroup)findViewById(R.id.search_radiogroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getId() == R.id.search_radiogroup) {
                    switch (checkedId) {
                        case R.id.search_radiobutton_stop:
                            vf.setInAnimation(in_right);
                            vf.setOutAnimation(out_right);
                            vf.setDisplayedChild(0);
                            break;
                        case R.id.search_radiobutton_line:
                            vf.setInAnimation(in_left);
                            vf.setOutAnimation(out_left);
                            vf.setDisplayedChild(1);
                            break;
                        default:
                            break;
                    }
                    etInput.selectAll();
                    etInput.requestFocus();
                }
            }
        });
        
        
        // 경유지 안내 버튼
        Button b = (Button)findViewById(R.id.search_btn_allsearch);
        b.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String input = etInput.getText().toString();
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.search_radiobutton_stop:
                        if(vf.getDisplayedChild()!=0){
                            vf.setInAnimation(in_right);
                            vf.setOutAnimation(out_right);
                            vf.showNext();
                        }
                        brpbStopName.setStop(input);
                        bpi.setParamMsg(paramStop);
                        bpi.addNameValuePair(brpbStopName.getAllItem());
                        break;
                    case R.id.search_radiobutton_line:
                        brpbLineName.setBusLineName(input);
                        bpi.setParamMsg(paramLine);
                        bpi.addNameValuePair(brpbLineName.getAllItem());
                        break;
                    default:
                        break;
                }
                bim = BusInfoManager.runProcess(TabSearchSearch.this, mAfterDown, bpi);
                //Toast.makeText(TabSearchSearch.this, R.string.toast_msg_none, Toast.LENGTH_SHORT).show();
                
           /*     vf.showNext();
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.search_radiobutton_stop:
                        Log.d(TAG, String.valueOf(vf.getChildCount()));
                        break;
                    case R.id.search_radiobutton_line:
                        Log.d(TAG,"line");
                        break;
                    default:
                        
                        break;
                }*/
            }
        });
    }
    
   
    @Override
    public void onBackPressed()
    {
        if(vf.getDisplayedChild()!=0 && rg.getCheckedRadioButtonId()==R.id.search_radiobutton_stop){
            vf.setInAnimation(in_right);
            vf.setOutAnimation(out_right);
            vf.showNext();
        }
        else
            super.onBackPressed();
    }


    private Handler mAfterDown = new Handler() {
        public void handleMessage(Message msg) {
            int flag = msg.what;
            Log.d(TAG,"msg.what="+String.valueOf(flag));
            ArrayList<String>result = null; 
            try {
                if(bim.getStatus()==Status.FINISHED)
                    result = bim.get();
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {}
            int length = result.size();
            Log.d(TAG,String.valueOf(length)+" Result = "+result.toString());
            switch (flag)
            {
                case 0:
                    if(length%2==0){
                        slais.clear();
                        for(int i=0; i<length; i+=2){
                            slais.add(new BeanListViewImplStop(result.get(i), result.get(i+1)));
                        }
                    }
                    break;
                case 1:
                    if(length%5==0){
                        slail.clear();
                        for(int i=0; i<length; i+=5){
                            slail.add(new BeanListViewImplLine(result.get(i), result.get(i+1)
                                                               ,result.get(i+2),result.get(i+3),result.get(i+4)));
                        }
                    }
                    break;
                case 2:
                    if(currentPosition!=-1){
                        result.add(0, current_stop_title);
                        slail.subAdd(currentPosition, result);
                        slail.notifyDataSetChanged();
                    }
                    break;
                default:
                    if(currentPosition!=-1){
                        slail.subAdd(currentPosition, getText(R.string.table_listview_current_stop_content_none).toString());
                        slail.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };
}//class








