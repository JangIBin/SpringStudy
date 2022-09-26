package com.global.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.global.biz.board.BoardService;
import com.global.biz.board.BoardVO;


@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// �� ���
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {

		System.out.println("�� ��� ó��");
		
		// ���� ���ε� ó����
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/pk/"+fileName));
		}
		
		
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	// �� ����
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {

		System.out.println("�� ���� ó��");
		
		boardService.updateBoard(vo);
		
		return "getBoardList.do"; // View ������ ����
	}
	
	// �� ����
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {

		System.out.println("�� ���� ó��");
		
		boardService.deleteBoard(vo);

		return "getBoardList.do"; // View ������ ����
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		
		// �˻� ���� ��� ����
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
		
	}
	
	
	// �� �� ��ȸ
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		
		System.out.println("�� �󼼺��� ó��");
		
		model.addAttribute("board", boardService.getBoard(vo)); // Model ������ ����
		return "getBoard.jsp"; // View ������ ����
		
	}
	
	// �� ��� ��ȸ
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
				
		System.out.println("�� ��Ϻ��� ó��");
		
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");

		// �˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� ������
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model ������ ����
		return "getBoardList.jsp"; // View ������ ����
	}
	
	/*
		// �� �� ��ȸ
	@RequestMapping(value = "/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
			
		System.out.println("�� �󼼺��� ó��");
			
		mav.addObject("board", boardDAO.getBoard(vo)); // Model ������ ����
		mav.setViewName("getBoard.jsp"); // View ������ ����
			
		return mav;
	}
		
	
	// �� ��� ��ȸ
	@RequestMapping(value = "/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		System.out.println("�� ��Ϻ��� ó��");
		// �˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� ������
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model ������ ����
		mav.setViewName("getBoardList.jsp"); // View ������ ����
		
		return mav;
	}
	 */
	
	/*
	// �� �� ��ȸ
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		System.out.println("�� �󼼺��� ó��");
		
		model.addAttribute("board", boardDAO.getBoard(vo)); // Model ������ ����
		return "getBoard.jsp"; // View ������ ����
		
	}
		
	// �� ��� ��ȸ
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(
			@RequestParam(value = "searchCondition" ,defaultValue = "TITLE", required = false) String condition,
			@RequestParam(value = "searchKeyword" ,defaultValue = "", required = false) String keyword,
			BoardDAO boardDAO, Model model) {
			
		System.out.println("�� ��Ϻ��� ó��");
		
		System.out.println("�� �󼼺��� ó��");
		System.out.println("�˻� ���� : "+condition);
		System.out.println("�˻� Ű���� : " + keyword);
		// �˻� ����� ȭ�� ������ ModelAndView�� �����Ͽ� ������
		//model.addAttribute("boardList", boardDAO.getBoardList(vo)); // Model ������ ����
		return "getBoardList.jsp"; // View ������ ����
	}
	*/
}
