package com.test.app.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.app.board.BoardVO;
import com.test.app.common.JDBCUtil;

public class BoardDAO {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private final String BOARD_INSERT="insert into board values((select nvl(max(bnum),0)+1 from board),?,?,?,?,?)";
	private final String BOARD_SELECTONE="select * from board where bnum=?";
	private final String BOARD_SELECTALL="select * from board order by bnum desc";
//	private final String BOARD_UPDATE="update board set bcontent=? where bnum=?";
	private final String BOARD_DELETE="delete board where bnum=?";
	
	private final String BOARD_SEARCH="select * from board where pnum=? order by bnum desc"; // 상품번호로 후기 검색
	
	
	public void Board_insert(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getBtitle());
			pstmt.setString(3, vo.getBcontent());
			pstmt.setString(4, vo.getBimg());
			pstmt.setInt(5, vo.getPnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	public BoardVO Board_selectOne(BoardVO vo) {
		BoardVO data=null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_SELECTONE);
			pstmt.setInt(1, vo.getBnum());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BoardVO();
				data.setBnum(rs.getInt("bnum"));
				data.setBtitle(rs.getString("btitle"));
				data.setMid(rs.getString("mid"));
				data.setBcontent(rs.getString("bcontent"));
				data.setBimg(rs.getNString("bimg"));
				data.setPnum(rs.getInt("pnum"));
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

	public List<BoardVO> Board_selectAll(BoardVO vo) {
		List<BoardVO> datas=new ArrayList<BoardVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_SELECTALL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				
				data.setBnum(rs.getInt("bnum"));
				data.setBtitle(rs.getString("btitle"));
				data.setMid(rs.getString("mid"));
				data.setBcontent(rs.getString("bcontent"));
				data.setBimg(rs.getNString("bimg"));
				data.setPnum(rs.getInt("pnum"));
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
	
//	public void Board_update(BoardVO vo) {
//		conn=JDBCUtil.connect();
//		try {
//			pstmt=conn.prepareStatement(BOARD_UPDATE);
//			pstmt.setString(1, vo.getBcontent());
//			pstmt.setInt(2, vo.getBnum());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.disconnect(pstmt, conn);
//		}
//	}
	
	public void Board_delete(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getBnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	
	public List<BoardVO> Board_search(BoardVO vo) {
		List<BoardVO> datas=new ArrayList<BoardVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BOARD_SEARCH);
			pstmt.setInt(1, vo.getPnum());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setBnum(rs.getInt("bnum"));
				data.setBtitle(rs.getString("btitle"));
				data.setMid(rs.getString("mid"));
				data.setBcontent(rs.getString("bcontent"));
				data.setBimg(rs.getNString("bimg"));
				data.setPnum(rs.getInt("pnum"));
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
	

}
