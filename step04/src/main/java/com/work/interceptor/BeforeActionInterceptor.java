package com.work.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.work.dto.Member;

import lombok.extern.slf4j.Slf4j;

/**
 * 다중 핸들러 인터셉터를 구분하기 위해 bean-name 설정
 * 사용자 로그인 인증, 권한 부여 정보 설정 처리 인터셉터
 * @author incoq
 *
 */
@Component("beforeActionInterceptor") 
@Slf4j
public class BeforeActionInterceptor implements HandlerInterceptor {

	/**
	 * 요청처리 전에 호출 수행, false 반환하면 Controller 수행하지 않음 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.debug("##beforeActionInterceptor :: ");
		
		// 세션 객체 가져오기 
		HttpSession session = request.getSession();
		
		// 세션 객체에 설정된 세션정보 가져오기 : 로그인 요청시에 설정해놓은 세션정보를 기반으로 코딩
		String memberId = (String)session.getAttribute("memberId");
		String grade = (String)session.getAttribute("grade");
		
		Member dto = (Member)session.getAttribute("dto");
		
		boolean isLogin = false;
		boolean isAdmin = false;
		
		// 로그인 여부 체킹
		if(memberId != null || (dto != null && dto.getMemberId() != null)) {
			isLogin = true;
		}
		
		// 관리자 여부 체킹
		if(grade.equals("A") || (dto != null && dto.getGrade() != null)) {
			isAdmin = true;
		}
		
		// 요청객체에 사용자 인증여부, 관리자 여부 정보 설정 
		request.setAttribute("isLogin",	isLogin);
		request.setAttribute("isAdmin",	isAdmin);
		
		log.debug("isLogin :: " + isLogin);
		log.debug("isAdmin :: " + isAdmin);
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/**
	 * 요청처리 후에 호출 수행 Controller에서 요청처리중에 예외발생시 수행하지 않음 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 요청처리 후에 응답전송 되면 호출 수행, 응답 view 생성시에 예외발생시 수행하지 않음 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
