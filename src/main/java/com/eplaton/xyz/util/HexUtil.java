package com.eplaton.xyz.util;


/**
 * 통신 패킷을 생성하는데 필요한 유틸리티 클래스
 * 
 * @version 1.0
 */
public class HexUtil {

    /**
     * byte array를 Hex String 으로 만들어 준다
     */
    private static final char[] hex = "0123456789ABCDEF".toCharArray();

    /**
     * unsigned byte를 int로 변환한다.
     * 
     * @param input
     * @return
     */
    public static int unsignedByteToInt(byte input) {
        return (int) input & 0xFF;
    }

    /**
     * short를 바이트 어레이로 변환한다.
     * 
     * @param input
     * @return
     */
    public static byte[] shortToBytes(short input) {
        byte[] output = new byte[2];
        output[0] = (byte) (input >>> 8);
        output[1] = (byte) (input);
        return output;
    }

    /**
     * 바이트 어레이를 short로 변환한다.
     * 
     * @param input
     * @return
     */
    public static short bytesToShort(byte input[]) {
        short output = 0;
        int pos = 0;
        output += unsignedByteToInt(input[pos++]) << 8;
        output += unsignedByteToInt(input[pos++]) << 0;
        return output;
    }

    /**
     * int를 바이트 어레이로 변환한다.
     * 
     * @param input
     * @return
     */
    public static byte[] intToBytes(int input) {
        byte[] output = new byte[4];
        output[0] = (byte) (input >>> 24);
        output[1] = (byte) (input >>> 16);
        output[2] = (byte) (input >>> 8);
        output[3] = (byte) (input);
        return output;
    }

    /**
     * 바이트 어레이를 int로 변환한다.
     * 
     * @param input
     * @return
     */
    public static int bytesToInt(byte input[]) {
        int output = 0;
        int pos = 0;
        output += unsignedByteToInt(input[pos++]) << 24;
        output += unsignedByteToInt(input[pos++]) << 16;
        output += unsignedByteToInt(input[pos++]) << 8;
        output += unsignedByteToInt(input[pos++]) << 0;
        return output;
    }

    /**
     * 바이트 어레이를 Hex 스트링으로 변환한다.
     * 
     * @param b
     * @return
     */
    public static String bytesToHex(byte[] b) {
        if (b == null)
            return "";
        //return null;

        char[] ret = new char[b.length * 2];
        for (int i = 0, j = 0; i < b.length; ++i) {
            ret[j++] = hex[(b[i] & 0xF0) >> 4];
            ret[j++] = hex[b[i] & 0xF];
        }
        return new String(ret);
    }

    /**
     * 1 바이트를 스트링으로 변환한다.
     * 
     * @param b
     * @return
     */
    public static String byteToHex(byte b) {
        if (new Byte(b) == null)
            return "";

        char[] ret = new char[2];
        ret[0] = hex[(b & 0xF0) >> 4];
        ret[1] = hex[(b & 0xF)];

        return new String(ret);
    }

    /**
     * Hex 스트링을 바이트 어레이로 변환한다.
     * 
     * @param s
     * @return
     */
    public static byte[] hexToBytes(String s) {
        if (s == null)
            return null;
        if (s.length() == 0)
            return null;

        byte[] ret = new byte[s.length() / 2];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = (byte) Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16);
        }
        return ret;
    }

    /**
     * 바이트 어레이를 스트링으로 변환한다.
     * 
     * @param b
     * @return
     */
    public static String byteToString(byte[] b) {
        String str = "";
        for (int i = 0; i < b.length; i++) {
            str += String.valueOf((char) b[i]);
        }
        return str;
    }

    /**
     * 단위 테스트를 실시한다.
     * 
     * @param args
     */
    public static void main(String[] args) {
        byte[] a = null;
        String b = "a";

        int aaa = 255;
        //aaa는 반드시 0 ~ 255 내에 있어야 한다.
        String bbb = byteToHex((byte) aaa);
        System.out.println("bbb: " + bbb);

        System.out.println("B: " + bytesToHex(a));
        System.out.println("A: " + hexToBytes(b));
        System.out.println("C: " + b.length() / 2);
    }
}