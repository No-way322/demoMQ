package com.qif.mainstate.manage.tag.entity;

/**
 * @author chenwei
 * @time 2019-01-24
 */
//心跳内容
public class Heartbeat extends BasePacket {
    //当前时间
    private int clockTimeStamp;
    //电源电压（浮点数，精确到小数点后1位，单位：V）
    private float batteryVoltage;
    //工作温度（浮点数，精确到小数点后1位，单位：℃）
    private float operationTemperature;
    //电池剩余电量（浮点数，精确到小数点后1位，单位：Ah）
    private float batteryCapacity;
    //浮充状态：①0x00充电 ②0x01放电
    private byte floatingCharge;
    //工作总时间（无符号整数，单位：小时）
    private int totalWorkingTime;
    //本次连续工作时间（无符号整数，单位：小时）
    private int workingTime;
    //连接状态：①0x00与所有传感器连接正常 ②0x01 与一个或者多个传感器连接异常
    private byte connectionState;
    //当月发送流量（无符号整数，单位：字节）
    private int sendFlow;
    //当月接收流量（无符号整数，单位：字节）
    private int receiveFlow;
    //通信协议版本号（带小数位）四个部分，每个字节代表一段；
    // 举例：版本号1.2.4.10的4个字节表示为：01 02 04 0A
    private String protocolVersion;

    public int getClockTimeStamp() {
        return clockTimeStamp;
    }

    public void setClockTimeStamp(int clockTimeStamp) {
        this.clockTimeStamp = clockTimeStamp;
    }

    public float getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(float batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public float getOperationTemperature() {
        return operationTemperature;
    }

    public void setOperationTemperature(float operationTemperature) {
        this.operationTemperature = operationTemperature;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public byte getFloatingCharge() {
        return floatingCharge;
    }

    public void setFloatingCharge(byte floatingCharge) {
        this.floatingCharge = floatingCharge;
    }

    public int getTotalWorkingTime() {
        return totalWorkingTime;
    }

    public void setTotalWorkingTime(int totalWorkingTime) {
        this.totalWorkingTime = totalWorkingTime;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    public byte getConnectionState() {
        return connectionState;
    }

    public void setConnectionState(byte connectionState) {
        this.connectionState = connectionState;
    }

    public int getSendFlow() {
        return sendFlow;
    }

    public void setSendFlow(int sendFlow) {
        this.sendFlow = sendFlow;
    }

    public int getReceiveFlow() {
        return receiveFlow;
    }

    public void setReceiveFlow(int receiveFlow) {
        this.receiveFlow = receiveFlow;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }
}
