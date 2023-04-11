package kr.co.kosmo.mvc.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//자유게시판
@Controller
@RequestMapping(value = "/customerboard")
public class BulletinBoard {

	@GetMapping(value = "/bulboard")
	public ModelAndView bulboard() {
		ModelAndView mav = new ModelAndView("customer_board/boardList");
		return mav;
	}
}
