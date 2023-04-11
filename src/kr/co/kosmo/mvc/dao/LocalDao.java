package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.ItemVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.PageSearchDTO;

@Repository
public class LocalDao implements LocalDaoInter {
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addlocalBoard(LocalVO vo) {
		ss.insert("local.addlocal", vo);
	}

	@Override
	public List<LocalVO> getList(PageSearchDTO dto) {
		return ss.selectList("local.listlocal",dto);
	}

	@Override
	public LocalVO detailLocal(int num) {
		return ss.selectOne("local.detaillocal", num);
	}

	@Override
	public void delLocal(int num) {
		ss.delete("local.dellocal", num);
	}

	@Override
	public void localmodify(LocalVO vo) {
		ss.update("local.modifylocal", vo);
	}

	@Override
	public LocalVO chartForReview(int num) {
		return ss.selectOne("local.chartForReview", num);
	}

	@Override
	public void addItem(List<ItemVO> list) {
		ss.insert("local.addItem", list);
	}

// ====================================================
	// 호스트전용
	@Override
	public List<LocalVO> hostLocalList(int hno) {
		return ss.selectList("local.holistlocal", hno);
	}

}
