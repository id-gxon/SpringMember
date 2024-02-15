package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service // root-context.xml(Spring)에서 해당 객체를 인식 
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	// DAO 객체 주입
	@Inject
	private MemberDAO mdao;

	// 시간 정보 조회
	@Override
	public String getTime() {
		logger.debug("getTime() 호출");

		return mdao.getTime();
	}

	// 회원가입 처리
	@Override
	public void memberJoin(MemberVO vo) {
		logger.debug("S: memberJoin(MemberVO vo) 실행");
		logger.debug("S: DAO 회원 가입 처리 동작 호출");

		mdao.insertMember(vo);

		logger.debug("S: 회원가입 완료");
		logger.debug("S: 다시 컨트롤러로 이동");
	}

	// 로그인 처리
	@Override
	public MemberVO memberLogin(MemberVO vo) {
		logger.debug("S: memberLogin(MemberVO vo) 실행");
		logger.debug("S: DAO 로그인 동작 호출");

		MemberVO resultVO = mdao.loginMember(vo);

		logger.debug("S: 로그인 완료");
		logger.debug("S: 다시 컨트롤러로 이동");

		return resultVO;
	}

	// 회원정보 조회
	@Override
	public MemberVO memberInfo(String userid) {
		logger.debug("S: memberInfo(String userid) 실행");
		logger.debug("S: DAO 회원정보 조회 동작 호출");

		return mdao.getMember(userid);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		logger.debug("S: memberUpdate(MemberVO vo) 실행");
		logger.debug("S: DAO 회원정보 수정 동작 호출");

		return mdao.updateMember(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		logger.debug("S: memberDelete(MemberVO vo) 실행");
		logger.debug("S: DAO 회원정보 삭제 동작 호출");

		return mdao.deleteMember(vo);
	}

	@Override
	public List<MemberVO> getMemberList() {
		logger.debug("S: getMemberList() 실행");
		logger.debug("S: DAO 회원목록 조회 동작 호출");
		
		return mdao.getMemberList();
	}

}
