package service;

import java.util.ArrayList;

import ui.MemberUI;
import vo.MemberVO;

public class SearchService {

	public MemberVO searchByMemberId(String memberId) {
		MemberVO searchedMemberVO = null;
		for (int i = 0; i < MemberUI.memberList.size(); i++) {
			if (memberId.contentEquals(MemberUI.memberList.get(i).getMemberId())) {
				searchedMemberVO = MemberUI.memberList.get(i);
				break;
			}
		}
		return searchedMemberVO;
	}

	public ArrayList<MemberVO> searchByMemberGeneration(String memberGeneration) {
		ArrayList<MemberVO> searchedMemberList = new ArrayList<MemberVO>();
		for (int i = 0; i < MemberUI.memberList.size(); i++) {
			if (MemberUI.memberList.get(i).getMemberGeneration() == Integer.parseInt(memberGeneration)) {
				searchedMemberList.add(MemberUI.memberList.get(i));
			}
		}
		return searchedMemberList;
	}

}