package action;

import java.util.Scanner;

// 각 요청을 처리하는 Action 클래스들의 규격을 정의하는 인터페이스
public interface Action {
	public void execute(Scanner scanner) throws Exception;
}