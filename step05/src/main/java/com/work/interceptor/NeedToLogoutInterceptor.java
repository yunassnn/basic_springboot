package com.work.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Component("needToLogoutInterceptor") // 다중 핸들러 인터셉터를 구분하기 위해 bean-name 설정
@Slf4j
public class NeedToLogoutInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean isLogin = (boolean) request.getAttribute("isLogin");

		log.debug("needToLogoutInterceptor :: " + isLogin);

		if (isLogin) {
			// Javascript 사용해서 경고메시지 출력 후 로그인페이지로 이동 요청
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.append("<script>");
			out.append("alert('로그아웃 후 이용하시기 바랍니다.');");
			//out.append("location.replace('/loginForm');"); // 1. location으로 로그인창 이동
			out.append("history.back();");
			out.append("</script>");

			// response.sendRedirect("/loginForm"); // 2. sendRedirect 사용해 로그인창 이동

			return false; // 사용자 인증받지 않은 사용자 요청 거부(Controller 요청 수행하지 않음)
		}

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
