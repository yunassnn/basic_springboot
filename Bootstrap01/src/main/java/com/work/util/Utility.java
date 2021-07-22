package com.work.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utility {
	/**
	 * <pre>
	 * 아규먼트로 전달받은 날짜 형식, 로케일 형식의 현재날짜 변환 반환 메서드
	 * 로케일 : java.util.Locale => FIELD 참고
	 * java.util.SimpleDateFormat 생성자 중복정의 => public SimpleDateFormat(String, Locale)
	 * 
	 * </pre>
	 * @see java.util.Locale
	 * @see java.util.SimpleDateFormat
	 * @param pattern  날짜형식  및 시간 형식
	 * @param locale 로케일형식
	 * @return  날짜 형식, 로케일 형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern, Locale locale) {
		return new SimpleDateFormat(pattern, locale).format(new Date());
	}
	
	/**
	 * 아규먼트로 전달받은 날짜 형식의 현재날짜 변환 반환 메서드 
	 * @param pattern 날짜형식
	 * @return 날짜형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern) {
		//return new SimpleDateFormat(pattern).format(new Date());
		return getCurrentDate(pattern, Locale.KOREA);
	}
	
	/**
	 * 현재 날짜를 기본날짜형식 년도 4자리.월2자리.일2자리 형식의 문자열 변환 반환 메서드
	 * @return 기본 형식의 현자낼짜 문자열
	 */
	public static String getCurrentDate() {
		return getCurrentDate("yyyy-MM-dd");
	}
}
