/**
 * @FileName : BeanParserInfo.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo.bean
 * @Date	 : 2011. 2. 8.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * @Class	 : BeanParserInfo
 * @Date	 : 2011. 2. 8.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanParserInfo {
    private static final String TAG="BeanParserInfo";
    private String url;
    private String charSet;
    private String elementName;
    private BeanParserParamMsg paramMsg;
    private ArrayList<NameValuePair> formValue;
    /**
     * BeanParserInfo's Constructor
     * @Comment  :
     */
    public BeanParserInfo(String url, String charSet, String elementName, String[]args,String msg, String patternMsg) {
        this.url=url;this.charSet=charSet;this.elementName=elementName;
        this.paramMsg = new BeanParserParamMsg(args,msg,patternMsg);
        formValue=new ArrayList<NameValuePair>();
    }
    public BeanParserInfo(String url, String charSet, String elementName, BeanParserParamMsg paramMsg) {
        this.url=url;this.charSet=charSet;this.elementName=elementName;
        this.paramMsg = paramMsg;
        formValue=new ArrayList<NameValuePair>();
    }
    public BeanParserInfo(String url, ArrayList<NameValuePair> formValue, 
                            String charSet, String elementName, String[]args, String msg, String patternMsg) {
        this.url=url;this.charSet=charSet;this.elementName=elementName;
        this.paramMsg = new BeanParserParamMsg(args,msg,patternMsg);
        this.formValue=formValue;
    }
    public void clearNameValuePair() {
        formValue.clear();
    }
    public void addNameValuePair(String name, String value) {
        formValue.add(new BasicNameValuePair(name, value));
    }
    public void addNameValuePair(HashMap<String, String> h) {
        if(formValue!=null)
            formValue.clear();
        Set<String> set =  h.keySet();
        for(String str:set) {
            formValue.add(new BasicNameValuePair(str,h.get(str)));
        }
    }
    public String getUrl() {
        return url;
    }
    public String getCharSet() {
        return charSet;
    }
    public String getElementName() {
        return elementName;
    }
    public ArrayList<NameValuePair> getFormValue() {
        return formValue;
    }
    public BeanParserParamMsg getParamMsg() {
        return paramMsg;
    }
    public void setParamMsg(BeanParserParamMsg paramMsg) {
        this.paramMsg = paramMsg;
    }
}//class




