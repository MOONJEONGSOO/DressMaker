package com.test.app.board;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int bnum;			// 글 번호
	private String mid;			// 회원 아이디(작성자)
	private String btitle;		// 글 제목
	private String bcontent;	// 글 내용
	private String bimg;		// 후기 사진
	private int pnum;			// 상품 번호
	private String pname;		// 상품 이름
	private String noData;		// 데이터가 없음
	private MultipartFile uploadFile;
	
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getNoData() {
		return noData;
	}
	public void setNoData(String noData) {
		this.noData = noData;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBimg() {
		return bimg;
	}
	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	@Override
	public String toString() {
		return "BoardVO [bnum=" + bnum + ", mid=" + mid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bimg="
				+ bimg + ", pnum=" + pnum + "]";
	}
	

}
