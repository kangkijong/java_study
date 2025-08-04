package chapter21_mini_project.service;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.application.BookMarketApplication;
import chapter21_mini_project.model.BookMarketBooks;
import chapter21_mini_project.model.BookMarketCart;
import chapter21_mini_project.model.BookMarketMember;
import db.GenericRepositoryInterface;

public class DefaultBookMarketService implements BookMarketService {
	BookMarketApplication bma;
	BookMarketMember bmm = new BookMarketMember();
	GenericRepositoryInterface<BookMarketBooks> repository;
	List<BookMarketCart> cartList = new ArrayList<>();
	
	public DefaultBookMarketService(BookMarketApplication bma, GenericRepositoryInterface<BookMarketBooks> repository) {	// ✔
	    this.bma = bma;
	    this.repository = repository;
	    
	    insertCustomerInfo();
	}
	
	public BookMarketMember insertCustomerInfo() {
		System.out.print("당신의 이름을 입력하세요 : ");
		bmm.setName(bma.scan.next());
		
		System.out.print("연락처를 입력하세요 : ");
		bmm.setPhone(bma.scan.next());
		
		return bmm;
	}
	
	/**
	 * 고객 정보 확인하기
	 */
	@Override
	public void menuGuestInfo() {
		System.out.println("현재 고객 정보");
		System.out.println("✅ 이름 : " + bmm.getName() + "\t\t연락처 : " + bmm.getPhone());
		
		bma.showMenu();
	}
	
	/**
	 * 장바구니 상품 목록 보기
	 */
	@Override
	public void menuCartItemList() {	// ✔
		if (cartList.isEmpty()) {
	        System.out.println("🛒 장바구니가 비어 있습니다.");
	    } else {
	        System.out.println("🛒 장바구니 상품 목록:");
	        for (BookMarketCart item : cartList) {
	            System.out.println("도서ID : " + item.getBid() + 
	                " | 수량 : " + item.getQuantity() +
	                " | 합계 : " + item.getTotal() + "원");
	        }
	    }
	    bma.showMenu();
	}
	
	/**
	 * 장바구니 비우기
	 */
	@Override
	public void menuCartClear() {
	    if (cartList.isEmpty()) {
	        System.out.println("🛒 장바구니가 이미 비어 있습니다.");
	        bma.showMenu();
	        return;
	    }

	    System.out.print("장바구니의 모든 항목을 삭제하시겠습니까? (Y/N): ");
	    String input = bma.scan.next();

	    if (input.equalsIgnoreCase("Y")) {
	        cartList.clear(); // ✅ 실제로 비움
	        System.out.println("✅ 장바구니의 모든 항목을 삭제했습니다.");
	    } else {
	        System.out.println("❌ 삭제가 취소되었습니다.");
	    }

	    bma.showMenu();
	}
	
	/**
	 * 바구니에 항목 추가하기 (도서 목록 표시하기)
	 */
	@Override
	public void menuCartAddItem() {
		List<BookMarketBooks> library = repository.findAll();
		library.forEach(book -> {
			System.out.print(book.getBid() + " | ");
			System.out.print(book.getTitle() + " | ");
			System.out.print(book.getPrice() + " | ");
			System.out.print(book.getAuthor() + " | ");
			System.out.print(book.getIntro() + " | ");
			System.out.print(book.getCategory() + " | ");
			System.out.print(book.getBdate() + "\n");
		});
		System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");
		String bid = bma.scan.next();
		
		// 도서 ID로 책 찾기
	    BookMarketBooks book = repository.find(bid);		// ✔

	    if (book == null) {
	        System.out.println("❌ 해당 ID의 도서를 찾을 수 없습니다.");
	        bma.showMenu();
	        return;
	    }

	    // 장바구니에 이미 있는지 확인
	    BookMarketCart existingCart = null;
	    for (BookMarketCart item : cartList) {
	        if (item.getBid().equals(bid)) {
	            existingCart = item;
	            break;
	        }
	    }

	    if (existingCart != null) {
	        existingCart.setQuantity(existingCart.getQuantity() + 1);
	        existingCart.setTotal(existingCart.getQuantity() * book.getPrice());
	        System.out.println("✅ 수량이 1 증가되었습니다.");
	    } else {
	        BookMarketCart cart = new BookMarketCart();
	        cart.setBid(bid);
	        cart.setQuantity(1);
	        cart.setTotal(book.getPrice());
	        cartList.add(cart);
	        System.out.println("✅ 도서가 장바구니에 추가되었습니다.");
	    }

		bma.showMenu();
	}
	
	/**
	 * 장바구니의 항목 수량 줄이기
	 */
	@Override
	public void menuCartRemoveItemCount() {
		System.out.println("장바구니의 항목 수량 줄이기");
		
		bma.showMenu();
	}
	
	/**
	 * 장바구니의 항목 삭제하기
	 */
	@Override
	public void menuCartRemoveItem() {	// ✔
	    if (cartList.isEmpty()) {
	        System.out.println("🛒 장바구니가 비어 있습니다.");
	        bma.showMenu();
	        return;
	    }

	    // 현재 장바구니 목록 보여주기
	    System.out.println("📚 현재 장바구니 항목:");
	    for (BookMarketCart item : cartList) {
	        System.out.println("도서 ID: " + item.getBid() + " | 수량: " + item.getQuantity() + " | 총액: " + item.getTotal());
	    }

	    System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 : ");
	    String bid = bma.scan.next();

	    // 해당 도서가 장바구니에 있는지 확인
	    BookMarketCart toRemove = null;
	    for (BookMarketCart item : cartList) {
	        if (item.getBid().equals(bid)) {
	            toRemove = item;
	            break;
	        }
	    }

	    if (toRemove == null) {
	        System.out.println("🚫 해당 도서 ID는 장바구니에 없습니다.");
	        bma.showMenu();
	        return;
	    }

	    System.out.print("장바구니의 목록을 삭제하시겠습니까? (Y/N): ");
	    String confirm = bma.scan.next();

	    if (confirm.equalsIgnoreCase("Y")) {
	        cartList.remove(toRemove);
	        System.out.println("✅ 장바구니에서 도서가 삭제되었습니다.");
	    } else {
	        System.out.println("❌ 삭제가 취소되었습니다.");
	    }

	    bma.showMenu();
	}
	
	/**
	 * 영수증 표시하기
	 */
	@Override
	public void menuCartBill() {
		System.out.print("배송받을 분은 고객정보와 같습니까? (Y/N): ");
		
		System.out.print("배송지를 입력해주세요 : ");
		
		System.out.println("----------------- 배송받을 고객 정보 ----------------- ");
		System.out.println("고객명 : " + "\t연락처 : ");
		System.out.println("배송지 : " + "\t발송일 : ");
		System.out.println("장바구니 상품 목록 : ");
		
		bma.showMenu();
	}
	
	/**
	 * 종료
	 */
	@Override
	public void menuExit() {
		System.out.println("✅ 시스템이 종료됩니다.");
		System.exit(0);
	}
	
	
}
