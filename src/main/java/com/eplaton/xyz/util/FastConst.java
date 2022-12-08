package com.eplaton.xyz.util;


/**
 * Fast 시스템에 쓰이는 전역변수
 * 
 * @author ckim
 * @version 1.0
 * @see
 *  
 */

public class FastConst {

    /* Session keys USER - 사용자ID 세션 정보 */
    public static String SESSION_KEY_USER_ID = "FastUserId";
    
    /* Session keys USER - 사용자의 PK, in_user_id, out_user_id */
    public static String SESSION_KEY_PK_USER_ID = "FastPKUserId";

    /* Session keys USER - 사용자유형 세션 정보 */
    public static String SESSION_KEY_USER_TYPE = "FastUserType";

    /* Session keys USER - 사용자권한 세션 정보 */
    public static String SESSION_KEY_USER_AUTHORITY = "FastUserAuthority";
    
    /* Session keys USER - 접근가능한 파산재단 정보*/
    public static String SESSION_KEY_USER_ACC_BRFDINFO = "FastUserAccBrFdInfo";
    
    /* Session keys USER - 현재선택된 파산재단 정보*/
    public static String SESSION_KEY_USER_SELECTED_BRFDINFO = "FastUserSelBrFdMstList";
    
    /* Session keys USER - 즐겨찾기*/
    public static String SESSION_KEY_USER_FAVORITE = "FastUserFavorite";
    
    /* Session keys USER - 금융권구분코드 */
    public static String SESSION_KEY_USER_FINAREAGBCD = "FastFinAreaGbCd";
    
    /* Session keys USER - 사용자명 */
    public static String SESSION_KEY_USER_NAME = "FastUserName";
    
    /* Session keys USER - 로그인후메시지관리 */
    public static String SESSION_KEY_USER_BIZINFO = "FastUserBizInfo";    
    
    /* 사번 */
    public static String SESSION_KEY_EMP_NO = "empNo";
    
    /* 파산재단 확정일자 */
    public static String SESSION_KEY_BRFD_CLOSING_DATE = "BrFdClosingDate";
    
    
    /* 사용자 유형 */
    public static final int USER_TYPE_INNER = 1; // 공사직원

    public static final int USER_TYPE_OUTWORK = 2; // 파산재단 관재인

    public static final int USER_TYPE_ASSIST = 3; // 파산재단 보조인

    public static final int USER_TYPE_RFC = 4; // RFC 직원

    public static final int USER_TYPE_OTHER = 5; // 외부 직원
    
    /* 마감 여부 */
    public static String CLOSE_Y = "0";		//마감
    
    public static String CLOSE_N = "1";	//미마감
    
}
