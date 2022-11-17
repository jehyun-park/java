package action;

import java.util.ArrayList;
import java.util.Scanner;

import service.SearchService;
import vo.MemberVO;
import vo.SearchVO;
import util.ConsoleUtil;

public class MemberSearchAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		ConsoleUtil consoleUtil = new ConsoleUtil();
		SearchVO searchVO = consoleUtil.getSearchVO(scanner);
		
		SearchService searchService = new SearchService();
		if(searchVO.getSearchCondition().contentEquals("회원아이디")) {
			MemberVO searchedMemberVO = searchService.searchByMemberId(searchVO.getSearchValue());
			consoleUtil.printSearchedMemberVO(searchedMemberVO);
		}
		else if(searchVO.getSearchCondition().contentEquals("나이대")) {
			ArrayList<MemberVO> searchedMemberList = searchService.searchByMemberGeneration(searchVO.getSearchValue());
			consoleUtil.printSearchedMemberVO(searchedMemberList);
		}
		
	}

}