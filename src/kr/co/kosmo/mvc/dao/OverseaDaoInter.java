package kr.co.kosmo.mvc.dao;

import java.util.List;


import kr.co.kosmo.mvc.vo.OverseaVO;

public interface OverseaDaoInter {
	public void addOversea(OverseaVO vo); //insert
	public List<OverseaVO> getList(); //List
	public OverseaVO detailOver(int num); //Detail
	public void delOver(int num); //Delete
	public void overseamodify(OverseaVO vo); //Update
	public OverseaVO chartForReview(int num); //¸®ºä¿ë Â÷Æ®
}
