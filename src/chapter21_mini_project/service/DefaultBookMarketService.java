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
	    if (cartList.isEmpty()) {
	        System.out.println("🛒 장바구니가 비어 있습니다.");
	        bma.showMenu();
	        return;
	    }

	    // 현재 장바구니 목록 출력
	    System.out.println("📚 현재 장바구니 항목:");
	    for (BookMarketCart item : cartList) {
	        System.out.println("도서 ID: " + item.getBid() + " | 수량: " + item.getQuantity() + " | 총액: " + item.getTotal());
	    }

	    // 도서 ID 입력
	    System.out.print("수량을 줄일 도서의 ID를 입력하세요 : ");
	    String bid = bma.scan.next();

	    // 장바구니에서 해당 항목 찾기
	    BookMarketCart target = null;
	    for (BookMarketCart item : cartList) {
	        if (item.getBid().equals(bid)) {
	            target = item;
	            break;
	        }
	    }

	    if (target == null) {
	        System.out.println("❌ 해당 도서 ID는 장바구니에 없습니다.");
	        bma.showMenu();
	        return;
	    }

	    // 수량 입력
	    System.out.print("줄일 수량을 입력하세요 : ");
	    if (!bma.scan.hasNextInt()) {
	        System.out.println("❌ 잘못된 수량입니다.");
	        bma.scan.next(); // 버퍼 비우기
	        bma.showMenu();
	        return;
	    }

	    int reduceQty = bma.scan.nextInt();

	    if (reduceQty <= 0) {
	        System.out.println("❌ 수량은 1 이상이어야 합니다.");
	        bma.showMenu();
	        return;
	    }

	    if (reduceQty >= target.getQuantity()) {
	        cartList.remove(target);
	        System.out.println("✅ 수량이 0 이하가 되어 장바구니에서 해당 항목이 삭제되었습니다.");
	    } else {
	        target.setQuantity(target.getQuantity() - reduceQty);

	        // 도서 가격 다시 계산
	        BookMarketBooks book = repository.find(bid);
	        if (book != null) {
	            target.setTotal(target.getQuantity() * book.getPrice());
	        }

	        System.out.println("✅ 수량이 줄어들었습니다. 현재 수량: " + target.getQuantity());
	    }

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
	    String deliveryName = bmm.getName();
	    String deliveryPhone = bmm.getPhone();
	    String deliveryCity = bmm.getCity();

	    System.out.print("배송받을 분은 고객정보와 같습니까? (Y/N): ");
	    String sameInfo = bma.scan.next();

	    if (sameInfo.equalsIgnoreCase("N")) {
	        System.out.print("배송받을 고객명을 입력하세요: ");
	        deliveryName = bma.scan.next();

	        System.out.print("배송받을 고객의 연락처를 입력하세요: ");
	        deliveryPhone = bma.scan.next();

	        System.out.print("배송받을 고객의 주소를 입력해주세요: ");
	        deliveryCity = bma.scan.next();
	    }

	    // 현재 날짜 구하기
	    String today = java.time.LocalDate.now().toString();

	    System.out.println("\n----------------- 배송받을 고객 정보 --------------------- ");
	    System.out.println("고객명 : " + deliveryName + "\t연락처 : " + deliveryPhone);
	    System.out.println("배송지 : " + deliveryCity + "\t발송일 : " + today);
	    System.out.println("-----------------------------------------------------");

	    if (cartList.isEmpty()) {
	        System.out.println("🛒 장바구니에 상품이 없습니다.");
	    } else {
	        System.out.println("도서ID\t\t수량\t합계");
	        int totalSum = 0;
	        for (BookMarketCart item : cartList) {
	            System.out.println(item.getBid() + "\t" + item.getQuantity() + "\t" + item.getTotal() + "원");
	            totalSum += item.getTotal();
	        }
	        System.out.println("-----------------------------------------------------");
	        System.out.println("\t\t\t\t주문 총액 : " + totalSum + "원\n");
	    }

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
