/**
 * @FileName : BeanParserParamMsg.java
 * @Project	 : BusInfo
 * @Package : com.teamgehem.businfo.bean
 * @Date	 : 2011. 2. 19.
 * @Writer   : Gehem_um
 * @Version  : 
 * @Edit     :
 * @Comment  : 
 */
package com.teamgehem.businfoc.bean;

/**
 * @Class	 : BeanParserParamMsg
 * @Date	 : 2011. 2. 19.
 * @Writer   : Gehem_um
 * @Edit     :
 * @Comment  : 
 */
public class BeanParserParamMsg {
    private String []args;
    private String msg;
    private String patternMsg;
    /**
     * BeanParserParamMsg's Constructor
     * @Comment  :
     */
    public BeanParserParamMsg(String []args, String msg, String patternMsg) {
        this.args=args;this.msg=msg;this.patternMsg=patternMsg;
    }
    
    public String[] getArgs() {
        return args;
    }
    public void setArgs(String[] args) {
        this.args = args;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getPatternMsg() {
        return patternMsg;
    }
    public void setPatternMsg(String patternMsg) {
        this.patternMsg = patternMsg;
    }
}//class










