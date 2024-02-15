package com.itwillbs.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MybatisTest {

	// DB 연결(MyBatis)
	@Inject
	private SqlSessionFactory sqlFactory;

	@Test
	public void test_객체확인() {
		System.out.println("sqlFactory: " + sqlFactory);
	}

	@Test
	public void test_DB연결() {
		// Connection + MyBatis 정보 -> SqlSession 객체
		SqlSession sqlSession = sqlFactory.openSession();

		System.out.println("sqlSession: " + sqlSession);
	}

}
