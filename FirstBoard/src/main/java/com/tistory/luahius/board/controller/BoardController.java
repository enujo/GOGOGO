package com.tistory.luahius.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.luahius.board.domain.BoardVo;
import com.tistory.luahius.board.service.BoardService;

@Controller
public class BoardController {
	
	// 로거 사용
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	// 게시글 작성 폼
	@RequestMapping(value = "insertBoard", method = RequestMethod.GET)
	public ModelAndView insertBoard() {
		logger.debug(" >>>>>>> insertBoard <<<<<<< ");
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("insertBoard");
		
		return mv;
	}
	
	// 게시글 작성
	@RequestMapping(value = "insertBoard", method = RequestMethod.POST)
	public ModelAndView insertBoard(BoardVo board) {
		logger.debug(" >>>>>>> insertBoard <<<<<<< ");
		logger.debug(" >>>>>>> insertBoard get param {} ", board);
		
		ModelAndView mv = new ModelAndView();
		
		boardService.insertBoard(board);
		
		mv.setViewName("redirect:boardList");
		
		return mv;
	}
	
	// 게시글 목록
	@RequestMapping(value = "boardList", method = RequestMethod.GET)
	public ModelAndView boardList(
				@RequestParam(value="currentPage", defaultValue = "1") int currentPage )  {
		logger.debug(" >>>>>>> boardList <<<<<<< ");
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = boardService.getBoardList(currentPage);
		
		mv.addObject("currentPage", currentPage);
		mv.addObject("boardList", map.get("boardList"));
		mv.addObject("startPage", map.get("startPage"));
		mv.addObject("pageSize", map.get("pageSize"));
		mv.addObject("endPage", map.get("endPage"));
		mv.addObject("lastPage", map.get("lastPage"));

		mv.setViewName("boardList");
		
		return mv;
	}
	
	// 게시글 상세
	@RequestMapping(value = "boardDetail", method = RequestMethod.GET)
	public ModelAndView boardDetail( @RequestParam(value="boardNo") int boardNo )  {
		logger.debug(" >>>>>>> boardDetail <<<<<<< ");
		logger.debug(" >>>>>>> boardDetail boardNo : {} <<<<<<< ", boardNo);
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = boardService.getBoardDetail(boardNo);

		mv.addObject("board", map.get("board"));

		mv.setViewName("boardDetail");
		
		return mv;
	}
		
	// 게시글 수정 화면
	@RequestMapping(value = "updateBoard", method = RequestMethod.GET)
	public ModelAndView updateBoard( @RequestParam(value="boardNo") int boardNo )  {
		logger.debug(" >>>>>>> updateBoard GET <<<<<<< ");
		logger.debug(" >>>>>>> updateBoard boardNo : {} <<<<<<< ", boardNo);
		
		ModelAndView mv = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = boardService.getBoardDetail(boardNo);

		mv.addObject("board", map.get("board"));

		mv.setViewName("updateBoard");
		
		return mv;
	}
	
	// 게시글 수정
	@RequestMapping(value = "updateBoard", method = RequestMethod.POST)
	public ModelAndView updateBoard(BoardVo board)  {
		logger.debug(" >>>>>>> updateBoard POST <<<<<<< ");
		logger.debug(" >>>>>>> updateBoard board : {} <<<<<<< ", board);
		
		ModelAndView mv = new ModelAndView();
		
		boardService.updateBoard(board);

		mv.setViewName("redirect:boardList");
		
		return mv;
	}
		
	// 게시글 삭제
	@RequestMapping(value = "boardDelete", method = RequestMethod.GET)
	public ModelAndView boardDelete( @RequestParam(value="boardNo") int boardNo )  {
		logger.debug(" >>>>>>> boardDelete <<<<<<< ");
		logger.debug(" >>>>>>> boardDelete boardNo : {} <<<<<<< ", boardNo);
		
		ModelAndView mv = new ModelAndView();
		
		boardService.boardDelete(boardNo);

		mv.setViewName("redirect:boardList");
		
		return mv;
	}
}
