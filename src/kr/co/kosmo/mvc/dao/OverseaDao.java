package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.OverseaVO;
@Repository
public class OverseaDao implements OverseaDaoInter{
	@Autowired
	private SqlSessionTemplate ss;
	@Override
	public void addOversea(OverseaVO vo) {
		
		ss.insert("oversea.addoversea", vo);
		
	}
	@Override
	public List<OverseaVO> getList() {
		
		return ss.selectList("oversea.listoversea");
	}
	@Override
	public OverseaVO detailOver(int num) {
		
		return ss.selectOne("oversea.detailoversea", num);
	}
	@Override
	public void delOver(int num) {
		ss.delete("oversea.deloversea", num);
		
	}
	@Override
	public void overseamodify(OverseaVO vo) {
		ss.update("oversea.modifyoversea", vo);
		
	}
	@Override
	public OverseaVO chartForReview(int num) {
		// TODO Auto-generated method stub
		return ss.selectOne("oversea.chartForReview", num);
	}

}
