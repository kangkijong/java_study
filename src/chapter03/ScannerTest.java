package chapter03;

/*
 * Scanner 실습 
 */

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = scan.next();
		
		System.out.print("나이를 입력하세요 : ");	// https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html
		int age = scan.nextInt();			// int형에 맞는 메소드를 찾아서 사용하기
		
		System.out.print("과목을 입력하세요 : ");
		String subject = scan.next();
		
		System.out.println("\n이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("과목 : " + subject);
		
	}

}
