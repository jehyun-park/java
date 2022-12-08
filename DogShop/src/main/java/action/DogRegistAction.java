package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.DogRegistService;
import vo.ActionForward;
import vo.DogVO;

public class DogRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String realFolder= "";

		//������ ���ε�� �������� ������
		String saveFolder = "images";
		
		String encType = "UTF-8";
		
		//�ѹ��� ���ε� �� �� �ִ� ����Ʈ��
		int maxSize = 5 * 1024 * 1024; //5M

	 	// ���ø����̼Ǵ� �ϳ��� �����Ǵ� ��ü
		ServletContext context = request.getServletContext();
		
		//������ �������� ��� ������
		realFolder = context.getRealPath(saveFolder);
		
	
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		DogVO dogVO = new DogVO();
		dogVO.setDogContent(multi.getParameter("dogContent"));
		dogVO.setDogCountry(multi.getParameter("dogCountry"));
		dogVO.setDogHeight(Integer.parseInt(multi.getParameter("dogHeight")));
		String serverFileName = multi.getFilesystemName("dogImage");
		dogVO.setDogImage(serverFileName.substring(0,serverFileName.indexOf(".")));
		dogVO.setDogKind(multi.getParameter("dogKind"));
		dogVO.setDogPrice(Integer.parseInt(multi.getParameter("dogPrice")));
		dogVO.setDogWeight(Integer.parseInt(multi.getParameter("dogWeight")));
		
		DogRegistService dogRegistService = new DogRegistService();
		
		boolean registSuccess = dogRegistService.registDog(dogVO);
		
		ActionForward forward = null;
		if(registSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setUrl("dogList.dog");
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��Ͻ���')");
			out.println("history.back()");
			out.println("</script");
		}
		
		return forward;
	}

}








