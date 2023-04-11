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
			// Pageó���� ���� �Ӽ�
	private int nowPage = 1; // ���� ������ �� -> �޴��������� �����Ǵ� ����
	private int nowBlock = 1; // ���� �� -> [][][][][] -> 1block
	private int totalRecord; // �� �Խù� �� .Dao�� ���� ����
	private int numPerPage = 10; // �� �������� ������ �Խù� ��
	private int pagePerBlock = 5; // �� ���� ������ ������ ��
	private int totalPage; // ��ü ������ �� => totalRecord/numPerPage
	private int totalBlock; // ��ü �� ��
	private int beginPerPage; // �� �������� ���� �Խù��� index��
	private int endPerPage; // �� �������� ������ �Խù��� index��
	// ----------------------------------
	
	@RequestMapping(value = "/surveyForm")
	public String surform() {
		return "survey/surveyAddform";
	}

	@RequestMapping(value = "/addsurvey")
	public ModelAndView surveyadd(SurveyVO vo,HttpServletRequest request) {
		//httpHttpServletRequest request : ������ surveytitle �Ѿ�ö� �Ķ���Ͱ� �ޱ�����
		String[] surveytitle = request.getParameterValues("surveytitle"); //subtitle�� �迭�� ����
		
		//DB�� �����ϱ� ���� List �����
		List<SurveyContentVO> list = new ArrayList<>();
		char stype = 'A';
		for (String e : surveytitle) {
			SurveyContentVO sv = new SurveyContentVO();
			sv.setSurveytitle(e);
			sv.setSurveycnt(0);
			sv.setSubtype(String.valueOf(stype));
			System.out.println("surveytitle : "+e);
			list.add(sv);
			stype++; //���ĺ� ����
		}
		System.out.println("����(Sub) : "+vo.getSub());		
		//surveyVO�� ���� Ÿ��Ʋ�� ������ List<SurveyContentVO> ���ڷ� ����
		vo.setSubvey(list);
		
		//service�� �� ���� => DB�� �����!
		surveyservice.addSurvey(vo, list);
		
		ModelAndView mav = new ModelAndView("redirect:surveyList");
		return mav;
	}
	
	
	
	
	
	//�������� ����Ʈ
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
		// --------------Page ó���ϱ�
		// �� �Խù� �� �������� => ������ TotalRecord :21
		totalRecord = dao.getCnt();
		System.out.println("1. TotalRecord :" + totalRecord);
		// ��ü ������ ����غ��� => totalPage :2.1
		// double totalPage2 = totalRecord/(double)numPerPage;
		
		// �ø� => 2.1 => 3
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage :" + totalPage);

		// totalBlock = totalPage/5;
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		System.out.println("3. totalBlock :" + totalBlock);

		// ���� �������� ��û�� �� �Ķ���ͷ� ���� ���������� �޴´�. 1 ~~~~~~~ n
		String s_page = cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		System.out.println("4. nowPage :" + nowPage);

		// nowPage�� ������ SQL���� #{begin} , #{end} ����
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// ������ �����غ���
		//Map<String, Integer> map = new HashMap<String, Integer>();
		//map.put("begin", beginPerPage);
		//map.put("end", endPerPage);
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);
		
		
        
        List<SurveyVO> list = surveyservice.listSurvey(vo);
     // ������ ��Ͼȿ� ������ �ݺ� ��Ű�� ���� startPage , endPage�� ���ؼ�
     		// view�� �����ؾ� ��.
     		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
     		int endPage = startPage + pagePerBlock - 1;
     		// endPage�� ������ ������ �츮�� ���� totalPage�� �̸��̶��
     		// totalPage�� ������ ���Խ�Ų��.
     		if (endPage > totalPage) {
     			endPage = totalPage;
     		}

     		System.out.println("6. startPage = " + startPage);
     		System.out.println("6. endPage = " + endPage);

     		// View�� forward�� ������ ������
     		model.addAttribute("list", list);
     		model.addAttribute("nowPage", nowPage);
     		model.addAttribute("startPage", startPage);
     		model.addAttribute("endPage", endPage);
     		model.addAttribute("pagePerBlock", pagePerBlock); // ������ 5
     		model.addAttribute("totalPage", totalPage);
     		model.addAttribute("searchType", vo.getSearchType());
     		model.addAttribute("searchValue", vo.getSearchValue());
     		// --------------------------
     		model.addAttribute("totalRecord", totalRecord);
     		// model.addAttribute("list", list);
        return "survey/surveyList";
	
	
	
	}
	
	
	
	
	
	
	
	//�������� ������ �����ڿ�
	@RequestMapping(value = "/surveyAdminDetail")
    public ModelAndView surveyDetail(int num) {
        ModelAndView mav = new ModelAndView("survey/surveyAdminDetail");
        SurveyVO vo = surveyservice.adminDetail(num);
        mav.addObject("vo", vo);
        return mav;
	}
	//�������� ����Form
	@RequestMapping(value = "/surveyDetail")
    public ModelAndView surveyClientDetail(int num) {
        ModelAndView mav = new ModelAndView("survey/surveyClientDetail");
        SurveyVO vo = surveyservice.adminDetail(num);
        mav.addObject("vo", vo);
        return mav;
	}
	//�������� ������ Ʈ�����
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
			System.out.println("else�� �ɸ�");
		}
		 return "redirect:surveyList";
	}
	

	
	
	
}
