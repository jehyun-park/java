package action;

import java.util.Scanner;

import service.MemberModifyService;
import util.ConsoleUtil;
import vo.MemberVO;

public class MemberModifyAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		ConsoleUtil consoleUtil = new ConsoleUtil();
		String memberId = consoleUtil.getMemberId("수정할 회원 아이디 : ",scanner);
		
		MemberModifyService memberModifyService = new MemberModifyService();
		
		MemberVO oldMemberVO = memberModifyService.getOldMemberVO(memberId);
		MemberVO newMemberVO = consoleUtil.getNewMemberVO(oldMemberVO, scanner);
		
		boolean modifySuccess = memberModifyService.modifyMemberVO(newMemberVO);
		
		if(modifySuccess) {
			consoleUtil.printModifySuccessMessage(memberId);
		}
		else {
			consoleUtil.printModifyFailMessage(memberId);
		}
	}

}