package com.test.app.product;

public class ProductVO {
	private int pnum;			// 상품 번호
	private String pname;		// 상품 이름
	private String pimg;		// 상품 이미지
	private int pprice;			// 상품 가격
	private int pmax;			// 상품 가격
	private String pstring;		// 상품 가격 문자열
	private String pinfo;		// 상품 정보
	private String prental;		// 대여 여부
	private String psearch;		// 검색 키워드
	private String pfail;		// 검색 실패	
	private int page;
	private int listcnt;
	
	
	
	public int getListcnt() {
		return listcnt;
	}
	public void setListcnt(int listcnt) {
		this.listcnt = listcnt;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPmax() {
		return pmax;
	}
	public void setPmax(int pmax) {
		this.pmax = pmax;
	}
	public String getPstring() {
		return pstring;
	}
	public void setPstring(String pstring) {
		this.pstring = pstring;
	}
	public String getPfail() {
		return pfail;
	}
	public void setPfail(String pfail) {
		this.pfail = pfail;
	}
	public String getPsearch() {
		return psearch;
	}
	public void setPsearch(String psearch) {
		this.psearch = psearch;
	}
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getPinfo() {
		return pinfo;
	}
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}
	public String getPrental() {
		return prental;
	}
	public void setPrental(String prental) {
		this.prental = prental;
	}
	@Override
	public String toString() {
		return "ProductVO [pnum=" + pnum + ", pname=" + pname + ", pimg=" + pimg + ", pprice=" + pprice + ", pinfo="
				+ pinfo + ", prental=" + prental + "]";
	}
	

}
