package com.test.app.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;

//@Repository("boardDAO")
public class BoardDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT="insert into board values((select nvl(max(bnum),0)+1 from board),?,?,?,?,?)";
	private final String BOARD_SELECTONE="select * from board where bnum=?";
	private final String BOARD_SELECTALL="select * from board order by bnum desc";
//	private final String BOARD_UPDATE="update board set bcontent=? where bnum=?";
	private final String BOARD_DELETE="delete board where bnum=?";
	
	private final String BOARD_SEARCH="select * from board where pnum=? order by bnum desc"; // 상품번호로 후기 검색
	

	
	public void Board_insert(BoardVO vo) {
		jdbcTemplate.update(BOARD_INSERT, vo.getMid(), vo.getBtitle(), vo.getBcontent(), vo.getBimg(), vo.getPnum());
		
	}

	public BoardVO Board_selectOne(BoardVO vo) {
		
		Object[] args= {vo.getBnum()};
		return jdbcTemplate.queryForObject(BOARD_SELECTONE, args, new BoardRowMapper());
	
	}

	public List<BoardVO> Board_selectAll(BoardVO vo) {
		return jdbcTemplate.query(BOARD_SELECTALL, new BoardRowMapper());
		
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
		jdbcTemplate.update(BOARD_DELETE, vo.getBnum());
		
	}
	
	
	public List<BoardVO> Board_search(BoardVO vo) {
		
		Object[] args= {vo.getPnum()};
		return jdbcTemplate.query(BOARD_SEARCH, args, new BoardRowMapper());
		
	}
}
class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setBnum(rs.getInt("bnum"));
		data.setBtitle(rs.getString("btitle"));
		data.setMid(rs.getString("mid"));
		data.setBcontent(rs.getString("bcontent"));
		data.setBimg(rs.getNString("bimg"));
		data.setPnum(rs.getInt("pnum"));
		return data;
	}

}