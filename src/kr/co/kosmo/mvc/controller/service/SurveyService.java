           package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.SurveyCheckVO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

//컨드롤러에서 Dao대신에 선언! => 트랜잭션 처리를 위해 단위처리!
//Dao에 두 메서드를 Service로 묶기
@Service
public class SurveyService {
	@Autowired
	private SurveyDao surveyDao;
	
	//<tx:annotation-driven transaction-manager="tm"/> => @Transactional
	//@Transactional 적용 후 각각 메서드 적용 후 commit됨!
	//모델에서 받아온 각 데이터를 Dao에 각각 전달해서 단위처리를 하기위한 메서드
	
	@Transactional
	public void addSurvey(SurveyVO vo,List<SurveyContentVO> list) {
		surveyDao.addSurvey(vo); //commitX
		surveyDao.addSurveyContent(list); //commitX
		//commit됨!
	}
	
	public List<SurveyVO> listSurvey(PageSearchDTO dto) {
		return surveyDao.listSurvey(dto);
	}

	public SurveyVO adminDetail(int num) {
		return surveyDao.adminDetail(num);
	}
	
	
	@Transactional
	public void updateSurveyCntck(SurveyContentVO subvo, SurveyCheckVO scvo) {
		surveyDao.updateSurveyCnt(subvo);
		surveyDao.addsc(scvo);
	}
	

	
	
}
