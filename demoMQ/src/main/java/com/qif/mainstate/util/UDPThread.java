/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UDPThread
 * Author:   Administrator
 * Date:     2019/1/24 16:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.util;

import com.qif.mainstate.common.interceptor.ByteConsts;
import com.qif.mainstate.common.interceptor.HeartBeatHandler;
import com.qif.mainstate.common.interceptor.HeartBeatResponseHandler;
import com.qif.mainstate.manage.tag.entity.HeartBeatResponse;
import com.qif.mainstate.manage.tag.entity.Heartbeat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * udp线程工具类
 */
public class UDPThread implements Runnable {

    DatagramSocket socket = null;
    DatagramPacket packet = null;

    public UDPThread(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
    }

    @Override
    public void run() {
        String info = null;
        InetAddress address = null;
        int port = 8800;
        byte[] data2 = null;
        DatagramPacket packet2 = null;
        try {
            //打印当前请求socket客户端的请求数据和信息。
//            info = new String(packet.getData(), 0, packet.getLength());
            Heartbeat heartbeat = new Heartbeat();
            HeartBeatHandler heartBeatHandler = new HeartBeatHandler();
            heartbeat = (Heartbeat) heartBeatHandler.getHeartBeat(packet.getData());
            System.out.println("我是服务器，客户端说：" + heartbeat);
            //封装数据包，响应给当前socket实例的客户端
            address = packet.getAddress();
            port = packet.getPort();
//            data2 = "我在响应你".getBytes();
            packet2 = new DatagramPacket(responseMessage(), responseMessage().length, address, port);
            socket.send(packet2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] makeMessage() {
        Heartbeat heartbeat = new Heartbeat();
        heartbeat.setSync(ByteConsts.PACKET_HEAD);
        heartbeat.setCmdID("01234567891234567");
        heartbeat.setFrameType(ByteConsts.FrameType.FRAME_TYPE_9);
        heartbeat.setPacketType(ByteConsts.PacketType.PACKET_TYPE_30);
        heartbeat.setFrameNo((byte) 0x01);
        heartbeat.setClockTimeStamp((int) (System.currentTimeMillis() / 1000));
        heartbeat.setBatteryVoltage(3.5f);
        heartbeat.setOperationTemperature(60.8f);
        heartbeat.setBatteryCapacity(1000.5f);
        heartbeat.setFloatingCharge(ByteConsts.FloatingCharge.STATUS_1);
        heartbeat.setTotalWorkingTime(100);
        heartbeat.setWorkingTime(3);
        heartbeat.setConnectionState(ByteConsts.ConnectionState.STATUS_0);
        heartbeat.setSendFlow(10000);
        heartbeat.setReceiveFlow(20000);
        heartbeat.setProtocolVersion("1.2.4.10");
        HeartBeatHandler heartBeatHandler = new HeartBeatHandler();
        byte[] datas = heartBeatHandler.getPacket(heartbeat);
//        heartbeat = (Heartbeat) heartBeatHandler.getHeartBeat(datas);
        return datas;
    }

    /**
     * 响应心跳
     *
     * @return
     */
    private byte[] responseMessage() {
        HeartBeatResponse heartBeatResponse = new HeartBeatResponse();
        heartBeatResponse.setSync(ByteConsts.PACKET_HEAD);
        heartBeatResponse.setCmdID("01234567891234567");
        heartBeatResponse.setFrameType(ByteConsts.FrameType.FRAME_TYPE_9);
        heartBeatResponse.setPacketType(ByteConsts.PacketType.PACKET_TYPE_30);
        heartBeatResponse.setFrameNo((byte) 0x01);
        heartBeatResponse.setCommandStatus(ByteConsts.CommandStatus.STATUS_0);
        heartBeatResponse.setMode(ByteConsts.Mode.STATUS_0);
        heartBeatResponse.setClocktimeStamp((int) (System.currentTimeMillis() / 1000));
        HeartBeatResponseHandler heartBeatResponseHandler = new HeartBeatResponseHandler();
        byte[] datas = heartBeatResponseHandler.getPacket(heartBeatResponse);
//        heartbeat = (Heartbeat) heartBeatHandler.getHeartBeat(datas);
        return datas;
    }
}