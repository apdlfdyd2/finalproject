package kr.co.kosmo.mvc.vo;
/*
NUM	NUMBER
BID	NUMBER
MID	VARCHAR2(50 BYTE)
STATUS	VARCHAR2(10 BYTE)
PAY	NUMBER
BPOINT	NUMBER
BTIME	DATE
 */
public class BookLoggerDTO {
	private int num,bid,pay,spoint,upoint;
	private String mid,status,btime;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getSpoint() {
		return spoint;
	}
	public void setSpoint(int spoint) {
		this.spoint = spoint;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	
}
