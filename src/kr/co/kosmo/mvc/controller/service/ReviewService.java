package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.LocalDaoInter;
import kr.co.kosmo.mvc.vo.LocalVO;

@Service
public class ReviewService {
	@Autowired
	    private LocalDaoInter localdao;

	    @Transactional
	    public LocalVO chartForReview(int num) {
	        return localdao.chartForReview(num);
	    }
	
}