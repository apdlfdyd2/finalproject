package kr.co.kosmo.mvc.controller.calendar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.vo.BookVO;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {
	@Autowired
	private CalendarService calenService;
	
	@RequestMapping(value = "/calendarList")
	public ModelAndView getCalendar(ModelAndView mav, HttpServletRequest request) {
		List<BookVO> calendar = null;
		try {
			calendar = calenService.getCalendar();
			request.setAttribute("calendarList", calendar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("calendar/calendar");
		return mav;
	}

}
