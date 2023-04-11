package kr.co.kosmo.mvc.controller.survey;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.SurveyCheckVO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Controller
@RequestMapping(value = "/survey")
public class SurveyController {
	@Autowired
	private SurveyService surveyservice;
	
	@Autowired
	private SurveyDao dao;
	
	// ----------------------------------
			// Page처리를 위한 속성
	private int nowPage = 1; // 현재 페이지 값 -> 메뉴페이지와 연동되는 변수
	private int nowBlock = 1; // 현재 블럭 -> [][][][][] -> 1block
	private int totalRecord; // 총 게시물 수 .Dao로 부터 받음
	private int numPerPage = 10; // 한 페이지당 보여질 게시물 수
	private int pagePerBlock = 5; // 한 블럭당 보여질 페이지 수
	private int totalPage; // 전체 페이지 수 => totalRecord/numPerPage
	private int totalBlock; // 전체 블럭 수
	private int beginPerPage; // 각 페이지별 시작 게시물의 index값
	private int endPerPage; // 각 페이지별 마지막 게시물의 index값
	// ----------------------------------
	
	@RequestMapping(value = "/surveyForm")
	public String surform() {
		return "survey/surveyAddform";
	}

	@RequestMapping(value = "/addsurvey")
	public ModelAndView surveyadd(SurveyVO vo,HttpServletRequest request) {
		//httpHttpServletRequest request : 폼에서 surveytitle 넘어올때 파라미터값 받기위해
		String[] surveytitle = request.getParameterValues("surveytitle"); //subtitle을 배열로 저장
		
		//DB에 전달하기 위한 List 만들기
		List<SurveyContentVO> list = new ArrayList<>();
		char stype = 'A';
		for (String e : surveytitle) {
			SurveyContentVO sv = new SurveyContentVO();
			sv.setSurveytitle(e);
			sv.setSurveycnt(0);
			sv.setSubtype(String.valueOf(stype));
			System.out.println("surveytitle : "+e);
			list.add(sv);
			stype++; //알파벳 증가
		}
		System.out.println("제목(Sub) : "+vo.getSub());		
		//surveyVO에 설문 타이틀을 저장한 List<SurveyContentVO> 인자로 전달
		vo.setSubvey(list);
		
		//service에 값 전달 => DB에 연결됨!
		surveyservice.addSurvey(vo, list);
		
		ModelAndView mav = new ModelAndView("redirect:surveyList");
		return mav;
	}
	
	
	
	
	
	//설문조사 리스트
	@RequestMapping(value = "/surveyList")
    public String surveylist(Model model, String cPage,String searchType,String searchValue) {
		
		System.out.println("================");
		System.out.println("cPage"+cPage);
		System.out.println("searchType"+searchType);
		System.out.println("searchValue"+searchValue);
		System.out.println("================");
		System.out.println("================Search");
		PageSearchDTO vo = new PageSearchDTO();
		vo.setSearchType(searchType);
		vo.setSearchValue(searchValue);
		System.out.println("searchType =>"+searchType);
		System.out.println("searchValue =>"+searchValue);
		// --------------Page 처리하기
		// 총 게시물 수 가져오기 => 실행결과 TotalRecord :21
		totalRecord = dao.getCnt();
		System.out.println("1. TotalRecord :" + totalRecord);
		// 전체 페이지 출력해보기 => totalPage :2.1
		// double totalPage2 = totalRecord/(double)numPerPage;
		
		// 올림 => 2.1 => 3
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage :" + totalPage);

		// totalBlock = totalPage/5;
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		System.out.println("3. totalBlock :" + totalBlock);

		// 현재 페이지를 요청할 때 파라미터로 현재 페이지값을 받는다. 1 ~~~~~~~ n
		String s_page = cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		System.out.println("4. nowPage :" + nowPage);

		// nowPage의 값에서 SQL문의 #{begin} , #{end} 연산
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// 데이터 전송해보기
		//Map<String, Integer> map = new HashMap<String, Integer>();
		//map.put("begin", beginPerPage);
		//map.put("end", endPerPage);
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);
		
		
        
        List<SurveyVO> list = surveyservice.listSurvey(vo);
     // 페이지 블록안에 페이지 반복 시키기 위한 startPage , endPage를 구해서
     		// view로 전달해야 함.
     		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
     		int endPage = startPage + pagePerBlock - 1;
     		// endPage의 연산의 범위가 우리가 구한 totalPage값 미만이라면
     		// totalPage의 값으로 대입시킨다.
     		if (endPage > totalPage) {
     			endPage = totalPage;
     		}

     		System.out.println("6. startPage = " + startPage);
     		System.out.println("6. endPage = " + endPage);

     		// View에 forward로 전송할 데이터
     		model.addAttribute("list", list);
     		model.addAttribute("nowPage", nowPage);
     		model.addAttribute("startPage", startPage);
     		model.addAttribute("endPage", endPage);
     		model.addAttribute("pagePerBlock", pagePerBlock); // 설정된 5
     		model.addAttribute("totalPage", totalPage);
     		model.addAttribute("searchType", vo.getSearchType());
     		model.addAttribute("searchValue", vo.getSearchValue());
     		// --------------------------
     		model.addAttribute("totalRecord", totalRecord);
     		// model.addAttribute("list", list);
        return "survey/surveyList";
	
	
	
	}
	
	
	
	
	
	
	
	//설문조사 디테일 관리자용
	@RequestMapping(value = "/surveyAdminDetail")
    public ModelAndView surveyDetail(int num) {
        ModelAndView mav = new ModelAndView("survey/surveyAdminDetail");
        SurveyVO vo = surveyservice.adminDetail(num);
        mav.addObject("vo", vo);
        return mav;
	}
	//설문조사 참여Form
	@RequestMapping(value = "/surveyDetail")
    public ModelAndView surveyClientDetail(int num) {
        ModelAndView mav = new ModelAndView("survey/surveyClientDetail");
        SurveyVO vo = surveyservice.adminDetail(num);
        mav.addObject("vo", vo);
        return mav;
	}
	//설문조사 참여시 트랜잭션
	@PostMapping(value = "/addSurveyClient")
    public String clientSurveyAdd(Model m, SurveyContentVO subvo, SurveyCheckVO scvo) {
		int cnt = dao.surveycheck(scvo);
		System.out.println(cnt);
		if(cnt==0) {
			System.out.println("Subcode : "+subvo.getSubcode());
			System.out.println("Subtype : " + subvo.getSubtype());
			System.out.println("Scid : " + scvo.getScid());
			System.out.println("Sccode : " + scvo.getSccode());
			System.out.println("Subtype : "+ scvo.getSubtype());
			surveyservice.updateSurveyCntck(subvo,scvo);			
		}else {
			System.out.println("else에 걸림");
		}
		 return "redirect:surveyList";
	}
	

	
	
	
}
