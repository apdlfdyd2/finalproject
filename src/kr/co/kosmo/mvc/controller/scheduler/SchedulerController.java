package kr.co.kosmo.mvc.controller.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kosmo.mvc.dao.SchedulerDaoInter;
import kr.co.kosmo.mvc.vo.SchedulerVO;

@Controller
@RequestMapping(value = "/scheduler")
public class SchedulerController {
	@Autowired
	private SchedulerDaoInter scheduler;
	
	@GetMapping(value = "/schePath")
	public String schedulerPath() {
		return "scheduler/schedulerPage";
	}
	
	@RequestMapping(value = "/scheduleList")
	public String scheduleList(Model m,String scmem) {
		List<SchedulerVO> list = scheduler.scheduleList(scmem);
		m.addAttribute("list",list);
		return "scheduler/schedulerList";
	}
}
