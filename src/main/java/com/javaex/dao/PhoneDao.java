package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;
	
	//전화번호 전체가져오기
	public List<PersonVo> getPersonList() {
		System.out.println("PhoneDao>getPersonList()");
		
		List<PersonVo> personList  = sqlSession.selectList("phonebook.selectList");
		
		return personList;
	}
	

	// 사람추가
	public int personInsert(PersonVo personVo) {

		System.out.println("PhoneDao>personUpdate()");

		int count = sqlSession.update("phonebook.personUpdate", personVo);

		return count;
	}
	
	// 사람추가2 : Map 이용
	public int personInsert2(Map<String, String> pMap) {
		System.out.println("phoneDao>personInsert2");
		
		//System.out.println(pMap.toString());
		
		int count = sqlSession.insert("phonebook.personInsert2", pMap);
	
		return 1;
	}
	
	
	

	
	// 사람 삭제
	public int personDelete(int no) {

		int count = sqlSession.delete("phonebook.personDelete", no);

		return count;
		// return sqlSession.delete("phonebook.personDelete", no);
	}

	
	
	
	
	// 1명 정보 가져오기
	public PersonVo getPerson(int no) {
		System.out.println("PhoneDao>getperson()");

		PersonVo personVo = sqlSession.selectOne("phonebook.getPerson", no);
		//System.out.println("personVo");

		return personVo;
		// return sqlSession.selectOne("phonebook.selectPerson", no);
	}
	
	
	// 1명 정보 가져오기2 : map 사용하여 가상의 상황 : 문법설명
	public Map<String, Object> getPerson2(int no) {
		System.out.println("PhoneDao>getperson2()");
		System.out.println(no);
		
		
		Map<String, Object> pMap = sqlSession.selectOne("phonebook.getPerson2", no);
		
		return pMap;
	}
	
	

	

	
	// 사람 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhoneDao>personUpdate()");

		int count = sqlSession.update("phonebook.personUpdate", personVo);

		return count;
	}

}
