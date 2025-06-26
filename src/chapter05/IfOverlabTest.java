package chapter05;

import java.util.Scanner;

/*
 * 중첩 if
 */

public class IfOverlabTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int math = 0, english = 0;
		
		System.out.print("수학 점수 : ");
		math = scan.nextInt();
		System.out.print("영어 점수 : ");
		english = scan.nextInt();
		
		// 1. 중첩 if
		if(math >= 60) {
			if(english >= 60) {
				System.out.println("합격");
			}
		} else {
			System.out.println("불합격");
		}
		
		// 2. 논리연산자 &&를 이용한 if ~ else
		if(math >= 60 && english >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}

}
