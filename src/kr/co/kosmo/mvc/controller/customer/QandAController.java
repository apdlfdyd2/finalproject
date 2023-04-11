package kr.co.kosmo.mvc.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Q&A
@Controller
@RequestMapping(value = "/customerqanda")
public class QandAController {
	
	@GetMapping(value = "/qanda")
	public ModelAndView qanda() {
		ModelAndView mav = new ModelAndView("customer_qaa/qaaList");
		return mav;
	}
}
