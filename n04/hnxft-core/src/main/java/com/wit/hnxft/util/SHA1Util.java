package com.wit.hnxft.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

public class SHA1Util {

    private final int[] abcde = {0x67452301, 0xefcdab89, 0x98badcfe,
            0x10325476, 0xc3d2e1f0 };

    // 摘要数据存储数组
    private int[] digestInt = new int[5];

    // 计算过程中的临时数据存储数组
    private int[] tmpData = new int[80];

    /**
     * 计算sha-1摘要
     *
     * @param bytedata
     * @return
     */
    private int processInputBytes(byte[] bytedata) {
        // 初试化常量
        System.arraycopy(abcde, 0, digestInt, 0, abcde.length);
        // 格式化输入字节数组，补10及长度数据
        byte[] newbyte = byteArrayFormatData(bytedata);
        // 获取数据摘要计算的数据单元个数
        int mCount = newbyte.length / 64;
        // 循环对每个数据单元进行摘要计算
        for (int pos = 0; pos < mCount; pos++) {
            // 将每个单元的数据转换成16个整型数据，并保存到tmpData的前16个数组元素中
            for (int j = 0; j < 16; j++) {
                tmpData[j] = byteArrayToInt(newbyte, (pos * 64) + (j * 4));
            }
            // 摘要计算函数
            encrypt();
        }
        return 20;
    }

    /**
     * 格式化输入字节数组格式
     *
     * @param bytedata
     * @return
     */
    private byte[] byteArrayFormatData(byte[] bytedata) {
        // 补0数量
        int zeros = 0;
        // 补位后总位数
        int size = 0;
        // 原始数据长度
        int n = bytedata.length;
        // 模64后的剩余位数
        int m = n % 64;
        // 计算添加0的个数以及添加10后的总长度
        if (m < 56) {
            zeros = 55 - m;
            size = n - m + 64;
        }
        else if (m == 56) {
            zeros = 63;
            size = n + 8 + 64;
        }
        else {
            zeros = 63 - m + 56;
            size = (n + 64) - m + 64;
        }
        // 补位后生成的新数组内容
        byte[] newbyte = new byte[size];
        // 复制数组的前面部分
        System.arraycopy(bytedata, 0, newbyte, 0, n);
        // 获得数组Append数据元素的位置
        int l = n;
        // 补1操作
        newbyte[l++] = (byte) 0x80;
        // 补0操作
        for (int i = 0; i < zeros; i++) {
            newbyte[l++] = (byte) 0x00;
        }
        // 计算数据长度，补数据长度位共8字节，长整型
        byte h8 = (byte) (n & 0xFF);
        byte h7 = (byte) ((n >> 8) & 0xFF);
        byte h6 = (byte) ((n >> 16) & 0xFF);
        byte h5 = (byte) ((n >> 24) & 0xFF);
        byte h4 = (byte) ((n >> 32) & 0xFF);
        byte h3 = (byte) ((n >> 40) & 0xFF);
        byte h2 = (byte) ((n >> 48) & 0xFF);
        byte h1 = (byte) (n >> 56);
        newbyte[l++] = h1;
        newbyte[l++] = h2;
        newbyte[l++] = h3;
        newbyte[l++] = h4;
        newbyte[l++] = h5;
        newbyte[l++] = h6;
        newbyte[l++] = h7;
        newbyte[l++] = h8;
        return newbyte;
    }

    private int f1(int x, int y, int z) {
        return (x & y) | (~x & z);
    }

    private int f2(int x, int y, int z) {
        return x ^ y ^ z;
    }

    private int f3(int x, int y, int z) {
        return (x & y) | (x & z) | (y & z);
    }

    private int f4(int x, int y) {
        return (x << y) | x >>> (32 - y);
    }

    /**
     * 单元摘要计算函数
     */
    private void encrypt() {
        for (int i = 16; i <= 79; i++) {
            tmpData[i] = f4(tmpData[i - 3] ^ tmpData[i - 8] ^ tmpData[i - 14]
                    ^ tmpData[i - 16], 1);
        }
        int[] tmpabcde = new int[5];
        for (int i1 = 0; i1 < tmpabcde.length; i1++) {
            tmpabcde[i1] = digestInt[i1];
        }
        for (int j = 0; j <= 19; j++) {
            int tmp = f4(tmpabcde[0], 5)
                    + f1(tmpabcde[1], tmpabcde[2], tmpabcde[3]) + tmpabcde[4]
                    + tmpData[j] + 0x5a827999;
            tmpabcde[4] = tmpabcde[3];
            tmpabcde[3] = tmpabcde[2];
            tmpabcde[2] = f4(tmpabcde[1], 30);
            tmpabcde[1] = tmpabcde[0];
            tmpabcde[0] = tmp;
        }
        for (int k = 20; k <= 39; k++) {
            int tmp = f4(tmpabcde[0], 5)
                    + f2(tmpabcde[1], tmpabcde[2], tmpabcde[3]) + tmpabcde[4]
                    + tmpData[k] + 0x6ed9eba1;
            tmpabcde[4] = tmpabcde[3];
            tmpabcde[3] = tmpabcde[2];
            tmpabcde[2] = f4(tmpabcde[1], 30);
            tmpabcde[1] = tmpabcde[0];
            tmpabcde[0] = tmp;
        }
        for (int l = 40; l <= 59; l++) {
            int tmp = f4(tmpabcde[0], 5)
                    + f3(tmpabcde[1], tmpabcde[2], tmpabcde[3]) + tmpabcde[4]
                    + tmpData[l] + 0x8f1bbcdc;
            tmpabcde[4] = tmpabcde[3];
            tmpabcde[3] = tmpabcde[2];
            tmpabcde[2] = f4(tmpabcde[1], 30);
            tmpabcde[1] = tmpabcde[0];
            tmpabcde[0] = tmp;
        }
        for (int m = 60; m <= 79; m++) {
            int tmp = f4(tmpabcde[0], 5)
                    + f2(tmpabcde[1], tmpabcde[2], tmpabcde[3]) + tmpabcde[4]
                    + tmpData[m] + 0xca62c1d6;
            tmpabcde[4] = tmpabcde[3];
            tmpabcde[3] = tmpabcde[2];
            tmpabcde[2] = f4(tmpabcde[1], 30);
            tmpabcde[1] = tmpabcde[0];
            tmpabcde[0] = tmp;
        }
        for (int i2 = 0; i2 < tmpabcde.length; i2++) {
            digestInt[i2] = digestInt[i2] + tmpabcde[i2];
        }
        for (int n = 0; n < tmpData.length; n++) {
            tmpData[n] = 0;
        }
    }

    /**
     * 4字节数组转换为整数
     *
     * @param bytedata
     * @param i
     * @return
     */
    private int byteArrayToInt(byte[] bytedata, int i) {
        return ((bytedata[i] & 0xff) << 24) | ((bytedata[i + 1] & 0xff) << 16)
                | ((bytedata[i + 2] & 0xff) << 8) | (bytedata[i + 3] & 0xff);
    }

    //
    /**
     * 整数转换为4字节数组
     *
     * @param intValue
     * @param byteData
     * @param i
     */
    private void intToByteArray(int intValue, byte[] byteData, int i) {
        byteData[i] = (byte) (intValue >>> 24);
        byteData[i + 1] = (byte) (intValue >>> 16);
        byteData[i + 2] = (byte) (intValue >>> 8);
        byteData[i + 3] = (byte) intValue;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param ib
     * @return
     */
    private static String byteToHexString(byte ib) {
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] ob = new char[2];
        ob[0] = digit[(ib >>> 4) & 0X0F];
        ob[1] = digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param bytearray
     * @return
     */
    private static String byteArrayToHexString(byte[] bytearray) {
        String strDigest = "";
        for (byte element : bytearray) {
            strDigest += byteToHexString(element);
        }
        return strDigest.toLowerCase();
    }

    /**
     * 计算sha-1摘要，返回相应的字节数组
     *
     * @param byteData
     * @return
     */
    public byte[] getDigestOfBytes(byte[] byteData) {
        processInputBytes(byteData);
        byte[] digest = new byte[20];
        for (int i = 0; i < digestInt.length; i++) {
            intToByteArray(digestInt[i], digest, i * 4);
        }
        return digest;
    }

    /**
     * 计算sha-1摘要，返回相应的十六进制字符串
     *
     * @param byteData
     * @return
     */
    public String getDigestOfString(byte[] byteData) {
        return byteArrayToHexString(getDigestOfBytes(byteData));
    }

    /**
     * @param data
     * @return
     */
    public String digest(String data) {
        return this.getDigestOfString(data.getBytes());
    }

    /**
     * @param data
     * @return
     */
    public String digest(String data, String encode) {
        try {
            return this.getDigestOfString(data.getBytes(encode));
        }
        catch (UnsupportedEncodingException e) {
            return this.digest(data);
        }
    }

    /**
     * @param text
     * @return
     */
    public static String sha1Digest(String text) {
        String pwd = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(text.getBytes());
            pwd = new BigInteger(1, md.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pwd;
    }

    @SuppressWarnings("rawtypes")
    public static String createSign(Map<String, Object> map, String charset) {
        SortedMap<String, String> packageParams = new TreeMap<String, String>();
        for (Map.Entry<String, Object> m : map.entrySet()) {
            packageParams.put(m.getKey(), m.getValue().toString());
        }

        StringBuffer sb = new StringBuffer();
        Set<?> es = packageParams.entrySet();
        Iterator<?> it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!StringUtils.isEmpty(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        SHA1Util sha1 = new SHA1Util();
        String sb2 = sb.toString();
        String sign = sha1.digest(sb2.substring(0, sb2.length() - 1), charset)
                .toLowerCase();
        return sign;
    }

    public  String getSignature(String jsapiTicket, String timestamp,
            String nonce, String jsurl) throws IOException {
        /****
         * 对 jsapi_ticket、 timestamp 和 nonce 按字典排序 对所有待签名参数按照字段名的 ASCII
         * 码从小到大排序（字典序）后，使用 URL 键值对的格式（即key1=value1&key2=value2…）拼接成字符串
         * string1。这里需要注意的是所有参数名均为小写字符。 接下来对 string1 作 sha1 加密，字段名和字段值都采用原始值，不进行
         * URL 转义。即 signature=sha1(string1)。
         * **如果没有按照生成的key1=value&key2=value拼接的话会报错
         */
        String[] paramArr = new String[] {"jsapi_ticket=" + jsapiTicket,
                "timestamp=" + timestamp, "noncestr=" + nonce, "url=" + jsurl };
        Arrays.sort(paramArr);
        // 将排序后的结果拼接成一个字符串
        String content = paramArr[0].concat("&" + paramArr[1]).concat("&" + paramArr[2])
                .concat("&" + paramArr[3]);
        String gensignature = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // 对拼接后的字符串进行 sha1 加密
            byte[] digest = md.digest(content.toString().getBytes());
            gensignature = byteToStr(digest);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将 sha1 加密后的字符串与 signature 进行对比
        if (gensignature != null) {
            return gensignature; // 返回signature
        }
        else {
            return "false";
        }
        // return (String) (ciphertext != null ? ciphertext: false);
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}
