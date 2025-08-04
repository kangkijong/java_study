package chapter21_mini_project.application;

import java.util.Scanner;

import chapter21_mini_project.repository.InMemoryBookMarket;
import chapter21_mini_project.service.BookMarketService;
import chapter21_mini_project.service.DefaultBookMarketService;

public class BookMarketApplication {
	public static final int GUESTINFO = 1;
	public static final int CARTITEMLIST = 2;
	public static final int MENUCARTCLEAR = 3;
	public static final int CARTADDITEM = 4;
	public static final int MENUCARTREMOVECOUNT = 5;
	public static final int MENUCARTREMOVEITEM = 6;
	public static final int MENUCARTBILL = 7;
	public static final int EXIT = 8;
	public Scanner scan;
	public BookMarketService service;
	
	public BookMarketApplication() {
	    scan = new Scanner(System.in);
	    service = new DefaultBookMarketService(this, new InMemoryBookMarket()); // ✔
	    showMenu();
	}
	
	/**
	 * 메뉴 출력
	 */
	public void showMenu() {
		System.out.println("***********************************************");
		System.out.println("\tWelcome to Shopping Mall");
		System.out.println("\tWelcome to Book Market");
		System.out.println("***********************************************");
		System.out.println("1. 고객 정보 확인하기\t\t4. 바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기\t5. 장바구니의 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기\t\t6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기\t\t8. 종료");
		System.out.println("***********************************************");
		selectMenu();
	}
	
	/**
	 * 메뉴 선택
	 */
	public void selectMenu() {
		System.out.print("메뉴 번호를 선택해주세요 : ");
		if(scan.hasNextInt()) {
			switch(scan.nextInt()) {
				case GUESTINFO				:	service.menuGuestInfo();			break;
				case CARTITEMLIST			:	service.menuCartItemList();			break;
				case MENUCARTCLEAR			: 	service.menuCartClear();			break;
				case CARTADDITEM			: 	service.menuCartAddItem();			break;
				case MENUCARTREMOVECOUNT	:	service.menuCartRemoveItemCount();	break;
				case MENUCARTREMOVEITEM		:	service.menuCartRemoveItem();		break;
				case MENUCARTBILL			:	service.menuCartBill();				break;
				case EXIT					:	service.menuExit();					break;
				default:
					System.out.println("=> 메뉴 준비중 입니다.\n");
					selectMenu();
			}
		} else {
			System.out.println("=> 올바르지 않은 형식입니다. 다시 선택해주세요.\n");
			scan.next();
			selectMenu();
		}
	}
	
	public static void main(String[] args) {
		new BookMarketApplication();
	}
		
}
