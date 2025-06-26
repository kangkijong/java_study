package chapter04;

/*
 * 사칙 연산자 : +, -, *, /, % 
 */

public class OpArithmeticTest {

	public static void main(String[] args) {
		int number1 = 5;
		int number2 = 2;
		
//		System.out.println("number1 + number2 = " + number1 + number2);		// number1 + number2 = 52	문자열 먼저 작성되면 접합연산자로 계산됨
		System.out.println("number1 + number2 = " + (number1 + number2));	// () 괄호로 묶어서 우선 연산처리하기
		System.out.println("number1 - number2 = " + (number1 - number2));
		System.out.println("number1 * number2 = " + (number1 * number2)); 
		System.out.println("number1 / number2 = " + (number1 / number2));
		System.out.println("number1 % number2 = " + (number1 % number2));
		
	}

}
