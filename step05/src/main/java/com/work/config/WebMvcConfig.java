package com.work.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	// DI interceptor 객체 : 다중 인스턴스의 경우 Qualifier 사용해 해당 instance 지정 
	@Autowired
	@Qualifier("beforeActionInterceptor")
	HandlerInterceptor beforeActionInterceptor;
	
	@Autowired
	@Qualifier("needToAdminInterceptor")
	HandlerInterceptor needToAdminInterceptor;
	
	@Autowired
	@Qualifier("needToLoginInterceptor")
	HandlerInterceptor needToLoginInterceptor;
	
	@Autowired
	@Qualifier("needToLogoutInterceptor")
	HandlerInterceptor needToLogoutInterceptor;

	// 인터셉터 클래스와 자원 및 요청들에 대한 인터셉터를 연결추가 설정 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 1. brforeActionInterceptor : 사용자인증, 관리자권한 정보 설정 위한 인터셉터 
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**")
			.excludePathPatterns("/css/**").excludePathPatterns("/js/**").excludePathPatterns("/img/**");
		//	.excludePathPatterns("/resource/**");
		
		// 2. needToLoginInterceptor : 로그인 체킹 인터셉터
		registry.addInterceptor(needToLoginInterceptor).addPathPatterns("/**").addPathPatterns("/memberDetail")
			.excludePathPatterns("/css/**").excludePathPatterns("/js/**").excludePathPatterns("/img/**")
			.excludePathPatterns("/").excludePathPatterns("/main")
			.excludePathPatterns("/loginForm").excludePathPatterns("/login")
			.excludePathPatterns("/joinForm").excludePathPatterns("/join");
		
		// 3. needToLogoutInterceptor : 로그인 상태에서는 사용할수 없음
		registry.addInterceptor(needToLogoutInterceptor).addPathPatterns("/loginForm")
			.addPathPatterns("/login").addPathPatterns("/joinForm")
			.addPathPatterns("/join").addPathPatterns("/joinForm");
		
		// 4. needToAdminInterceptor : 
		registry.addInterceptor(needToAdminInterceptor)
			.addPathPatterns("/memberList");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
