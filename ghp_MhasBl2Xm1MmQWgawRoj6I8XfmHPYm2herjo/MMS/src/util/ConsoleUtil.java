package util;

import java.util.ArrayList;
import java.util.Scanner;

import vo.MemberVO;
import vo.SearchVO;

public class ConsoleUtil {

	public static MemberVO getNewMemberVO(Scanner scanner) {
		// TODO Auto-generated method stub
		vo.MemberVO newMemberVO = new MemberVO();
		System.out.println("회원정보입력");
		System.out.print("회원아이디 : ");
		String memberId = scanner.next();
		System.out.print("회원이름 : ");
		String memberName = scanner.next();
		System.out.print("회원나이대 : ");
		int memberGeneration = scanner.nextInt();
		System.out.print("회원나이 : ");
		int memberAge = scanner.nextInt();
		System.out.print("회원주소 : ");
		String memberAddr = scanner.next();
		System.out.print("회원이메일 : ");
		String memberEmail = scanner.next(); 
		System.out.print("회원성별 : ");
		String memberGender = scanner.next(); 
		
		newMemberVO.setMemberAddr(memberAddr);
		newMemberVO.setMemberAge(memberAge);
		newMemberVO.setMemberEmail(memberEmail);
		newMemberVO.setMemberGender(memberGender);
		newMemberVO.setMemberGeneration(memberGeneration);
		newMemberVO.setMemberId(memberId);
		newMemberVO.setMemberName(memberName);
		
		return newMemberVO;
	}

	public void printRegistSuccessMessage(String memberName) {
		System.out.println(memberName + " 회원등록 성공");
	}
	public void printRegistFailMessage(String memberName) {
		System.out.println(memberName + " 회원등록 실패");
	}

	public void printMemberList(ArrayList<MemberVO> memberList) {
		if(memberList.size() == 0) {
			System.out.println("등록된 회원이 없습니다.");
		}
		else {
			for (int i = 0; i < memberList.size(); i++) {
				System.out.println(memberList.get(i));
			}
		}
	}

	public String getMemberId(String label, Scanner scanner) {
		System.out.print(label);
		return scanner.next();
	}

	public MemberVO getNewMemberVO(MemberVO oldMemberVO, Scanner scanner) {
		vo.MemberVO newMemberVO = new MemberVO();
		System.out.println("수정정보 입력");
		System.out.println("이전 회원이름 : " + oldMemberVO.getMemberName());
		System.out.println("회원이름 : ");
		String memberName = scanner.next();
		
		System.out.println("이전 회원나이대 : " + oldMemberVO.getMemberGeneration());
		System.out.println("회원나이대 : ");
		int memberGeneration = scanner.nextInt();
		
		System.out.println("이전 회원나이 : " + oldMemberVO.getMemberAge());
		System.out.println("회원나이 : ");
		int memberAge = scanner.nextInt();
		
		System.out.println("이전 회원주소 : " + oldMemberVO.getMemberAddr());
		System.out.println("회원주소 : ");
		String memberAddr = scanner.next();
		
		System.out.println("이전 회원이메일 : " + oldMemberVO.getMemberEmail());
		System.out.println("회원이메일 : ");
		String memberEmail = scanner.next();
		
		
		System.out.println("이전 회원성별 : " + oldMemberVO.getMemberGender());
		System.out.println("회원성별 : ");
		String memberGender = scanner.next(); 
		
		newMemberVO.setMemberAddr(memberAddr);
		newMemberVO.setMemberAge(memberAge);
		newMemberVO.setMemberEmail(memberEmail);
		newMemberVO.setMemberGender(memberGender);
		newMemberVO.setMemberGeneration(memberGeneration);
		newMemberVO.setMemberId(oldMemberVO.getMemberId());
		newMemberVO.setMemberName(memberName);
		
		return newMemberVO;
	}

	public void printModifySuccessMessage(String memberId) {
		System.out.println(memberId + "님의 정보수정 성공");
	}
	public void printModifyFailMessage(String memberId) {
		System.out.println(memberId + "님의 정보수정 실패");
	}

	public void printRemoveSuccessMessage(String memberId) {
		System.out.println(memberId + "님의 정보 삭제성공");
	}
	public void printRemoveFailMessage(String memberId) {
		System.out.println(memberId + "님의 정보 삭제실패");
	}
	
	public SearchVO getSearchVO(Scanner scanner) {
		SearchVO searchVO = new SearchVO();
		System.out.println("검색조건(회원아이디|나이대) : ");
		String searchCondition = scanner.next();
		
		if(searchCondition.equals("회원아이디")){
			System.out.println("검색할 회원아이디 : ");
		}
		else if(searchCondition.equals("나이대")){
			System.out.println("검색할 나이대 : ");
		}
		String searchValue = scanner.next();
		
		searchVO.setSearchCondition(searchCondition);
		searchVO.setSearchValue(searchValue);
		return searchVO;
	}

	public void printSearchedMemberVO(MemberVO searchedMemberVO) {
		if(searchedMemberVO == null) {
			System.out.println("검색된 회원정보가 없습니다.");
		}
		else {
			System.out.println("회원아이디로 검색한 결과");
			System.out.println(searchedMemberVO);
		}
	}

	public void printSearchedMemberVO(ArrayList<MemberVO> searchedMemberList) {
		if(searchedMemberList.size() == 0) {
			System.out.println("검색된 회원정보가 없습니다.");
		}
		else {
			System.out.println("회원 나이대로 검색한 결과");
			for (int i = 0; i < searchedMemberList.size(); i++) {
				System.out.println(searchedMemberList.get(i));
			}
		}
	}
}