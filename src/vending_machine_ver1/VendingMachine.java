package vending_machine_ver1;

import commons.Menu;

public class VendingMachine {
	String[] nameList = {"☕ 밀크커피","☕ 아메리카노","🍋 유자차  ","🥛 초코우유  "};
	int[] priceList = {300, 400, 300, 200};
	Menu[] menuList;
	Menu[] orderMenuList; 	//user가 주문가능한 메뉴 
	int orderMenuCount = 0;

	String title;	//자판기 회사명
	User user;		//자판기 사용자
	int totalCoin;	//총 투입 금액
	Menu orderMenu;	//주문한 메뉴
	int change;		//잔돈
	
	public static final int EXIT = 9;	//클래스명.상수명 (예 : VendingMachine.EXIT)
	
	
	public VendingMachine(User user) {
		this("막심", user);
	}
	public VendingMachine(String title, User user) {
		this.title = title;
		this.user = user;
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	
	/*
	 * 메뉴 체크
	 */
	public boolean menuCheck(int menuNo) {
		boolean result = false;		
		for(int i=0; i<orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
			if(menu.getNo() == menuNo) result = true;
		}		
		return result;
	}
	
	/*
	 * 메뉴 선택
	 */
	public void selectMenu() {  //정확한 메뉴 선택!!!
		System.out.println("=> 메뉴를 선택해 주세요.");
		System.out.println("=> 취소는 ["+ VendingMachine.EXIT +"]번을 입력해주세요.");
		int menuNo = user.selectMenu();
		if(menuNo != VendingMachine.EXIT) {
			if(menuCheck(menuNo)) {
				placeOrder(menuNo);
			} else {
				selectMenu();
			}
		} else {
			System.out.println("=> 동전을 반환하고, 프로그램을 종료합니다.");
			System.out.println("=> 반환 동전 : " + totalCoin);
			System.exit(0);
		}
	}
	
	/*
	 * 주문
	 */
	public void placeOrder(int menuNo) {
		//주문가능한 메뉴리스트에서 선택한 menuNo를 비교하여 메뉴주소를 orderMenu에 대입
		for(Menu menu : orderMenuList) {
			if(menu != null) {
				if(menu.getNo() == menuNo) orderMenu = menu;
			} else break;
		}
		System.out.println("=> 주문완료!!");
		processPayment();
	}
	
	/*
	 * 결제
	 */
	public void processPayment() {
		if(orderMenu != null) {
			int price = orderMenu.getPrice();
			if(price <= totalCoin) {
				change = totalCoin - price;
				System.out.println("=> 결제 완료!!");
				init();	//사용한 객체 초기화 => orderMenuList, orderMenu, totalCoin
			}
		}
		finalCheck();		
	}
	
	/*
	 * 종료 후 객체 초기화
	 */
	public void init() {
		orderMenuList = null;
		orderMenu = null;
		totalCoin = 0;
		orderMenuCount = 0;
	}
	
	/*
	 * 종료
	 */
	public void finalCheck() {
		//잔돈이 최소 주문금액보다 크면 계속 주문
		int price = menuList[menuList.length-1].getPrice();
		if(change >= price) {	//메뉴리스트의 마지막 주소가 가리키는 객체의 가격
			totalCoin = change;
			System.out.println("=> 잔돈 : " + change);
			createOrderMenuList(totalCoin);		
			showMenuList("주문 가능 메뉴 리스트");
			selectMenu();					
		} else {
			System.out.println("=> 결제 내역!!");
			System.out.println("=> 잔돈 : " + change);
			System.out.println("=> 이용해 주셔서 감사합니다!!");
		}
	}
		
	
	/*
	 * 입력되는 동전 체크 
	 */
	public void checkInsertCoin() {
		System.out.println("=> 동전을 투입해 주세요.");
		int coin = user.insertCoin();		
		if(coin == 100 || coin == 500) { //사용가능 동전 체크
			totalCoin += coin;
			System.out.println("총 투입금액 : " + totalCoin);
			
			if(totalCoin < 200) {	//메뉴 선택 최소 금액 체크
				System.out.println("=> 최소 금액 부족!!");
				checkInsertCoin();
			} else {
				//메뉴 선택 여부 체크
				System.out.print("=> 메뉴선택(n), 동전투입계속(아무키)> ");
				if(user.scan.next().equals("n")) {
					createOrderMenuList(totalCoin);		
					showMenuList("주문 가능 메뉴 리스트");
					selectMenu();					
				}
				else	checkInsertCoin();
			}
		} else {
			System.out.println("=> 동전은 100원, 500원만 사용 가능합니다. 동전 반환!!");
			checkInsertCoin();
		}		
	}
	
	/*
	 * 주문가능한 메뉴 리스트 생성
	 */
	public void createOrderMenuList(int totalCoin) {
		orderMenuList = new Menu[menuList.length];
		
		//orderMenuCount 변수를 이용하여 향상된 for문 사용
		for(Menu menu : menuList) {
			if(menu.getPrice() <= totalCoin) {
				orderMenuList[orderMenuCount] = menu;
				orderMenuCount++;
			}
		}		
		
		/*
		for(int i=0; i<menuList.length; i++) {
			Menu menu = menuList[i];				
			if(menu.getPrice() <= totalCoin) {
				orderMenuList[i] = menu;
			}
		}
		*/
	}
	
	
	/*
	 * 총 투입금액에 맞춘 메뉴 출력
	 */
	public void showMenuList(String msg) {		
		System.out.println("--------------------------------");
		System.out.println("  ☕🍵🥤 "+ title + " Coffee Machine");
		System.out.println("--------------------------------");	
		System.out.println("\t" + msg);
		System.out.println("--------------------------------");	
		for(int i=0; i<orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
			System.out.print(menu.getNo() +".\t");
			System.out.print(menu.getName() +"\t");
			System.out.print(String.format("%,d", menu.getPrice()) +"원\n");		
		}
		System.out.println("--------------------------------");	
	}
	
	/*
	 * 전체 메뉴 출력
	 */
	public void showMenuList() {		
		System.out.println("--------------------------------");
		System.out.println("  ☕🍵🥤 "+ title + " Coffee Machine");
		System.out.println("--------------------------------");		
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() +".\t");
			System.out.print(menu.getName() +"\t");
			System.out.print(String.format("%,d", menu.getPrice()) +"원\n");			
		}
		System.out.println("--------------------------------");	
	}
	
	/*
	 * 메뉴 리스트 생성
	 */
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for(int i=0; i<nameList.length; i++) {
			int no = i + 1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
		}		
	}

}//class - VendingMachine