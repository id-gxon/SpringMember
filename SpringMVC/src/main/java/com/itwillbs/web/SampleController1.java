package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* 
 * @Controller: 일반 클래스를 컨트롤러로 사용하도록 설정
 * 				Servlet-context.xml에서 해당 객체를 컨트롤러 빈(객체)으로 인식
 */

@Controller
public class SampleController1 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);

	/*
	 * JSPMVC
	 * web.xml(매핑) - Controller -> (doGet / doPost) => doProcess
	 * 
	 * 1. 가상 주소 계산
	 * 2. 가상 주소 매핑(패턴 1, 2, 3) - Action 객체 - DAO 처리
	 * 3. 가상 주소 이동
	 */

	/*
	 * SpringMVC에서의 컨트롤러 동작
	 * - 스프링에서 처리하는 작업
	 * 		1) URI를 부넉해서 적절한 컨트롤러 호출(~.me, ~.bo)
	 * 		2) 컨트롤러에 필요한 메서드 호출
	 * 		3) 컨트롤러의 결과를 뷰 페이지로 전달
	 * 		4) 호출 주소에 맞는 적절한 뷰 페이지 연결
	 * 		5) 파라메터 자동 수집
	 * 
	 * - 개발자가 처리하는 작업
	 * 		1) 특정 주소에 동작하는 컨트롤러 설계
	 * 		2) 서비스 객체 생성
	 * 		3) DAO 객체 생성
	 * 		4) 컨트롤러에서 실행하는 동작을 메서드로 설계
	 * 		5) 정보를 전달받아 출력
	 */

	// 동작1 http://localhost:8088/web/doA
	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	/* /doA 주소를 get방식으로 호출하면 아래 메서드를 실행 */
	public void doA() {
		logger.debug("doA() 호출");
		
		/*
		 * SpringMVC에서 자동으로 연결된 뷰 페이지로 이동(은닉)
		 * 이동할 페이지 정보
		 *  -> 메서드의 리턴 타입이 void일 때
		 *  	호출된 주소.jsp 뷰 페이지로 연결
		 */
	}
}
