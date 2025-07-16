package chapter12;

public class MathTest {

	public static void main(String[] args) {
		//모든 메소드가 static으로 정의되어 있음 : 클래스명.메소드명()
		System.out.println(Math.abs(-100));			//절대값
		System.out.println(Math.floor(123.4567));	//소수점 뒷자리를 절삭함(반올림 X)
		System.out.println(Math.max(100, 200));		//둘 중 큰 수 반환
		System.out.println(Math.min(100, 200));		//둘 중 작은 수 반환
		System.out.println(Math.random());			//0 ~ 1 사이의 랜덤
		System.out.println((int)Math.floor(Math.random() * 100));	//정수 2자리 랜덤 호출
		System.out.println(Math.round(123.567));	//반올림
		
	}

}
