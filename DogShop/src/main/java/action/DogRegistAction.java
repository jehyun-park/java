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

		//파일이 업로드될 서버상의 폴더명
		String saveFolder = "images";
		
		String encType = "UTF-8";
		
		//한번에 업로드 할 수 있는 바이트수
		int maxSize = 5 * 1024 * 1024; //5M

	 	// 애플리케이션당 하나씩 생성되는 객체
		ServletContext context = request.getServletContext();
		
		//서버의 물리적인 경로 얻어오기
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
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script");
		}
		
		return forward;
	}

}








