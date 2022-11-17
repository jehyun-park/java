package action;

import java.util.Scanner;

import service.MemberRemoveService;
import util.ConsoleUtil;

public class MemberRemoveAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		ConsoleUtil consoleUtil = new ConsoleUtil();
		String memberId = consoleUtil.getMemberId("삭제할 회원아이디 : ", scanner);
		
		MemberRemoveService memberRemoveService = new MemberRemoveService();
		
		boolean removeSuccess = memberRemoveService.removeMemberVO(memberId);
		
		if(removeSuccess) {
			consoleUtil.printRemoveSuccessMessage(memberId);
		}
		else {
			consoleUtil.printRemoveFailMessage(memberId);
		}
	}

}
