package kr.co.kosmo.mvc.vo;

import org.springframework.web.multipart.MultipartFile;

/*
 * 
 * lid number constraint item_semi_lid_fk references local_semi(lno) on delete cascade,
otitle varchar(20),
oprice number

 */
public class ItemVO {
	private int lid, iprice, istock;
	private String itype, iname, iimg;
	private MultipartFile ifile, ifile2, ifile3, ifile4, ifile5, ifile6, ifile7, ifile8, ifile9, ifile10;
	private String sdate, edate;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getIprice() {
		return iprice;
	}
	public void setIprice(int iprice) {
		this.iprice = iprice;
	}
	public int getIstock() {
		return istock;
	}
	public void setIstock(int istock) {
		this.istock = istock;
	}
	public String getItype() {
		return itype;
	}
	public void setItype(String itype) {
		this.itype = itype;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIimg() {
		return iimg;
	}
	public void setIimg(String iimg) {
		this.iimg = iimg;
	}
	public MultipartFile getIfile() {
		return ifile;
	}
	public void setIfile(MultipartFile ifile) {
		this.ifile = ifile;
	}
	public MultipartFile getIfile2() {
		return ifile2;
	}
	public void setIfile2(MultipartFile ifile2) {
		this.ifile2 = ifile2;
	}
	public MultipartFile getIfile3() {
		return ifile3;
	}
	public void setIfile3(MultipartFile ifile3) {
		this.ifile3 = ifile3;
	}
	public MultipartFile getIfile4() {
		return ifile4;
	}
	public void setIfile4(MultipartFile ifile4) {
		this.ifile4 = ifile4;
	}
	public MultipartFile getIfile5() {
		return ifile5;
	}
	public void setIfile5(MultipartFile ifile5) {
		this.ifile5 = ifile5;
	}
	public MultipartFile getIfile6() {
		return ifile6;
	}
	public void setIfile6(MultipartFile ifile6) {
		this.ifile6 = ifile6;
	}
	public MultipartFile getIfile7() {
		return ifile7;
	}
	public void setIfile7(MultipartFile ifile7) {
		this.ifile7 = ifile7;
	}
	public MultipartFile getIfile8() {
		return ifile8;
	}
	public void setIfile8(MultipartFile ifile8) {
		this.ifile8 = ifile8;
	}
	public MultipartFile getIfile9() {
		return ifile9;
	}
	public void setIfile9(MultipartFile ifile9) {
		this.ifile9 = ifile9;
	}
	public MultipartFile getIfile10() {
		return ifile10;
	}
	public void setIfile10(MultipartFile ifile10) {
		this.ifile10 = ifile10;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}

	
	
	

	
}
