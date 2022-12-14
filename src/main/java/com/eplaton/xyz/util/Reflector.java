package com.eplaton.xyz.util;

/*
 * 작성된 날짜: 2007-07-07
 *
 * TODO 생성된 파일에 대한 템플리트를 변경하려면 다음으로 이동하십시오.
 * 창 - 환경 설정 - Java - 코드 스타일 - 코드 템플리트
 */
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author wsjang
 *
 *         Reflection을 사용하기 위한 utility class이다. 특정 object의 attribute(상위 class의
 *         attribute까지 포함한다)와 그 값을 map으로 바꾼다.<br>
 *         이 때 map의 key는 attribute의 이름이고 value는 attribute의 값이다.<br>
 */
final public class Reflector {
	/**
	 * Constructor for Reflector.
	 */
	private Reflector() {
		super();
	}

	private static List allFileds(Class clazz) {
		List fields = new ArrayList();
		Class parent = clazz;

		do {
			fields.addAll(Arrays.asList(parent.getDeclaredFields()));
			parent = parent.getSuperclass();
		} while (!parent.equals(Object.class));

		return fields;
	}

	/**
	 * 특정 object의 attribute(상위 class의 attribute까지 포함한다)와 그 값을 map으로 바꾼다.<br>
	 * 이 때 map의 key는 attribute의 이름이고 value는 attribute의 값이다.<br>
	 * 
	 * @param o
	 * @return Map
	 */
	public static Map objectToMap(Object o) {
		Map result = new HashMap();

		List fields = Reflector.allFileds(o.getClass());

		// synchronized (o)
		// {
		try {
			for (Iterator i = fields.iterator(); i.hasNext();) {
				Field f = (Field) i.next();
				f.setAccessible(true);
				result.put(f.getName(), f.get(o));
				f.setAccessible(false);
			}
		} catch (IllegalAccessException _e) {
		}
		// }

		return result;
	}

	/**
	 * 특정 object의 attribute(상위 class의 attribute까지 포함한다)와 그 값을 String 문자열로 바꾼다.<br>
	 * 문자열의 형식은 다음과 같다.<br>
	 * {class name=(attribute1 name : attribute1 value)(attribute2 name : attribute2
	 * value)...}<br>
	 * 
	 * @param o
	 * @return String
	 */
	public static String objectToString(Object o) {
		StringBuffer result = new StringBuffer();
		Class clazz = o.getClass();

		result.append("{").append(clazz.getName()).append("=");

		List fields = Reflector.allFileds(clazz);

		// synchronized (o)
		// {
		try {
			for (Iterator i = fields.iterator(); i.hasNext();) {
				Field f = (Field) i.next();
				f.setAccessible(true);
				result.append("(").append(f.getName()).append(":").append(f.get(o)).append(")");
				f.setAccessible(false);
			}
		} catch (IllegalAccessException _e) {
		}
		// }

		result.append("}");

		return result.toString();
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		CommonDTO com = new CommonDTO();
//		 System.out.println("SEND-"+Reflector.objectToString(com));
//
//	}
}

 class CommonDTO 
{

    private String terminalID;
    private String terminalType;
    private String xmlSeq;
    private String bankCode;
    private String branchCode;
    private String glPostBranchCode;
    private String channelType;
    private String userID;
    private String eventNo;
}

