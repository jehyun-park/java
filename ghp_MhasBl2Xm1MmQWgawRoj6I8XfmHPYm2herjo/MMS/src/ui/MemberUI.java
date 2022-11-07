package ui;

import java.util.ArrayList;
import java.util.Scanner;

import action.Action;
import action.MemberListAction;
import action.MemberModifyAction;
import action.MemberRegistAction;
import action.MemberRemoveAction;
import action.MemberSearchAction;
import controller.MemberController;
import vo.MemberVO;

public class MemberUI {
	public static ArrayList<MemberVO> memberList = new ArrayList<>();
	
	public static void main(String args[]) {
		boolean stop = false;
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(System.getProperty("line.separator"));
		MemberController memberController = new MemberController();
		//모델 2 개발 방식에서는 사용자의 요청어을 컨트롤러 클래스에서 받아서 처리함
		
		Action action = null;
		
		do {
			System.out.println("======회원관리======");
			System.out.println("1. 회원등록"); //C(Create)
			System.out.println("2. 회원목록보기"); //R(Read)
			System.out.println("3. 회원정보수정"); //U(Update)
			System.out.println("4. 회원정보삭제"); //D(Delete)
			System.out.println("5. 회원정보검색"); //R(Read)
			System.out.println("6. 프로그램종료"); //R(Read)
			
			System.out.print("메뉴번호 : ");
			int menuNumber = scanner.nextInt();
			
			switch (menuNumber) {
			case 1: {
				action = new MemberRegistAction();
				break;
			}
			case 2: {
				action = new MemberListAction();
				break;
			}
			case 3: {
				action = new MemberModifyAction();
				break;
			}
			case 4: {
				action = new MemberRemoveAction();
				break;
			}
			case 5: {
				action = new MemberSearchAction();
				break;
			}
			case 6: {
				action = null;
				stop = true;
				System.out.println("프로그램 종료");
				break;
			}
			default:
				break;
			}
			
			if(action != null) {
				memberController.processRequest(action, scanner);
			}
		} while(!stop);
	}
}