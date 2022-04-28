package com.test.app.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.member.MemberVO;
@Repository("memberDAO")
public class MemberDAO3 {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	
	public MemberVO Member_checkId(MemberVO vo) {
		vo = mybatis.selectOne("MemberDAO.Member_checkId", vo);
		if(vo==null||vo.getMid().equals("")) {
			vo = new MemberVO();
			vo.setMid("가능");
		}
		return vo;
	}


	public void Member_insert(MemberVO vo) {
		mybatis.insert("MemberDAO.Member_insert", vo);
		
	}

	public MemberVO Member_selectOne(MemberVO vo) {
		return (MemberVO) mybatis.selectOne("MemberDAO.Member_selectOne", vo);

	}

	public List<MemberVO> Member_selectAll(MemberVO vo) {
		return mybatis.selectList("MemberDAO.Member_selectAll", vo);
	}

	public void Member_update(MemberVO vo) {
		mybatis.update("MemberDAO.Member_update", vo);
	}

	public void Member_delete(MemberVO vo) {
		mybatis.delete("MemberDAO.Member_delete", vo);
	}

	public MemberVO Member_idSearch(MemberVO vo) { // 아이디 찾기

		return (MemberVO)mybatis.selectOne("MemberDAO.Member_idSearch", vo);
		
	}

	public MemberVO Member_pwSearch(MemberVO vo) { // 비밀번호 찾기
		return (MemberVO)mybatis.selectOne("MemberDAO.Member_pwSearch", vo);
	}

}
