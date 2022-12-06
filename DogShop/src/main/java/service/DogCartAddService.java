package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.CartVO;
import vo.DogVO;

public class DogCartAddService {

	public void addCart(DogVO dogVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		ArrayList<CartVO> cartList = (ArrayList<CartVO>)session.getAttribute("cartList");
		
		if(cartList == null) {
			cartList = new ArrayList<CartVO>();
			session.setAttribute("cartList", cartList);
		}
		
		//´ã±â
		
		boolean newCart = true;
		
		for(int i = 0; i < cartList.size(); i++) {
			if(dogVO.getDogKind().contentEquals(cartList.get(i).getDogKind())) {
				newCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty() + 1);
			}
		}
		
		if(newCart) {
			CartVO cartVO = new CartVO();
			cartVO.setDogId(dogVO.getDogid());
			cartVO.setDogImage(dogVO.getDogImage());
			cartVO.setDogKind(dogVO.getDogKind());
			cartVO.setDogPrice(dogVO.getDogPrice());
			cartVO.setQty(1);
			
			cartList.add(cartVO);
		}
	}
	
}