package kr.co.kosmo.mvc.vo;

public class LoginLoggerDTO {
	private int num,runtime;
	private String midn;
	private String reip,uagent,status,sstime,eetime;
	//eetime : 로그아웃시간 => runtime구하기 위해 선언
	//runtime : 총 로그인했던시간 계산

	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMidn() {
		return midn;
	}
	public void setMidn(String midn) {
		this.midn = midn;
	}
	public String getReip() {
		return reip;
	}
	public void setReip(String reip) {
		this.reip = reip;
	}
	public String getUagent() {
		return uagent;
	}
	public void setUagent(String uagent) {
		this.uagent = uagent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSstime() {
		return sstime;
	}
	public void setSstime(String sstime) {
		this.sstime = sstime;
	}
	public String getEetime() {
		return eetime;
	}
	public void setEetime(String eetime) {
		this.eetime = eetime;
	}
}
