package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ZipCodeSearchService;
import vo.AddressVO;

@WebServlet("/zipCodeSearch")
public class ZipCodeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZipCodeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ro =request.getParameter("ro");
		System.out.println("ro = "+ ro);
		ZipCodeSearchService zipCodeSearchServlet = new ZipCodeSearchService();
		
		ArrayList<AddressVO> addressList = ZipCodeSearchService.getaddressList(ro);
		request.setAttribute("addressList", addressList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("zipCodeSearch.jsp");
		dispatcher.forward(request, response);
		
	}

}
