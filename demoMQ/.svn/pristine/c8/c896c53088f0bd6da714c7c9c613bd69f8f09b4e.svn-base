/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HeartBeatResponse
 * Author:   Administrator
 * Date:     2019/1/29 10:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.manage.tag.entity;

/**
 * 心跳响应报文
 */
public class HeartBeatResponse extends BasePacket {

    //数据发送状态：①0xFF成功 ②0x00失败
    private byte commandStatus;

    //运行模式：①0x00切换到正常模式 ②0x01切换到调试模式
    private byte mode;

    //上位机当前时间（世纪秒，当值为0时，表示装置时间与上位机时间一致；当值非0时，装置需要根据该时间进行校时）
    private int clocktimeStamp;

    public byte getCommandStatus() {
        return commandStatus;
    }

    public void setCommandStatus(byte commandStatus) {
        this.commandStatus = commandStatus;
    }

    public byte getMode() {
        return mode;
    }

    public void setMode(byte mode) {
        this.mode = mode;
    }

    public int getClocktimeStamp() {
        return clocktimeStamp;
    }

    public void setClocktimeStamp(int clocktimeStamp) {
        this.clocktimeStamp = clocktimeStamp;
    }
}