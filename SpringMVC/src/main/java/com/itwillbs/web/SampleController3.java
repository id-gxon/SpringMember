package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController3 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);

	// http://localhost:8088/web/doC?userid=admin
	// http://localhost:8088/web/doC?userid=admin&userpw=1234&username=관리자&bno=100
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public String doC(/* @ModelAttribute("memberVO") */ MemberVO vo, @ModelAttribute("bno") String bno) {
		// MemberVO 객체에 저장되는 파라메터 자동 수집
		// MemberVO 객체에 저장되지 않는 파라메터는 따로 저장
		logger.debug("doC() 호출");

		logger.debug("vo: " + vo);

		return "result";
	}

	// http://localhost:8088/web/doC1
	@RequestMapping(value = "/doC1", method = RequestMethod.GET)
	public String doC1(Model model/* MemberVO vo 사용 불가 */ ) {
		// Model 객체 생성: 컨트롤러 <-> 뷰 페이지 사이에서 정보 전달하는 객체
		// 스프링에서 제공하는 기능(객체)
		logger.debug("doC1() 호출");

		// 컨트롤러의 데이터(DB)를 연결된 뷰 페이지에 전달
		MemberVO vo = new MemberVO();

		vo.setUserid("itwill");
		vo.setUserpw("1234");

		// 모델 객체에 정보를 저장
		model.addAttribute("vo", vo);

		// 연결된 뷰 페이지로 이동
		return "result";
	}

	// http://localhost:8088/web/doC2
	// http://localhost:8088/web/doC2?userid=admin&userpw=1234&username=관리자
	@RequestMapping(value = "/doC2", method = RequestMethod.GET)
	public String doC2(Model model, MemberVO vo) {
		logger.debug("doC2() 호출");

		MemberVO mvo = new MemberVO();

		mvo.setUserid("itwill");
		mvo.setUserpw("1234");

		// model.addAttribute("mvo", mvo);
		// request.setAttribute(key, value)의 동작을 수행
		model.addAttribute(mvo); // model.addAttribute("memberVO", mvo);
		// 전달하는 이름이 없는 경우 전달하는 데이터 타입의 클래스명 첫 글자를 소문자로 변경한 데이터를 key 값으로 사용하여 생성

		return "result";
	}

}
