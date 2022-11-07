package action;

import java.util.Scanner;

import service.SearchService;
import util.ConsoleUtil;
import vo.SearchVO;

public class MemberSearchAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		ConsoleUtil consoleUtil = new ConsoleUtil();
		SearchVO searchVO = consoleUtil.getSearchVO(scanner);
		
		SearchService searchService = new SearchService();
		if(searchVO.getSearchCondition().contentEquals("ȸ�����̵�")) {
			MemberVO searchedMemberVO = searchService.searchByMemberId(searchVO.getSerachValue());
		}
		else if(searchVO.getSearchCondition().contentEquals("���̴�")) {
			ArrayList<MemberVO> searchedMemberList = searchService.searchByMemberGeneration(searchVO.getSerachValue());
			consoleUtil.printSearchedMemberList(searchedMemberList);
		}
	}

}