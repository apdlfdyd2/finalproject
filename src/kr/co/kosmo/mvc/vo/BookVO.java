package kr.co.kosmo.mvc.vo;

/*
 * 
  bno number constraint reservation_semi_rno_pk primary key, --예약번호(식별)
  mid number constraint book_mid_fk references member_semi(mnum), --고객번호 : 멤버TB와 연결(멤버1:예약N)
  lid number constraint book_lid_fk references local_semi(lno), --국내여행 : 
  bookcnt number, --예약수(나중에 예약일수로 핸들링 가능성O)
  bstatus varchar2(20), --주문 상태(예약중/예약완료/예약취소 등등) //
  sdate date, --입실날짜 // 
  edate date, --퇴실날짜 // 
  bname  varchar2(30), --예약자명 //
  otitle varchar2(30), --선택옵션
  oprice number, -- 예약금액
  bdate date default sysdate --예약을 수행한 날짜

 */
public class BookVO {

	private int bid, mid, lid;
	//tcount_차트에이용 /listchk_리스트선택(Top3 또는 전체리스트) / uplimit_예약수정가능여부 / dellimit_예약취소시 환불%
	//datediff_날짜차이/bookcnt_예약횟수
	private int tcount,listchk,uplimit,dellimit,datediff,bookcnt;

	private String bstatus, sdate, edate, bname, itype, iname, bdate;
	//month_차트에이용 /
	private String month;

	private LocalVO local;
	private ChargeMVO charge;

	
	public int getBookcnt() {
		return bookcnt;
	}

	public void setBookcnt(int bookcnt) {
		this.bookcnt = bookcnt;
	}

	public int getDatediff() {
		return datediff;
	}

	public void setDatediff(int datediff) {
		this.datediff = datediff;
	}

	public int getUplimit() {
		return uplimit;
	}

	public void setUplimit(int uplimit) {
		this.uplimit = uplimit;
	}

	public int getDellimit() {
		return dellimit;
	}

	public void setDellimit(int dellimit) {
		this.dellimit = dellimit;
	}

	public int getListchk() {
		return listchk;
	}

	public void setListchk(int listchk) {
		this.listchk = listchk;
	}

	public ChargeMVO getCharge() {
		return charge;
	}

	public void setCharge(ChargeMVO charge) {
		this.charge = charge;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getTcount() {
		return tcount;
	}

	public void setTcount(int tcount) {
		this.tcount = tcount;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
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

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getItype() {
		return itype;
	}

	public void setItype(String itype) {
		this.itype = itype;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public LocalVO getLocal() {
		return local;
	}

	public void setLocal(LocalVO local) {
		this.local = local;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

}
