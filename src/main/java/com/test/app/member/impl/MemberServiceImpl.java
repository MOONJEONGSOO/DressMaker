package com.test.app.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO3 memberDao;

	@Override
	public void Member_insert(MemberVO vo) {
		memberDao.Member_insert(vo);
	}

	@Override
	public MemberVO Member_selectOne(MemberVO vo) {
		return memberDao.Member_selectOne(vo);
	}

	@Override
	public List<MemberVO> Member_selectAll(MemberVO vo) {
		return memberDao.Member_selectAll(vo);
	}

	@Override
	public void Member_update(MemberVO vo) {
		memberDao.Member_update(vo);
	}

	@Override
	public void Member_delete(MemberVO vo) {
		memberDao.Member_delete(vo);
	}

	@Override
	public MemberVO Member_idSearch(MemberVO vo) {
		return memberDao.Member_idSearch(vo);
	}

	@Override
	public MemberVO Member_pwSearch(MemberVO vo) {
		return memberDao.Member_pwSearch(vo);
	}

	@Override
	public MemberVO Member_checkId(MemberVO vo) {
		return memberDao.Member_checkId(vo);
	}

}
