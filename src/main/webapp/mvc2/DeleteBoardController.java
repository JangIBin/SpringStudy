package com.global.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;


public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("�� ���� ó��");
		
		String seq = request.getParameter("seq");
		
		// 2. DB ����
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do"); // View ������ ����
		
		// 3. ȭ�� ����
		
		return mav;
	}

}
