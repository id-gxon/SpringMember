package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * VO(Value Object) => DTO(Data Transfer Object)
 */

/*
 * @Data: lombok 라이브러리를 사용해서 자동으로 set/get 생성
 * 
 * @Setter
 * 
 * @Getter
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * @ToString
 */
@Data
public class MemberVO {

	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Timestamp regdate;
	private Timestamp updatedate;

	//	public int getAge() {
	//		return age;
	//	}

	// private String uId; (lombok을 쓸 때는 대소문자 구분이 어려움)

}
