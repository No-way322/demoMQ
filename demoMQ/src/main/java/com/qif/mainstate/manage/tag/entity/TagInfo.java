/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: TagInfo
 * Author:   Administrator
 * Date:     2018/12/27 11:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.manage.tag.entity;

import java.io.Serializable;

/**
 * 表m_taginfo实体类
 */
public class TagInfo implements Serializable {

	private static final long serialVersionUID = 3182929398081898844L;

	private String TagId;

    private String vcName;

    private float fValue;

    private int iAlarmLevel;

    private int iUpdateTime;

    private int iParam1;

    private int iParam2;

    private int iParam3;

    private String vcParam4;

    private String vcParam5;

    private String vcParam6;

    private int iFlag;

    private String vcMemo;

    public String getTagId() {
        return TagId;
    }

    public void setTagId(String tagId) {
        TagId = tagId;
    }

    public String getVcName() {
        return vcName;
    }

    public void setVcName(String vcName) {
        this.vcName = vcName;
    }

    public float getfValue() {
        return fValue;
    }

    public void setfValue(float fValue) {
        this.fValue = fValue;
    }

    public int getiAlarmLevel() {
        return iAlarmLevel;
    }

    public void setiAlarmLevel(int iAlarmLevel) {
        this.iAlarmLevel = iAlarmLevel;
    }

    public int getiUpdateTime() {
        return iUpdateTime;
    }

    public void setiUpdateTime(int iUpdateTime) {
        this.iUpdateTime = iUpdateTime;
    }

    public int getiParam1() {
        return iParam1;
    }

    public void setiParam1(int iParam1) {
        this.iParam1 = iParam1;
    }

    public int getiParam2() {
        return iParam2;
    }

    public void setiParam2(int iParam2) {
        this.iParam2 = iParam2;
    }

    public int getiParam3() {
        return iParam3;
    }

    public void setiParam3(int iParam3) {
        this.iParam3 = iParam3;
    }

    public String getVcParam4() {
        return vcParam4;
    }

    public void setVcParam4(String vcParam4) {
        this.vcParam4 = vcParam4;
    }

    public String getVcParam5() {
        return vcParam5;
    }

    public void setVcParam5(String vcParam5) {
        this.vcParam5 = vcParam5;
    }

    public String getVcParam6() {
        return vcParam6;
    }

    public void setVcParam6(String vcParam6) {
        this.vcParam6 = vcParam6;
    }

    public int getiFlag() {
        return iFlag;
    }

    public void setiFlag(int iFlag) {
        this.iFlag = iFlag;
    }

    public String getVcMemo() {
        return vcMemo;
    }

    public void setVcMemo(String vcMemo) {
        this.vcMemo = vcMemo;
    }
}