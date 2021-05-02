/**
 * @FileName : SendRequest.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo.manager
 * @Date	 : 2011. 2. 7.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc.manager;

import java.io.InputStream;
import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.teamgehem.businfoc.R;
import com.teamgehem.businfoc.bean.BeanParserInfo;
import com.teamgehem.businfoc.bean.BeanParserParamMsg;
import com.teamgehem.util.EasyRequestUtil;
import com.teamgehem.util.ParserUtil;

/**
 * @Class : SendRequest
 * @Date : 2011. 2. 7.
 * @Writer : Gehem_um
 * @Edit :
 * @Comment :
 */
public class BusInfoManager extends
		AsyncTask<Object, String, ArrayList<String>> {
	private static final String TAG = "BusInfoManager";
	private EasyRequestUtil eru = EasyRequestUtil.getInstance();
	private ParserUtil pu = ParserUtil.getInstance();
	private ArrayList<String> result;
	private BeanParserInfo bpi;
	private ProgressDialog pd;
	private Context context;
	private Handler handler;
	private Toast toast;
	private int gMsg;

	/**
	 * SendRequest's Constructor
	 * 
	 * @Comment :
	 */
	private BusInfoManager() {
	}

	public static BusInfoManager runProcess(Context context, Handler handler,
			Object... params) {
		BusInfoManager bim = new BusInfoManager();
		bim.context = context;
		bim.handler = handler;
		bim.execute(params);
		return bim;
	}

	@Override
	protected void onCancelled() {
		pd.dismiss();
		toast.setText(R.string.toast_msg_cancel);
		toast.show();
	}

	@Override
	protected void onPostExecute(ArrayList<String> result) {
		pd.dismiss();
		int length = result.size();
		if (length < 1) {
			toast.setText(R.string.toast_msg_failed);
			gMsg = -1;
		}
		toast.show();
		handler.sendEmptyMessage(gMsg);
	}

	@Override
	protected void onPreExecute() {
		if (result != null) {
			result.clear();
		}
		Resources res = context.getResources();
		String[] dialogMsg = { res.getString(R.string.dialog_title),
				res.getString(R.string.dialog_msg),
				res.getString(R.string.dialog_btn_cancel) };
		toast = Toast.makeText(context, R.string.toast_msg_complete,
				Toast.LENGTH_SHORT);

		// progressDialog factory
		pd = new ProgressDialog(context);
		pd.setTitle(dialogMsg[0]);
		pd.setMessage(dialogMsg[1]);
		pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pd.setButton(dialogMsg[2], new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				cancel(true);
			}
		});
		pd.show();
	}

	@Override
	protected void onProgressUpdate(String... values) {
		if (values != null)
			switch (values.length) {
			case 2:
				pd.setMessage(values[1]);
			case 1:
				pd.setTitle(values[0]);
				break;
			default:
				break;
			}
	}

	@Override
	protected ArrayList<String> doInBackground(Object... params) {
		for (int i = 0; i < params.length; i++) {
			if (params[i] instanceof BeanParserInfo)
				this.bpi = (BeanParserInfo) params[i];
		}
		publishProgress(null);
		BeanParserParamMsg bppm = bpi.getParamMsg();
		gMsg = Integer.parseInt(bppm.getMsg());
		InputStream in = eru.getInputStreamResultHttpPost(bpi.getUrl(),
				bpi.getFormValue());
		result = pu
				.parserHtml(in, bpi.getCharSet(), bpi.getElementName(), bppm);
		// threadSleep(3, 1000);
		return result;
	}

	private void threadSleep(int c, int interval) {
		for (int i = 0; i < c; i++) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
			}
			Log.d(TAG, String.valueOf(i));
		}
	}
}// class

