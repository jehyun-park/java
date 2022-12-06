package action;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DogCartListService;
import vo.ActionForward;
import vo.CartVO;

public class DogCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogCartListService dogCartListService = new DogCartListService();
		ArrayList<CartVO> cartList = dogCartListService.getCartList(request);
		
		int totalMoney = 0;
		for(int i = 0; i<cartList.size(); i++) {
			totalMoney += cartList.get(i).getDogPrice() * cartList.get(i).getQty(); 
		}
		
		request.setAttribute("cartList", cartList);
		request.setAttribute("totalMoney", totalMoney);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("dogCartList.jsp");
		
		return forward;
	}

}