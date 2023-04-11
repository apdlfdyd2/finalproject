package kr.co.kosmo.mvc.vo;

public class SendMailVO {
	private String sdate,edate,memail;
    private int chpay;
    
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
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public int getChpay() {
		return chpay;
	}
	public void setChpay(int chpay) {
		this.chpay = chpay;
	}
}
