package com.test.app.member;

import java.util.List;

public interface MemberService {


	public void Member_insert(MemberVO vo);

	public MemberVO Member_selectOne(MemberVO vo);

	public List<MemberVO> Member_selectAll(MemberVO vo);

	public void Member_update(MemberVO vo);

	public void Member_delete(MemberVO vo);

	public MemberVO Member_idSearch(MemberVO vo);

	public MemberVO Member_pwSearch(MemberVO vo);
	
	public MemberVO Member_checkId(MemberVO vo);


}
