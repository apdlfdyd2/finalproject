package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.LocalDao;
import kr.co.kosmo.mvc.vo.ItemVO;
import kr.co.kosmo.mvc.vo.LocalVO;

@Service
public class LocalService {
	@Autowired
	private LocalDao dao;

	@Transactional // 단위 처리 적용!
	public void insert(LocalVO vo, List<ItemVO> list) {
		dao.addlocalBoard(vo); // commit x
		dao.addItem(list); // commit x
		// commit o
	}

}
