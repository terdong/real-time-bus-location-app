/**
 * @FileName : EasyRequest.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.util
 * @Date	 : 2011. 2. 7.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.teamgehem.businfoc.bean.BeanParserParamMsg;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;
import android.util.Log;

/**
 * @Class	 : EasyRequest
 * @Date	 : 2011. 2. 7.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class ParserUtil {
    protected static final String TAG="ParserUtil";
    protected ArrayList<String> al = new ArrayList<String>();
    private static ParserUtil instance;
    private Pattern p;
    private Matcher m;
    /**
     * EasyRequest's Constructor
     * @Comment  :
     */
    private ParserUtil() {
    }
    public static ParserUtil getInstance() {
        if(instance==null)
            instance=new ParserUtil();
        return instance;
    }
    public void reset() {
        //swa.reset();
    }
    public ArrayList<String> parserHtml(InputStream in, String charSet, String elementName, BeanParserParamMsg paramMsg ){
        Source source = null;
        try {
            source = getSourceByInputStream(in, charSet);
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {}
        if(elementName==null)
            try {
                processNoneParser(source, charSet);
            } catch (UnsupportedEncodingException e) {}
        else
            processParser(source.getAllElements(elementName), paramMsg);
        return al;
    }
    public ArrayList<String> parserHtml(String url, String charSet, String elementName, BeanParserParamMsg paramMsg){
        Source source = null;
        try {
            source = getSourceByUrl(url);
        } catch (MalformedURLException e1) {
        } catch (IOException e1) {}
        if(elementName==null)
            try {
                processNoneParser(source, charSet);
            } catch (UnsupportedEncodingException e) {}
        else
            processParser(source.getAllElements(elementName), paramMsg);
        return al;
    }
    
    private Source getSourceByInputStream(InputStream in, String charSet) throws UnsupportedEncodingException, IOException{
        return new Source(new InputStreamReader(in,charSet));
    }
    private Source getSourceByUrl(String url) throws MalformedURLException, IOException {
        return new Source(new URL(url));
    }
    
    private void processNoneParser(Source source, String charSet) throws UnsupportedEncodingException {
        source.fullSequentialParse();
        String str = source.getTextExtractor().toString();
        str = new String(str.getBytes(source.getEncoding()),charSet);
        al.clear();
        al.add(str);
    }

    /**
     * @param list
     * @param paramMsg 필터 구분자
     * void
     * @Comment : 실질적으로 쓰레기 값과 추출 값을 paramMsg로 필터링하여 List에 담는다.
     */
    private void processParser(List<Element> list, BeanParserParamMsg paramMsg){
        String msg = paramMsg.getMsg();
        String []args = paramMsg.getArgs();
        String patternMsg = paramMsg.getPatternMsg();
        Log.d(TAG,list.toString());
        Log.d(TAG,String.format("msg=%S", msg));
        al.clear();
       // if(msg!=null)
       //     al.add(msg);
        Element e;
        String str=null;
        int length = args!=null?args.length:0;
        for(int i=0; i<list.size(); i++) {
            e=list.get(i);

            /*Log.d(TAG,"e.getName() = "+e.getName());
            Log.d(TAG,"e.getAttributes() = "+e.getAttributes().toString());*/
            Log.d(TAG,"e.getAllTags() = "+e.getAllTags().toString());
            /*Log.d(TAG,"e.getAllElements() = "+e.getAllElements().toString());
            Log.d(TAG,"e.getChildElements() = "+e.getChildElements().toString());
            Log.d(TAG,"e.getFirstElement() = "+e.getFirstElement().toString());
            Log.d(TAG,"e.getFirstStartTag() = "+e.getFirstStartTag().toString());*/
            str = e.getAllTags().toString();
            
            p = Pattern.compile(patternMsg,Pattern.CASE_INSENSITIVE);
            m = p.matcher(str);
            while(m.find()) {
                //Log.d(TAG,"m.group(1)="+m.group(1));
                al.add(m.group(1));
            }
            
            str=e.getContent().getTextExtractor().toString();
            if(str!="" && str!=null) {
                int count = 0;
                for(int j=0; j<length; j++) {
                    if(!str.equals(args[j]))
                        count++;
                }
                if(count==length) {
                    // 불필요한 공백 제거
                    str.replaceAll("\\p{Space} ","");
                    if(msg.equals("2"))
                        str=str+"\n";
                    al.add(str);
                }
            }
        }
    }
}//class


















