/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HeartBeatResponseHandler
 * Author:   Administrator
 * Date:     2019/1/29 10:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.common.interceptor;

import com.qif.mainstate.manage.tag.entity.BasePacket;
import com.qif.mainstate.manage.tag.entity.HeartBeatResponse;
import com.qif.mainstate.util.ByteUtil;

public class HeartBeatResponseHandler extends BasePacketHandler {

    /**
     * 将对象心跳响应转成byte数组
     */
    public byte[] getPacket(HeartBeatResponse heartBeatResponse) {
        return getBytes(heartBeatResponse);
    }

    /**
     * 将byte数组转成心跳响应对象
     */
    public BasePacket getHeartBeat(byte[] packet) {

        return getBean(packet);
    }

    private BasePacket getBean(byte[] packet) {
        HeartBeatResponse heartBeatResponse = new HeartBeatResponse();
        return getBaseBean(packet, heartBeatResponse);
    }

    /**
     * 将心跳响应特有的属性转成byte数组返回
     */
    @Override
    protected byte[] getContentBytes(BasePacket packet) {
        HeartBeatResponse heartBeatResponse = new HeartBeatResponse();


        //数据发送状态：①0xFF成功 ②0x00失败
        byte content[] = {heartBeatResponse.getCommandStatus()};
//        content = addBytes(content, commandStatus);
        //运行模式：①0x00切换到正常模式 ②0x01切换到调试模式
        byte[] mode = {heartBeatResponse.getMode()};
        content = addBytes(content, mode);
        //上位机当前时间
        content = addBytes(content, ByteUtil.int2Bytes(heartBeatResponse.getClocktimeStamp()));
        return content;
    }

    @Override
    protected BasePacket getPacketBean(BasePacket packet) {
        HeartBeatResponse heartBeatResponse = (HeartBeatResponse) packet;
        byte[] content = heartBeatResponse.getContent();
        int length = 0;

        heartBeatResponse.setCommandStatus(content[length]);
        length++;

        heartBeatResponse.setMode(content[length]);
        length++;

        byte[] clocktimeStamp = new byte[4];
        System.arraycopy(content, length, clocktimeStamp, 0, clocktimeStamp.length);
        heartBeatResponse.setClocktimeStamp(ByteUtil.bytes2Int(clocktimeStamp));
        length += clocktimeStamp.length;

        return heartBeatResponse;
    }
}