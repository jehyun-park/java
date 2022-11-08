package service;

import ui.MemberUI;

public class MemberRemoveService {

	public boolean removeMemberVO(String memberId) {
		boolean removeSuccess = false;
		for (int i = 0; i < MemberUI.memberList.size(); i++) {
			if(memberId.contentEquals(MemberUI.memberList.get(i).getMemberId())) {
				MemberUI.memberList.remove(i);
				removeSuccess = true;
				break;
			}
		}
		return removeSuccess;
	}

}