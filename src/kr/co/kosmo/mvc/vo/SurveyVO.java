package kr.co.kosmo.mvc.vo;

import java.util.List;

public class SurveyVO {
	private int num;
	private String sub;
	private int code;
	private String sdate;

	private int surveytotal;	
	
	private List<SurveyContentVO> subvey;

	public List<SurveyContentVO> getSubvey() {
		return subvey;
	}

	public void setSubvey(List<SurveyContentVO> subvey) {
		this.subvey = subvey;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public int getSurveytotal() {
		return surveytotal;
	}

	public void setSurveytotal(int surveytotal) {
		this.surveytotal = surveytotal;
	}

	
}
