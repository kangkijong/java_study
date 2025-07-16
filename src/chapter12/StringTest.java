package chapter12;

public class StringTest {

	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = new String("홍길동");
		String num = String.valueOf(123);	//기본자료형 값을 문자열로 변환하여 리턴
		name2 = "welcometoJava!!";
		
		String phone = "010-1234-5678";
		String subject = "java,css,html,mysql";
		String[] phones = phone.split("-");
		String[] subjects = subject.split(",");		//문자열을 매개변수 ","를 구분자로 나눠서 배열로 리턴
		
		String jphone = String.join("|", phones);
		
		System.out.println(subject.contains("html"));	//subject에서 html을 포함하는가?
		System.out.println(jphone); 		//010|1234|5678
		System.out.println(subjects[0]);	//java
		System.out.println(phones[0]);		//010
		System.out.println(name2.substring(7, 10));	//매개변수 start위치부터 end위치 전 인덱스까지 잘라냄
		System.out.println(name2.substring(7));		//매개변수 start위치(인덱스)에서 끝까지 잘라냄
		System.out.println(name2.length());			//문자열의 길이를 리턴
		System.out.println(name2.toLowerCase());	//문자열을 소문자로 변환하여 리턴
		System.out.println(name2.toUpperCase());	//문자열을 대문자로 변환하여 리턴
		System.out.println(num + 10);				//문자임을 알 수 있음
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		
//		if(name1 == name2) {
//			System.out.println("동일");
//		} else {
//			System.out.println("다름");	//홍길동과 주소값을 비교하기 때문에 "다름"이 출력됨
//		}
		
//		if(name1.equals(name2)) {
//			System.out.println("동일");	
//		} else {
//			System.out.println("다름");
//		}
		
	}

}
