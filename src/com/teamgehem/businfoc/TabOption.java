/**
 * @FileName : TabOption.java
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

import net.htmlparser.jericho.HTMLElementName;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import com.teamgehem.businfoc.bean.BeanParserInfo;
import com.teamgehem.businfoc.bean.BeanRequestParamImplBusLineName;
import com.teamgehem.businfoc.manager.BusInfoManager;

/**
 * @Class	 : TabOption
 * @Date	 : 2011. 2. 4.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class TabOption extends Activity {
    private static final String TAG="TabOption";
    private BeanParserInfo bpi;
    private RadioGroup rg;
    private ProgressDialog mProgress;
    private BusInfoManager bThread;
    DownThread mThread;
    /**
     * TabOption's Constructor
     * @Comment  :
     */
    public TabOption() {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_option);
        //ParserUtil.getInstance().reset();
        
        bpi = new BeanParserInfo("http://its.cheonan.go.kr","EUC-KR",HTMLElementName.DIV,null);
        bpi.addNameValuePair("action", "/service/bus/BusController");
        bpi.addNameValuePair("cmd", "buslocationstop");
        bpi.addNameValuePair("stop", "���ִ�");
        bpi.addNameValuePair("type","1");
        
    }

    class DownThread extends Thread {
        String mAddr;
        String mResult;

        DownThread(String addr) {
            mAddr = addr;
            mResult = "";
        }

        public void run() {
            StringBuilder html = new StringBuilder(); 

            
            ArrayList<String>result = null; 

            BeanRequestParamImplBusLineName brpbLineName = new BeanRequestParamImplBusLineName(getString(R.string.request_param_cmd_linename)
                    ,getString(R.string.request_param_action_all) 
                    ,null);
            
            
            mResult=result.toString();
                Log.d(TAG,mResult);
        }
    }
    
    
} //class











