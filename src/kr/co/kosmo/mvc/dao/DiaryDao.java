package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.DiaryVO;
import kr.co.kosmo.mvc.vo.HostVO;

@Repository
public class DiaryDao implements DiaryDaoInter {
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addDiary(DiaryVO vo) {
		ss.insert("diary.addDiary",vo);
	}

	@Override
	public List<DiaryVO> listDiary(String dwriter) {
		return ss.selectList("diary.listDiary",dwriter);
	}

	@Override
	public void updateDiary(DiaryVO vo) {
		ss.update("diary.updateDiary",vo);
	}

	@Override
	public DiaryVO detailDiary(int num) {
		return ss.selectOne("diary.detailDiary",num);
	}

	@Override
	public void deleteDiary(int num) {
		ss.delete("diary.delDiary",num);
	}
}