package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;
import vo.ReplyVO;

public class BoardWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("action");
		int num=0,ref=1,re_step=0,re_level=0;
	
		if(request.getParameter("num")!=null){
		num=Integer.parseInt(request.getParameter("num"));
		ref=Integer.parseInt(request.getParameter("ref"));
		re_step=Integer.parseInt(request.getParameter("re_step"));
		re_level=Integer.parseInt(request.getParameter("re_level"));
		}
		
		ReplyVO replyVO = new ReplyVO();
		replyVO.setNum(num);
		replyVO.setRef(ref);
		replyVO.setRe_step(re_step);
		replyVO.setRe_level(re_level);
		
		request.setAttribute("replyVO", replyVO);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("board/writeForm.jsp");
		
		return forward;
	}

}
