package com.test.app.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.app.common.JDBCUtil;
import com.test.app.member.MemberVO;
//@Repository("memberDAO")
public class MemberDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private final String MEMBER_INSERT="insert into member values(?,?,?,?)";
	private final String MEMBER_SELECTONE="select * from member where mid=? and mpw=?";
	private final String MEMBER_SELECTALL="select * from member order by id desc";
	private final String MEMBER_UPDATE="update member set mpw=?, mmail=? where mid=?";
	private final String MEMBER_DELETE="delete member where mid=?";
	
	private final String MEMBER_IDCHECK="select mid from member where mid=?";
	
	private final String MEMBER_IDSEARCH="select mid from member where mname=? and mmail=?";
	private final String MEMBER_PWSEARCH="select mpw from member where mid=? and mname=? and mmail=?";
	
	public int Member_checkId(String id) {
		conn=JDBCUtil.connect();
		int check = 0;
		try {
			pstmt=conn.prepareStatement(MEMBER_IDCHECK);
			pstmt.setString(1,id);			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next() || id.equals("")) { // 불가
				check = 0;
			} else { // 가능
				check = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return check;
	}
	
	public void Member_insert(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_INSERT);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	public MemberVO Member_selectOne(MemberVO vo) {
		MemberVO data=null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_SELECTONE);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setMmail(rs.getString("mmail"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

	public List<MemberVO> Member_selectAll(MemberVO vo) {
		List<MemberVO> datas=new ArrayList<MemberVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_SELECTALL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setMmail(rs.getString("mmail"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public void Member_update(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_UPDATE);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getMmail());
			pstmt.setString(3, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public void Member_delete(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_DELETE);
			pstmt.setString(1, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public MemberVO Member_idSearch(MemberVO vo) { // 아이디 찾기
		MemberVO data = null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_IDSEARCH);
			pstmt.setString(1,vo.getMname());
			pstmt.setString(2, vo.getMmail());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				data.setMid(rs.getString("mid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return data;
	}
	
	public MemberVO Member_pwSearch(MemberVO vo) { // 비밀번호 찾기
		MemberVO data = new MemberVO();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(MEMBER_PWSEARCH);
			pstmt.setString(1,vo.getMid());
			pstmt.setString(2,vo.getMname());
			pstmt.setString(3, vo.getMmail());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				
				data.setMpw(rs.getString("mpw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return data;
	}

}
