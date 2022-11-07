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
		//�� 2 ���� ��Ŀ����� ������� ��û���� ��Ʈ�ѷ� Ŭ�������� �޾Ƽ� ó����
		
		Action action = null;
		
		do {
			System.out.println("======ȸ������======");
			System.out.println("1. ȸ�����"); //C(Create)
			System.out.println("2. ȸ����Ϻ���"); //R(Read)
			System.out.println("3. ȸ����������"); //U(Update)
			System.out.println("4. ȸ����������"); //D(Delete)
			System.out.println("5. ȸ�������˻�"); //R(Read)
			System.out.println("6. ���α׷�����"); //R(Read)
			
			System.out.print("�޴���ȣ : ");
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
				System.out.println("���α׷� ����");
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