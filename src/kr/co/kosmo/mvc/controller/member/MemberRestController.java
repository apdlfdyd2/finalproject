package kr.co.kosmo.mvc.controller.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.BookService;
import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.BookVO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MembershipVO;

@RestController
public class MemberRestController {
	@Autowired
	private MemberDaoInter memberdao;

	@Autowired
	private BookService booksvc;

//====================================================
	@RequestMapping(value = "/upmbti")
	public String upmbti(String mid,String mbtitype) {
		System.out.println(mid);
		System.out.println(mbtitype);
		int mmbti=memberdao.mbtichk(mbtitype);//mbtitype의 mbtinum을 받아옴
		System.out.println("실행됨?");
		System.out.println("처리후"+mid);
		System.out.println("처리후"+mmbti);
		MemberVO vo = new MemberVO();
		vo.setMid(mid);
		vo.setMmbti(mmbti);
		memberdao.upMbti(vo);
		return "redirect:/main";
	}
//====================================================
	// 마이페이지의 차트
	// [{sub:연령대별~},Map]
	@RequestMapping(value = "/membershipGauge", produces = "application/json;charset=utf-8")
	public String tourCount2(int mnum) {
		MembershipVO mbsvo = memberdao.chartMbs(mnum);
		List<MemberVO> list = mbsvo.getMember();
		String gradename = mbsvo.getMbsname();
		// System.out.println("gradename => "+gradename);

		int grade = 0;
		int percentage = 0;

		for (MemberVO e : list) {
			// System.out.println("grade => "+e.getMgrade());
			// System.out.println("Percentage => "+e.getPercentage());
			grade = e.getMgrade();
			percentage = e.getPercentage();
		}

		String result = null;

		ObjectMapper objmapper = new ObjectMapper();

		try {
			result = objmapper.writeValueAsString(grade);
			result = objmapper.writeValueAsString(percentage);
			result = "[{\"grade\":" + grade + "},{\"percentage\":\"" + percentage + "\"},{\"gradename\":\"" + gradename
					+ "\"}]";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}

//====================================================
	// 마이페이지의 나의 그래프 => 차트
	// [{sub:연령대별~},Map]
//----------	
	// 월 별 여행 횟수
	@RequestMapping(value = "/tourMonthCount", produces = "application/json;charset=utf-8")
	public String tourCount(int mnum) {
		// 1. 핸들링할 데이터 List 저장
		List<BookVO> list = booksvc.tourCount(mnum);

		// 2. 제목 저장 => String
		String subject = "월 별 여행 비율";

		// 3. 데이터 저장 => Map
		// {2023-03:4},{2023-02:3}...
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 3-1. foreach문으로 예약 데이터 map 안에 저장
		// List<ReservationVO> 선언되었으므로 ReservationVO에 값 저장
		for (BookVO e : list) {
			// key : N달
			// value : CNT값
			map.put(e.getMonth(), e.getTcount());
		}

		// 4. return반환 해줄 결과값 선언 => String
		String result = null;

		// 5. ObjectMapper 선언 : 객체를 문자열로 변환 => JSON?
		ObjectMapper objmapper = new ObjectMapper();

		// 6. result에 문자열로 변환한 값(=Map_survey 데이터) 저장 => writeValueAsString
		// => try/catch
		try {
			// {"2023-03":4},{"2023-02":3}...
			result = objmapper.writeValueAsString(map);

			// 7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
			// 형식 : [{"sub":"주제"},map]
			result = "[{\"sub\":\"" + subject + "\"}," + result + "]";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}
	// ----------
	// 방문 여행지
	@RequestMapping(value = "/visitSpotCount", produces = "application/json;charset=utf-8")
	public String visitSpotCount(int mnum) {
		// 1. 핸들링할 데이터 List 저장
		List<BookVO> list = booksvc.visitSpot(mnum);

		// 2. 제목 저장 => String
		String subject = "방문 여행지";

		// 3. 데이터 저장 => Map
		// {서울:4},{인천:3}...
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 3-1. foreach문으로 예약 데이터 map 안에 저장
		// List<ReservationVO> 선언되었으므로 ReservationVO에 값 저장
		for (BookVO e : list) {
			// key : 지역
			// value : CNT값
			map.put(e.getLocal().getLarea(), e.getLocal().getLocalcnt());
		}

		// 4. return반환 해줄 결과값 선언 => String
		String result = null;

		// 5. ObjectMapper 선언 : 객체를 문자열로 변환 => JSON?
		ObjectMapper objmapper = new ObjectMapper();

		// 6. result에 문자열로 변환한 값(=Map_survey 데이터) 저장 => writeValueAsString
		// => try/catch
		try {
			// {서울:4},{인천:3}.....
			result = objmapper.writeValueAsString(map);

			// 7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
			// 형식 : [{"sub":"주제"},map]
			result = "[{\"sub\":\"" + subject + "\"}," + result + "]";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}
	// ----------
	// 최대 여행 기간
	@RequestMapping(value = "/periodMaxChart", produces = "application/json;charset=utf-8")
	public String periodMax(int mnum) {
		// 1. 핸들링할 데이터 List 저장
		List<BookVO> list = booksvc.periodMax(mnum);

		// 2. 제목 저장 => String
		String subject = "최대 여행 기간";

		// 3. 데이터 저장 => Map
		// {2023-02-11:3},{2023-03-29:4},...
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 3-1. foreach문으로 예약 데이터 map 안에 저장
		// List<BookVO> 선언되었으므로 BookVO에 값 저장
		for (BookVO e : list) {
			// key : 날짜
			// value : 날짜차이값
			map.put(e.getSdate(), e.getDatediff());
		}

		// 4. return반환 해줄 결과값 선언 => String
		String result = null;

		// 5. ObjectMapper 선언 : 객체를 문자열로 변환 => JSON?
		ObjectMapper objmapper = new ObjectMapper();

		// 6. result에 문자열로 변환한 값(=Map_survey 데이터) 저장 => writeValueAsString
		// => try/catch
		try {
			// {"2023-02-11":3},{"2023-03-29":4}...
			result = objmapper.writeValueAsString(map);

			// 7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
			// 형식 : [{"sub":"주제"},map]
			result = "[{\"sub\":\"" + subject + "\"}," + result + "]";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}

	// ----------
	// 주 결제 방식
	@RequestMapping(value = "/costTypeChart", produces = "application/json;charset=utf-8")
	public String visitSpot(int mnum) {
		// 1. 핸들링할 데이터 List 저장
		List<BookVO> list = booksvc.costType(mnum);

		// 2. 제목 저장 => String
		String subject = "주 결제 방식";

		// 3. 데이터 저장 => Map
		// {간편결제:3},{카드:4}...
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 3-1. foreach문으로 예약 데이터 map 안에 저장
		// List<BookVO> 선언되었으므로 BookVO에 값 저장
		for (BookVO e : list) {
			// key : 결제타입
			// value : cnt
			map.put(e.getCharge().getChtype(), e.getCharge().getCtypecnt());
		}

		// 4. return반환 해줄 결과값 선언 => String
		String result = null;

		// 5. ObjectMapper 선언 : 객체를 문자열로 변환 => JSON?
		ObjectMapper objmapper = new ObjectMapper();

		// 6. result에 문자열로 변환한 값(=Map_survey 데이터) 저장 => writeValueAsString
		// => try/catch
		try {
			// {"간편결제":3},{"카드":4}...
			result = objmapper.writeValueAsString(map);

			// 7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
			// 형식 : [{"sub":"주제"},map]
			result = "[{\"sub\":\"" + subject + "\"}," + result + "]";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}

// ----------
	// 누적 여행 비용
	// [{sub:연령대별~},[날짜],[누적금액]]
	@RequestMapping(value = "/costTotalChart", produces = "application/json;charset=utf-8")
	public String costTotal(int mnum) {
		// 1. 핸들링할 데이터 List 저장
		List<BookVO> list = booksvc.costTotal(mnum);

		// 2. 제목 저장 => String
		String subject = "누적 여행 비용";

		// 3. 데이터 저장 => List
		// ['2023-02-11','2023-03-29'..],[180000,680000...]
		List<String> datelist = new ArrayList<>(); // 날짜
		List<Object> sumlist = new ArrayList<>(); // 누적 값
		// 3-1. foreach문으로 예약 데이터 map 안에 저장
		// List<BookVO> 선언되었으므로 BookVO에 값 저장
		datelist.add("\'x\'");
		sumlist.add("\'누적 여행 비용\'");
		for (BookVO e : list) {
			// key : 날짜
			// value : 누적 값
			datelist.add("\'" + e.getSdate() + "\'");
			sumlist.add(e.getCharge().getTotal());
		}
		System.out.println("datelist => " + datelist);
		System.out.println("sumlist => " + sumlist);

		// 4. return반환 해줄 결과값 선언 => String
		String result = null;

		// 5. ObjectMapper 선언 : 객체를 문자열로 변환 => JSON?
		ObjectMapper objmapper = new ObjectMapper();

		// 6. result에 문자열로 변환한 값(=Map_survey 데이터) 저장 => writeValueAsString
		// => try/catch
		try {
			// {"2023-02-11":3},{"2023-03-29":4}...
			result = objmapper.writeValueAsString(datelist);

			// 7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
			// 형식 : [{"sub":"주제"},map]
			result = "[{\"sub\":\"" + subject + "\"},{\"datelist\":\"" + datelist + "\"},{\"sumlist\":\"" + sumlist
					+ "\"}]";
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
		// 형식 : [{"sub":"주제"},map]

		return result;
	}
//====================================================

}
