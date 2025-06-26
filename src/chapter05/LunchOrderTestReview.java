package chapter05;

import java.util.Scanner;

public class LunchOrderTestReview {

	public static void main(String[] args) {
		// 메뉴판
		System.out.println("********************************************");
		System.out.println("\t\t Mega Coffee");
		System.out.println("********************************************");
		System.out.println("\t 1. 아메리카노(☕)\t 2. 아이스크림(🍦)");
		System.out.println("\t 3. 프레첼(🥨)\t 4. 쿠키(🍪)");
		System.out.println("\t 9. 나가기");
		System.out.println("********************************************");
		int menuNo = -1;
		int menuPrice = -1;
		int charge = -1;
		int change = -1;
		String menuName = "";
		
		// 1. 메뉴 주문
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴를 선택하세요(숫자) : ");
		if(scan.hasNextInt()) {
			menuNo = scan.nextInt();
			
			switch(menuNo) {
				case 1: System.out.println("주문하신 메뉴는 아메리카노(☕)입니다. 가격은 3000원 입니다."); menuName = "아메리카노(☕)"; 	menuPrice = 3000; 	break;
				case 2: System.out.println("주문하신 메뉴는 아이스크림(🍦)입니다. 가격은 2000원 입니다."); 	menuName = "아이스크림(🍦)";	menuPrice = 2000;	break;
				case 3: System.out.println("주문하신 메뉴는 프레첼(🥨)입니다. 가격은 1000원 입니다."); 	menuName = "프레첼(🥨)";		menuPrice = 1000;	break;
				case 4: System.out.println("주문하신 메뉴는 쿠키(🍪)입니다. 가격은 500원 입니다."); 		menuName = "쿠키(🍪)";		menuPrice = 500;	break;
				case 9: 
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
				default: 
					System.out.println("잘못된 접근입니다. 프로그램을 종료합니다.");
					System.exit(0);
			}
		} else {
			System.out.println("숫자를 제대로 입력해주세요.");
			System.exit(0);
		}
		
		// 2. 주문 메뉴 결제
		System.out.print("\n요금을 제시해주세요 : ");
		if(scan.hasNextInt()) {
			charge = scan.nextInt();
			if(charge >= menuPrice) {
				change = charge - menuPrice;
			} else {
				System.out.println("요금이 부족합니다.");
				System.exit(0);
			}
		} else {
			System.out.println("요금을 정확히 입력해주세요.");
			System.exit(0);
		}
		
		// 3. 주문 내역 출력 : 주문한 메뉴는 (), 결제금액(), 잔돈() 입니다.
		System.out.println("주문하신 메뉴는 "+menuName+"입니다. 결제금액은 "+charge+", 잔돈은 "+change+"원 입니다.");
		
	}

}
