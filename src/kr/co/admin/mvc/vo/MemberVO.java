package kr.co.admin.mvc.vo;

/*
 * MNUM	NUMBER
MID	VARCHAR2(30 BYTE)
MPWD	VARCHAR2(10 BYTE)
MNAME	VARCHAR2(50 BYTE)
MJUMIN	VARCHAR2(100 BYTE)
MPHONE	VARCHAR2(50 BYTE)
MADDR	VARCHAR2(200 BYTE)
MEMAIL	VARCHAR2(100 BYTE)
MCALL	VARCHAR2(50 BYTE)
# MPOINT	NUMBER => MembershipVO
# MACCOUNT	NUMBER => ChargeMVO
MNO	NUMBER
MDATE	DATE
 */
public class MemberVO {
	private int mnum, mpoint, maccount, mno;
	private String mid, mpwd, mname, mjumin, mphone, maddr, memail, mcall, mdate;
	
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	public int getMaccount() {
		return maccount;
	}
	public void setMaccount(int maccount) {
		this.maccount = maccount;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMjumin() {
		return mjumin;
	}
	public void setMjumin(String mjumin) {
		this.mjumin = mjumin;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMaddr() {
		return maddr;
	}
	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMcall() {
		return mcall;
	}
	public void setMcall(String mcall) {
		this.mcall = mcall;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
}
