package member;
/**
 * Vo는 전체 필드를 대상으로 작성할 것
 * ex) name, email만 전송할 것이지만, member_id, create_at도 같이 작성해주어야 함
 * 	member_id	int	NO					PRI
	name		varchar(50)		NO	
	email		varchar(100)	NO		UNI
	created_at	datetime		YES	
 */
public class MemberVo {
	int rno;		//번호 매기고 싶을 때
	int memberId;	//테이블에서 가져올 필드들 작성
	String name;
	String email;
	String createdAt;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createAt) {
		this.createdAt = createAt;
	}
	
}
