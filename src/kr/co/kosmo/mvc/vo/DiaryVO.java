package kr.co.kosmo.mvc.vo;

import org.springframework.web.multipart.MultipartFile;

/*
 * HNO	NUMBER
HID	VARCHAR2(50 BYTE)
HPWD	VARCHAR2(100 BYTE)
HNAME	VARCHAR2(100 BYTE)
HPHONE	VARCHAR2(100 BYTE)
HADDR	VARCHAR2(100 BYTE)
HEMAIL	VARCHAR2(100 BYTE)
HCALL	VARCHAR2(100 BYTE)
HACCOUNT	VARCHAR2(100 BYTE)
HNUM	NUMBER
HDATE	DATE
 */
public class DiaryVO {
	private int dno;
	private String dtitle, dwriter, dcontent, dimg, dtag, ddate;
	private MultipartFile mfile;
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getDtitle() {
		return dtitle;
	}
	public void setDtitle(String dtitle) {
		this.dtitle = dtitle;
	}
	public String getDwriter() {
		return dwriter;
	}
	public void setDwriter(String dwriter) {
		this.dwriter = dwriter;
	}
	public String getDcontent() {
		return dcontent;
	}
	public void setDcontent(String dcontent) {
		this.dcontent = dcontent;
	}
	public String getDimg() {
		return dimg;
	}
	public void setDimg(String dimg) {
		this.dimg = dimg;
	}
	public String getDtag() {
		return dtag;
	}
	public void setDtag(String dtag) {
		this.dtag = dtag;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public MultipartFile getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}

}
