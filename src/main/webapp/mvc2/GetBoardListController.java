package com.global.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;


public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("�� ��Ϻ��� ó��");
		
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		/*
		// �˻������ ���ǿ� �����ϰ� �� ��� ȭ������ �̵�
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		*/
		
		// �˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� return��
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // Model ������ ����
		mav.setViewName("getBoardList"); // View ������ ����
		
		return mav;
	}

}
