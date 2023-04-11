package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.RestaurantVO;
import kr.co.kosmo.mvc.vo.SchedulerVO;


public interface SchedulerDaoInter {
	public List<LocalVO> showList();
	public List<RestaurantVO> restList();
	
	//------------------------------------
	public void scheduleInsert(SchedulerVO vo);
	public List<SchedulerVO> scheduleList(String scmem);

}
