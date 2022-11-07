package service;

import ui.MemberUI;

public class MemberRemoveService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean removeSuccess = false;
		for (int i = 0; i < MemberUI.memberList; i++) {
			if(memberId.contentEquals(MemberUI.memberList.get(i)));
				MemberUI.memberList.remove(i);
				removeSuccess = false;
				break;
			
		}
	
		return removeSuccess;
	}
	

}
