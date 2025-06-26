package chapter04;

/*
 * 논리 연산자 : &&(AND), ||(OR), !(NOT)
 * &&, || 연산자는 앞의 식의 결과에 따라 Shortcut으로 진행됨 => 활용하면 프로그램의 실행속도를 높이는 효과
 */

public class OpLogicTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 5;

		// AND(&&) : 두 개의 항의 결과가 모두 true인 경우만 실행결과가 true
		System.out.println((a > b) && (a == 10));	// true
		System.out.println((a > b) && (b == 10));	// false 
		System.out.println((a < b) && (a == 10));	// false => 앞의 연산이 true이므로 Shortcut으로 실행됨
		System.out.println((a < b) && (b == 10));	// false => 앞의 연산이 true이므로 Shortcut으로 실행됨
		
		// OR(||) : 두 개의 항의 결과중 하나라도 true면 실행결과가 true
		System.out.println((a > b) || (a == 10));	// true	=> 앞의 연산이 true이므로 Shortcut으로 실행됨
		System.out.println((a > b) || (b == 10));	// true => 앞의 연산이 true이므로 Shortcut으로 실행됨
		System.out.println((a < b) || (a == 10));	// true 
		System.out.println((a < b) || (b == 10));	// false
		
		// NOT(!) : 결과를 반대의 boolean 값으로 변경
		System.out.println(!(a > b));				// true -> false
		System.out.println(!(a == 10));				// true -> false
		System.out.println(!(!(a > b) || !(a == 10)));	// true
//		System.out.println(!a);	// a는 int 타입으로 NOT 연산자가 적용되지 않음
	}

}
