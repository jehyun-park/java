package controller;

import java.util.Scanner;

import action.Action;

public class MemberController {

	public void processRequest(Action action, Scanner scanner) {
		
		try {
			action.execute(scanner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}