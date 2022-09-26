package com.global.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {

	@RequestMapping(value = "/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		System.out.println("�� �󼼺��� ó��");
		
		mav.addObject("board", boardDAO.getBoard(vo)); // Model ������ ����
		mav.setViewName("getBoard.jsp"); // View ������ ����
		
		return mav;
	}

}
