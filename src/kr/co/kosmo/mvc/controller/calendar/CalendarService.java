package kr.co.kosmo.mvc.controller.calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kosmo.mvc.dao.CalendarDaoInter;
import kr.co.kosmo.mvc.vo.BookVO;

@Service
public class CalendarService {
	@Autowired
	private CalendarDaoInter calendao;
	
	public List<BookVO> getCalendar() throws Exception{
		return calendao.getCalendar();
	}

}
