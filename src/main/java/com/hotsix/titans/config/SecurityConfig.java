package com.hotsix.titans.config;

import com.hotsix.titans.jwt.JwtAccessDeniedHandler;
import com.hotsix.titans.jwt.JwtAuthenticationEntryPoint;
import com.hotsix.titans.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfig {

	private final TokenProvider tokenProvider;
	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

	@Autowired
	public SecurityConfig(TokenProvider tokenProvider
			            , JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint
			            , JwtAccessDeniedHandler jwtAccessDeniedHandler) {
		this.tokenProvider = tokenProvider;
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
		this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
	}

	/* 1. 암호화 처리를 위한 PasswordEncoder를 빈으로 설정(빈을 등록 시 메소드 이름 오타 없을 것) */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/* 2. 시큐리티 설정을 무시 할 정적 리소스 등록 */
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/images/**",
				                                   "/lib/**", "/profileImages/**");
	}

	/* 3. HTTP요청에 대한 권한별 설정(세션 인증 -> 토큰 인증으로 인해 바뀐 부분 존재) */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable()
			.exceptionHandling()

			/* 기본 시큐리티 설정에서 JWT 토큰과 관련된 유효성과 권한 체크용 설정 */
			.authenticationEntryPoint(jwtAuthenticationEntryPoint)	// 유효한 자격 증명 없을 시(401)
			.accessDeniedHandler(jwtAccessDeniedHandler)			// 필요한 권한 없이 접근 시(403)
		    .and()
		    .authorizeRequests()
		    	.antMatchers("/").authenticated()
		    	.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()		// cors를 위해 preflight 요청 처리용 options 요청 허용
		    				// preflight request란? 요청 할 url이 외부 도메인일 경우 웹 브라우저에서 자체 실행되며 options 메소드로 사전 요청을 보내게 된다.

				/* 로그인 */
				.antMatchers("/auth/login").permitAll()

				/* 마이페이지 */
				.antMatchers("/api/v1/members/**").permitAll()
				.antMatchers("/api/vi/simpleMember/**").permitAll()
				.antMatchers("/api/v1/mypage/**").permitAll()
//				.antMatchers("/api/v1/members/{memberCode}").permitAll()	// 회원 한명 조회
//				.antMatchers("/api/vi/simpleMember/{memberCode}").permitAll()	// 회원 간단정보 조회
//				.antMatchers("/api/v1/members/allMember/count").permitAll()		// 전사원 count
//				.antMatchers("/api/v1/mypage/management/update/{memberCode}").permitAll()	// 개인정보 변경
//				.antMatchers("/api/v1/members/password/{memberCode}").permitAll()	// 비밀번호 변경
//				.antMatchers("/api/v1/members/profileImage/{memberCode}").permitAll()	// 프로필 이미지 변경

				/* 인사 */
				.antMatchers("/api/v1/organization/chart").permitAll()	//	재직자 명단 조회
				// 증명서 신청현황
				.antMatchers("/auth/signup").hasRole("ADMIN")	// 신규 사원 등록
				.antMatchers("/api/v1/organization/retireeChart").hasRole("ADMIN")	// 퇴직자 명단 조회

				/* 근태 - 현재는 인사팀 기능만 있음 */
				.antMatchers("/api/v1/attendance/**").hasRole("ADMIN")
//				.antMatchers("/api/v1/attendance").permitAll()
//				.antMatchers("/api/v1/attendance/mypageAregist").permitAll()
//				.antMatchers("/api/v1/attendance/mypageAfinishRegist").permitAll()
//				.antMatchers("/api/v1/attendance/mypageAregistSelect").permitAll()
//				.antMatchers("/api/v1/attendance/modalSave").permitAll()

				/* 휴가 */
				.antMatchers("/api/v1/annual/**").permitAll()
//				.antMatchers("/api/v1/annual/standardsManagement/**").permitAll()		// 휴가 기준
//				.antMatchers("/api/v1/mypage/main/{memberCode}")	----?????
//				.antMatchers("/api/v1//annual/management/{startIndex}/{endIndex}").hasRole("ADMIN")		// 전사원 연차 조회

				/* 전자결재 */
				.antMatchers("/ea/**").permitAll()
				.antMatchers("/ea/eaLeave/**").permitAll() // 사전에 요청이 안전한지 확인하기 위함(유효한지 서버에 미리 파악할 수 있도록 보내는 수단이다.)

				/* 급여 */
//				.antMatchers("/api/v1/salary/check/{memberCode}/**").permitAll()
				.antMatchers("/api/v1/salary/check/{memberCode}/{year}/{month}").permitAll()	// 날짜에 따른 내 급여 조회

				.antMatchers("/api/v1/salary/check/detail/{selectedSalaryCode}").hasRole("ADMIN")	// 급여 코드에 해당하는 상세 급여 조회
				.antMatchers("/api/v1/salary/check/all/{year}/{month}/{paymentsYn}").hasRole("ADMIN")	// 지급 여부와 날짜에 따른 급여 조회
				.antMatchers("/api/v1/salary/check/insert/{memberCode}").hasRole("ADMIN")	// 사원번호 입력받아 급여 정보 조회
				.antMatchers("/api/v1/salary/check/all/{selectedSalaryCode}").hasRole("ADMIN")	// 급여 지급하여 지급여부 상태 변경
				.antMatchers("/api/v1/salary/month/insert").hasRole("ADMIN")		// 급여 지급하기

				.antMatchers("/api/v1/salary/bonus/**").hasRole("ADMIN")	// 상여금
//				.antMatchers("/api/v1/salary/bonus/{year}/{month}").hasRole("ADMIN")		// 상여금 명단 리스트 조회
//				.antMatchers("/api/v1/salary/bonus/check/{memberCode}").hasRole("ADMIN")		// 사원번호에 해당하는 상여자 조회
//				.antMatchers("/api/v1/salary/bonus/insert/{salaryCode}").hasRole("ADMIN")	// 상여 명단 추가

				/* 게시판 */
				.antMatchers("/api/v1/board/notice").permitAll()	// 공지사항 리스트 조회
				.antMatchers("/api/v1/board/notice/insert").hasRole("ADMIN")	// 공지사항 글쓰기
				.antMatchers("/api/v1//board/notice/{noticeCode}").hasRole("ADMIN")	// 공지사항 수정, 삭제

				/* 캘린더 */
				.antMatchers("/api/v1/calendar/main").permitAll()
				.antMatchers("/api/v1/calendar/addSchedule").hasRole("ADMIN")
				.antMatchers("/api/v1/calendar/delete/{calendarCode}").hasRole("ADMIN")

				/* 메세지 */
				.antMatchers("/api/v1/message/**").permitAll()
//				.antMatchers("/api/v1/message/msgAllMember").permitAll()
//				.antMatchers("/api/v1/message/{messageCode}").permitAll()
//				.antMatchers("/api/v1/message/search/{memberName1}").permitAll()
				.antMatchers("/api/v1/messageReceived").permitAll()
				.antMatchers("/api/v1/messageReceivedCount").permitAll()
				.antMatchers("/api/v1/messageSent").permitAll()
				.antMatchers("/api/v1/messageSentCount").permitAll()

//		    	.antMatchers("/api/**").hasRole("MEMBER")
//		    	.antMatchers("/api/**").hasRole("ADMIN")
//				.antMatchers("/api/**").hasAnyRole("MEMBER", "ADMIN")
//		    	.anyRequest().permitAll();	// 어떤 요청이든 허용 가능, 시큐리티를 활용한 로그인이 모두 완성 되지 않았을 때 활용할 것
			.and()

				/* 세션 인증 방식을 쓰지 않겠다는 설정 */
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.cors()
			.and()

				/* jwt 토큰 방식을 쓰겠다는 설정 */
				.apply(new JwtSecurityConfig(tokenProvider));
		return http.build();
	}

	/* 4. CORS 설정용 Bean(허용 할 origin과 httpMethod 종류와 header 값) */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE"));
		configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Content-type"
													, "Access-Control-Allow-Headers", "Authorization"
													, "X-Requested-With"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}


}




