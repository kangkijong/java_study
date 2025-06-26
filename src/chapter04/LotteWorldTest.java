package chapter04;

import java.util.Scanner;

public class LotteWorldTest {

	public static void main(String[] args) {
		// 놀이기구 탑승 전 체크사항
		// 1. 6세 이상 탑승 가능(단, 6세 미만은 키가 120cm 이상이고 보호자 동반하에 탑승가능)
		// 2. 키 120cm 이상 탑승 가능
		// 3. 심장질환자는 탑승 불가
		
		Scanner input = new Scanner(System.in);
		// 지역변수를 선언하는 경우에는 반드시 초기화를 진행함
		String name = "";	// 클래스는 null값으로 초기화 가능
		int age = 0, height = 0;
		boolean parent = false, hearchDease = false;
		
		System.out.print("이름 : ");
		name = input.next();
		System.out.print("나이 : ");
		age = input.nextInt();
		System.out.print("키 : ");
		height = input.nextInt();
		System.out.print("부모님 동반여부(동반O : 1, 동반X : 0) : ");
		parent = (input.nextInt() == 1) ? true : false;
		System.out.print("심장질환 여부(유 : 1, 무 : 0) : ");
		hearchDease = (input.nextInt() == 1) ? true : false;
		
//		System.out.println(name + ", " + age + ", " + height + ", " + parent + ", " + hearchDease);
		String result = (((age >= 6) && (height >= 120)) || ((age < 6) && (height >= 120) && (parent==true))) && (hearchDease==false)
						? "탑승 가능!" : "탑승 불가능!";
		System.out.println(name + "은(는) " + result);
	}

}
