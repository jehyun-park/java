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
		
		int pageSize = 10; //���������� ��µ� ���� ����
		
		String pageNum = request.getParameter("pageNum");
	    if (pageNum == null) {  // �Խ��� �޴��� Ŭ���ϰ� ��û������
	        pageNum = "1";
	    }

	    int currentPage = Integer.parseInt(pageNum); // ����¡ ó���Ҷ� ������ ��ȣ�� ������ �ϱ����ؼ� ����Ÿ������ ��ȯ
	    int startRow = (currentPage - 1) * pageSize + 1; // �ش��������� Ǯ�µ� ù��° ���� ���ڵ��ȣ
	    
	    int count = 0; // �� ���� ������ ������ ����
	    int number=0; // �ش� �������� ��µǴ� ù��° ���� �۹�ȣ

	    List<BoardVO> articleList = null;
	    BoardListService boardListService = new BoardListService(); 
	    		
	  
	    count = boardListService.getArticelCount();
	    if (count > 0) {
	        articleList = boardListService.getArticles(startRow, pageSize);
	    }

		number=count-(currentPage-1)*pageSize; 
		//������ ��ȣ: 1
		//�� ���� ����: 123
		//123 -(1-1) *10 ==> 123
		
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;
		 if (count > 0) {
		        pageCount = count / pageSize + 
		        		( count % pageSize == 0 ? 0 : 1);
		        //���������� ����
		        //123
		        //123 / 10 + 1 ==> 13
				 
		        startPage = (int)((currentPage-1)/10)*10+1;
		        // �ϳ��� ������ �׷��� ���������� ��ȣ
		        // ���������� : 3
		        //(3/10) * 10 + 1 ==>1
		        
				int pageBlock=10; //�ѹ��� ������ ��µǴ� ���������� �׷�
		        endPage = startPage + pageBlock-1; 
		        //�ϳ��� ������ �׷��� ������ ������ ��ȣ
		        if (endPage > pageCount) endPage = pageCount;
		        // ������ ������ �׷��� ���
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
