package chapter11;

import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("num1> ");
		int num1 = scan.nextInt();
		
		System.out.print("num2> ");
		int num2 = scan.nextInt();
		
		try {
			int result = num1/num2;
			System.out.println("result : " + result);
			
			int[] numbers = {1, 2, 3};
//			System.out.println(numbers[5]);
			
		} catch(Exception e) {	//편리하지만 상세한 설명은 작성할 수 없음
			System.out.println("예외 발생!!");
			e.printStackTrace();
		} finally {
			scan.close();
			System.out.println("-- 프로그램 종료 --");
		}
		
	}

}
