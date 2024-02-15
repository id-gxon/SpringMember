package com.itwillbs.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

/*
 * @Repository: 스프링에서 해당 코드를 MemberDAO로 인식하도록 설정
 * -> root-context.xml에서 해당 객체를 빈(bean)으로 인식 가능
 */

@Repository
public class MemberDAOImpl implements MemberDAO {

	/*
	 * JSP DAO
	 * 
	 * 1. 공통변수 선언
	 * 2. DB 연결 / 자원 해제 메서드
	 * 3. 각각의 기능 메서드
	 * 		3-1. DB 연결(Connection Pool)
	 * 		3-2. SQL 구문 작성 & pstmt 객체
	 * 		3-3. SQL 실행
	 * 		3-4. 데이터 처리
	 */

	// Spring DAO
	// 1. DB 연결 -> 해당 객체 주입(DI)
	@Inject
	private SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

	// mapper의 위치 정보(namespace)
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";

	@Override
	public String getTime() {
		System.out.println("DAOImpl: getTime() execute");
		logger.debug("======= DAO log Test =======");

		String time = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");

		System.out.println("DAOImpl: " + time);

		return time;
	}

	@Override
	public void insertMember(MemberVO vo) {
		logger.debug("insertMember(MemberVO vo) 실행");
		logger.debug("sqlSession 사용 -> mapper 호출");

		sqlSession.insert(NAMESPACE + ".insertMember", vo);

		logger.debug("MySql 실행 완료");
	}

	@Override
	public MemberVO loginMember(MemberVO vo) {
		logger.debug("loginMember(MemberVO vo) 실행");

		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".loginMember", vo);

		return resultVO;
	}

	@Override
	public MemberVO loginMember(String userid, String userpw) {
		logger.debug("loginMember(String userid, String userpw) 실행");

		// MemberVO vo = new MemberVO();

		// vo.setUserid(userid);
		// vo.setUserpw(userpw);

		/*
		 * 하나의 VO로 전달된 정보가 모두 저장이 불가능한 경우(Join)
		 * 	=> Map<K, V> 사용
		 */
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		// paramMap.put("mapper에서 호출하는 이름", 실제 데이터);

		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".loginMember", paramMap);

		return resultVO;
	}

	@Override
	public MemberVO getMember(String userid) {
		logger.debug("getMember(String userid) 실행");

		return sqlSession.selectOne(NAMESPACE + ".getMember", userid);
	}

	@Override
	public int updateMember(MemberVO uvo) {
		logger.debug("updateMember(MemberVO uvo) 실행");
		
		return sqlSession.update(NAMESPACE + ".updateMember", uvo);
	}

	@Override
	public int deleteMember(MemberVO dvo) {
		logger.debug("deleteMember(MemberVO dvo) 실행");

		return sqlSession.delete(NAMESPACE + ".deleteMember", dvo);
	}

	@Override
	public List<MemberVO> getMemberList() {
		
		return sqlSession.selectList(NAMESPACE + ".getMemberList");
	}
}
