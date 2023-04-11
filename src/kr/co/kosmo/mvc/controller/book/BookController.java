package kr.co.kosmo.mvc.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.BookService;
import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.MembershipVO;
import kr.co.kosmo.mvc.vo.SendMailVO;
import kr.co.kosmo.mvc.vo.BookLoggerDTO;
import kr.co.kosmo.mvc.vo.BookVO;

@Controller
@RequestMapping(value = "/book")
public class BookController {
	@Autowired
	private BookService booksvc;

	@Autowired
	private MemberDaoInter memberdao;

	// 예약폼으로 이동
	@GetMapping(value = "/bookForm")
	public ModelAndView bookForm(int lid,HttpSession session) {
		ModelAndView mav = new ModelAndView("book/bookForm");
		//멤버쉽------------------------------------
		int mnum = (int) session.getAttribute("sessionNum");
		MembershipVO mbsvo = memberdao.memMembership(mnum);
		mav.addObject("mbsvo", mbsvo);
		//국내여행(숙소)정보-----------------------------------		
		LocalVO lvo = booksvc.detailLocalTotal(lid);
		mav.addObject("vo", lvo);
		return mav;
	}

	// 예약 insert
	// 예약 + 결제 (+멤버십포인트)
	@PostMapping(value = "/bookProcess")
	public String bookProcessInsert(HttpSession session,BookVO bookvo, ChargeMVO chvo, HttpServletRequest request,
			SendMailVO mailvo) {
		// String mid = (String) session.getAttribute("sessionID");
		int mnum = (int) session.getAttribute("sessionNum");

		// System.out.println("index" + request.getParameter("index"));
		int index = Integer.parseInt(request.getParameter("index"));
		char itype = 'A';

		for (int i = 0; i <= index; i++) {
			if (i == index) {
				bookvo.setItype(String.valueOf(itype));
			}
			itype++;
		}
		// 인자값 SendMailVO 테스트
		/*
		 * System.out.println("===BookController SendMail===");
		 * System.out.println("chpay =>"+mailvo.getChpay());
		 * System.out.println("Edate =>"+mailvo.getEdate());
		 * System.out.println("Sdate =>"+mailvo.getSdate());
		 * System.out.println("Memail =>"+mailvo.getMemail());
		 * System.out.println("===BookController SendMail===");
		 */
		booksvc.addBookCh(bookvo, chvo, mailvo, mnum);
		return "redirect:/main";
	}

//====================================================
	// 예약 수정폼으로 이동
	@GetMapping(value = "/bookUpdateForm")
	public ModelAndView bookUpdateForm(int bid,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		BookVO bvo;

		// 날짜 제한
		// uplimit 수정 : 0 수정가능 / 1 직접연락해서 수정
		bvo = booksvc.changeLimit(bid);
		int uplimit = bvo.getUplimit();

		if (uplimit == 0) { // 예약수정 가능
			mav = new ModelAndView("book/bookUpdateForm");
			//멤버쉽------------------------------------
			int mnum = (int) session.getAttribute("sessionNum");
			MembershipVO mbsvo = memberdao.memMembership(mnum);
			mav.addObject("mbsvo", mbsvo);
			//기존 예약 + 국내여행(숙소)정보-----------------------------------		
			bvo = booksvc.updateBookForm(bid); // bid,lid,itype,sdate,edate
			mav.addObject("bvo", bvo);
			LocalVO lvo = booksvc.detailLocalTotal(bvo.getLid());
			mav.addObject("vo", lvo);
		} else if (uplimit == 1) { // 예약수정 불가능
			System.out.println("수정불가능! 호스트에게 직접 연락하세요");
			mav = new ModelAndView("redirect:/calendar/calendarList");
		}

		return mav;
	}

	// 예약 수정 : 예약수정 및 결제수정 + 캘린더로 이동
	@PostMapping(value = "/bookUpdate")
	public String bookProcessUpdate(HttpSession session,BookVO bookvo, ChargeMVO chvo, HttpServletRequest request) {
		// String mid = (String) session.getAttribute("sessionID");
		int mnum = (int) session.getAttribute("sessionNum");
		bookvo.setMid(mnum);

		// System.out.println("index" + request.getParameter("index"));
		int index = Integer.parseInt(request.getParameter("index"));
		char itype = 'A';

		for (int i = 0; i <= index; i++) {
			if (i == index) {
				bookvo.setItype(String.valueOf(itype));
			}
			itype++;
		}
		// 값 전달
		booksvc.updateBookCh(bookvo, chvo, mnum);

		return "redirect:/calendar/calendarList";
	}

//====================================================
	// 예약 취소 : 예약취소 및 캘린더로 이동 + 결제내역도 같이 삭제됨
	@GetMapping(value = "/delBook")
	public String bookProcessDelete(HttpSession session,BookVO bookvo) {
		// 날짜 제한=================================
		// dellimit 취소 : 1일 직접연락 / 3일 50%환불 / 5일 70%환불 / 7일 100%환불
		BookVO bvo;
		bvo = booksvc.changeLimit(bookvo.getBid());
		int datediff = bvo.getDatediff(); // 날짜 차이
		int dellimit = bvo.getDellimit(); // 취소금액
		//System.out.println("취소금액 : " + dellimit);

		if (datediff <= 1) { //1일 직접연락
		} else if (datediff <= 3) { //3일 50%환불
		} else if (datediff <= 5) { //5일 70%환불
		} else { //7일 100%환불
			booksvc.delBook(bookvo); // 100%
		}
		return "redirect:/calendar/calendarList";
	}
}
