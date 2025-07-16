package chapter12;

public class WrapperTest {

	public static void main(String[] args) {

		int num1 = 100;
		Integer num2 = new Integer(num1);		//Deprecated!! (권장 X)
		Integer num3 = Integer.valueOf(num1);	//문자열 -> Wrapper 클래스 객체
		int num4 = Integer.parseInt("123");		//문자열 -> 기본자료형 (자주 사용함)
		double dnum = Double.valueOf("123.60");	//문자열 -> Wrapper 클래스 객체
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(dnum);
	}

}
