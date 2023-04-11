package kr.co.kosmo.mvc.controller.chart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//tchart/busan
@Controller
@RequestMapping(value = "/tchart")
public class TourChartController {

	@GetMapping(value = "/preference")
	public String tourChart() {
		return "tourChart/tChart_preference";
	}
	
	@GetMapping(value = "/gender")
	public String tourChart2() {
		return "tourChart/tChart_gender";
	}
	
}
