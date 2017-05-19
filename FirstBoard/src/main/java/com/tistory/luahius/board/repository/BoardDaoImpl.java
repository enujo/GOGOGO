package com.tistory.luahius.board.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tistory.luahius.board.domain.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	private static final Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private final String BOARD_NS = "com.tistory.luahius.board.repository.BoardMapper."; 
	
	// 게시글 입력
	@Override
	public int insertBoard(BoardVo board) {
		logger.debug(" >>>>>>> insertBoard board : {} <<<<<<< ",board);
		
		return sqlSession.insert(BOARD_NS + "insertBoard", board);
	}
	
	// 게시글 총 수 가져오기
	@Override
	public int getTotalCount() {
		logger.debug(" >>>>>>> getTotalCount <<<<<<< ");
		return sqlSession.selectOne(BOARD_NS + "totalCount");
	}
	
	// 게시글 목록 가져오기
	@Override
	public List<BoardVo> getBoardList(Map<String, Object> returnMap) {
		logger.debug(" >>>>>>> getBoardList <<<<<<< ");
		
		return sqlSession.selectList(BOARD_NS + "getBoardList", returnMap);
	}
	
	// 게시글 상세
	@Override
	public BoardVo getBoardDetail(int boardNo) {
		logger.debug(" >>>>>>> getBoardDetail <<<<<<< ");
		
		return sqlSession.selectOne(BOARD_NS + "getBoardDetail", boardNo);
	}
	
	// 게시글 수정
	@Override
	public int updateBoard(BoardVo board) {
		logger.debug(" >>>>>>> updateBoard <<<<<<< ");
		logger.debug(" >>>>>>> updateBoard board : {} <<<<<<< ",board);
		
		return sqlSession.update(BOARD_NS + "updateBoard", board);
	}
		
	// 게시글 삭제
	@Override
	public int boardDelete(int boardNo) {
		logger.debug(" >>>>>>> boardDelete <<<<<<< ");
		
		return sqlSession.delete(BOARD_NS + "boardDelete", boardNo);
	}

}
