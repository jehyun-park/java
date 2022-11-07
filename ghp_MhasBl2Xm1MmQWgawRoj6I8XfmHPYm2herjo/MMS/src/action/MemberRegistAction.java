package action;

import java.util.Scanner;

import service.MemberRegistService;
import util.ConsoleUtil;
import vo.MemberVO;

public class MemberRegistAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		ConsoleUtil consoleUtil = new ConsoleUtil();
		MemberVO newMemberVO = ConsoleUtil.getNewMemberVO(scanner);
		
		MemberRegistService memberRegistService = new MemberRegistService();
		boolean registSuccess = memberRegistService.registNewMember(newMemberVO);
		
		if(registSuccess) {
			consoleUtil.printRegistSuccessMessage(newMemberVO.getMemberName());
		}
		else {
			consoleUtil.printRegistFailMessage(newMemberVO.getMemberName());
		}
		
	}

}