package com.qif.mainstate.util;

/**
 * @author chenwei
 * @time 2019-01-24
 */
//16进制转换工具
public class ByteUtil {


    /**
     * 字符串转换成为16进制(无需Unicode编码)
     *
     * @param str
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     *
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }


    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * byte[]转16进制字符串
     *
     * @param bytes
     * @return
     */
    public static String bytes2HexStr(byte[] bytes) {
        // 一个byte为8位，可用两个十六进制位标识
        char[] buf = new char[bytes.length * 2];
        int a = 0;
        int index = 0;
        for (byte b : bytes) {
            // 使用除与取余进行转换
            if (b < 0) {
                a = 256 + b;
            } else {
                a = b;
            }
            buf[index++] = HEX_CHAR[a / 16];
            buf[index++] = HEX_CHAR[a % 16];
        }
        return new String(buf);
    }

    /**
     * 16进制字符串转byte[]
     */
    public static byte[] hexStr2Bytes(String hexStr) {
        if (hexStr == null || hexStr.equals("")) {
            return null;
        }
        // toUpperCase将字符串中的所有字符转换为大写
        hexStr = hexStr.toUpperCase();
        int length = hexStr.length() / 2;
        // toCharArray将此字符串转换为一个新的字符数组。
        char[] hexChars = hexStr.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    //charToByte返回在指定字符的第一个发生的字符串中的索引，即返回匹配字符
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * short转成byte[]
     */
    public static byte[] short2Bytes(short x) {
        byte high = (byte) (0x00FF & (x >> 8));//定义第一个byte
        byte low = (byte) (0x00FF & x);//定义第二个byte
        byte[] bytes = new byte[2];
        bytes[0] = high;
        bytes[1] = low;
        return bytes;
    }

    /**
     * byte[]转成short
     */
    public static short bytes2short(byte[] bytes) {
        byte high = bytes[0];
        byte low = bytes[1];
        short z = (short) (((high & 0x00FF) << 8) | (0x00FF & low));
        return z;

    }

    //byte[] 转 int型
    public static int bytes2Int(byte[] b) {
        int a = b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
        return a;
    }

    //int型转byte[]
    public static byte[] int2Bytes(int a) {
        return new byte[]{
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    /**
     * 浮点型转成byte[]
     */
    public static byte[] float2HexBytes(float num) {
        //这个浮点数的位布局的整数值
        int a = Float.floatToIntBits(num);
        return int2Bytes(a);
    }

    //byte数组转换成浮点数
    public static float hexBytes2Float(byte data[]) {
        int a = bytes2Int(data);
        return Float.intBitsToFloat(a);
    }

    /**
     * 把带点的版本号转成16进制byte数组
     */
    public static byte[] version2Bytes(String version) {
        String temps[] = version.split("\\.");
        byte versions[] = new byte[temps.length];
        for (int i = 0; i < temps.length; i++) {
            int a = Integer.valueOf(temps[i]);
            versions[i] = (byte) a;
        }
        return versions;
    }

    /**
     * 把byte数组转成带点的版本号
     */
    public static String bytes2Version(byte[] versions) {
        String version = "";
        for (byte v : versions) {
            int a = v;
            version += a + ".";
        }
        version = version.substring(0, version.length() - 1);
        return version;
    }

    /**
     * 把带空格的校验码转成byte数组
     */
    public static byte[] crcStr2Bytes(String crc) {
        String temps[] = crc.split(" ");
        byte versions[] = new byte[temps.length];
        for (int i = 0; i < temps.length; i++) {
            int a = Integer.valueOf(temps[i]);
            versions[i] = (byte) a;
        }
        return versions;
    }

    /**
     * 把byte数组转成带空格的校验码
     */
    public static String bytes2CrcStr(byte[] crc) {
        String version = "";
        for (byte v : crc) {
            int a = Integer.valueOf(v);
            version += a + " ";
        }
        version = version.substring(0, version.length() - 1);
        return version;
    }

    public static int byte2Unsigned(byte s) {
        return s & 0xFF;
    }


}
