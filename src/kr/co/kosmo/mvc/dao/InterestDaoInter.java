package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.InterestVO;
import kr.co.kosmo.mvc.vo.LocalVO;

public interface InterestDaoInter {
	public void addCart(InterestVO vo);
	public List<LocalVO> listCart(InterestVO vo);
	public int countCart(int mid);
}
