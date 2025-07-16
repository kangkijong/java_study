package chapter12;

public class MathTest {

	public static void main(String[] args) {
		//모든 메소드가 static으로 정의되어 있음 : 클래스명.메소드명()
		System.out.println(Math.abs(-100));			//변수의 절대값 리턴
		System.out.println(Math.floor(123.4567));	//매개변수보다 작은 가장 큰 수(값 내림, 소수점 뒷 자리 수 절삭)
		System.out.println(Math.max(100, 200));		//매개변수 두 개 중 큰 수 리턴
		System.out.println(Math.min(100, 200));		//매개변수 두 개 중 작은 수 리턴
		System.out.println(Math.random());			//0.0 이상 1.0 미만의 랜덤 수 리턴(1은 포함되지 않음)
		System.out.println((int)Math.floor(Math.random() * 100));	//정수 2자리 랜덤 호출
		System.out.println(Math.round(123.567));	//반올림
		
	}

}
