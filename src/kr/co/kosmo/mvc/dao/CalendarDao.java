package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.BookVO;

@Repository
public class CalendarDao implements CalendarDaoInter{
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public List<BookVO> getCalendar() {
		List<BookVO> calendar = ss.selectList("book.bookCalendar");
		return calendar;
	}

}
