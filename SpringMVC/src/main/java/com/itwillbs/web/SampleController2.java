package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController2 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);

	// doB 주소 실행하는 동작 http://localhost:8088/web/doB
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public void doB() {
		logger.debug("doB() 호출");
	}

	// 메서드 리턴 타입이 String일 때 이동하는 페이지는 리턴문자.jsp
	// http://localhost:8088/web/doB1
	@RequestMapping(value = "/doB1", method = RequestMethod.GET)
	public String doB1() {
		logger.debug("doB1() 호출");

		// 리턴 데이터.jsp로 이동
		return "itwill";
	}

	public void main(String[] args) {

	}

	// http://localhost:8088/web/doB2
	// http://localhost:8088/web/doB2?msg=아이티윌
	// http://localhost:8088/web/doB2?msg=아이티윌&tel=0518030909
	@RequestMapping(value = "/doB2", method = RequestMethod.GET)
	public String doB2(@ModelAttribute("msg") String msg, @ModelAttribute("tel") String tel) {
		// @ModelAttribute("전달되는 타입의 이름") String 전달되는 타입의 이름 	
		// => 컨트롤러 호출 시 전달 정보를 저장 & 연결된 jsp에 전달

		logger.debug("doB2() 호출");

		logger.debug("msg: " + msg);
		logger.debug("tel: " + tel);

		// 리턴 데이터.jsp로 이동
		return "itwill";
	}

	// http://localhost:8088/web/doB3?msg=아이티윌&tel=0518030909&tel=01012344567
	@RequestMapping(value = "/doB3", method = RequestMethod.GET)
	public String doB3(@RequestParam("msg") String msg, @RequestParam("tel") String[] tel, @RequestParam("tel") String tel2) {
		// @RequestParam("전달되는 타입의 이름") String 전달되는 타입의 이름 	
		// => request.getParamater()의 동작

		logger.debug("doB3() 호출");

		logger.debug("msg: " + msg);
		logger.debug("tel: " + tel);
		logger.debug("tel2: " + tel2);

		// 리턴 데이터.jsp로 이동
		return "itwill";
	}

}
