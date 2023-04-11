package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.RestaurantVO;
import kr.co.kosmo.mvc.vo.SchedulerVO;


@Repository
public class SchedulerDao implements SchedulerDaoInter{
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public List<LocalVO> showList() {
		return ss.selectList("local.showList");
	}

	@Override
	public List<RestaurantVO> restList() {
		return ss.selectList("restaurant.reslist");
	}

	@Override
	public void scheduleInsert(SchedulerVO vo) {
		ss.insert("scheduler.scheduleInsert",vo);
	}

	@Override
	public List<SchedulerVO> scheduleList(String scmem) {
		return ss.selectList("scheduler.scheduleList",scmem);
	}

}
