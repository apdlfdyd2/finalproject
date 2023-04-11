package kr.co.kosmo.mvc.controller.chart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyCountVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@RestController
public class TourRestChartController {
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private SurveyDao dao;
	
	//[{sub:연령대별~},Map]
	@RequestMapping(value = "/tourChartJson" , produces = "application/json;charset=utf-8")
	public String busan(int num) {
		//1. 핸들링할 데이터 VO에 저장
		SurveyVO vo = surveyService.adminDetail(num);
		 
		//2. survey 주제 저장 => String
		//{sub:연령대별~}
		//String subject = vo.getSub();
		
		//3. survey 데이터 저장 => Map
		//{20대:500},{30대:500}...
		Map<String, Integer> map = new HashMap<String, Integer>();
		//3-1. foreach문으로 survey 데이터 map 안에 저장
		//SurveyVO안에 List 선언되었으므로 SurveyContentVO에 값 저장 => vo.getSubvey()
		for (SurveyContentVO e : vo.getSubvey()) {
			//key : e.getSurveytitle()
			//value : e.getSurveycnt()
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}

		//4. return반환 해줄 결과값 선언 => String
		String result = null;
		
		//5. ObjectMapper 선언 : 객체를 문자열로 변환 => JSON?
		ObjectMapper objmapper = new ObjectMapper();
		
		//6. result에 문자열로 변환한 값(=Map_survey 데이터) 저장 => writeValueAsString
		// => try/catch
		try {
			//{"30대":100,"20대":550,"50대":300,"40대":150,"60대":350}
			result = objmapper.writeValueAsString(map);

		//7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
			//형식 : [{"sub":"주제"},map]
			result = "[{\"sub\":\""+ vo.getSub() +"\"},"+result+"]";

		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		return result;
	}
	
	//[{sub:연령대별~},Map]
		@RequestMapping(value = "/surveycountJson" , produces = "application/json;charset=utf-8")
		public String count(int num) {
			//1. 핸들링할 데이터 VO에 저장
			
			SurveyCountVO vo = (SurveyCountVO) dao.getcount(num);
			//2. survey 주제 저장 => String
			//{sub:연령대별~}
			//String sub = vo.getSub();
			
			//3. survey 데이터 저장 => Map
			//{20대:500},{30대:500}...
			Map<String, Integer> map = new HashMap<String, Integer>();
			//map.put("gender",vo.getGender());
			map.put("msum",vo.getMsum());
			map.put("wsum",vo.getWsum());
			//4. return반환 해줄 결과값 선언 => String
			String result = null;
			
			//5. ObjectMapper 선언 : 객체를 문자열로 변환 => JSON?
			ObjectMapper objmapper = new ObjectMapper();
			
			//6. result에 문자열로 변환한 값(=Map_survey 데이터) 저장 => writeValueAsString
			// => try/catch
			try {
				//{"30대":100,"20대":550,"50대":300,"40대":150,"60대":350}
				result = objmapper.writeValueAsString(map);

			//7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
				//형식 : [{"sub":"주제"},map]
				//result = "[{\"sub\":\""+ vo.getSub() +"\"},"+result+"]";
				result = "[{\"sub\":\""+ "투표성별비율" +"\"},"+result+"]";

			} catch (JsonProcessingException e1) {
				e1.printStackTrace();
			}
			
			
			return result;
		}
		
		

		
		
		
		
		
		
}
