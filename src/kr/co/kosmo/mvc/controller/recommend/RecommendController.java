package kr.co.kosmo.mvc.controller.recommend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/recommend")
public class RecommendController {
	
	@RequestMapping(value = "/home")
	public String recommend() {
		return "prepare/prepare";
	}

}
