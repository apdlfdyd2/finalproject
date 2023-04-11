package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.NoticeVO;
import kr.co.kosmo.mvc.vo.PageSearchDTO;


public interface NoticeInter {
    public void addinsert(NoticeVO vo);
    public List<NoticeVO> noList(); 
    public int getCnt(PageSearchDTO vo);
    public List<NoticeVO> getList(PageSearchDTO vo);
 }
