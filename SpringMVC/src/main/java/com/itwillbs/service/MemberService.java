package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {

	// 시간 정보 조회
	public String getTime();

	// 회원가입 처리
	public void memberJoin(MemberVO vo);

	// 로그인 처리
	public MemberVO memberLogin(MemberVO vo);

	// 회원정보 조회
	public MemberVO memberInfo(String userid);
	
	// 회원정보 수정
	public int memberUpdate(MemberVO vo);
	
	// 회원정보 삭제
	public int memberDelete(MemberVO vo);
	
	// 회원목록 조회
	public List<MemberVO> getMemberList();
}
