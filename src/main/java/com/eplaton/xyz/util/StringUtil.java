package com.eplaton.xyz.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Fast 시스템에 쓰이는 문자열 조작 클래스
 * 
 * @author djsong
 * @version 1.0
 * @see
 *  
 */
public class StringUtil {
    private static final DecimalFormat df_comma = new DecimalFormat("###,###,###,###,##0");

    /**
     * String에서 token 문자를 삭제한다.
     * 
     * @param value
     *        원래 String 값
     * @param token
     *        삭제할 문자
     * @return String 삭제된 String 값
     */
    public static String removeChar(String value, String token) {
        if (value == null || "".equals(value))
            return "";

        int index = 0;
        StringBuffer toBuf = new StringBuffer(value);
        while (true) {
            index = toBuf.toString().indexOf(token);
            if (index == -1)
                break;

            toBuf = toBuf.delete(index, index + 1);
        }

        return toBuf.toString();
    }

    /**
     * 전각문자 스페이스 없애는 메소드이다. <br>
     * mrna의 계약자 이름 뒤에 12288 값을 갖는 전각문자 스페이스가 붙는다. 이 문자는 trim() 메소드로 지워지지 않는다.
     * 
     * @param src
     *        원래 문자열
     * @return String 처리된 문자열
     */
    public static String trimFullWord(String src) {
        if (src == null)
            return null;

        StringBuffer sb = new StringBuffer();
        String tmp = src.trim();
        int len = tmp.length();
        for (int i = 0; i < len; i++) {
            char c = tmp.charAt(i);
            if (c == 12288)
                continue;
            sb.append(c);
        }

        return sb.toString();
    }

    /**
     * 전각문자 스페이스를 공백으로 변환한다 <br>
     * mrna의 계약자 이름 뒤에 12288 값을 갖는 전각문자 스페이스가 붙는다. 이 문자는 trim() 메소드로 지워지지 않는다.
     * 
     * @param src
     *        원래 문자열
     * @return String 처리된 문자열
     */
    public static String trimFullToBlank(String src) {
        if (src == null)
            return null;

        StringBuffer sb = new StringBuffer();
        String tmp = src.trim();
        int len = tmp.length();
        for (int i = 0; i < len; i++) {
            char c = tmp.charAt(i);
            if (c == 12288) {
                sb.append("/");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String filterArea(String targetString) {
        if (targetString == null)
            return "";
        String returnValue = "";
        targetString.trim();
        StringTokenizer token = new StringTokenizer(targetString, "/");
        String dongName = "";
        while (token.hasMoreTokens()) {
            dongName = token.nextToken();
        }

        return dongName;

    }

    public static String htmlEscape(String src) {
        if (src == null)
            return null;

        StringBuffer sb = new StringBuffer();
        int len = src.length();
        for (int i = 0; i < len; i++) {
            char c = src.charAt(i);
            String escapeStr = null;
            switch (c) {
            case '>':
                escapeStr = "&gt;";
                break;
            case '<':
                escapeStr = "&lt;";
                break;
            case '&':
                escapeStr = "&amp;";
                break;
            case '"':
                escapeStr = "&quot;";
                break;
            case '\'':
                escapeStr = "&quot;";
                break;
            }

            if (escapeStr == null)
                sb.append(c);
            else
                sb.append(escapeStr);
        }

        return sb.toString();
    }

    public static String crTobr(String src) {
        if (src == null)
            return null;

        StringBuffer sb = new StringBuffer();
        int len = src.length();
        for (int i = 0; i < len; i++) {
            char c = src.charAt(i);
            if (c == '\n') {
                sb.append("<br>");
            } else if (c == '\r') {
                continue;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * src 의 oldString 문자열이 변경된 새로운 스트링을 반환. newString 이 null 이라면, src를 반환한다. src에 영향을 주지 않는다.
     */
    public static String replace(String src, String oldString, String newString) {
        if (oldString == null || "".equals(oldString.trim()) || newString == null) {
            return src;
        }

        String targetString = new String(src);

        int index = 0;

        //int count = 0;;
        String result = "";
        while (targetString.indexOf(oldString) >= 0) {
            index = targetString.indexOf(oldString);

            // 시작과 끝이 변경대상 스트링이면, 새로운 스트링으로 변경.
            if (index == 0) {
                result = newString;
                targetString = targetString.substring(oldString.length());
            } else if (index == targetString.length() - oldString.length()) {
                result += targetString.substring(0, index) + newString;
                targetString = "";
                break;
            } else {
                result += targetString.substring(0, index) + newString;
                targetString = targetString.substring(index + oldString.length());
            }
        }

        result += targetString;
        return result;
    }

    /**
     * 구분자에 따라 분할된 스트링 리스트를 반환한다.
     * 
     * @param src
     * @param delimeter
     * @return
     */
    public static List token(String src, String delimeter) {
        if (delimeter == null || "".equals(delimeter.trim()))

        {
            return new ArrayList();
        }

        List tokenList = new ArrayList();
        String targetString = new String(src);

        int index = 0;

        int count = 0;
        ;
        String result = "";
        while (targetString.indexOf(delimeter) >= 0) {
            index = targetString.indexOf(delimeter);

            // 시작과 끝이 Delimeter 스트링이라면,
            if (index == 0) {
                targetString = targetString.substring(delimeter.length());
            } else if (index == targetString.length() - delimeter.length()) {
                tokenList.add(targetString.substring(0, index));
                targetString = "";
                break;
            } else {
                tokenList.add(targetString.substring(0, index));
                targetString = targetString.substring(index + delimeter.length());
            }
        }

        if (!"".equals(targetString)) {
            tokenList.add(targetString);
        }

        return tokenList;
    }

    /**
     * null 값을 ""로 변환해 준다.
     * 
     * @param str
     *        null을 체크할 string
     * @return string
     */
    public static String nullTosp(String str) {

        String ret = null;
        try {
            ret = str;
            if (str == null)
                ret = "";
            else
                ret = str;
        } catch (NullPointerException e) {
            ret = "";
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String nullTosp(Object str) {

        String ret = null;
        try {
            if (str == null)
                ret = "";
            else
                ret = (String) str;
        } catch (NullPointerException e) {
            ret = "";
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * null을 "0"으로 리턴해 준다.
     * 
     * @param str
     * @return
     */
    public static String nullToZero(String str) {

        String ret = null;
        try {
            ret = str;
            if (str == null || str.length() == 0)
                ret = "0";
        } catch (NullPointerException e) {
            ret = "0";
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * null을 "0"으로 리턴해 준다.
     * 
     * @param str
     * @return
     */
    public static String nullToZero(Object obj) {

        String ret = null;
        try {
            if (obj != null && obj.toString().length() > 0)
                ret = obj.toString();
            else
                ret = "0";
        } catch (NullPointerException e) {
            ret = "0";
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * null을 0으로 리턴해 준다.
     * 
     * @param str
     * @return
     */
    public static int nullToZeroInt(String str) {

        int rtn = 0;
        try {
            if (str == null || str.equals("")) {
                return 0;
            }
            rtn = new Integer(str).intValue();
        } catch (Exception e) {
        }
        return rtn;
    }

    /**
     * null을 0으로 리턴해 준다.
     * 
     * @param str
     * @return
     */
    public static double nullToZeroDouble(String str) {

        double rtn = 0;
        try {
            if (str == null || str.equals("")) {
                return 0;
            }
            rtn = new Double(str).doubleValue();
        } catch (Exception e) {
        }
        return rtn;
    }

    /**
     * int[]을 String[] 로 만들어 준다.
     * 
     * @param cd
     * @return
     */
    public static String[] makeStringArray(int[] cd) throws Exception {
        String[] res = null;
        if (cd != null) {
            res = new String[cd.length];
            int size = cd.length;
            for (int i = 0; i < size; i++) {
                res[i] = cd[i] + "";
            }
        }
        return res;
    }

    /**
     * String[]을 int[] 로 만들어 준다.
     * 
     * @param cd
     * @return
     */
    public static int[] makeIntArray(String[] cd) throws Exception {
        int[] res = null;
        if (cd != null) {
            res = new int[cd.length];
            int size = cd.length;
            for (int i = 0; i < size; i++) {
                res[i] = nullToZeroInt(cd[i]);
            }
        }
        return res;
    }

    /**
     * String[]을 double[] 로 만들어 준다.
     * 
     * @param cd
     * @return
     */
    public static double[] makeDoubleArray(String[] cd) throws Exception {
        double[] res = null;
        if (cd != null) {
            res = new double[cd.length];
            int size = cd.length;
            for (int i = 0; i < size; i++) {
                res[i] = nullToZeroDouble(cd[i]);
            }
        }
        return res;
    }

    /**
     * long 숫자를 환 표시로 변환하여 준다.
     * 
     * 
     * @param l
     * @return
     * @throws Exception
     * @author abraxas
     */
    public static final String LongToMoneyFmt(long l) throws Exception {

        return df_comma.format(l);

    }

    /**
     * long을 월 만원 단위로 환산하여 준다.
     * 
     * @param l
     * @return
     * @throws Exception
     * @author abraxas
     */
    public static final String LongToRoundMoney(long l) throws Exception {

        String s = LongToFmtRoundComma(l, -4);

        return s;
    }

    /**
     * long 을 기준 단위로 반올림하여 원단위로 환산하여 준다.
     * 
     * @param l
     * @param i
     * @return
     * @author abraxas
     */
    public static final String LongToFmtRoundComma(long l, int i) {
        double d1 = round(i, (double) l);
        String s = "";
        if (i < 0)
            s = df_comma.format(Math.round(d1 / Math.pow(10D, -i)));
        else if (i == 0) {
            s = df_comma.format(Math.round(l));
        } else {
            DecimalFormat decimalformat = new DecimalFormat("###,###,###,###,##" + exp_fmt(i));
            s = decimalformat.format(d1);
        }
        return s;
    }

    public static final double round(int i, double d) {
        double d1 = 0.0D;
        d1 = (double) Math.round(d * Math.pow(10D, i)) / Math.pow(10D, i);
        return d1;
    }

    private static final String exp_fmt(int i) {
        if (i <= 0)
            return "";
        String s = "0.";
        for (int j = 1; j < i + 1; j++)
            s = s + "0";

        return s;
    }
    
    /**
     * @PARAM str 바꾸려는 문자열을 가진 원본
     * @PARAM pattern 찾을 문자열
     * @PARAM replace 바꿔줄 문자열
     * str="aaaaa k k"
     * pattern="k k"
     * replace="w w"
     * return = "aaaaa w w"
     */
    static String changeStr(String str, String pattern, String replace) {

      int s = 0; // 찾기 시작할 위치
      int e = 0; // StringBuffer에 append 할 위치
      StringBuffer result = new StringBuffer(); // 잠시 문자열 담궈둘 놈

      while ((e = str.indexOf(pattern, s)) >= 0) {
        result.append(str.substring(s, e));
        result.append(replace);
        s = e+pattern.length();
      }
      result.append(str.substring(s));
      return result.toString();
    }

    
}
