package com.test.app.buyInfo;

public class BuyInfoVO {
	
	private int inum;		// 정보 번호
	private String mid;		// 회원 아이디
	private int pnum;		// 상품 번호
	private String pname;	// 상품 이름
	
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getInum() {
		return inum;
	}
	public void setInum(int inum) {
		this.inum = inum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	
	@Override
	public String toString() {
		return "BuyInfoVO [inum=" + inum + ", mid=" + mid + ", pnum=" + pnum + "]";
	}

}
