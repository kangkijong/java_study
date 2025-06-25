package chapter03;

//import java.lang.String;
//import java.lang.System;	// 따로 선언하지 않아도 사용이 가능함
import java.util.Scanner;

public class ReferenceDataType {

	public static void main(String[] args) {
		// 참조 데이터 타입 정의 : 배열, 클래스, 인터페이스 ..
		String name = new String("홍길동");
		Scanner scan = new Scanner(System.in);
		
		// !!!!! 중요 !!!!!
		// String 클래스는 기본형으로도 사용이 가능함
		String name2 = "홍길동";
		
		System.out.println(name);	// 참조형(주소값)
		System.out.println(name2);	// 기본형(홍길동)
		System.out.println(name == name2);	// 비교 연산자를 통해 같지 않은 것을 알 수 있음(false)
		System.out.println(scan);
	}

}
