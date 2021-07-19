package com.work.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 로그인 인증여부 처리 인터셉터
 * @author incoq
 *
 */
@Component("needToLoginInterceptor")
@Slf4j
public class NeedToLoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// beforeActionInterceptor 에서 isLogin 가져와서 로그인 여부체크
		boolean isLogin = (boolean)request.getAttribute("isLogin");
		log.debug("needToLoginInterceptor :: " + isLogin);
		
		if(!isLogin) {
			// Javascript 사용해서 경고메시지 출력 후 로그인페이지로 이동 요청
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.append("<script>");
			out.append("alert('로그인 후 이용하시기 바랍니다.');");
			//out.append("location.replace('/loginForm');"); // 1. location으로 로그인창 이동
			out.append("history.back();");
			out.append("</script>");
			
			
			//response.sendRedirect("/loginForm"); // 2. sendRedirect 사용해 로그인창 이동
			
			return false; // 사용자 인증받지 않은 사용자 요청 거부(Controller 요청 수행하지 않음)
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	

}
