package kr.co.kosmo.mvc.controller.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kosmo.mvc.dao.SchedulerDaoInter;
import kr.co.kosmo.mvc.vo.SchedulerVO;

@Service
public class SchedulerService {
	@Autowired
	private SchedulerDaoInter scheduler;
	
	public void scheduleInsert(SchedulerVO vo) {
		scheduler.scheduleInsert(vo);
	}
	
	
	

}
