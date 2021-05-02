/**
 * 0. Project		: XXXX
 *
 * 1. FileName	: BeanListViewImplNotify.java
 * 2. Package	: com.teamgehem.businfo.bean
 * 3. Commnet	: 
 * 4. Writer		: Gehem_um
 * 5. Date		: 2011. 4. 4. 오전 12:02:44
 * 6. Edit	: 
 *                    name     : date          : reference    : comment
 *                   ------------------------------------------------------
 *                    Gehem_um  : 2011. 4. 4.  :              : 신규 개발.
 */
package com.teamgehem.businfoc.bean;

/**
 * <PRE>
 * 1. ClassName	: BeanListViewImplNotify
 * 2. FileName		: BeanListViewImplNotify.java
 * 3. Package		: com.teamgehem.businfo.bean
 * 4. Commnet		: 
 * 5. Writer			: Gehem_um
 * 6. Date			: 2011. 4. 4. 오전 12:02:44
 * </PRE>
 */
public class BeanListViewImplNotify extends BeanListViewAbs
{
    private String notifyHead;
    private String notifyDate;
    private String notifyContents;
    
    /**
     * <PRE>
     * 1. MethodName	: BeanListViewImplNotify
     * 2. ClassName		: BeanListViewImplNotify
     * 3. Commnet			: 
     * 4. Writer			: Gehem_um
     * 5. Date				: 2011. 4. 4. 오전 12:02:44
     * </PRE>
     */
    public BeanListViewImplNotify(String head, String date, String contents)
    {
        this.notifyHead=head;
        this.notifyDate=date;
        this.notifyContents=contents;
    }

    public String getNotifyHead()
    {
        return notifyHead;
    }

    public void setNotifyHead(String notifyHead)
    {
        this.notifyHead = notifyHead;
    }

    public String getNotifyDate()
    {
        return notifyDate;
    }

    public void setNotifyDate(String notifyDate)
    {
        this.notifyDate = notifyDate;
    }

    public String getNotifyContents()
    {
        return notifyContents;
    }

    public void setNotifyContents(String notifyContents)
    {
        this.notifyContents = notifyContents;
    }
    
    
}//class












