package com.eplaton.xyz.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Fast 시스템에 쓰이는 날짜 유틸리티 클래스
 * 
 * @author djsong
 * @version 1.0
 * @see
 *  
 */

public class DateUtil {
    public static String DEFAULT_DATE_FOMART = "yyyyMMdd";

    public static String DOT_MONTH_FOMART = "yyyy.MM";

    public static String DOT_DATE_FOMART = "yyyy.MM.dd";

    public static String DASH_DATE_FOMART = "yyyy-MM-dd";

    public static String DEFAULT_DATETIME_FOMART = "yyyyMMddHHmmss";

    public static String DOT_DATETIME_FOMART = "yyyy.MM.dd HH:mm:ss";

    public static String DASH_DATETIME_FOMART = "yyyy-MM-dd HH:mm:ss";

    public static String DOT_DATE_MIN_FOMART = "yyyy.MM.dd HH:mm";

    /**
     * java.util.Date 형의 데이터를 format아규먼트형의 날자 스트링으로 변환한다.
     * 
     * @param date
     *        Date String형으로 변환할 날짜
     * @return String format 형의 날자 스트링
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * java.util.Date 형의 데이터를 'YYYYMMDD'형의 날자 스트링으로 변환한다.
     * 
     * @param date
     *        Date String형으로 변환할 날짜
     * @return String 'YYYYMMDD' 형의 날자 스트링
     */
    public static String dateToString(Date date) {
        return dateToString(date, DEFAULT_DATE_FOMART);
    }

    /**
     * format아규먼트형 형태의 날자 입력 스트링을 java.util.Date형으로 변환한다.
     * 
     * @param sourceDate
     *        String format아규먼트형 형태의 날자 입력 스트링
     * @return Date
     */
    public static Date stringToDate(String sourceDate, String format) {
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            date = formatter.parse(sourceDate);
        } catch (java.text.ParseException pe) {
            //			pe.printStackTrace();
        }
        return date;
    }

    /**
     * "yyyyMMdd"형태의 날자 입력 스트링을 java.util.Date형으로 변환한다.
     * 
     * @param sourceDate
     *        String yyyy-MM-dd"형태의 날자 입력 스트링
     * @return Date
     */
    public static Date stringToDate(String sourceDate) {
        return stringToDate(sourceDate, DEFAULT_DATE_FOMART);
    }

    /**
     * "yyyyMMddHHmmss" 형식의 sourceDate를 java.util.Date 형으로 바꿈.
     * 
     * @param sourceDate
     * @return Date
     */
    public static Date stringToDateTime(String sourceDate) {
        return stringToDate(sourceDate, DEFAULT_DATETIME_FOMART);
    }

    /**
     * 현재 시간을 Date형으로 반환
     * 
     * @return Date
     */
    public static Date currentDate() {
        Calendar calendar = Calendar.getInstance();
        Date apTime = calendar.getTime();
        return apTime;
    }

    /**
     * 현재 시간을 "yyyyMMddHHmmss" 형식을 갖는 문자열로 반환한다.
     * 
     * @mod__returnType String
     * @name currentDateTimeString
     */
    public static String currentDateTimeString() {
        Calendar calendar = Calendar.getInstance();
        return dateToString(calendar.getTime(), DEFAULT_DATETIME_FOMART);
    }

    /**
     * 현재 시간을 "yyyyMMdd" 형식을 갖는 문자열로 반환한다.
     * 
     * @mod__returnType String
     * @name currentDateString
     */
    public static String currentDateString() {
        Calendar calendar = Calendar.getInstance();
        return dateToString(calendar.getTime(), DEFAULT_DATE_FOMART);
    }

    /**
     * 현재 시간을 "yyyyMMdd" 형식을 갖는 문자열로 반환한다.
     * 
     * @mod__returnType String
     * @name currentDateString
     */
    public static String currentDateString(String format) {
        Calendar calendar = Calendar.getInstance();
        return dateToString(calendar.getTime(), format);
    }

    /**
     * 기준일을 기준으로 주어진 날 수 이전의 년월일을 반환한다.
     */
    public static String getDateStringBeforeDay(String baseDate, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtil.stringToDate(baseDate));
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return dateToString(calendar.getTime(), DEFAULT_DATE_FOMART);
    }

    public static int diffYear(String date1, String date2) {
        int diff = diffMonth(date1, date2);
        if (diff == -1)
            return -1;

        return (diff / 12);
    }

    public static int diffMonth(String date1, String date2) {
        java.util.Date d1 = null;
        java.util.Date d2 = null;
        int paymentMethodType = 0;
        try {
            SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FOMART);
            d1 = df.parse(date1);
            d2 = df.parse(date2);
        } catch (Exception e) {
            return -1;
        }

        return diffMonth(d1, d2);
    }

    public static int diffMonth(Date date1, Date date2) {
        if (date1 == null || date2 == null)
            return -1;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        int date1Year = cal.get(Calendar.YEAR);
        int date1Month = cal.get(Calendar.MONTH) + 1;
        cal.setTime(date2);
        int date2Year = cal.get(Calendar.YEAR);
        int date2Month = cal.get(Calendar.MONTH) + 1;

        int diffYear = date2Year - date1Year;
        int diffMonth = date2Month - date1Month;

        return (diffYear * 12) + diffMonth;
    }

    /**
     * 고객정보 관리에서 사용된다.
     * 
     * 검색에 필요한 형태의 Date Format으로 변환한다.
     * 
     * @param sourceDate
     * @return String
     */
    public static String convertSearchDateFormat(String sourceDate) {
        if (sourceDate == null || sourceDate.trim().length() == 0)
            return "";

        Date date = DateUtil.stringToDate(sourceDate, DateUtil.DOT_DATE_FOMART);
        return DateUtil.dateToString(date, DateUtil.DEFAULT_DATE_FOMART);
    }

    /**
     * 현재 시간을 sql.Date형으로 반환
     * 
     * @return Date
     */
    public static java.sql.Date currentSqlDate() {
        Calendar calendar = Calendar.getInstance();

        java.sql.Date apTime = new java.sql.Date(calendar.getTime().getTime());
        return apTime;
    }
}