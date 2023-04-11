package kr.co.kosmo.mvc.vo;

import org.springframework.web.multipart.MultipartFile;

/*
ONO	NUMBER
OAREA	VARCHAR2(50 BYTE)
OTTITLE	VARCHAR2(50 BYTE)
OCONTENT	VARCHAR2(500 BYTE)
OIMG	VARCHAR2(50 BYTE)
OCODE	NUMBER
OPRICE	NUMBER
TSORT	NUMBER
 */
public class OverseaVO {
	private int ono,ocode,oprice,tsort;
	private String oarea,ottitle,ocontent,oimg;
	private MultipartFile mfile;
	
	public MultipartFile getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}
	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public int getOcode() {
		return ocode;
	}
	public void setOcode(int ocode) {
		this.ocode = ocode;
	}
	public int getOprice() {
		return oprice;
	}
	public void setOprice(int oprice) {
		this.oprice = oprice;
	}
	public int getTsort() {
		return tsort;
	}
	public void setTsort(int tsort) {
		this.tsort = tsort;
	}
	public String getOarea() {
		return oarea;
	}
	public void setOarea(String oarea) {
		this.oarea = oarea;
	}
	public String getOttitle() {
		return ottitle;
	}
	public void setOttitle(String ottitle) {
		this.ottitle = ottitle;
	}
	public String getOcontent() {
		return ocontent;
	}
	public void setOcontent(String ocontent) {
		this.ocontent = ocontent;
	}
	public String getOimg() {
		return oimg;
	}
	public void setOimg(String oimg) {
		this.oimg = oimg;
	}
	
}
