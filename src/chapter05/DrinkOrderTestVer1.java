package chapter05;

import java.util.Scanner;

/*
 *  ☕🍵🥤 음료 주문 프로그램
 */
public class DrinkOrderTestVer1 {

	public static void main(String[] args) {
		// 지역 변수 선언
		Scanner scan = new Scanner(System.in);
		int menuNum = 0;
		int menuPrice = 0;
		int charge = 0;
		int change = 0;
		String menuName ="";
		String menuPriceOutput = "";
		boolean menuFlag = true;
		boolean chargeFlag = true;
		
		// step 1 : 메뉴판 출력
		System.out.println("[시작]");
		System.out.println("========== 메뉴판 ==========");
		System.out.println("1. ☕ 아메리카노\t - 2,800원");
		System.out.println("2. 🍵 바닐라 라떼\t - 3,500원");
		System.out.println("3. 🥤 딸기 쉐이크\t - 4,000원");
		System.out.println("==========================");
		
		// step 2 : 메뉴 주문 기능
		while(menuFlag) {
			System.out.print("\n주문할 메뉴 번호 입력> ");
			if(scan.hasNextInt()) {
				menuFlag = false;
				menuNum = scan.nextInt();
				
				switch(menuNum) {
					case 1: menuName = "☕ 아메리카노"; 	menuPrice = 2800; 	break;
					case 2:	menuName = "🍵 바닐라 라떼";	menuPrice = 3500; 	break;
					case 3: menuName = "🥤 딸기 쉐이크";	menuPrice = 4000;	break;
					default: 
						System.out.println("준비중 입니다.");
						menuFlag = true;
				}//switch
				
				// 출력용 메뉴가격 저장
				menuPriceOutput = String.format("%,d", new Object[] {Integer.valueOf(menuPrice)});
			} else {
				System.out.println("올바르지 않은 값입니다.");
				scan.next();
			}
		}
		System.out.println("=> 주문 메뉴 : "+menuName+", 결제 예정 금액 : "+menuPriceOutput+"원");

		// step 3 : 결제 기능
		while(chargeFlag) {
			System.out.print("\n결제할 금액 입력> ");
			if(scan.hasNextInt()) {
				chargeFlag = false;
				charge += scan.nextInt();
				System.out.println("총 입금 금액 : "+charge);
				
				if(charge<menuPrice) {	//요금이 메뉴금액보다 모자랄 경우
					System.out.println("=> 금액이 부족합니다. 다시 입력해주세요.");
					chargeFlag = true;
				} else {				//요금이 충분할 경우
					change = charge - menuPrice;
					System.out.println("=> 결제 완료! 잔돈: "+change+"원");
				}
				
			} else {
				System.out.println("올바르지 않은 값입니다.");
				scan.next();
			}
		}
		
		// step 4 : 종료
		System.out.println("\n[종료]");
		System.out.println("이용해주셔서 감사합니다.");
	}

}
