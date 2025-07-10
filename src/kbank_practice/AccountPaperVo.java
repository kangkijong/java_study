package kbank_practice;

import java.util.Scanner;

import drink.Payment;
/*
 * 고객이 작성하는 출금 정보 데이터 저장 객체
 * 
 * 고객은 자신의 출금 정보를 출금용지에 작성한다.
 * 고객은 작성한 출금용지를 은행 직원에게 전달한다.
 */
public class AccountPaperVo {
	//Field
	String name;			//이름
	String account;			//계좌번호
	int money;				//금액
	private int password; 	//비밀번호

	Scanner scan = new Scanner(System.in);
	
	//Constructor
	public AccountPaperVo() {}
	public AccountPaperVo(String name, String account, int money, int password) {
		this.name = name;
		this.account = account;
		this.money = money;
		this.password = password;
		
		init();
	}
	
	//Method
	public int getpassword() { return password; }
	public void setpassword(int password) { this.password = password; }
	
	public void init() {
		accountPaperWrite();
	}
	
	public void accountPaperWrite() {
		System.out.println("===== 출금용지 작성 =====");
		System.out.print("이름> ");
		name = scan.next();
		System.out.print("계좌번호> ");
		account = scan.next();
		System.out.println("인출할 금액> ");
		money = scan.nextInt();
		System.out.println("비밀번호> ");
		password = scan.nextInt();
	}
	
	
}
