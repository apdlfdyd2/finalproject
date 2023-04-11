package kr.co.kosmo.mvc.vo;

import java.util.List;

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
	private int mnum, mpoint, mgrade, mno, mcharge,mmbti;
	private int percentage;
	private String mid, mpwd, mname, mjumin, mphone, maddr, memail, mcall, mdate;
	private String gender, mage;
	
	private List<BookVO> resrv;

	
	public int getMmbti() {
		return mmbti;
	}

	public void setMmbti(int mmbti) {
		this.mmbti = mmbti;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public int getMcharge() {
		return mcharge;
	}

	public void setMcharge(int mcharge) {
		this.mcharge = mcharge;
	}

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

	public int getMgrade() {
		return mgrade;
	}

	public void setMgrade(int mgrade) {
		this.mgrade = mgrade;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMage() {
		return mage;
	}

	public void setMage(String mage) {
		this.mage = mage;
	}

	public List<BookVO> getResrv() {
		return resrv;
	}

	public void setResrv(List<BookVO> resrv) {
		this.resrv = resrv;
	}

}
