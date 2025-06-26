package chapter04;

import java.util.Scanner;

/*
 * 삼항 연산자 : (조건식) ? 결과1 : 결과2 ; 
 */

public class OpTernaryTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	// Scanner에 커서두고 ctrl + shift + o 누르면 자동으로 import됨
				
		System.out.print("점수를 입력하세요 : ");
		int score = input.nextInt();
		
		// score가 60점 이상이면 "합격", 이하면 "불합격"임. 해당 결과를 result 변수에 대입함
		String result = (score >= 60) ? "합격" : "불합격";  
		System.out.println("결과 : " + result);
	}

}
