package vo;

public class MemberVO {
	private String memberId; //식별자 --> Primary Key
	private String memberName; 
	private int memberAge;
	public String getMemberAddr1() {
		return memberAddr1;
	}
	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}
	public String getMemberAddr2() {
		return memberAddr2;
	}
	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	private String memberAddr1;
	private String memberAddr2;
	private String zipCode;
	private String memberEmail;
	private String memberGender;
	private int memberGeneration;
	private String memberPasswd;
	private String Age;
	
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public int getMemberGeneration() {
		return memberGeneration;
	}
	public void setMemberGeneration(int memberGeneration) {
		this.memberGeneration = memberGeneration;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	
	public String getMemberPasswd() {
		return memberPasswd;
	}
	public void setMemberPasswd(String memberPasswd) {
		this.memberPasswd = memberPasswd;
	}
	@Override
	public String toString() {
		return "회원 아이디 : " + memberId + ", 회원 이름 : " + memberName + ", 회원 이메일 : " + memberEmail + ", 회원 주소 : " + memberAddr1
				+ ", 회원 나이대 : " + memberGeneration;
	}
}