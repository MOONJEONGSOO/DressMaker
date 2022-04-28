package com.test.app.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.board.BoardService;
import com.test.app.board.BoardVO;
@Service("BoardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO3 boardDao;

	@Override
	public void Board_insert(BoardVO vo) {
		boardDao.Board_insert(vo);
	}

	@Override
	public BoardVO Board_selectOne(BoardVO vo) {
		return boardDao.Board_selectOne(vo);
	}

	@Override
	public List<BoardVO> Board_selectAll(BoardVO vo) {
		return boardDao.Board_selectAll(vo);
	}

	@Override
	public void Board_delete(BoardVO vo) {
		boardDao.Board_delete(vo);
	}

	@Override
	public List<BoardVO> Board_search(BoardVO vo) {
		return boardDao.Board_search(vo);
	}

	@Override
	public BoardVO Board_pname(BoardVO vo) {
		return boardDao.Board_pname(vo);
	}

}
