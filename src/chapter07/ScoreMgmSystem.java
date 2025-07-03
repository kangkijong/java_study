package chapter07;

import java.util.Scanner;
/*
 * - 학생 3명의 점수를 입력 받는다.
 * - 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다. 
 */
public class ScoreMgmSystem {
	// Field
	Scanner scan = new Scanner(System.in);
	String admin;
	Student student;
	Student[] slist = new Student[3];	// 배열로 학생 10명의 정보를 받는다면
	int count = 0;
	
	// Constructor
	public ScoreMgmSystem() {}
	
	// Method
	public void insert() {
		System.out.println("-- insert --");
//		student = new Student();

		for(int i=count ; i<slist.length ; i++) {
			slist[i] = new Student();
			
			System.out.print("학생명> ");
			slist[i].name = scan.next();
			
			System.out.print("국어> ");
			slist[i].kor = scan.nextInt();
			
			System.out.print("영어> ");
			slist[i].eng = scan.nextInt();
			
			System.out.print("수학> ");
			slist[i].math = scan.nextInt();
			
			count++;
			
			System.out.print("계속 입력 하시겠습니까?(계속:아무키나 누르세요, 종료:n)> ");
			if(scan.next().equals("n")) {
				System.out.println("=> 등록 완료!!");
				break;	// break;
			}
		}
		
//		System.out.print("학생명> ");
//		student.name = scan.next();
//		
//		System.out.print("국어> ");
//		student.kor = scan.nextInt();
//		
//		System.out.print("영어> ");
//		student.eng = scan.nextInt();
//		
//		System.out.print("수학> ");
//		student.math = scan.nextInt();
//		
//		System.out.println("=> 등록 완료!!");
	}
	
	public void show() {
		System.out.println("-----------------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------");
		for(int i=0 ; i<count ; i++) {
			System.out.print(slist[i].name+"\t");
			System.out.print(slist[i].kor+"\t");
			System.out.print(slist[i].eng+"\t");
			System.out.print(slist[i].math+"\t");
			System.out.print(slist[i].getTot()+"\t");
			System.out.println(slist[i].getAvg());
		}
		System.out.println("----------------------------------------------");
	}
	
	public void update() {
		System.out.println("수정");
	}
	
	public void remove() {
		System.out.println("삭제");
	}
	
	public void search() {
		System.out.println("검색");
	}
	
}
