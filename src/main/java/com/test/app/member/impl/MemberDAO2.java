package com.test.app.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.app.member.MemberVO;
//@Repository("memberDAO")
public class MemberDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String MEMBER_INSERT="insert into member values(?,?,?,?)";
	private final String MEMBER_SELECTONE="select * from member where mid=? and mpw=?";
	private final String MEMBER_SELECTALL="select * from member order by mid desc";
	private final String MEMBER_UPDATE="update member set mpw=?, mmail=? where mid=?";
	private final String MEMBER_DELETE="delete member where mid=?";
	
	private final String MEMBER_IDCHECK="select * from member where mid=?";
//	private final String MEMBER_IDCHECK="select mid from member where mid=?";

	private final String MEMBER_IDSEARCH="select mid from member where mname=? and mmail=?";
	private final String MEMBER_PWSEARCH="select mpw from member where mid=? and mname=? and mmail=?";
	
	
	
	public MemberVO Member_checkId(MemberVO vo) {
		System.out.println(vo.getMid());
		Object[] args= {vo.getMid()};
		try {
		return jdbcTemplate.queryForObject(MEMBER_IDCHECK, args, new MemberRowMapper());
		} catch (EmptyResultDataAccessException e) {
			vo.setMid("가능");
			return vo;
		}
	}


	public void Member_insert(MemberVO vo) {

		jdbcTemplate.update(MEMBER_INSERT, vo.getMid(), vo.getMpw(), vo.getMname(), vo.getMmail());

	}

	public MemberVO Member_selectOne(MemberVO vo) {
		Object[] args= {vo.getMid(), vo.getMpw()};
		try {
			return jdbcTemplate.queryForObject(MEMBER_SELECTONE, args, new MemberRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<MemberVO> Member_selectAll(MemberVO vo) {
		return jdbcTemplate.query(MEMBER_SELECTALL, new MemberRowMapper());
	}

	public void Member_update(MemberVO vo) {
		jdbcTemplate.update(MEMBER_UPDATE, vo.getMpw(), vo.getMmail(), vo.getMid());
	}

	public void Member_delete(MemberVO vo) {
		jdbcTemplate.update(MEMBER_DELETE, vo.getMid());
	}

	public MemberVO Member_idSearch(MemberVO vo) { // 아이디 찾기

		Object[] args= {vo.getMname(), vo.getMmail()};
		return jdbcTemplate.queryForObject(MEMBER_IDSEARCH, args, new MemberRowMapper());

	}

	public MemberVO Member_pwSearch(MemberVO vo) { // 비밀번호 찾기
		Object[] args= {vo.getMid(), vo.getMname(), vo.getMmail()};
		return jdbcTemplate.queryForObject(MEMBER_PWSEARCH, args, new MemberRowMapper());

	}
}

class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setMid(rs.getString("mid"));
		data.setMpw(rs.getString("mpw"));
		data.setMname(rs.getString("mname"));
		data.setMmail(rs.getString("mmail"));
		return data;
	}

}
