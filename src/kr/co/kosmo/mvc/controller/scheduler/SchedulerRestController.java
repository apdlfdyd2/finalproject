package kr.co.kosmo.mvc.controller.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.SchedulerDaoInter;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.RestaurantVO;
import kr.co.kosmo.mvc.vo.SchedulerVO;

@RestController
@RequestMapping(value = "/schedulerRest")
public class SchedulerRestController {
	@Autowired
	private SchedulerDaoInter scheduler;

	
	@RequestMapping(value = "/showList", produces = "application/json;charset=utf-8")
	public List<LocalVO> showList() {
		List<LocalVO> list = scheduler.showList();
		return list;
	}
	
	@RequestMapping(value = "/restList", produces = "application/json;charset=utf-8")
	public List<RestaurantVO> restList() {
		List<RestaurantVO> restList = scheduler.restList();
		return restList;
	}
	
	@RequestMapping(value = "/scheduleInsert", produces = "application/json;charset=utf-8")
	public SchedulerVO scheduleInsert(SchedulerVO vo) {
		scheduler.scheduleInsert(vo);
		System.out.println("scmem: "+vo.getScmem());
		System.out.println("sclist: " + vo.getSclist());
		return vo;
	}
	

}
