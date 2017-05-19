package com.tistory.luahius.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tistory.luahius.board.domain.BoardVo;
import com.tistory.luahius.board.repository.BoardDao;

@Service
public class BoardServiceImpl implements BoardService{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	BoardDao boardDao;
	
	// 게시글 DB에 저장 및 확인
	@Override
	public void insertBoard(BoardVo board) {
		logger.debug(" >>>>>>> insertBoard <<<<<<< ");
		
		int result;
		
		result = boardDao.insertBoard(board);
		
		logger.debug(" >>>>>>> insertBoard result : {} <<<<<<< ", result);
		
	}
	
	// 게시글 목록 가져오기
	@Override
	public Map<String, Object> getBoardList(int currentPage) {
		logger.debug(" >>>>>>> getBoardList <<<<<<< ");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		int pagePerRow = 5;
        int pageSize = 3;
        
		int totalCount = boardDao.getTotalCount();
		
        int beginRow = (currentPage-1)*pagePerRow;
        int startPage =((currentPage-1)/pageSize)*pageSize+1;
        
        int endPage = startPage + pageSize -1;
        
        int lastPage = totalCount/pagePerRow;
        if(totalCount%pagePerRow!=0){
            lastPage++;
        }
        if(endPage > lastPage){
            endPage = lastPage;
        }
        returnMap.put("beginRow", beginRow);
		returnMap.put("pagePerRow", pagePerRow);
		
		list = boardDao.getBoardList(returnMap);
		
		logger.debug(" >>>>>>> getBoardList list <<<<<<< \n {} <<<<<<< ", list);
		
		returnMap.put("boardList", list);
		returnMap.put("startPage", startPage);
        returnMap.put("pageSize", pageSize);
        returnMap.put("endPage", endPage);
        returnMap.put("lastPage", lastPage);
		
		return returnMap;
	}

	@Override
	public Map<String, Object> getBoardDetail(int boardNo) {
		logger.debug(" >>>>>>> getBoardDetail <<<<<<< ");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		BoardVo board = boardDao.getBoardDetail(boardNo);
		returnMap.put("board", board);
		
		return returnMap;
	}
	

	// 게시글 수정
	@Override
	public void updateBoard(BoardVo board) {
		logger.debug(" >>>>>>> updateBoard <<<<<<< ");
		logger.debug(" >>>>>>> updateBoard board : {} <<<<<<< ", board);
		int result;
		
		result = boardDao.updateBoard(board);
		
		logger.debug(" >>>>>>> updateBoard result : {} <<<<<<< ", result);
		
	}

	// 게시글 삭제
	@Override
	public void boardDelete(int boardNo) {
		logger.debug(" >>>>>>> getBoardDetail <<<<<<< ");
		
		int result = 0;
		result = boardDao.boardDelete(boardNo);
		
	}

}
