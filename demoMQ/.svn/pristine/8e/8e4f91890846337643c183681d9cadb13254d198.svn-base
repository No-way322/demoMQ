package com.qif.mainstate.common.interceptor;

import com.qif.mainstate.manage.tag.entity.BasePacket;
import com.qif.mainstate.util.ByteUtil;
import com.qif.mainstate.util.CRC16Util;
import com.qif.mainstate.util.CrcUtils;

/**
 * @author chenwei
 * @time 2019-01-28
 */

public abstract class BasePacketHandler {

    /**
     * 将报文实体类的头尾转成byte数组
     * */
    protected byte[] getBytes(BasePacket packet) {
        byte[] crcContent = getCrcContent(packet);
        //放入头
        byte[] packetBytes = ByteUtil.short2Bytes(packet.getSync());
        //把内容放进去
        packetBytes = addBytes(packetBytes, crcContent);
        //放入尾
        byte[] end = {packet.getEnd()};
        packetBytes = addBytes(packetBytes, end);
        return packetBytes;
    }

    /**
     * 讲报文实体类对象的固定字段转成byte数组
     * */
    private byte[] getCrcContent(BasePacket packet) {
        byte[] content = getContentBytes(packet);
        packet.setPacketLength((short) content.length);
        //放入报文长度
        byte[] crcContent = ByteUtil.short2Bytes(packet.getPacketLength());

        String hexIdStr = ByteUtil.str2HexStr(packet.getCmdID());
        //放入设备id
        crcContent = addBytes(crcContent, ByteUtil.hexStr2Bytes(hexIdStr));
        //放入帧类型
        byte[] frameType = {packet.getFrameType()};
        crcContent = addBytes(crcContent, frameType);
        //放入报文类型
        byte[] packetType = {packet.getPacketType()};
        crcContent = addBytes(crcContent, packetType);
        //放入帧序列号
        byte[] frameNo = {packet.getFrameNo()};
        crcContent = addBytes(crcContent, frameNo);
        //放入内容
        crcContent = addBytes(crcContent, content);
//        packet.setCrc16(CrcUtils.getCrc(CrcUtils.calcCrc16(crcContent)));
        packet.setCrc16((short) CrcUtils.calcCrc16(crcContent));
        //放入校验位
        crcContent = addBytes(crcContent, ByteUtil.crcStr2Bytes(String.valueOf(packet.getCrc16())));
        return crcContent;
    }

    /**
     * 将两个byte数组拼成一个byte数组
     * */
    protected byte[] addBytes(byte[] old, byte[] add) {
        byte[] newByte = new byte[old.length + add.length];
        System.arraycopy(old, 0, newByte, 0, old.length);
        System.arraycopy(add, 0, newByte, old.length, add.length);
        old = null;
        add = null;
        return newByte;
    }

    /**
     * 先转头尾
     * */
    protected BasePacket getBaseBean(byte[] packetBytes,BasePacket packet) {
        byte[] sync = new byte[2];
        System.arraycopy(packetBytes, 0, sync, 0, sync.length);
        packet.setSync(ByteUtil.bytes2short(sync));

        packet.setEnd(packetBytes[packetBytes.length - 1]);

        byte[] crc = new byte[2];
        int length = 1 + crc.length;
        System.arraycopy(packetBytes, packetBytes.length - length, crc, 0, crc.length);
        packet.setCrc16(ByteUtil.bytes2short(crc));

        byte[] crcContent = new byte[packetBytes.length - sync.length - length];
        System.arraycopy(packetBytes, sync.length, crcContent, 0, crcContent.length);
        packet.setContent(crcContent);
        return getFixedPacket(packet);
    }

    /**
     * 再转固定字段
     * */
    protected BasePacket getFixedPacket(BasePacket packet) {
        byte[] crcContent = packet.getContent();
        int length = 0;
        byte[] packetLength = new byte[2];
        System.arraycopy(crcContent, length, packetLength, 0, packetLength.length);
        packet.setPacketLength(ByteUtil.bytes2short(packetLength));
        length += packetLength.length;

        byte[] cmdId = new byte[17];
        System.arraycopy(crcContent, length, cmdId, 0, cmdId.length);
        packet.setCmdID(ByteUtil.hexStr2Str(ByteUtil.bytes2HexStr(cmdId)));
        length += cmdId.length;

        packet.setFrameType(crcContent[length]);
        length++;
        packet.setPacketType(crcContent[length]);
        length++;
        packet.setFrameNo(crcContent[length]);
        length++;

        int contentLength = crcContent.length - length;
        byte[] content = new byte[contentLength];
        System.arraycopy(crcContent, length, content, 0, contentLength);
        packet.setContent(content);
        return getPacketBean(packet);
    }

    /**
     * 最后通过子类里实现该方法将报文里特有的属性转成byte数组返回
     */
    protected abstract byte[] getContentBytes(BasePacket packet);

    /**
     * 最后通过子类里实现该方法去转换每个报文特有的属性，并将对象返回回来
     * */
    protected abstract BasePacket getPacketBean(BasePacket packet);

}
