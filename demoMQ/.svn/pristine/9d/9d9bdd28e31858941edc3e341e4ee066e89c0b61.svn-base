package com.qif.mainstate.common.interceptor;

import com.qif.mainstate.manage.tag.entity.BasePacket;
import com.qif.mainstate.manage.tag.entity.Heartbeat;
import com.qif.mainstate.util.ByteUtil;

/**
 * @author chenwei
 * @time 2019-01-25
 */

public class HeartBeatHandler extends BasePacketHandler {

    /**
     * 将对象心跳对象转成byte数组
     */
    public byte[] getPacket(Heartbeat heartbeat) {
        return getBytes(heartbeat);
    }

    /**
     * 将byte数组转成心跳对象
     */
    public BasePacket getHeartBeat(byte[] packet) {

        return getBean(packet);
    }

    private BasePacket getBean(byte[] packet) {
        Heartbeat heartbeat = new Heartbeat();
        return getBaseBean(packet, heartbeat);
    }

    /**
     * 将心跳特有的属性转成byte数组返回
     */
    @Override
    protected byte[] getContentBytes(BasePacket packet) {
        Heartbeat heartbeat = (Heartbeat) packet;
        //放入时间
        byte content[] = ByteUtil.int2Bytes(heartbeat.getClockTimeStamp());
        //放入电压
        content = addBytes(content, ByteUtil.float2HexBytes(heartbeat.getBatteryVoltage()));
        //放入温度
        content = addBytes(content, ByteUtil.float2HexBytes(heartbeat.getOperationTemperature()));
        //放入电量
        content = addBytes(content, ByteUtil.float2HexBytes(heartbeat.getBatteryCapacity()));
        byte[] floatingCharge = {heartbeat.getFloatingCharge()};
        //放浮充状态
        content = addBytes(content, floatingCharge);
        //放入总工作时长
        content = addBytes(content, ByteUtil.int2Bytes(heartbeat.getTotalWorkingTime()));
        //放入本次工作时长
        content = addBytes(content, ByteUtil.int2Bytes(heartbeat.getWorkingTime()));
        //放入链接状态
        byte[] connectionState = {heartbeat.getConnectionState()};
        content = addBytes(content, connectionState);
        //放入当月发送流量
        content = addBytes(content, ByteUtil.int2Bytes(heartbeat.getSendFlow()));
        //放入本月接收流量
        content = addBytes(content, ByteUtil.int2Bytes(heartbeat.getReceiveFlow()));
        //放入版本号
        content = addBytes(content, ByteUtil.version2Bytes(heartbeat.getProtocolVersion()));
        return content;
    }

    /**
     * 将基类报文对象里剩余的byte数组转成心跳特有的属性
     */
    @Override
    protected BasePacket getPacketBean(BasePacket base) {
        Heartbeat heartbeat = (Heartbeat) base;
        byte[] content = heartbeat.getContent();
        int length = 0;

        byte[] clockTime = new byte[4];
        System.arraycopy(content, length, clockTime, 0, clockTime.length);
        heartbeat.setClockTimeStamp(ByteUtil.bytes2Int(clockTime));
        length += clockTime.length;

        byte[] voltage = new byte[4];
        System.arraycopy(content, length, voltage, 0, voltage.length);
        heartbeat.setBatteryVoltage(ByteUtil.hexBytes2Float(voltage));
        length += voltage.length;

        byte[] temperature = new byte[4];
        System.arraycopy(content, length, temperature, 0, temperature.length);
        heartbeat.setOperationTemperature(ByteUtil.hexBytes2Float(temperature));
        length += temperature.length;

        byte[] capacity = new byte[4];
        System.arraycopy(content, length, capacity, 0, capacity.length);
        heartbeat.setBatteryCapacity(ByteUtil.hexBytes2Float(capacity));
        length += capacity.length;

        heartbeat.setFloatingCharge(content[length]);
        length++;

        byte[] totalWork = new byte[4];
        System.arraycopy(content, length, totalWork, 0, totalWork.length);
        heartbeat.setTotalWorkingTime(ByteUtil.bytes2Int(totalWork));
        length += totalWork.length;

        byte[] workTime = new byte[4];
        System.arraycopy(content, length, workTime, 0, workTime.length);
        heartbeat.setWorkingTime(ByteUtil.bytes2Int(workTime));
        length += workTime.length;

        heartbeat.setConnectionState(content[length]);
        length++;

        byte[] sendFlow = new byte[4];
        System.arraycopy(content, length, sendFlow, 0, sendFlow.length);
        heartbeat.setSendFlow(ByteUtil.bytes2Int(sendFlow));
        length += sendFlow.length;

        byte[] receiveFlow = new byte[4];
        System.arraycopy(content, length, receiveFlow, 0, receiveFlow.length);
        heartbeat.setReceiveFlow(ByteUtil.bytes2Int(receiveFlow));
        length += receiveFlow.length;

        byte[] version = new byte[4];
        System.arraycopy(content, length, version, 0, version.length);
        heartbeat.setProtocolVersion(ByteUtil.bytes2Version(version));
        return heartbeat;
    }

}
