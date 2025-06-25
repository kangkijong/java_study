package chapter03;
import java.lang.String;	// 주석처리해도 오류뜨지 않음(자주쓰는 것은 lang에 들어가 있어서)

public class Variable {
	public static void main(String[] args) {
		// 기본 자료형 변수 정의
		int age = 10;			// int age = 10.0; 		실수 넣으면 오류 발생
		double aged = 10.0;		// double aged = 10; 	정수형도 캐스팅으로 인해 사용가능 
		boolean flag = true;	// true(1), false(0)
		char name = '홍';		// char name = "홍"; 	더블쿼테이션 쓰면 오류 발생
		
		// 참조 자료형 변수 정의
		String sname = new String("홍길동");	// 참조형으로도 사용 가능함
		
		// String 클래스는 기본형과 참조형으로 모두 사용 가능!!
		String sname2 = "홍길동 입니다";
		
		System.out.println(age);	// 변수가 선언된 후에 작성되어야함
		System.out.println(aged);
		System.out.println(flag);
		System.out.println(name);
		System.out.println(sname);
		System.out.println(sname2);	// ctrl + d : 한줄 지우기
	}
}
