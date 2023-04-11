package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.DiaryVO;

public interface DiaryDaoInter {
	public void addDiary(DiaryVO vo);
	public List<DiaryVO> listDiary(String dwriter);
	public void updateDiary(DiaryVO vo);
	public DiaryVO detailDiary(int num);
	public void deleteDiary(int num);
}
