package com.scoremgm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.app.ScoreMgmSystem;
import com.scoremgm.model.MemberVo;
import com.scoremgm.repository.ScoreRepositoryImpl;

import db.GenericRepositoryInterface;

public class ScoreServiceImpl implements ScoreService {
	Scanner scan;
	ScoreMgmSystem sms;
	GenericRepositoryInterface<MemberVo> repository = new ScoreRepositoryImpl();
	
	public ScoreServiceImpl() {}
	public ScoreServiceImpl(ScoreMgmSystem sms) {
		this.sms = sms;
		this.scan = sms.scan;
	}
	
	/**
	 * 학생 정보 임시 저장 객체 생성
	 * @return List
	 */
	public List createMemberInfo() {
		String[] labels = {"학생명", "전공", "국어", "영어", "수학"};
		List memberInfo = new ArrayList();
		
		for(int i=0 ; i<labels.length ; i++) {
			if(i>=2) {
				System.out.print(labels[i] + "> ");
				memberInfo.add(scan.nextInt());
			} else {
				//i = 0, 1
				System.out.print(labels[i] + "> ");
				memberInfo.add(scan.next());
			}
		}
		return memberInfo;
	}
	
	/**
	 * 학생 정보 임시 저장 객체 생성
	 * @param no 학번
	 * @return List
	 */
	public List createMemberInfo(MemberVo member) {
		String[] labels = {"국어", "영어", "수학"};
		List memberInfo = new ArrayList();
		
//		System.out.println("학번 : " + member.getNo() + ", 학생명 : " + member.getName());
		
		for(int i=0 ; i<labels.length ; i++) {
			System.out.print(labels[i] + "> ");
			memberInfo.add(scan.nextInt());
		}
		return memberInfo;
	}
	
	/**
	 * 학생정보 저장소(storage)의 갯수 가져오기
	 */
	@Override
	public int getCount() {
		return repository.getCount();
	}
	
	/**
	 * 등록
	 */
	@Override
	public void register() {
		List memberInfo = createMemberInfo();

		MemberVo member = new MemberVo();
//		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(0));
		member.setDepartment((String)memberInfo.get(1));
		member.setKor((int)memberInfo.get(2));
		member.setEng((int)memberInfo.get(3));
		member.setMath((int)memberInfo.get(4));
		
		if(repository.insert(member) == 1) {
			System.out.println("=> 등록 완료!!");
		} else {
			System.out.println("=> 등록 실패!!");
		}
		//메뉴호출!!
		sms.showMenu();
		sms.selectMenu();
	}
	
	/**
	 * 조회
	 */
	@Override
	public void list() {
		if(getCount() != 0) {
			List<MemberVo> list = repository.findAll();
			System.out.println("조회 결과!!");
			System.out.println("---------------------------------------------------");
			System.out.print("번호\t학번\t이름\t전공\t국어\t영어\t수학\n");
			list.forEach((member) -> {
				System.out.print(member.getRno() + "\t");
				System.out.print(member.getMid() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
			});
			System.out.println("---------------------------------------------------");
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	}

	/**
	 * 검색 : 학번 기준
	 */
	@Override
	public void search() {
		if(getCount() != 0) {
			System.out.print("학번> ");
			String mid = scan.next();
			MemberVo member = repository.find(mid);
			
			System.out.println("검색 결과!!");
			System.out.println("---------------------------------------------------");
			System.out.print("번호\t학번\t이름\t전공\t국어\t영어\t수학\n");
			if(member.getMid() != null) {
				System.out.print(member.getMid() + "\t");
				System.out.print(member.getName() + "\t");
				System.out.print(member.getDepartment() + "\t");
				System.out.print(member.getKor() + "\t");
				System.out.print(member.getEng() + "\t");
				System.out.print(member.getMath() + "\n");
			} else {
				System.out.println("=> 학생 정보 없음!!");
			}
			System.out.println("---------------------------------------------------");
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	}
	
	/**
	 * 수정
	 */
	@Override
	public void update() {
		if(getCount() != 0) {
			System.out.print("학번> ");
			String no = scan.next();
			MemberVo member = repository.find(no);	//학생 정보 - old
			
			if(member != null) {
				//수정할 학생 정보 입력!! 학번 제외!! 
				List memberInfo = createMemberInfo(member);
				member.setKor((int)memberInfo.get(0));
				member.setEng((int)memberInfo.get(1));
				member.setMath((int)memberInfo.get(2));
				
				//storage에 member 업데이트
				repository.update(member);
				
				System.out.println("수정 결과!!");
				System.out.println("---------------------------------------------------");
				System.out.print("학번\t이름\t전공\t국어\t영어\t수학\n");
				if(member.getMid() != null) {
					System.out.print(member.getMid() + "\t");
					System.out.print(member.getName() + "\t");
					System.out.print(member.getDepartment() + "\t");
					System.out.print(member.getKor() + "\t");
					System.out.print(member.getEng() + "\t");
					System.out.print(member.getMath() + "\n");
				} else {
					System.out.println("=> 학생 정보 없음!!");
				}
				System.out.println("---------------------------------------------------");
			}
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	}
	
	/**
	 * 삭제
	 */
	public void delete() {
		if(getCount() != 0) {
			System.out.print("학번> ");
			String mid = scan.next();
			MemberVo member = repository.find(mid);
			
			if(member != null) {
				System.out.print("정말로 삭제하시겠습니까? (y:삭제, 아무키:취소)> ");
				if(scan.next().equals("y")) {
					repository.remove(mid);
					System.out.println("=> 삭제 완료!!");
				}
			}
		} else {
			System.out.println("=> 등록된 학생이 없습니다.");
		}
		sms.showMenu();
		sms.selectMenu();
	}
	
	@Override
	public void exit() {
		System.out.println("=> 프로그램 종료!!");
		System.exit(0);
	}
}
