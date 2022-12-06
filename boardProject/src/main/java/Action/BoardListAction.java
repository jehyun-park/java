package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardListService;
import vo.ActionForward;
import vo.BoardVO;
import vo.PageVO;

import java.util.List;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int pageSize = 10; //한페이지당 출력될 글의 개수
		
		String pageNum = request.getParameter("pageNum");
	    if (pageNum == null) {  // 게시판 메뉴를 클릭하고 요청했을때
	        pageNum = "1";
	    }

	    int currentPage = Integer.parseInt(pageNum); // 페이징 처리할때 페이지 번호르 연산을 하기위해서 정수타입으로 변환
	    int startRow = (currentPage - 1) * pageSize + 1; // 해당페이지에 풀력될 첫번째 글의 레코드번호
	    
	    int count = 0; // 총 글의 개수를 저장할 변수
	    int number=0; // 해당 페이지에 출력되는 첫번째 글의 글번호

	    List<BoardVO> articleList = null;
	    BoardListService boardListService = new BoardListService(); 
	    		
	  
	    count = boardListService.getArticelCount();
	    if (count > 0) {
	        articleList = boardListService.getArticles(startRow, pageSize);
	    }

		number=count-(currentPage-1)*pageSize; 
		//페이지 번호: 1
		//총 글의 개수: 123
		//123 -(1-1) *10 ==> 123
		
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;
		 if (count > 0) {
		        pageCount = count / pageSize + 
		        		( count % pageSize == 0 ? 0 : 1);
		        //총페이지의 개수
		        //123
		        //123 / 10 + 1 ==> 13
				 
		        startPage = (int)((currentPage-1)/10)*10+1;
		        // 하나의 페이지 그룹의 시작페이지 번호
		        // 현재페이지 : 3
		        //(3/10) * 10 + 1 ==>1
		        
				int pageBlock=10; //한번에 묶여서 출력되는 페이지들의 그룹
		        endPage = startPage + pageBlock-1; 
		        //하나의 페이지 그룹의 마지막 페이지 번호
		        if (endPage > pageCount) endPage = pageCount;
		        // 마지막 페이지 그룹인 경우
		 }
		request.setAttribute("articleList", articleList);
		PageVO pageVO = new PageVO();
		pageVO.setCount(count);
		pageVO.setCurrentPage(currentPage);
		pageVO.setEndPage(endPage);
		pageVO.setNumber(number);
		pageVO.setPageCount(pageCount);
		pageVO.setStartPage(startPage);
		request.setAttribute("pageVO", pageVO);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("board/list.jsp");
		
		return forward
				;
	}

}
