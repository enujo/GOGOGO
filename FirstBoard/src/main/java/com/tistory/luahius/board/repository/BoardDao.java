package com.tistory.luahius.board.repository;

import java.util.List;
import java.util.Map;

import com.tistory.luahius.board.domain.BoardVo;

public interface BoardDao {

	int insertBoard(BoardVo board);

	List<BoardVo> getBoardList(Map<String, Object> returnMap);

	int getTotalCount();

	BoardVo getBoardDetail(int boardNo);

	int boardDelete(int boardNo);

	int updateBoard(BoardVo board);

}
