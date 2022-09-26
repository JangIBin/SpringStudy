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
	
	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {

		System.out.println("글 등록 처리");
		
		// 파일 업로드 처리함
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/pk/"+fileName));
		}
		
		
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {

		System.out.println("글 수정 처리");
		
		boardService.updateBoard(vo);
		
		return "getBoardList.do"; // View 정보를 저장
	}
	
	// 글 삭제
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {

		System.out.println("글 삭제 처리");
		
		boardService.deleteBoard(vo);

		return "getBoardList.do"; // View 정보를 저장
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		
		// 검색 조건 목록 설정
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
		
	}
	
	
	// 글 상세 조회
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		
		System.out.println("글 상세보기 처리");
		
		model.addAttribute("board", boardService.getBoard(vo)); // Model 정보를 저장
		return "getBoard.jsp"; // View 정보를 저장
		
	}
	
	// 글 목록 조회
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
				
		System.out.println("글 목록보기 처리");
		
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");

		// 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴함
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 정보를 저장
		return "getBoardList.jsp"; // View 정보를 저장
	}
	
	/*
		// 글 상세 조회
	@RequestMapping(value = "/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
			
		System.out.println("글 상세보기 처리");
			
		mav.addObject("board", boardDAO.getBoard(vo)); // Model 정보를 저장
		mav.setViewName("getBoard.jsp"); // View 정보를 저장
			
		return mav;
	}
		
	
	// 글 목록 조회
	@RequestMapping(value = "/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		
		System.out.println("글 목록보기 처리");
		// 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴함
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model 정보를 저장
		mav.setViewName("getBoardList.jsp"); // View 정보를 저장
		
		return mav;
	}
	 */
	
	/*
	// 글 상세 조회
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		System.out.println("글 상세보기 처리");
		
		model.addAttribute("board", boardDAO.getBoard(vo)); // Model 정보를 저장
		return "getBoard.jsp"; // View 정보를 저장
		
	}
		
	// 글 목록 조회
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(
			@RequestParam(value = "searchCondition" ,defaultValue = "TITLE", required = false) String condition,
			@RequestParam(value = "searchKeyword" ,defaultValue = "", required = false) String keyword,
			BoardDAO boardDAO, Model model) {
			
		System.out.println("글 목록보기 처리");
		
		System.out.println("글 상세보기 처리");
		System.out.println("검색 조건 : "+condition);
		System.out.println("검색 키워드 : " + keyword);
		// 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴함
		//model.addAttribute("boardList", boardDAO.getBoardList(vo)); // Model 정보를 저장
		return "getBoardList.jsp"; // View 정보를 저장
	}
	*/
}
