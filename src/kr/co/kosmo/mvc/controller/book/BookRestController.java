package kr.co.kosmo.mvc.controller.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.BookService;
import kr.co.kosmo.mvc.vo.BookVO;
import kr.co.kosmo.mvc.vo.ItemVO;

@RestController
public class BookRestController {
	@Autowired
	private BookService booksvc;

//====================================================
	// 예약폼에 적용
	@GetMapping(value = "/listLocalBook")
	public String listLocalBook(int lid, String sdate, String edate) {
		List<ItemVO> list = booksvc.detailItem(lid);
		List<Integer> cntList = new ArrayList<Integer>();

		for (ItemVO e : list) {
			e.setSdate(sdate);
			e.setEdate(edate);

			cntList.add(booksvc.checkItem(e));
		}

		// getBookCnt
		ItemVO vo = new ItemVO();

		vo.setSdate(sdate);
		vo.setEdate(edate);

		int bookCnt = booksvc.getBookCnt(vo);
		System.out.println(sdate);
		System.out.println(edate);
		System.out.println(bookCnt);
		String result = "[{\"cntList\":" + cntList + "},{\"bookCnt\":\"" + bookCnt + "\"}]";
		// System.out.println(result);

		return result;
	}

//====================================================
	// 예약 수정 및 취소 => 날짜 제한 확인
	@RequestMapping(value = "/bookUpdateJson", produces = "application/json;charset=utf-8")
	public String bookUpdateJson(String chk, int bid) {
		BookVO bvo;
		// 날짜 제한
		// uplimit 수정 : 0 수정가능 / 1 직접연락해서 수정
		// dellimit 취소 : 1일 직접연락 / 3일 50%환불 / 5일 70%환불 / 7일 100%환불
		bvo = booksvc.changeLimit(bid);
		int datediff = bvo.getDatediff();
		int uplimit = bvo.getUplimit();
		int dellimit = bvo.getDellimit();
		// System.out.println("=====날짜 제한 Test=====");
		// System.out.println("날짜차이 => " + datediff);
		// System.out.println("수정가능 여부 => " + uplimit);
		// System.out.println("취소금액 => " + dellimit);

		String result = null;
		String limitMsg = null;

		if (chk.equals("upBtn")) {
			if (uplimit == 0) { // 예약수정 가능
				limitMsg = "예약 수정 가능";
			} else if (uplimit == 1) { // 예약수정 불가능
				limitMsg = "예약 수정 불가능! 호스트에게 직접 연락하세요";
			}
		} else if (chk.equals("delBtn")) {
			if (datediff <= 1) {
				limitMsg = "입실까지 남은 기간 " + datediff + "일 => 예약 취소 불가능! 호스트에게 직접 연락하세요";
			} else if (datediff <= 3) {
				limitMsg = "입실까지 남은 기간 " + datediff + "일(50% 환불) => 결제 취소금액 : " + dellimit + "원 입니다. ";
			} else if (datediff <= 5) {
				limitMsg = "입실까지 남은 기간 " + datediff + "일(70% 환불) => 결제 취소금액 : " + dellimit + "원 입니다. ";
			} else {
				limitMsg = "입실까지 남은 기간 " + datediff + "일(100% 환불) => 결제 취소금액 : " + dellimit + "원 입니다. ";
			}
		}

		ObjectMapper objmapper = new ObjectMapper();

		try {
			result = objmapper.writeValueAsString(limitMsg);
			result = "[{\"uplimit\":" + uplimit + "},{\"limitMsg\":\"" + limitMsg + "\"}]";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}

}
