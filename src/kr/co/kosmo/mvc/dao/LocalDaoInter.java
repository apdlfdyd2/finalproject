package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.ItemVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.PageSearchDTO;

public interface LocalDaoInter {
	public void addlocalBoard (LocalVO vo); //Insert
	public List<LocalVO> getList (PageSearchDTO dto); //List
	public LocalVO detailLocal(int num); //Detail
	public void localmodify(LocalVO vo); //Update
	public void delLocal(int num); //Delete
	public LocalVO chartForReview(int num); //별점 차트
	public void addItem(List<ItemVO> list);
//=========================================================
	public List<LocalVO> hostLocalList(int hno); //HostList
}
