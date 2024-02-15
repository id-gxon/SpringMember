package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);

	// /doD 호출 -> doE 호출

	// http://localhost:8088/web/doD
	@GetMapping(value = "/doD") // @RequestMapping(value = "/doD", method = RequestMethod.GET)
	public String doD(/* Model model */ RedirectAttributes rttr) {
		logger.debug("doD() 실행");

		// model.addAttribute("msg", "itwill01"); // pageRedirect하면 주소줄에 전달
		rttr.addFlashAttribute("msg", "itwill02"); // pageRedirect하면 전달
		/*
		 * addAttribute(attributeName, attributeValue); URI에 표시 O, F5 사용 시 데이터 유지
		 * 
		 * addFlashAttribute(attributeName, attributeValue); URI에 표시 X, F5 사용 시 데이터 소멸(일회성)
		 * Redirect 방식으로 페이지 이동 시에만 사용 가능
		 */

		// return "/doE";
		return "redirect:/doE"; // JSP sendRedirect를 사용한 호출(주소 변경 O, 화면 변경 O)
		// return "forward://doE"; // forward를 사용한 호출(주소 변경 X, 화면 변경 O)
		// return "redirect:/doE?msg=itwill";
	}

	// http://localhost:8088/web/doE
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public void doE(@ModelAttribute("msg") String msg) {
		logger.debug("doE() 실행");

		// doD에서 전달된 정보 출력
		logger.debug("msg: " + msg);
	}

	// http://localhost:8088/web/doF
	@RequestMapping(value = "/doF", method = RequestMethod.GET)
	public int doF() {
		logger.debug("doF() 실행");

		return 100;
	}
}
