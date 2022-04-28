package com.test.app.member;

public class MemberVO {
	private String mid;		// 회원 아이디
	private String mpw;		// 회원 비밀번호
	private String mname;	// 회원 이름
	private String mmail;	// 회원 이메일
	private String mfail;	// 로그인 실패
	
	public String getMfail() {
		return mfail;
	}
	public void setMfail(String mfail) {
		this.mfail = mfail;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMmail() {
		return mmail;
	}
	public void setMmail(String mmail) {
		this.mmail = mmail;
	}
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mmail=" + mmail + "]";
	}
	
	
	

}
