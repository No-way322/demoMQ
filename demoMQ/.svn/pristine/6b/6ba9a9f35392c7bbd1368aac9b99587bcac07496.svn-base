package com.qif.mainstate.common.interceptor;

/**
 * @author chenwei
 * @time 2019-01-24
 */

public class ByteConsts {

    //报文头
    public static final short PACKET_HEAD = 0x5AA5;
    //报文尾
    public static final short packet_end = 0x96;


    //帧类型
    public class FrameType {
        //监测数据报（监测装置上位机）
        public static final byte FRAME_TYPE_1 = 0x01;
        //数据响应报（上位机监测装置）
        public static final byte FRAME_TYPE_2 = 0x02;
        //控制数据报（上位机监测装置）
        public static final byte FRAME_TYPE_3 = 0x03;
        //控制响应报（监测装置上位机）
        public static final byte FRAME_TYPE_4 = 0x04;
        //图像数据报（监测装置上位机）
        public static final byte FRAME_TYPE_5 = 0x05;
        //图像数据响应报（上位机监测装置）（暂未使用）
        public static final byte FRAME_TYPE_6 = 0x06;
        //图像控制报（上位机监测装置）
        public static final byte FRAME_TYPE_7 = 0x07;
        //图像控制响应报（监测装置上位机）
        public static final byte FRAME_TYPE_8 = 0x08;
        //工作状态报（监测装置上位机）
        public static final byte FRAME_TYPE_9 = 0x09;
        //工作状态响应报（上位机监测装置）
        public static final byte FRAME_TYPE_10 = 0x0a;
    }

    //报文类型
    public class PacketType {
        //心跳数据报
        public static final byte PACKET_TYPE_30 = (byte) 0xC1;
    }

    //浮充状态
    public class FloatingCharge{
        //充电
        public static final byte STATUS_0 = (byte) 0x00;
        //放电
        public static final byte STATUS_1 = (byte) 0x01;
    }

    //连接状态
    public class ConnectionState{
        //①0x00与所有传感器连接正常
        public static final byte STATUS_0 = (byte) 0x00;
        //②0x01 与一个或者多个传感器连接异常
        public static final byte STATUS_1 = (byte) 0x01;
    }

    public class CommandStatus{
        //0xFF成功
        public static final byte STATUS_0 = (byte) 0xFF;
        //0x00失败
        public static final byte STATUS_1 = (byte) 0x00;
    }

    public class Mode{
        //0x00切换到正常模式
        public static final byte STATUS_0 = (byte) 0x00;
        //0x01切换到调试模式
        public static final byte STATUS_1 = (byte) 0x01;
    }
}
