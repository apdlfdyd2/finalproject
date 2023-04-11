package kr.co.kosmo.mvc.controller.review;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.controller.service.ReviewService;
import kr.co.kosmo.mvc.dao.ReviewDaoInter;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.ReviewVO;

@RestController
@RequestMapping(value = "/reviewRest")
public class ReviewRestController {
	@Autowired
    private ReviewDaoInter reviewdao;

	@Autowired
	private ReviewService reviewService;

	
    @RequestMapping(value = "/getavg")
    public int getstarAvg(int recode) {
        int avg = reviewdao.getstarAvg(recode);
        return avg;
    }
    
    @RequestMapping(value = "/reviewstarChart", produces = "application/json;charset=utf-8")
    public Map<Integer, Integer> chartForReview(int num) {
        LocalVO vo = reviewService.chartForReview(num);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(ReviewVO e : vo.getReview()) {
            map.put(e.getStar(), e.getStarcnt());
        }
        return map;
    }
}
