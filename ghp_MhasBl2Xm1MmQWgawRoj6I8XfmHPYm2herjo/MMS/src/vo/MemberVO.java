package vo;

public class MemberVO {
	private String memberId; //�ĺ��� --> Primary Key
	private String memberName; 
	private int memberAge;
	private String memberAddr;
	private String memberEmail;
	private String memberGender;
	private int memberGeneration;
	
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
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
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
	@Override
	public String toString() {
		return "ȸ�� ���̵� : " + memberId + ", ȸ�� �̸� : " + memberName + ", ȸ�� �̸��� : " + memberEmail + ", ȸ�� �ּ� : " + memberAddr
				+ ", ȸ�� ���̴� : " + memberGeneration;
	}
}