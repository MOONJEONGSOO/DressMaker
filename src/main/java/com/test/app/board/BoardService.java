package com.test.app.board;

import java.util.List;

public interface BoardService {

	public void Board_insert(BoardVO vo);

	public BoardVO Board_selectOne(BoardVO vo);

	public List<BoardVO> Board_selectAll(BoardVO vo);

	public void Board_delete(BoardVO vo);

	public List<BoardVO> Board_search(BoardVO vo);

	public BoardVO Board_pname(BoardVO vo);

}

