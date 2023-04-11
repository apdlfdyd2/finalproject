package kr.co.kosmo.mvc.vo;


public class ReviewVO {
	private int reno,recode,star;
	//starcnt_평점갯수 / listchk_리뷰리스트조건
	private int starcnt,listchk;
	
    private String retitle,rewriter,recontent,redate;
        
	public int getListchk() {
		return listchk;
	}
	public void setListchk(int listchk) {
		this.listchk = listchk;
	}
	public int getStarcnt() {
		return starcnt;
	}
	public void setStarcnt(int starcnt) {
		this.starcnt = starcnt;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
	}
	public int getRecode() {
		return recode;
	}
	public void setRecode(int recode) {
		this.recode = recode;
	}
	public String getRetitle() {
		return retitle;
	}
	public void setRetitle(String retitle) {
		this.retitle = retitle;
	}
	public String getRewriter() {
		return rewriter;
	}
	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}
	public String getRecontent() {
		return recontent;
	}
	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}	

}
