package kr.co.admin.mvc.dao;

import java.util.List;

import kr.co.admin.mvc.vo.MemberVO;
import kr.co.admin.mvc.vo.PageDTO;

public interface ListDaoInter {
    public List<MemberVO> member(PageDTO vo);
    public int countMember();
}