package chapter12;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();				//Random 객체를 생성하는 생성자
		System.out.println(random.nextInt());		//정수 랜덤값 리턴
		System.out.println(random.nextFloat());		//float 타입의 랜덤값 리턴
		System.out.println(random.nextDouble());	//double 자료형의 랜덤수 리턴
		
		
	}

}
