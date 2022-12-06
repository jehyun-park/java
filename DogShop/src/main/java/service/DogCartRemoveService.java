package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.CartVO;

public class DogCartRemoveService {

	public void removeCart(String[] deleteIdArray, HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<CartVO> cartList = (ArrayList<CartVO>)session.getAttribute("cartList");
		
		for(int i=0; i<deleteIdArray.length; i+=1) {
			for(int j=0; j<cartList.size(); j+=1) {
				if(Integer.parseInt(deleteIdArray[i]) == cartList.get(j).getDogId()) {
					cartList.remove(cartList.get(j));
				}
			}
		}
	}

}
