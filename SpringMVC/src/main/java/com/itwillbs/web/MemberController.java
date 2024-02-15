package com.itwillbs.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value = "/member/*") // /member/로 시작도는 모든 주소를 처리하는 컨트롤러
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService mService;

	// http://localhost:8088/web/test.me (X)
	// http://localhost:8088/web/member/test.me
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void testMe() {
		logger.debug("testMe() 호출");
	}

	// http://localhost:8088/web/member/memberjoin
	// 회원가입(입력) - GET 방식(정보 입력, 조회, 출력)
	@RequestMapping(value = "/memberjoin", method = RequestMethod.GET)
	public void memberJoinGET() {
		logger.debug("memberJoinGET() 실행 - 회원 정보 입력");
		logger.debug("연결된 뷰 페이지로 이동");
	}

	// 회원가입(처리) - POST 방식(처리, DB 사용)
	@RequestMapping(value = "/memberjoin", method = RequestMethod.POST)
	public String MemberJoinPOST(MemberVO vo) {
		logger.debug("MemberJoinPOST() 실행 - 회원 정보 처리");

		// 0. 한글 처리 - web.xml에 필터 사용 처리

		// 1. 전달 정보 저장(submit)
		logger.debug("회원가입 vo: " + vo);

		// 2. Service -> DB에 전달 정보 저장
		mService.memberJoin(vo);

		logger.debug("회원가입 성공");

		// 3. 페이지 이동(로그인 페이지 - GET)
		return "redirect:/member/login";
	}

	// http://localhost:8088/web/member/login (X)
	// http://localhost:8088/member/login
	// 로그인 - GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void memberLoginGET() {
		logger.debug("login.jsp - memberLoginGET() 호출");
		logger.debug("/member/login.jsp 연결");
	}

	// 로그인 - POST
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memberLoginPOST(MemberVO vo, HttpSession session/* ,
																	@ModelAttribute("userid") String userid,
																	@RequestParam("userpw") String userpw */) {
		logger.debug("login.jsp - memberLoginPOST() 호출");
		logger.debug("로그인 vo: " + vo);

		MemberVO resultVO = mService.memberLogin(vo);

		String addr = "";

		if (resultVO == null) {
			logger.debug("로그인 실패!");

			addr = "/member/login";
		} else {
			logger.debug("로그인 성공");

			// 로그인 성공한 계정 정보를 세션에 저장
			session.setAttribute("id", resultVO.getUserid());

			addr = "/member/main";
		}

		return "redirect:" + addr;
	}

	// http://localhost:8088/member/main
	// main page - GET
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String memberMainGET(HttpSession session) {
		logger.debug("memberMainGET() 실행");
		logger.debug("main.jsp 이동");

		return "/member/main"; // String 형태로 리턴 시에는 컨트롤러 주소를 포함한 페이지 이름을 작성
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String memberLogoutGET(HttpSession session) {
		logger.debug("memberLogoutGET() 실행");

		// 세션 정보 초기화
		session.invalidate();

		logger.debug("세션 객체 초기화");

		return "redirect:/member/main";
	}

	// 회원정보 조회
	@GetMapping(value = "/info")
	public void memberInfoGET(Model model, HttpSession session) {
		logger.debug("memberInfoGET() 실행");
		logger.debug("info.jsp 이동");

		String userid = (String) session.getAttribute("id");
		logger.debug("userid: " + userid);

		model.addAttribute(mService.memberInfo(userid));
	}

	// 회원정보 수정 - GET
	@GetMapping(value = "/update")
	public void memberUpdateGET(Model model, HttpSession session) {
		logger.debug("memberUpdateGET() 실행");
		logger.debug("Update.jsp 이동");

		String userid = (String) session.getAttribute("id");
		logger.debug("userid: " + userid);

		model.addAttribute(mService.memberInfo(userid));
	}

	// 회원정보 수정 - POST
	@PostMapping(value = "/update")
	public String memberUpdatePost(MemberVO vo) {
		logger.debug("memberUpdatePOST() 실행");

		logger.debug("수정할 정보: " + vo);

		int result = mService.memberUpdate(vo);

		logger.debug("result: " + result);

		String attr = "/member/update";

		if (result == 1) {
			attr = "/member/main";
		}

		return "redirect:" + attr;
	}

	// 회원정보 삭제 - GET
	@GetMapping(value = "/delete")
	public void memberDeleteGET() {
		logger.debug("memberDeleteGET() 실행");
		logger.debug("delete.jsp 이동");
	}

	// 회원정보 삭제 - POST
	@PostMapping(value = "/delete")
	public String memberDeletePOST(MemberVO vo, HttpSession session) {
		logger.debug("memberUpdatePOST() 실행");

		logger.debug("삭제할 정보: " + vo);

		int result = mService.memberDelete(vo);

		logger.debug("result: " + result);

		String attr = "/member/delete";

		if (result == 1) {
			attr = "/member/main";

			session.invalidate();
		}

		return "redirect:" + attr;
	}

	// 회원목록 조회 - GET
	@GetMapping(value = "/list")
	public String memberListGET(Model model, HttpSession session) {
		logger.debug("memberListGET() 실행");
		
		if (((String)session.getAttribute("id")) == null || !((String)session.getAttribute("id")).equals("admin")) {
			logger.debug((String)session.getAttribute("id"));
			return "redirect:/member/main";
		}

		logger.debug("list.jsp 이동");

		model.addAttribute(mService.getMemberList());
		
		return "/member/list";
	}
}
