package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DogCartAddService;
import service.DogViewService;
import vo.ActionForward;
import vo.DogVO;

public class DogCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int dogId = Integer.parseInt(request.getParameter("dogId"));
		DogViewService dogViewService = new DogViewService();
		DogVO dogVO = dogViewService.getDog(dogId);
		
		DogCartAddService dogCartAddService = new DogCartAddService();
		dogCartAddService.addCart(dogVO, request);

		ActionForward forward = new ActionForward();
		forward.setUrl("dogCartList.dog");
		forward.setRedirect(true);
		return forward;
	}

}