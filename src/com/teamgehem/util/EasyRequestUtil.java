/**
 * @FileName : ParserUtil.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.util
 * @Date	 : 2011. 2. 7.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * @Class	 : ParserUtil
 * @Date	 : 2011. 2. 7.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class EasyRequestUtil {
    private static final String TAG="EasyRequestUtil";
    private static EasyRequestUtil instance;
    /**
     * ParserUtil's Constructor
     * @Comment  :
     */
    private EasyRequestUtil() {}
    public static EasyRequestUtil getInstance() {
        if(instance==null)
            instance = new EasyRequestUtil();
        return instance;
    }
    
    public InputStream getInputStreamResultHttpPost(String url, ArrayList<NameValuePair> nameValue) {
        HttpParams params=new BasicHttpParams();
        params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpClient client = new DefaultHttpClient(params);
        HttpPost post = new HttpPost(url);
        try {
            List<NameValuePair> list = nameValue;
            Log.d(TAG,nameValue.toString());
            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(list,"EUC-KR");
            post.setEntity(ent);
            return requestGetInputStream(client, post);
        } catch (UnsupportedEncodingException e) {
        } catch (ClientProtocolException e) {
        } catch (IOException e) {}
        return null;
    }
   
    public String getStringResultHttpPost(String url, ArrayList<NameValuePair> nameValue) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        try {
            List<NameValuePair> list = nameValue;
            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(list,HTTP.UTF_8);
            post.setEntity(ent);
            return requestGetString(client, post);
        } catch (UnsupportedEncodingException e) {
        } catch (ClientProtocolException e) {
        } catch (IOException e) {}
        return null;
    }
    
    public String getStringResultHttpGet(String url) {
        HttpClient client = new DefaultHttpClient();  
        HttpGet get = new HttpGet(url);
        try {
            return requestGetString(client, get);
        } catch (ClientProtocolException e) {
        } catch (IOException e) {}
        return null;
    }
    
    // file upload
    public String getStringResultMultiPartPost(String url, String fileName,File file) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);  
        reqEntity.addPart(fileName, new FileBody(file));
        post.setEntity(reqEntity);  
        try {
            return requestGetString(client, post);
        } catch (ClientProtocolException e) {
        } catch (IOException e) {}
        return null;
    }
    
    private String requestGetString(HttpClient client, Object request) throws ClientProtocolException, IOException {
        HttpEntity entity = requestResult(client,request);
        return entity!=null?EntityUtils.toString(entity):null;
    }
    
    private InputStream requestGetInputStream(HttpClient client, Object request) throws ClientProtocolException, IOException {
        HttpEntity entity = requestResult(client,request);
        return entity!=null?entity.getContent():null;
    }
    
    private HttpEntity requestResult(HttpClient client, Object request) throws ClientProtocolException, IOException {
        HttpResponse response = null;
        if(request instanceof HttpPost)
            response=client.execute((HttpPost)request);
        else if(request instanceof HttpGet)
            response = client.execute((HttpGet)request);
        int status = response.getStatusLine().getStatusCode();
        if (status == HttpStatus.SC_OK) {
                return response.getEntity();
        }
        return null;
    }
}//class














