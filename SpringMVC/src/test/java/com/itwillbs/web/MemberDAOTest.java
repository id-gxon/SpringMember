package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {
	// =>Controller + Action페이지동작

	// DAO 객체 생성 -> 주입
	@Inject
	private MemberDAO mdao; // MemberDAO mdao = new MemberDAOImpl();
	// @Inject
	// private MemberDAOImpl mdaoImpl; // MemberDAOImpl mdao = new MemberDAOImpl();

	// 로그 처리 객체
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);

	// @Test
	public void 시간정보조회() {
		System.out.println("Test: 시간정보조회() 실행");
		logger.info("Test: 시간정보조회() 실행");
		logger.debug("======= debug =======");
		logger.warn("======= warn =======");

		String time = mdao.getTime();

		System.out.println("Test: 결과 - " + time);
		logger.info("Test: 결과 - " + time);
	}

	// @Test
	public void 회원가입테스트() {
		logger.debug("회원가입테스트() 실행");
		logger.debug("DAO 회원가입 메서드 호출");

		// 임시 회원정보 객체
		MemberVO vo = new MemberVO();

		vo.setUserid("admin");
		vo.setUserpw("1234");
		vo.setUsername("관리자");
		vo.setUseremail("admin@admin.com");

		mdao.insertMember(vo);

		logger.debug("회원가입 완료");
	}

	// @Test
	public void 로그인테스트1() {
		logger.debug("로그인테스트1() 실행");

		// 임시 사용자 계정
		MemberVO vo = new MemberVO();

		vo.setUserid("admin");
		vo.setUserpw("1234");

		MemberVO resultvo = mdao.loginMember(vo);

		if (resultvo != null) {
			logger.debug("로그인 성공");
			logger.debug("메인페이지 이동");
		} else {
			logger.debug("로그인 실패");
		}
	}

	// @Test
	public void 로그인테스트2() {
		logger.debug("로그인테스트2() 실행");

		MemberVO resultVO = mdao.loginMember("admin", "1234");

		if (resultVO != null) {
			logger.debug("로그인 성공");
			logger.debug("메인페이지 이동");
		} else {
			logger.debug("로그인 실패");
		}
	}

	// 특정 사용자의 정보를 조회하는 메서드 실행
	// @Test
	public void 회원정보조회() {
		logger.debug("회원정보조회() 실행");
		logger.debug("id: admin, pw: 1234 계정정보 사용");

		MemberVO vo = mdao.getMember("admin");

		logger.debug("vo: " + vo);
	}

	// 특정 계정의 이름, updatedate 변경 메서드 실행
	// @Test
	public void 회원정보수정() {
		logger.debug("회원정보수정() 실행");
		logger.debug("id: admin, pw: 1234 계정정보 사용");

		MemberVO uvo = new MemberVO();

		uvo.setUserid("admin");
		uvo.setUserpw("1234");
		uvo.setUsername("admin");

		mdao.updateMember(uvo);
	}

	// @Test
	public void 회원정보삭제() {
		logger.debug("회원정보삭제() 실행");
		logger.debug("id: test, pw: 1234 계정정보 사용");

		MemberVO dvo = new MemberVO();

		dvo.setUserid("test");
		dvo.setUserpw("1234");

		int result = mdao.deleteMember(dvo);

		if (result == 1) {
			logger.debug("회원정보 삭제 완료");
		} else {
			logger.debug("회원정보 삭제 실패");
		}
	}
	
	@Test
	public void 회원목록조회() {
		logger.debug("회원목록조회() 실행");
		
		List<MemberVO> memberList = mdao.getMemberList();
		
		logger.debug("memberList: " + memberList);
	}
}
