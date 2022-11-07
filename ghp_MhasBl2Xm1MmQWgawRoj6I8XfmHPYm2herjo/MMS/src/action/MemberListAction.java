package action;

import java.util.ArrayList;
import java.util.Scanner;

import service.MemberListService;
import util.ConsoleUtil;
import vo.MemberVO;

public class MemberListAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		MemberListService memberListService = new MemberListService();
		ArrayList<MemberVO> memberList = memberListService.getMemberList();
		
		ConsoleUtil consoleUtil = new ConsoleUtil();
		consoleUtil.printMemberList(memberList);
		
	}

}