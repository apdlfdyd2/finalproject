package kr.co.kosmo.mvc.vo;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

/*
 * CHNO	NUMBER
CHNAME	VARCHAR2(50 BYTE)
CHRESNO	NUMBER
 */
public class ChargeMVO {
	//total_sum합친값,maxpay_최대지출값,ctypecnt_결제방식 count
	private int chpay,total,maxpay;
	
	private int chno;
	private int ctypecnt,usepoint;
	private String chtype,chdate;

	public int getUsepoint() {
		return usepoint;
	}
	public void setUsepoint(int usepoint) {
		this.usepoint = usepoint;
	}
	public int getCtypecnt() {
		return ctypecnt;
	}
	public void setCtypecnt(int ctypecnt) {
		this.ctypecnt = ctypecnt;
	}
	public int getMaxpay() {
		return maxpay;
	}
	public void setMaxpay(int maxpay) {
		this.maxpay = maxpay;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getChno() {
		return chno;
	}
	public void setChno(int chno) {
		this.chno = chno;
	}
	public int getChpay() {
		return chpay;
	}
	public void setChpay(int chpay) {
		this.chpay = chpay;
	}
	public String getChtype() {
		return chtype;
	}
	public void setChtype(String chtype) {
		this.chtype = chtype;
	}
	public String getChdate() {
		return chdate;
	}
	public void setChdate(String chdate) {
		this.chdate = chdate;
	}

}
