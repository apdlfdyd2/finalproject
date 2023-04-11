package kr.co.kosmo.mvc.controller.oversea;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/overseas")
public class OverseastripController {
	//@Autowired
	
	
	//해외여행 View로 이동
	@GetMapping(value = "/overseastrip")
	public ModelAndView overseastrip() {
		ModelAndView mav = new ModelAndView("overseastrip/overseastrip");
		return mav;
	}
	
}
