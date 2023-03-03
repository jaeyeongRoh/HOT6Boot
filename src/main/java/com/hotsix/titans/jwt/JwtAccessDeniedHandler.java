//package com.hotsix.titans.jwt;
//
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///* SecurityConfig의 권한별 요청에 대한 예외처리용으로 생성(유효한 자격 증명이 없을 시에 401상태코드를 발생용) */
//@Component
//public class JwtAccessDeniedHandler implements AccessDeniedHandler{
//
//	@Override
//	public void handle(HttpServletRequest request, HttpServletResponse response,
//			AccessDeniedException accessDeniedException) throws IOException, ServletException {
//
//		/* 유효한 자격증명을 제공하지 않고 접근 시 401 상태코드 발생 */
//		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//	}
//
//}
//
//
