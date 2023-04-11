package kr.co.kosmo.mvc.vo;

public class NoticeVO {
	private int nnum, macode;
	private String nsub, nwriter, ncontent, ndate;

	public int getNnum() {
		return nnum;
	}

	public void setNnum(int nnum) {
		this.nnum = nnum;
	}

	public int getMacode() {
		return macode;
	}

	public void setMacode(int macode) {
		this.macode = macode;
	}

	public String getNsub() {
		return nsub;
	}

	public void setNsub(String nsub) {
		this.nsub = nsub;
	}

	public String getNwriter() {
		return nwriter;
	}

	public void setNwriter(String nwriter) {
		this.nwriter = nwriter;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNdate() {
		return ndate;
	}

	public void setNdate(String ndate) {
		this.ndate = ndate;
	}

}