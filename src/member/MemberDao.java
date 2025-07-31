package member;

import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class MemberDao extends DBConn implements GenericInterface<MemberVo> {	//DBCon 상속, MemberInterface 오버라이딩
	
	public MemberDao() {	//기본 생성자 호출
		super();
	}
	
	//CRUD 기능 구현 - 애플리케이션 기반의 DB연동은 기본적으로 Autocommit = true임, 바로 적용됨!!
	/**
	 * 데이터 검색 (이름)
	 */
	public List<MemberVo> search(String name) {	//?(물음표) 한 개면 매개변수도 한 개 이상이어야 함
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = """
					select	member_id,
							name,
					        email,
					        created_at
					from member 
					where name = ?
				""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, name);	//?(물음표) 작성 순서대로 넘버링됨
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setMemberId(rs.getInt(1));
				memberVo.setName(rs.getString(2));
				memberVo.setEmail(rs.getString(3));
				memberVo.setCreatedAt(rs.getString(4));
				
				list.add(memberVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 데이터 검색 (아이디)
	 */
	@Override
	public MemberVo search(int memberId) {	//고유(Primary)
		MemberVo member = new MemberVo();
		String sql = "select member_id, name, email, created_at "
				+ " from member where member_id = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setMemberId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setCreatedAt(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	/**
	 * 데이터 삭제
	 */
	@Override
	public int delete(int memberId) {	//삭제할 땐 Pirmary Key가 필요
		int rows = 0;
		String sql = "delete from member where member_id = ?";
		
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, memberId);
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	/**
	 * 데이터 수정(업데이트)
	 */
	@Override
	public int update(MemberVo member) {
		int rows = 0;
		String sql = """
					update member
						set name = ?, email = ?
					where member_id = ?
				""";
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2,  member.getEmail());
			pstmt.setInt(3, member.getMemberId());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	/**
	 * 전체 리스트
	 */
	@Override
	public List<MemberVo> listAll() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "select member_id, name, email, left(created_at, 10) from member";
		
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo member = new MemberVo();
				member.setMemberId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setCreatedAt(rs.getString(4));
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 데이터 추가
	 */
	@Override
	public int insert(MemberVo member) {
		int rows = 0;
		String sql = """
					insert into member(name, email, created_at)
						values(?, ?, now())
				""";
		//Auto-increment 제외
		
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
}
