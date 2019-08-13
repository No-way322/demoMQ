package com.qif.mainstate.manage.tag.entity;

/**
 * @author chenwei
 * @time 2019-01-28
 */

public class BasePacket {
    private int id;
    //报文头：5AA5
    private short sync=0X5AA5;
    //校验位
    private short crc16;
    //报文尾：0x96
    private byte end;
    //报文长度
    private short packetLength;
    //状态监测装置ID（17位编码）
    private String cmdID;
    //帧类型
    private byte frameType;
    //报文类型
    private byte packetType;
    //帧序列号（无符号整数）
    private byte frameNo;
    private byte[] content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getSync() {
        return sync;
    }

    public void setSync(short sync) {
        this.sync = sync;
    }

    public short getCrc16() {
        return crc16;
    }

    public void setCrc16(short crc16) {
        this.crc16 = crc16;
    }

    public byte getEnd() {
        return end;
    }

    public void setEnd(byte end) {
        this.end = end;
    }

    public short getPacketLength() {
        return packetLength;
    }

    public void setPacketLength(short packetLength) {
        this.packetLength = packetLength;
    }

    public String getCmdID() {
        return cmdID;
    }

    public void setCmdID(String cmdID) {
        this.cmdID = cmdID;
    }

    public byte getFrameType() {
        return frameType;
    }

    public void setFrameType(byte frameType) {
        this.frameType = frameType;
    }

    public byte getPacketType() {
        return packetType;
    }

    public void setPacketType(byte packetType) {
        this.packetType = packetType;
    }

    public byte getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(byte frameNo) {
        this.frameNo = frameNo;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
