package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.InterestVO;
import kr.co.kosmo.mvc.vo.LocalVO;

@Repository
public class InterestDao implements InterestDaoInter {
	@Autowired
	SqlSessionTemplate ss;
	
	@Override
	public void addCart(InterestVO vo) {
		// TODO Auto-generated method stub
		ss.insert("interest.addCart", vo);
	}
	@Override
	public List<LocalVO> listCart(InterestVO vo) {
		// TODO Auto-generated method stub
		return ss.selectList("interest.listCart", vo);
	}
	@Override
	public int countCart(int mnum) {
		// TODO Auto-generated method stub
		return ss.selectOne("interest.countCart", mnum);
	}
}