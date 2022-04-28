package com.test.app.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;
@Repository("boardDAO")
public class BoardDAO3 {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void Board_insert(BoardVO vo) {
		mybatis.insert("boardDAO.Board_insert", vo);
	}

	public BoardVO Board_selectOne(BoardVO vo) {
		
		return (BoardVO)mybatis.selectOne("boardDAO.Board_selectOne",vo);
	
	}
	public BoardVO Board_pname(BoardVO vo) {
		
		return (BoardVO)mybatis.selectOne("boardDAO.Board_pname",vo);
		
	}

	public List<BoardVO> Board_selectAll(BoardVO vo) {
		return mybatis.selectList("boardDAO.Board_selectAll",vo);
		
	}
	
	public void Board_delete(BoardVO vo) {
		mybatis.update("boardDAO.Board_delete", vo);
	}
	
	
	public List<BoardVO> Board_search(BoardVO vo) {
		
		return mybatis.selectList("boardDAO.Board_search", vo);
		
	}

}
