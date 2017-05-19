package com.tistory.luahius.board.service;

import java.util.Map;

import com.tistory.luahius.board.domain.BoardVo;

public interface BoardService {
	
	void insertBoard(BoardVo board);

	Map<String, Object> getBoardList(int currentPage);

	Map<String, Object> getBoardDetail(int boardNo);

	void boardDelete(int boardNo);

	void updateBoard(BoardVo board);

}
