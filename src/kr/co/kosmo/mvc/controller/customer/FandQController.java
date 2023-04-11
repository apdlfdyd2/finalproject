package kr.co.kosmo.mvc.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//자주 묻는 질문
@Controller
@RequestMapping(value = "/customerfandq")
public class FandQController {
	
	@GetMapping(value = "/fandq")
	public ModelAndView fandq() {
		ModelAndView mav = new ModelAndView("customer_faq/faqDetail");
		return mav;
	}
}
