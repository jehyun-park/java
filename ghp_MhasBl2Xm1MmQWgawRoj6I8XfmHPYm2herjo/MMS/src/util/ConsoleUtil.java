package util;

import java.util.ArrayList;
import java.util.Scanner;

import vo.MemberVO;
import vo.SearchVO;

public class ConsoleUtil {

	public static MemberVO getNewMemberVO(Scanner scanner) {
		// TODO Auto-generated method stub
		vo.MemberVO newMemberVO = new MemberVO();
		System.out.println("ȸ�������Է�");
		System.out.print("ȸ�����̵� : ");
		String memberId = scanner.next();
		System.out.print("ȸ���̸� : ");
		String memberName = scanner.next();
		System.out.print("ȸ�����̴� : ");
		int memberGeneration = scanner.nextInt();
		System.out.print("ȸ������ : ");
		int memberAge = scanner.nextInt();
		System.out.print("ȸ���ּ� : ");
		String memberAddr = scanner.next();
		System.out.print("ȸ���̸��� : ");
		String memberEmail = scanner.next(); 
		System.out.print("ȸ������ : ");
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
		System.out.println(memberName + " ȸ����� ����");
	}
	public void printRegistFailMessage(String memberName) {
		System.out.println(memberName + " ȸ����� ����");
	}

	public void printMemberList(ArrayList<MemberVO> memberList) {
		if(memberList.size() == 0) {
			System.out.println("��ϵ� ȸ���� �����ϴ�.");
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
		System.out.println("�������� �Է�");
		System.out.println("���� ȸ���̸� : " + oldMemberVO.getMemberName());
		System.out.println("ȸ���̸� : ");
		String memberName = scanner.next();
		
		System.out.println("���� ȸ�����̴� : " + oldMemberVO.getMemberGeneration());
		System.out.println("ȸ�����̴� : ");
		int memberGeneration = scanner.nextInt();
		
		System.out.println("���� ȸ������ : " + oldMemberVO.getMemberAge());
		System.out.println("ȸ������ : ");
		int memberAge = scanner.nextInt();
		
		System.out.println("���� ȸ���ּ� : " + oldMemberVO.getMemberAddr());
		System.out.println("ȸ���ּ� : ");
		String memberAddr = scanner.next();
		
		System.out.println("���� ȸ���̸��� : " + oldMemberVO.getMemberEmail());
		System.out.println("ȸ���̸��� : ");
		String memberEmail = scanner.next();
		
		
		System.out.println("���� ȸ������ : " + oldMemberVO.getMemberGender());
		System.out.println("ȸ������ : ");
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
		System.out.println(memberId + "���� �������� ����");
	}
	public void printModifyFailMessage(String memberId) {
		System.out.println(memberId + "���� �������� ����");
	}

	public void printRemoveSuccessMessage(String memberId) {
		System.out.println(memberId + "���� ���� ��������");
	}
	public void printRemoveFailMessage(String memberId) {
		System.out.println(memberId + "���� ���� ��������");
	}
	
	public SearchVO getSearchVO(Scanner scanner) {
		SearchVO searchVO = new SearchVO();
		System.out.println("�˻�����(ȸ�����̵�|���̴�) : ");
		String searchCondition = scanner.next();
		
		if(searchCondition.equals("ȸ�����̵�")){
			System.out.println("�˻��� ȸ�����̵� : ");
		}
		else if(searchCondition.equals("���̴�")){
			System.out.println("�˻��� ���̴� : ");
		}
		String searchValue = scanner.next();
		
		searchVO.setSearchCondition(searchCondition);
		searchVO.setSearchValue(searchValue);
		return searchVO;
	}

	public void printSearchedMemberVO(MemberVO searchedMemberVO) {
		if(searchedMemberVO == null) {
			System.out.println("�˻��� ȸ�������� �����ϴ�.");
		}
		else {
			System.out.println("ȸ�����̵�� �˻��� ���");
			System.out.println(searchedMemberVO);
		}
	}

	public void printSearchedMemberVO(ArrayList<MemberVO> searchedMemberList) {
		if(searchedMemberList.size() == 0) {
			System.out.println("�˻��� ȸ�������� �����ϴ�.");
		}
		else {
			System.out.println("ȸ�� ���̴�� �˻��� ���");
			for (int i = 0; i < searchedMemberList.size(); i++) {
				System.out.println(searchedMemberList.get(i));
			}
		}
	}
}