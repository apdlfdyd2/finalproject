package kr.co.kosmo.mvc.controller.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.SurveyCheckVO;


@RestController
public class SurveyCheckController {

	@Autowired
	private SurveyDao dao;
	
	@RequestMapping(value = "/surcheck")
	public int surcheck(SurveyCheckVO scvo) {
		int cnt = dao.surveycheck(scvo);
		System.out.println("cnt : "+cnt);
		return cnt;
	}
}
