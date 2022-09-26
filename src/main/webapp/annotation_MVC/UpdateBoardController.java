package com.global.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController{

	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {

		System.out.println("글 수정 처리");
		
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do"; // View 정보를 저장

	}

}
