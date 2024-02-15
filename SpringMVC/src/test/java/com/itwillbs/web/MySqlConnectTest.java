package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

/**
 * Junit을 사용하여 테스트를 진행
 */
public class MySqlConnectTest {

	// DB 연결 정보
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/springdb";
	private static final String DBID = "root";
	private static final String DBPW = "1234";

	/*
	 * @Test: 테스트를 수행하고자 하는 메서드 위에 특정 어노테이션(@Test)을 선언하면 해당 메서드를 Junit이 해당 코드를 테스트용
	 * 코드로 인식해서 실행
	 * 
	 * junit 4.11버전 이상 사용
	 */
	@Test
	public void connect_test() {
		// DB 연결
		try {
			// 1) 드라이버 로드
			Class.forName(DRIVER);
			System.out.println("DRIVER load 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2) DB 연결
//		Connection con = null;
//		try {
//			con = DriverManager.getConnection(DBURL, DBID, DBPW);
//			System.out.println("DB connect 성공");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// 자원 해제
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}

		/*
		 * try-with 구문(JDK 1.7~ 사용가능)
		 * 		try (AutoCloseable Interface를 구현한 객체 사용) {
		 * 			예외가 발생할지도 모르는 코드
		 * 		} catch (Exception e) {
		 * 			예외발생 처리 구문
		 * 		}
		 */
		try (Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);) {
			System.out.println("DB connect 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}		

	}

}
