package vending_machine_ver2;

import commons.Menu;

public class VendingMachine {
	//Field (메뉴 배열, 가격 배열, 메뉴 배열...)
	String[] nameList = {"아메리카노", "라떼", "에이드", "스무디", "프라페"};
	int[] priceList = {1500, 2000, 3000, 3500, 4000};
	Menu[] menuList;	//commons/Menu import
	
	String title;	//자판기 이름
	User user;		//자판기 사용자
	int totalCoin;	//총 투입 금액
	int change;		//잔돈
	
	//Constructor
	public VendingMachine(User user) {
		this("매머드", user);
	}
	public VendingMachine(String title, User user) {
		this.title = title;
		this.user = user;
		
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	
	//Method
	
	//메뉴 생성
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for(int i=0 ; i<nameList.length ; i++) {
			int no = i + 1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
		}
	}
	
	//메뉴 출력
	public void showMenuList() {
		System.out.println("       "+ title + " 카페 메뉴판");
		System.out.println("===========================");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + ".\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
		}
		System.out.println("===========================");
	}
	
	//코인 체크
	public void checkInsertCoin() {
		System.out.println("=> 동전을 투입하세요.");
		int coin = user.insertCoin();
		if(coin == 100 || coin == 500) {
			totalCoin += coin;
			System.out.println("총 투입금액 : " + totalCoin);
			
			if(totalCoin < 1500) {
				System.out.println("=> 최소 금액 부족!!");
				checkInsertCoin();
			} else {
				System.out.print("=> 메뉴 선택(m), 동전 계속 투입(아무키나)> ");
				if(user.scan.next().equals("m")) {
					//메뉴 선택화면
				} else {
					checkInsertCoin();
				}
			}
		} else {
			System.out.println("=> 동전은 100원, 500원짜리만 사용 가능합니다.");
			checkInsertCoin();
		}
	}
	
	//메뉴 선택
	
	//주문
	
	//결제
	
	//파이널 체크
}
