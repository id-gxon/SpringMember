package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JUnit을 사용해서 테스트
 */

@RunWith(SpringJUnit4ClassRunner.class)
/* Spring을 사용해서 테스트하겠다는 설정 */
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
/* 스프링 테스트에 필요한 설정 정보 가져오기(사용하도록 허용) */
public class DataSourceTest {

	// DB 연결 정보
	@Inject
	/* DI(Dependency Injection: 의존성 주입) - 의존 관계에 있는 객체를 주입해서 사용 */
	private DataSource ds;

	// DB 연결 테스트
	@Test
	/* JUnit을 사용한 테스트 수행 */
	public void testConnection() {
		// DB 연결 정보
		try {
			Connection con = ds.getConnection();
			System.out.println("con: " + con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
