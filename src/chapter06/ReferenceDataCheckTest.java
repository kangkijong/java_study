package chapter06;

import java.util.Scanner;
/*
 * 기본형 데이터와 참조형 데이터의 저장구조를 정리
 */
public class ReferenceDataCheckTest {

	public static void main(String[] args) {
		// 기본형
		int a = 10;
		int b = 10;
		String str1 = "홍길동은 자바천재";
		String str2 = "홍길동은 자바천재";
		String str3 = "홍길순은 자바천재";
		
		// call by value 형태로 값을 비교
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println("a == b : " + (a == b));
		System.out.println("str1 == str2 : " + (str1 == str2));
		
		// 참조형
		String strObj1 = new String("홍길동");
		String strObj2 = new String("홍길동");
		
		System.out.println(System.identityHashCode(strObj1));	// 시스템에 생성되는 객체 주소를 가져옴
		System.out.println(System.identityHashCode(strObj2));
		System.out.println("strObj1 == strObj2 : " + (strObj1 == strObj2));	// stack 주소 비교
		System.out.println("strObj1.equals(strObj2) : " + (strObj1.equals(strObj2)));	// 주소가 가지고 있는 문자열은 같음
		
		//
		strObj1 = str1;
		System.out.println(strObj1);
		System.out.println(System.identityHashCode(strObj1));
		
		// Scanner 객체를 이용하여 문자열을 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String sdata = scan.next();	// 외부에서 입력받는 문자열은 Heap에 저장됨 (객체로 생성되어 저장됨)
		
		System.out.println(sdata);
		System.out.println("sdata == str1 : " + (sdata == str1));	// 입력받은 문자와 sdata 비교
		System.out.println("sdata.equals(str1) : " + (sdata.equals(str1)));
	}

}
