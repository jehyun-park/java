package service;

import ui.MemberUI;
import vo.MemberVO;

public class MemberRegistService {

	public boolean registNewMember(MemberVO newMemberVO) throws Exception {
		boolean registSuccess = true;
		for (int i = 0; i < MemberUI.memberList.size(); i++) {
			if(newMemberVO.getMemberId().contentEquals(MemberUI.memberList.get(i).getMemberId())) {
				registSuccess = false;
				break;
			}
		}
		if(registSuccess) {
			MemberUI.memberList.add(newMemberVO);
		}
		return registSuccess;
	}
	
}